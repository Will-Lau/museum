package museum.museum.dao;

import java.util.List;
import museum.museum.Entity.MedalGet;
import museum.museum.Entity.MedalGetExample;
import museum.museum.Entity.MedalGetKey;
import org.apache.ibatis.annotations.Param;

public interface MedalGetMapper {
    int countByExample(MedalGetExample example);

    int deleteByExample(MedalGetExample example);

    int deleteByPrimaryKey(MedalGetKey key);

    int insert(MedalGet record);

    int insertSelective(MedalGet record);

    List<MedalGet> selectByExample(MedalGetExample example);

    MedalGet selectByPrimaryKey(MedalGetKey key);

    int updateByExampleSelective(@Param("record") MedalGet record, @Param("example") MedalGetExample example);

    int updateByExample(@Param("record") MedalGet record, @Param("example") MedalGetExample example);

    int updateByPrimaryKeySelective(MedalGet record);

    int updateByPrimaryKey(MedalGet record);
}