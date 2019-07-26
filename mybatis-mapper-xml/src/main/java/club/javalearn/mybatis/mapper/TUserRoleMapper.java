package club.javalearn.mybatis.mapper;

import club.javalearn.mybatis.entity.TUserRoleKey;

/**
 * @BelongsProject: mybatis-learn
 * @BelongsPackage: club.javalearn.mybatis.mapper
 * @Author: King-Pan(pwpw1218@gmail.com)
 * @CreateTime: 2019-07-26 23:04
 * @Description: 用户角色关系表mapper
 */
public interface TUserRoleMapper {
    int deleteByPrimaryKey(TUserRoleKey key);

    int insert(TUserRoleKey record);

    int insertSelective(TUserRoleKey record);
}
