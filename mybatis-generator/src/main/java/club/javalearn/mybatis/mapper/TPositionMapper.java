package club.javalearn.mybatis.mapper;

import club.javalearn.mybatis.entity.TPosition;
import club.javalearn.mybatis.entity.TPositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPositionMapper {
    long countByExample(TPositionExample example);

    int deleteByExample(TPositionExample example);

    int insert(TPosition record);

    int insertSelective(TPosition record);

    List<TPosition> selectByExample(TPositionExample example);

    int updateByExampleSelective(@Param("record") TPosition record, @Param("example") TPositionExample example);

    int updateByExample(@Param("record") TPosition record, @Param("example") TPositionExample example);
}