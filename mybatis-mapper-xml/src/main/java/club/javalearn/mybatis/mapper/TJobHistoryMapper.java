package club.javalearn.mybatis.mapper;

import club.javalearn.mybatis.entity.TJobHistory;

public interface TJobHistoryMapper {
    int insert(TJobHistory record);

    int insertSelective(TJobHistory record);

    TJobHistory selectByUserId(Integer userId);
}