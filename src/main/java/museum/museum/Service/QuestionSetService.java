package museum.museum.Service;

import museum.museum.Entity.*;
import museum.museum.Request.CreateQuestionSetRequest;
import museum.museum.Request.GetQuestionsRule;
import museum.museum.Response.QuestionResponse;
import museum.museum.Response.QuestionSetResponse;
import museum.museum.Response.QuestionSetProcessResponse;
import museum.museum.Response.QuestionSetResponsePlus;
import museum.museum.dao.QuestionMapper;
import museum.museum.dao.QuestionMatchMapper;
import museum.museum.dao.QuestionSetMapper;
import museum.museum.dao.UserMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static museum.museum.Service.StarletService.OneStar;
import static museum.museum.Service.StarletService.TwoStar;
import static museum.museum.UsefulUtils.DozerUtils.mapList;

@Service
public class QuestionSetService {
    @Resource
    protected Mapper dozerMapper;

    @Autowired
    protected QuestionService questionService;

    @Autowired
    protected QuestionMatchService questionMatchService;

    @Autowired
    protected UserService userService;

    @Autowired
    protected MedalService medalService;

    @Resource
    protected QuestionMapper questionMapper;

    @Resource
    protected QuestionSetMapper questionSetMapper;

    @Resource
    protected QuestionMatchMapper questionMatchMapper;

    @Resource
    protected UserMapper userMapper;




    //创建题集
    public QuestionSetResponse createQuestionSet(String userId,CreateQuestionSetRequest createQuestionSetRequest){



        //判断用户是否能做这个难度的题
        /*用户一开始的进度为0，只能做1难度的题，做完1后其进度变为1，可做2难度的题目,因此用户进度+1>=题目难度*/
        QuestionSet userProgress=getQuestionSetProgressByKind(userId,createQuestionSetRequest.getKind());
        if(userProgress.getDegree()+1<createQuestionSetRequest.getDegree()) return null;


        //查询符合条件的题目
        List<Question> questions=questionService.getQuestionsByKindAndDegree(createQuestionSetRequest.getKind(),
                                                                                    createQuestionSetRequest.getDegree());


        if(questions==null){
            return null;
        }
        else{
            //组题
            Collections.shuffle(questions);
            int num=createQuestionSetRequest.getNum();
            List<Question> selectQuestions=new ArrayList();
            if(questions.size()>=(num+1))
                selectQuestions=questions.subList(0,num);
            else
                selectQuestions=questions;

            //创建QuestionSet
            QuestionSet questionSet=insertQuestionSet(userId,createQuestionSetRequest.getKind(),createQuestionSetRequest.getDegree());

            //创建match
            questionMatchService.insertMatches(selectQuestions,questionSet.getQsId());



            /*QuestionSetResponse createQuestionSetResponse= QuestionSetResponse.builder()
                                                                .qsId(questionSet.getQsId())
                                                                .userId(userId)
                                                                .questionResponses(mapList(selectQuestions, QuestionResponse.class))
                                                                .build();*/
            return getQuestionSet(questionSet.getQsId(),userId);




        }
    }

    //删除一个题集
    public String deleteQuestionSet(Long qsId,String userId){
        QuestionSet questionSet=questionSetMapper.selectByPrimaryKey(qsId);
        if(questionSet==null) return "此题集不存在";
        if(!questionSet.getUserId().equals(userId)) return "没有权限";
        questionSetMapper.deleteByPrimaryKey(qsId);
        return "删除成功";

    }

    //放弃做一个题集
    public String quitQuestionSet(Long qsId,String userId){
        QuestionSet questionSet=questionSetMapper.selectByPrimaryKey(qsId);
        if(questionSet==null) return "此题集不存在";
        if(!questionSet.getUserId().equals(userId)) return "没有权限";
        questionSet.setStatus("quit");
        questionSetMapper.updateByPrimaryKey(questionSet);
        return "已放弃";
    }

