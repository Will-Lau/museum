package museum.museum.Service;

import museum.museum.Entity.Question;
import museum.museum.Entity.QuestionMatch;
import museum.museum.Entity.QuestionMatchExample;
import museum.museum.Entity.QuestionMatchKey;
import museum.museum.Request.JudgeQuestionRequest;
import museum.museum.dao.QuestionMatchMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class QuestionMatchService {
    @Resource
    protected Mapper dozerMapper;

    @Resource
    protected QuestionMatchMapper questionMatchMapper;

    @Resource
    protected QuestionService questionService;

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

        //将正误写入数据库QuestionMatch
        questionMatch.setGrade(grade);
        questionMatch.setUserAnswer(judgeQuestionRequest.getUserAnswer());
        questionMatchMapper.updateByPrimaryKeySelective(questionMatch);
        if(grade.equals("true")){
            return "true";
        }
        else {
            return "false";
        }

    }
}
