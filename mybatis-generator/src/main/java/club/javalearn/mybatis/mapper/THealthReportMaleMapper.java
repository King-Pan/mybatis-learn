package club.javalearn.mybatis.mapper;

import club.javalearn.mybatis.entity.THealthReportMale;
import club.javalearn.mybatis.entity.THealthReportMaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THealthReportMaleMapper {
    long countByExample(THealthReportMaleExample example);

    int deleteByExample(THealthReportMaleExample example);

    int insert(THealthReportMale record);

    int insertSelective(THealthReportMale record);

    List<THealthReportMale> selectByExample(THealthReportMaleExample example);

    int updateByExampleSelective(@Param("record") THealthReportMale record, @Param("example") THealthReportMaleExample example);

    int updateByExample(@Param("record") THealthReportMale record, @Param("example") THealthReportMaleExample example);
}