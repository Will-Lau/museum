package museum.museum.dao;

import java.util.List;
import museum.museum.Entity.Medal;
import museum.museum.Entity.MedalExample;
import org.apache.ibatis.annotations.Param;

public interface MedalMapper {
    int countByExample(MedalExample example);

    int deleteByExample(MedalExample example);

    int deleteByPrimaryKey(Long medalId);

    int insert(Medal record);

    int insertSelective(Medal record);

    List<Medal> selectByExample(MedalExample example);

    Medal selectByPrimaryKey(Long medalId);

    int updateByExampleSelective(@Param("record") Medal record, @Param("example") MedalExample example);

    int updateByExample(@Param("record") Medal record, @Param("example") MedalExample example);

    int updateByPrimaryKeySelective(Medal record);

    int updateByPrimaryKey(Medal record);
}