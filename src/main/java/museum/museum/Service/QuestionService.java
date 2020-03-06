package museum.museum.Service;

import museum.museum.Entity.QuestionExample;
import museum.museum.Entity.QuestionSetExample;
import museum.museum.Request.GetQuestionsRule;
import museum.museum.Request.InsertQuestionRequest;
import museum.museum.dao.QuestionMapper;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import museum.museum.Entity.Question;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionService{
    @Resource
    protected Mapper dozerMapper;

    @Resource
    protected QuestionMapper questionMapper;

    //添加问题
    public long insertQuestion(InsertQuestionRequest insertQuestionRequest){
            Question question=dozerMapper.map(insertQuestionRequest,Question.class);
            questionMapper.insertSelective(question);
            long qId=question.getqId();
            return qId;
    }

    //删除问题
    public String deleteQuestion(long qId){
        questionMapper.deleteByPrimaryKey(qId);
        return "删除完成";
    }

    //修改问题
    public String updateQuestion(Question question){
        QuestionExample questionExample =new QuestionExample();
        questionExample.createCriteria().andQIdEqualTo(question.getqId());
        questionMapper.updateByPrimaryKeySelective(question);
        return "修改完成";
    }

    //获得问题
    public Question getQuestion(long qId){
        QuestionExample questionExample =new QuestionExample();
        questionExample.createCriteria().andQIdEqualTo(qId);
        List<Question> questions=questionMapper.selectByExample(questionExample);
        if(questions==null||questions.size()==0) return null;
        else return questions.get(0);

    }

    public List<Question> getQuestions(GetQuestionsRule getQuestionsRule){
        QuestionExample questionExample =new QuestionExample();
        QuestionExample.Criteria criteria=questionExample.createCriteria();
        if(getQuestionsRule.getqId()!=null) criteria.andQIdEqualTo(getQuestionsRule.getqId());
        if(getQuestionsRule.getKind()!=null) criteria.andKindEqualTo(getQuestionsRule.getKind());
        if(getQuestionsRule.getDegree()!=null) criteria.andDegreeEqualTo(getQuestionsRule.getDegree());
        if(getQuestionsRule.getContent()!=null) criteria.andContentLike("%"+getQuestionsRule.getContent()+"%");
        if(getQuestionsRule.getOptionA()!=null) criteria.andOptionALike(getQuestionsRule.getOptionA());
        if(getQuestionsRule.getOptionB()!=null) criteria.andOptionBLike(getQuestionsRule.getOptionB());
        if(getQuestionsRule.getOptionC()!=null) criteria.andOptionCLike(getQuestionsRule.getOptionC());
        if(getQuestionsRule.getAnswer()!=null) criteria.andAnswerEqualTo(getQuestionsRule.getAnswer());
        if(getQuestionsRule.getAnalysis()!=null) criteria.andAnalysisLike("%"+getQuestionsRule.getAnalysis()+"%");
        List<Question> questions=questionMapper.selectByExample(questionExample);
        if(questions==null||questions.size()==0) return null;
        else return questions;
    }

    //根据kind和degree获得题集
    public List<Question> getQuestionsByKindAndDegree(String kind,int degree){
        QuestionExample questionExample=new QuestionExample();
        questionExample.createCriteria().andKindEqualTo(kind).andDegreeEqualTo(degree);
        List<Question> questions=questionMapper.selectByExample(questionExample);
        if(questions==null||questions.size()==0){
            return null;
        }

        else return questions;
    }

    //判断正误，只返回正误不做其他事
    public String judgeQuestion(long qId,String userAnswer){
        Question question=questionMapper.selectByPrimaryKey(qId);
        if(question==null) return "不存在该问题";
        else {
            //答案正确
            if (question.getAnswer().equals(userAnswer)){
                return "true";
            }
            else {
                return "false";
            }
        }
    }



}
