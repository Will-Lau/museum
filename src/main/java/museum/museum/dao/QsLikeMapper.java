package museum.museum.dao;

import java.util.List;
import museum.museum.Entity.QsLike;
import museum.museum.Entity.QsLikeExample;
import museum.museum.Entity.QsLikeKey;
import org.apache.ibatis.annotations.Param;

public interface QsLikeMapper {
    int countByExample(QsLikeExample example);

    int deleteByExample(QsLikeExample example);

    int deleteByPrimaryKey(QsLikeKey key);

    int insert(QsLike record);

    int insertSelective(QsLike record);

    List<QsLike> selectByExample(QsLikeExample example);

    QsLike selectByPrimaryKey(QsLikeKey key);

    int updateByExampleSelective(@Param("record") QsLike record, @Param("example") QsLikeExample example);

    int updateByExample(@Param("record") QsLike record, @Param("example") QsLikeExample example);

    int updateByPrimaryKeySelective(QsLike record);

    int updateByPrimaryKey(QsLike record);
}