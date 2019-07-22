package club.javalearn.mybatis.mapper;

import club.javalearn.mybatis.entity.TJobHistory;
import club.javalearn.mybatis.entity.TJobHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TJobHistoryMapper {
    long countByExample(TJobHistoryExample example);

    int deleteByExample(TJobHistoryExample example);

    int insert(TJobHistory record);

    int insertSelective(TJobHistory record);

    List<TJobHistory> selectByExample(TJobHistoryExample example);

    int updateByExampleSelective(@Param("record") TJobHistory record, @Param("example") TJobHistoryExample example);

    int updateByExample(@Param("record") TJobHistory record, @Param("example") TJobHistoryExample example);
}