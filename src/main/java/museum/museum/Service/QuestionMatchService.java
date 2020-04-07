package museum.museum.Service;

import museum.museum.Entity.*;
import museum.museum.Request.JudgeQuestionRequest;
import museum.museum.dao.QuestionMapper;
import museum.museum.dao.QuestionMatchMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class QuestionMatchService {
    @Resource
    protected Mapper dozerMapper;

    @Resource
    protected QuestionMatchMapper questionMatchMapper;

    @Resource
    protected QuestionMapper questionMapper;

    @Resource
    protected QuestionService questionService;

    @Autowired
    private RedisTemplate redisTemplate;

    public int insertMatches(List<Question> questions,long qsId){
        for(Question item:questions){
            QuestionMatch questionMatch =new QuestionMatch();
            questionMatch.setQsId(qsId);

            questionMatch.setqId(item.getqId());
            System.out.println(questionMatch.getQsId()+questionMatch.getqId().toString());
            questionMatchMapper.insertSelective(questionMatch);
            System.out.println(questionMatch.getQsId());
        }
        return 0;
    }

    public double calculateAccurary(long qsid){
        QuestionMatchExample questionMatchExample=new QuestionMatchExample();
        QuestionMatchExample questionMatchExample2=new QuestionMatchExample();
        questionMatchExample.createCriteria().andQsIdEqualTo(qsid);
        questionMatchExample2.createCriteria().andQsIdEqualTo(qsid).andGradeEqualTo("true");
        double total=questionMatchMapper.countByExample(questionMatchExample);
        double right=questionMatchMapper.countByExample(questionMatchExample2);
        System.out.println(right);
        //计算并四舍五入保留两位小数
        double f=right/total;
        BigDecimal b=new BigDecimal(f);
        double f1=b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
        return f1;

    }


    //给问题评分
    public String updateQuestionMatchGrade(JudgeQuestionRequest judgeQuestionRequest){
        //grade存储正误结果，true为正，false为误
        String grade=questionService.judgeQuestion(judgeQuestionRequest.getQId(),judgeQuestionRequest.getUserAnswer());

        QuestionMatchKey questionMatchKey=dozerMapper.map(judgeQuestionRequest,QuestionMatchKey.class);
        QuestionMatch questionMatch=questionMatchMapper.selectByPrimaryKey(questionMatchKey);
        if(questionMatch==null) return "获取成绩失败";
        if(grade.equals("不存在该问题")) return "问题不存在";

        //答题存储在redis中
       redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
       redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
       redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        HashOperations<Long, Long, String> h= redisTemplate.opsForHash();
        h.put(judgeQuestionRequest.getQsId(),judgeQuestionRequest.getQId(),judgeQuestionRequest.getUserAnswer());
        redisTemplate.expire(judgeQuestionRequest.getQsId(),30, TimeUnit.MINUTES);

        //test
        String a=h.get(judgeQuestionRequest.getQsId(),judgeQuestionRequest.getQId());
        System.out.println(a);

        //将正误写入数据库QuestionMatch
        questionMatch.setGrade(grade);
        questionMatch.setUserAnswer(judgeQuestionRequest.getUserAnswer());
        questionMatchMapper.updateByPrimaryKeySelective(questionMatch);
        if(grade.equals("true")){
            return "true";
        }
        else {
            Question question=questionMapper.selectByPrimaryKey(judgeQuestionRequest.getQId());
            return question.getAnswer();
        }

    }
}
