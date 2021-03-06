package museum.museum.dao;

import java.util.List;
import museum.museum.Entity.QuestionSet;
import museum.museum.Entity.QuestionSetExample;
import museum.museum.Response.MaxAccuarcyByDegree;
import museum.museum.Response.QuestionSetProcessResponse;
import org.apache.ibatis.annotations.Param;

public interface QuestionSetMapper {
    int countByExample(QuestionSetExample example);

    int deleteByExample(QuestionSetExample example);

    int deleteByPrimaryKey(Long qsId);

    int insert(QuestionSet record);

    int insertSelective(QuestionSet record);

    List<QuestionSet> selectByExample(QuestionSetExample example);

    QuestionSet selectByPrimaryKey(Long qsId);

    int updateByExampleSelective(@Param("record") QuestionSet record, @Param("example") QuestionSetExample example);

    int updateByExample(@Param("record") QuestionSet record, @Param("example") QuestionSetExample example);

    int updateByPrimaryKeySelective(QuestionSet record);

    int updateByPrimaryKey(QuestionSet record);

    List<QuestionSetProcessResponse> getProgress(String userId);

    List<QuestionSet> getProgressByKind(String userId,String kind);

    List<MaxAccuarcyByDegree> getMaxAccuracyGuoupByDegree(String userId,String kind);
}