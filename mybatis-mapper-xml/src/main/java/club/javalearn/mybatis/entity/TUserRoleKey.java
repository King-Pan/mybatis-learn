package club.javalearn.mybatis.entity;

import lombok.Data;

/**
 * @BelongsProject: mybatis-learn
 * @BelongsPackage: club.javalearn.mybatis.entity
 * @Author: King-Pan(pwpw1218@gmail.com)
 * @CreateTime: 2019-07-26 23:02
 * @Description: 用户角色关联表
 */
@Data
public class TUserRoleKey {
  private Integer userId;
  private Integer roleId;
}
