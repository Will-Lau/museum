package museum.museum.dao;

import java.util.List;
import museum.museum.Entity.RelicLike;
import museum.museum.Entity.RelicLikeExample;
import museum.museum.Entity.RelicLikeKey;
import org.apache.ibatis.annotations.Param;

public interface RelicLikeMapper {
    int countByExample(RelicLikeExample example);

    int deleteByExample(RelicLikeExample example);

    int deleteByPrimaryKey(RelicLikeKey key);

    int insert(RelicLike record);

    int insertSelective(RelicLike record);

    List<RelicLike> selectByExample(RelicLikeExample example);

    RelicLike selectByPrimaryKey(RelicLikeKey key);

    int updateByExampleSelective(@Param("record") RelicLike record, @Param("example") RelicLikeExample example);

    int updateByExample(@Param("record") RelicLike record, @Param("example") RelicLikeExample example);

    int updateByPrimaryKeySelective(RelicLike record);

    int updateByPrimaryKey(RelicLike record);
}