package museum.museum.Service;

import museum.museum.Entity.Medal;
import museum.museum.Entity.MedalExample;
import museum.museum.Entity.MedalGet;
import museum.museum.Entity.User;
import museum.museum.Request.MedalRequest;
import museum.museum.Response.MedalResponse;
import museum.museum.dao.MedalGetMapper;
import museum.museum.dao.MedalMapper;
import museum.museum.dao.UserMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import static museum.museum.UsefulUtils.DozerUtils.mapList;

@Service
public class MedalService {
    @Resource
    protected Mapper dozerMapper;

    @Resource
    protected MedalMapper medalMapper;

    @Resource
    protected UserMapper userMapper;

    @Resource
    protected MedalGetMapper medalGetMapper;






    //增
    public String insertNewMedal(MedalRequest insertMedalResquest){
        MedalExample medalExample=new MedalExample();
        medalExample.createCriteria().andNameEqualTo(insertMedalResquest.getName());
        if(medalMapper.selectByExample(medalExample)!=null&&medalMapper.selectByExample(medalExample).size()!=0) return "该勋章已存在";
        else {
            Medal medal=dozerMapper.map(insertMedalResquest,Medal.class);
            medalMapper.insertSelective(medal);
            return "增加成功";
        }
    }

    //查
    public MedalResponse getMedal(String name){
        MedalExample medalExample=new MedalExample();
        medalExample.createCriteria().andNameEqualTo(name);
        return dozerMapper.map(medalMapper.selectByExample(medalExample).get(0),MedalResponse.class);
    }

    //查所有
    public List<MedalResponse> getAllMedal(){
        MedalExample medalExample=new MedalExample();
        medalExample.createCriteria().andMedalIdIsNotNull();
        return mapList(medalMapper.selectByExample(medalExample),MedalResponse.class);
    }

    //条件查
    public List<Medal> getMedals(Medal medal){
        MedalExample medalExample=new MedalExample();
        MedalExample.Criteria criteria=medalExample.createCriteria();
        if(medal.getMedalId()!=null) criteria.andMedalIdEqualTo(medal.getMedalId());
        if(medal.getName()!=null) criteria.andNameEqualTo(medal.getName());
        if(medal.getStar()!=null) criteria.andStarEqualTo(medal.getStar());
        List<Medal> medals=medalMapper.selectByExample(medalExample);
        if(medals==null||medals.size()==0) return null;
        return medals;
    }
    //删
    public String deleteMedal(String name){
        MedalExample medalExample=new MedalExample();
        medalExample.createCriteria().andNameEqualTo(name);
        medalMapper.deleteByExample(medalExample);
        if(medalMapper.selectByExample(medalExample)==null||medalMapper.selectByExample(medalExample).size()==0)
            return "删除完成";
        else return  "删除失败，请稍后重试";
    }

    //改
    public String updateMedal(MedalRequest medalRequest){
        MedalExample medalExample=new MedalExample();
        medalExample.createCriteria().andNameEqualTo(medalRequest.getName());
        Medal medal=medalMapper.selectByExample(medalExample).get(0);
        medal.setStar(medalRequest.getStar());
        medalMapper.updateByPrimaryKey(medal);
        return "更新完成";

    }

    //根据小星星数量获得勋章
    public Set<Medal> getMedalBystartlet(long starlet){
        MedalExample medalExample=new MedalExample();
        MedalExample.Criteria criteria=medalExample.createCriteria();

        criteria.andStarLessThanOrEqualTo(starlet);
        List<Medal> medals=medalMapper.selectByExample(medalExample);
        Set<Medal> medals1=new HashSet<>(medals);
        return medals1;
    }

    //得到两个勋章集合的差，以更新勋章
    public Set<Medal> getMedalSetDifference(Set<Medal> s1,Set<Medal> s2){
        s1.removeAll(s2);
        return s1;
    }

    //根据两次小星星的差值更新勋章
    public void getMedalByStarletDifference(String userId,long s1,long s2){
        MedalExample medalExample=new MedalExample();
        MedalExample.Criteria criteria=medalExample.createCriteria();
        criteria.andStarGreaterThan(s1);
        criteria.andStarLessThanOrEqualTo(s2);
        List<Medal> medals=medalMapper.selectByExample(medalExample);
        for(Medal item:medals){
            MedalGet medalGet=new MedalGet();
            medalGet.setName(item.getName());
            medalGet.setMedalId(item.getMedalId());
            medalGet.setUserId(userId);
            medalGetMapper.insertSelective(medalGet);
        }
    }

    //得到特殊的勋章
    public void getSpeicalMedal(User user){
        Medal medal=new Medal();
        medal.setStar((long)99999999);
        if(user.getQsFinish()==1) medal.setName("青铜探险家");
        if(user.getQsFinish()==2) medal.setName("白银探险家");
        if(user.getQsFinish()==3) medal.setName("黄金探险家");
        if(user.getQsFinish()==4) medal.setName("铂金探险家");
        if(user.getQsFinish()==5) medal.setName("钻石探险家");

        MedalExample medalExample=new MedalExample();
        MedalExample.Criteria criteria=medalExample.createCriteria();
        criteria.andNameEqualTo(medal.getName());
        //查看这个勋章在不在medal表里，不在就新建
        List<Medal> medals=medalMapper.selectByExample(medalExample);
        if(medals==null||medals.size()==0) medalMapper.insertSelective(medal);
        List<Medal> medals1=medalMapper.selectByExample(medalExample);
        Medal medal1=medals1.get(0);


        //插入新的MedalGet
        MedalGet medalGet=new MedalGet();
        medalGet.setUserId(user.getUserId());
        medalGet.setMedalId(medal1.getMedalId());
        medalGet.setName(medal1.getName());
        medalGetMapper.insertSelective(medalGet);
        return;
    }

}