    //获得一个题集，做了的题给结果和解析，没做的题不给
    public QuestionSetResponse getQuestionSet(Long qsId,String userId){
        QuestionSet questionSet=questionSetMapper.selectByPrimaryKey(qsId);
        if(questionSet==null) return null;
        if(!questionSet.getUserId().equals(userId)) return null;
        QuestionSet userProgress=getQuestionSetProgressByKind(userId,questionSet.getKind());
        if(userProgress.getDegree()+1<questionSet.getDegree()) return null;
        return mapQuestionSetToQuestionSetResponse(questionSet);

    }

    //找到一个QuestionSet对应的question
    public List<Question> QuestionSetToQuestion(QuestionSet questionSet){
        QuestionMatchExample questionMatchExample=new QuestionMatchExample();
        questionMatchExample.createCriteria().andQsIdEqualTo(questionSet.getQsId());
        List<QuestionMatch> questionMatches=questionMatchMapper.selectByExample(questionMatchExample);

        if(questionMatches==null||questionMatches.size()==0) return  null;

        //新建一个Question的List
        List<Question> questions=new ArrayList<>();
        for(QuestionMatch item:questionMatches){

                Question question = questionMapper.selectByPrimaryKey(item.getqId());
                 questions.add(question);

        }

        return questions;
    }


    //将QuestionSet转换为QuestionSetResponse
    public QuestionSetResponse mapQuestionSetToQuestionSetResponse(QuestionSet questionSet){
        QuestionMatchExample questionMatchExample=new QuestionMatchExample();
        questionMatchExample.createCriteria().andQsIdEqualTo(questionSet.getQsId());
        List<QuestionMatch> questionMatches=questionMatchMapper.selectByExample(questionMatchExample);

        if(questionMatches==null||questionMatches.size()==0) return  null;

        //新建一个QuestionResponse的List
        List<QuestionResponse> questionResponses=new ArrayList<>();
        for(QuestionMatch item:questionMatches){

            if(item.getUserAnswer()==null) {
                //如果没做就把结果和答案置空
                Question question = questionMapper.selectByPrimaryKey(item.getqId());
                question.setAnalysis(null);
                question.setAnswer(null);
                questionResponses.add(dozerMapper.map(question,QuestionResponse.class));
            }else {
                //如果做了就给结果、答案和解析
                Question question = questionMapper.selectByPrimaryKey(item.getqId());
                QuestionResponse questionResponse=dozerMapper.map(question,QuestionResponse.class);
                questionResponse.setGrade(item.getGrade());
                questionResponse.setUserAnswer(item.getUserAnswer());
                questionResponses.add(questionResponse);
            }
        }
        QuestionSetResponse questionSetResponse= QuestionSetResponse.builder()
                .qsId(questionSet.getQsId())
                .questionResponses(questionResponses)
                .build();
        return questionSetResponse;

    }


    //创建一个空QuestionSet,将status初始化为unfinished
    public QuestionSet insertQuestionSet(String userId,String kind,int degree) {
        QuestionSet questionSet = new QuestionSet();
        questionSet.setUserId(userId);
        questionSet.setStatus("unfinished");
        questionSet.setKind(kind);
        questionSet.setDegree(degree);
        questionSetMapper.insertSelective(questionSet);
        QuestionSet questionSet1 = questionSetMapper.selectByPrimaryKey(questionSet.getQsId());
        return questionSet1;
    }



    //根据做题情况更新题集正确率
    public double updateQuestionSetAccurary(long qsId){
        QuestionSet questionSet=questionSetMapper.selectByPrimaryKey(qsId);
        if(questionSet==null) return -1;
        if(!questionSet.getStatus().equals("finished")) return -2;
        double accuracy=questionMatchService.calculateAccurary(qsId);
        questionSet.setAccuracy(accuracy);
        questionSet.setStatus("graded");
        questionSetMapper.updateByPrimaryKey(questionSet);
        return accuracy;
    }


