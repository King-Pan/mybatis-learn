package club.javalearn.mybatis.mapper;

import club.javalearn.mybatis.entity.THealthReportFemale;
import club.javalearn.mybatis.entity.THealthReportFemaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THealthReportFemaleMapper {
    long countByExample(THealthReportFemaleExample example);

    int deleteByExample(THealthReportFemaleExample example);

    int insert(THealthReportFemale record);

    int insertSelective(THealthReportFemale record);

    List<THealthReportFemale> selectByExample(THealthReportFemaleExample example);

    int updateByExampleSelective(@Param("record") THealthReportFemale record, @Param("example") THealthReportFemaleExample example);

    int updateByExample(@Param("record") THealthReportFemale record, @Param("example") THealthReportFemaleExample example);
}