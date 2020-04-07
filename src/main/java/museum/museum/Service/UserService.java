package museum.museum.Service;

import museum.museum.Entity.*;

import museum.museum.Response.UserCodeResponse;
import museum.museum.Response.UserResponse;
import museum.museum.Response.UserTokenResponse;
import museum.museum.UsefulUtils.AesEncryptUtils;
import museum.museum.UsefulUtils.WxMappingJackson2HttpMessageConverter;
import museum.museum.dao.QuestionSetMapper;
import museum.museum.dao.UserMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static museum.museum.Service.StarletService.*;

@Service
public class UserService {

    @Resource
    protected Mapper dozerMapper;

    @Resource
    protected UserMapper userMapper;

    @Resource
    protected QuestionSetMapper questionSetMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private MedalService medalService;

    @Autowired
    public static int maxDegree=3;

    @Autowired
    private RestTemplate restTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<String,Object> valueOperations;

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, Object> hashOperations;

    private String appid="wxbd87df0fc293c266";

    private String secret="a4bf0ad6112653f62d1c2bbf8ffb830c";

    private String grantType="authorization_code";



    //使用code换取token，如果是第一次登录就新建用户
    public UserTokenResponse login(String code) throws Exception {

        //为restTemplate增添对于不同返回值的错误处理
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());

        //向微信官方接口发送请求获得userOpenIdResponse
        String url= "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        UserCodeResponse userOpenIdResponse=restTemplate.getForObject(url, UserCodeResponse.class);
        if(null == userOpenIdResponse || !userOpenIdResponse.valid()) userOpenIdResponse=null;

        //根据openid和session_key使用aes加密生成session_id,在前端称作token
        String session_id= AesEncryptUtils.encrypt(userOpenIdResponse.getOpenid(),userOpenIdResponse.getSession_key());
        //创建返回给前端的UsersessionResponse
        UserTokenResponse userSessionResponse= UserTokenResponse.builder().token(session_id).build();

        //将session_id存入redis,过期时间为30分钟
        stringRedisTemplate.opsForValue().set(session_id,userOpenIdResponse.getOpenid(),30*60, TimeUnit.SECONDS);

        System.out.println(userOpenIdResponse.getOpenid());

        //检查数据库中有无该用户，没有则新建
        User user=userMapper.selectByPrimaryKey(userOpenIdResponse.getOpenid());
        if(user==null){
            User new_user=new User();
            new_user.setUserId(userOpenIdResponse.getOpenid());
            new_user.setQsFinish(0);
            new_user.setQsTotalFinish(0);
            new_user.setStarlet((long)0);
            new_user.setTranspondTime(0);
            new_user.setAccuracy((double)0);
            userMapper.insert(new_user);
        }

        return userSessionResponse;
    }

    //更新头像
    public String updateAvatar(String userId,String pic){
        User user=userMapper.selectByPrimaryKey(userId);
        if(user==null) return "用户不存在";
        else {
            user.setAvatar(pic);
            userMapper.updateByPrimaryKey(user);
            return "修改成功";
        }
    }

    public String updateTranspondTimePlusOne(String userId){
        User user=userMapper.selectByPrimaryKey(userId);
        if(user==null) return "用户不存在";
        else {
            user.setTranspondTime(user.getTranspondTime()+1);
            userMapper.updateByPrimaryKey(user);
            User user1=userMapper.selectByPrimaryKey(userId);
            medalService.getTranspondMedal(user1);
            return "修改成功";
        }
    }

    //获得用户可见信息
    public UserResponse getUserInfo(String userId){
        User user=userMapper.selectByPrimaryKey(userId);
        if(user==null) return null;
        else {
            UserResponse userResponse=dozerMapper.map(user,UserResponse.class);
            return userResponse;
        }
    }

    //根据题集完成情况获得小星星
    public void getStarletByQsid(long qsId){
        QuestionSet questionSet=questionSetMapper.selectByPrimaryKey(qsId);
        User user=userMapper.selectByPrimaryKey(questionSet.getUserId());
        long starlet=user.getStarlet();
        long oldstart=starlet;
        //根据正确率获得星星
        if(questionSet.getAccuracy()>=OneStar) starlet++;
        if(questionSet.getAccuracy()>=TwoStar) starlet++;
        if(questionSet.getAccuracy()>=ThreeStar) starlet++;
        user.setStarlet(starlet);
        userMapper.updateByPrimaryKey(user);

        //更新勋章
        medalService.getMedalByStarletDifference(user.getUserId(),oldstart,starlet);

        return;
    }




    public List<User> getUsers(User user){
        UserExample userExample =new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        if(user.getUserId()!=null) criteria.andUserIdEqualTo(user.getUserId());
        if(user.getAvatar()!=null) criteria.andAvatarEqualTo(user.getAvatar());
        if(user.getQsFinish()!=null) criteria.andQsFinishEqualTo(user.getQsFinish());
        if(user.getQsTotalFinish()!=null) criteria.andQsTotalFinishEqualTo(user.getQsTotalFinish());
        if(user.getStarlet()!=null) criteria.andStarletEqualTo(user.getStarlet());
        if(user.getAccuracy()!=null) criteria.andAccuracyEqualTo(user.getAccuracy());
        if(user.getTranspondTime()!=null) criteria.andTranspondTimeEqualTo(user.getTranspondTime());
        List<User> users=userMapper.selectByExample(userExample);
        if(users==null||users.size()==0) return null;
        else return users;

    }

    public String getUserId(String token){
        if(token==null||token.equals("")) return "";
        String userId=stringRedisTemplate.opsForValue().get(token);
        return userId;
    }

}
