package club.javalearn.mybatis.mapper;

import club.javalearn.mybatis.entity.TPosition;

public interface TPositionMapper {

    int insert(TPosition record);

    int insertSelective(TPosition record);

    TPosition selectById(Integer id);
}