    //获取用户各类别做题进度
    public List<QuestionSetProcessResponse> getQuestionSetProgress(String userId){
        List<QuestionSet> questionSets=questionSetMapper.getProgress(userId);
        if(questionSets==null||questionSets.size()==0){
            return null;
        }else
        return mapList(questionSets,QuestionSetProcessResponse.class);

    }

    //获取用户某一类的做题进度
    public QuestionSet getQuestionSetProgressByKind(String userId, String kind){

        QuestionSet questionSet=questionSetMapper.getProgressByKind(userId,kind);
        if(questionSet==null){
            QuestionSet questionSet1=new QuestionSet();
            questionSet1.setUserId(userId);
            questionSet1.setDegree(0);
            questionSet1.setKind(kind);

            return questionSet1;
        }else  return questionSet;
    }

    //更改题集状态为完成
    public double updateQuestionStatusToFinished(long qsId){
        QuestionSet questionSet=questionSetMapper.selectByPrimaryKey(qsId);
        if(questionSet==null) {
            return -1;
        }
        else {
            questionSet.setStatus("finished");
            questionSetMapper.updateByPrimaryKey(questionSet);
            //返回题集的正确率
            double accurary=updateQuestionSetAccurary(qsId);
            //根据正确率获得小星星和依靠小星星数量能够获得的勋章
            userService.getStarletByQsid(qsId);
            //判断是否通关了一个类别的题集
            QuestionSetExample questionSetExample=new QuestionSetExample();
            QuestionSetExample.Criteria criteria=questionSetExample.createCriteria();
            criteria.andUserIdEqualTo(questionSet.getUserId());
            criteria.andKindEqualTo(questionSet.getKind());
            criteria.andStatusEqualTo("finished");
            criteria.andAccuracyGreaterThanOrEqualTo(0.8);
            List<QuestionSet> questionSets=questionSetMapper.selectByExample(questionSetExample);
            if(questionSets!=null&&questionSets.size()==1){
                //让user的QsFinish+1
                User user= userMapper.selectByPrimaryKey(questionSet.getUserId());
                user.setQsFinish(user.getQsFinish()+1);
                userMapper.updateByPrimaryKey(user);

                //获得能根据通过类别数量所得的勋章
                medalService.getSpeicalMedal(user);
            }

            return accurary;
        }
    }

    public List<QuestionSetResponsePlus> getQuestionSets(QuestionSet questionSet){
        QuestionSetExample questionSetExample =new QuestionSetExample();
        QuestionSetExample.Criteria criteria=questionSetExample.createCriteria();
        if(questionSet.getQsId()!=null) criteria.andQsIdEqualTo(questionSet.getQsId());
        if(questionSet.getUserId()!=null) criteria.andUserIdEqualTo(questionSet.getUserId());
        if(questionSet.getAccuracy()!=null) criteria.andAccuracyEqualTo(questionSet.getAccuracy());
        if(questionSet.getFinishTime()!=null) criteria.andFinishTimeEqualTo(questionSet.getFinishTime());
        if(questionSet.getStatus()!=null) criteria.andStatusEqualTo(questionSet.getStatus());
        if(questionSet.getKind()!=null) criteria.andKindEqualTo(questionSet.getKind());
        if(questionSet.getDegree()!=null) criteria.andDegreeEqualTo(questionSet.getDegree());

        List<QuestionSet> questionSets=questionSetMapper.selectByExample(questionSetExample);
        if(questionSets==null||questionSets.size()==0) return null;
        else{
            List<QuestionSetResponsePlus> questionSetResponsePluses=new ArrayList<>();
            for (QuestionSet item:questionSets){
                QuestionSetResponsePlus questionSetResponsePlus=dozerMapper.map(item,QuestionSetResponsePlus.class);
                questionSetResponsePlus.setQuestions(QuestionSetToQuestion(item));
                questionSetResponsePluses.add(questionSetResponsePlus);
            }
            return questionSetResponsePluses;
        }


    }

}
