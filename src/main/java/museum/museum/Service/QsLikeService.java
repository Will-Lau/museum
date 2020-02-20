package museum.museum.Service;


import museum.museum.Request.GetQuestionsRule;
import museum.museum.dao.QsLikeMapper;
import museum.museum.Entity.*;
import museum.museum.Request.InsertLikeQuestionSetRequest;
import museum.museum.Response.QuestionSetSimpleResponse;
import museum.museum.dao.QuestionSetMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class QsLikeService {
    @Resource
    protected Mapper dozerMapper;

    @Autowired
    protected UserService userService;

    @Resource
    protected QuestionSetMapper questionSetMapper;

    @Resource
    protected QsLikeMapper qsLikeMapper;

    //获得收藏的所有题集
    public List<QuestionSetSimpleResponse> getLikeQuestionSet(String userId){
        QsLikeExample qsLikeExample=new QsLikeExample();
        qsLikeExample.createCriteria().andUserIdEqualTo(userId);
        List<QsLike> qsLikes=qsLikeMapper.selectByExample(qsLikeExample);
        List<QuestionSetSimpleResponse> questionSetSimpleResponses=new ArrayList<>();
        for(QsLike item:qsLikes){
            QuestionSet questionSet=questionSetMapper.selectByPrimaryKey(item.getQsId());
            QuestionSetSimpleResponse questionSetSimpleResponse=dozerMapper.map(questionSet,QuestionSetSimpleResponse.class);
            questionSetSimpleResponse.setLikeTime(item.getLikeTime());
            questionSetSimpleResponses.add(questionSetSimpleResponse);
        }
        return questionSetSimpleResponses;
    }

    //收藏题集
    public String insertLikeQuestion(String uesrId, InsertLikeQuestionSetRequest insertLikeQuestionSetRequest){
        QsLike qsLike=new QsLike();
        qsLike.setUserId(uesrId);
        qsLike.setQsId(insertLikeQuestionSetRequest.getQsId());
        qsLike.setLikeTime(insertLikeQuestionSetRequest.getLikeTime());
        qsLikeMapper.insertSelective(qsLike);
        return "增加成功";

    }

    //删除收藏
    public String deleteLikeQuestion(String userId, long qsId){

        QsLikeKey qsLikeKey=new QsLikeKey();
        qsLikeKey.setUserId(userId);
        qsLikeKey.setQsId(qsId);
        if(qsLikeMapper.selectByPrimaryKey(qsLikeKey)==null) return "收藏不存在";
        else {
            qsLikeMapper.deleteByPrimaryKey(qsLikeKey);
            return "删除成功";
        }

    }

    public List<QsLike> getQsLikes(QsLike qsLike){
        QsLikeExample qsLikeExample =new QsLikeExample();
        QsLikeExample.Criteria criteria=qsLikeExample.createCriteria();
        if(qsLike.getQsId()!=null) criteria.andQsIdEqualTo(qsLike.getQsId());
        if(qsLike.getUserId()!=null) criteria.andUserIdEqualTo(qsLike.getUserId());
        if(qsLike.getLikeTime()!=null) criteria.andLikeTimeEqualTo(qsLike.getLikeTime());
        List<QsLike> qsLikes=qsLikeMapper.selectByExample(qsLikeExample);
        if(qsLikes==null||qsLikes.size()==0) return null;
        else return qsLikes;

    }
}
