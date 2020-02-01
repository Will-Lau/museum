package museum.museum.dao;

import java.util.List;
import museum.museum.Entity.QuestionMatch;
import museum.museum.Entity.QuestionMatchExample;
import museum.museum.Entity.QuestionMatchKey;
import org.apache.ibatis.annotations.Param;

public interface QuestionMatchMapper {
    int countByExample(QuestionMatchExample example);

    int deleteByExample(QuestionMatchExample example);

    int deleteByPrimaryKey(QuestionMatchKey key);

    int insert(QuestionMatch record);

    int insertSelective(QuestionMatch record);

    List<QuestionMatch> selectByExample(QuestionMatchExample example);

    QuestionMatch selectByPrimaryKey(QuestionMatchKey key);

    int updateByExampleSelective(@Param("record") QuestionMatch record, @Param("example") QuestionMatchExample example);

    int updateByExample(@Param("record") QuestionMatch record, @Param("example") QuestionMatchExample example);

    int updateByPrimaryKeySelective(QuestionMatch record);

    int updateByPrimaryKey(QuestionMatch record);
}