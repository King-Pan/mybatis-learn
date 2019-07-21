package club.javalearn.mybatis.mapper;

import club.javalearn.mybatis.entity.TRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TRoleMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(TRole record);


    int insertSelective(TRole record);


    TRole selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);

    List<TRole> selectByIds(List<Integer> ids);


    List<TRole> selectByArray(Integer[] ids);

    List<TRole> selectByMap(Map<String,Object> map);

    int insertByMap(@Param("params") Map<String,Object> map);

}