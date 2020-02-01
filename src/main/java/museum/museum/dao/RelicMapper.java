package museum.museum.dao;

import java.util.List;
import museum.museum.Entity.Relic;
import museum.museum.Entity.RelicExample;
import org.apache.ibatis.annotations.Param;

public interface RelicMapper {
    int countByExample(RelicExample example);

    int deleteByExample(RelicExample example);

    int deleteByPrimaryKey(Long rId);

    int insert(Relic record);

    int insertSelective(Relic record);

    List<Relic> selectByExample(RelicExample example);

    Relic selectByPrimaryKey(Long rId);

    int updateByExampleSelective(@Param("record") Relic record, @Param("example") RelicExample example);

    int updateByExample(@Param("record") Relic record, @Param("example") RelicExample example);

    int updateByPrimaryKeySelective(Relic record);

    int updateByPrimaryKey(Relic record);
}