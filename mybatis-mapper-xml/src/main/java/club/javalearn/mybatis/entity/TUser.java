package club.javalearn.mybatis.entity;

import lombok.Data;

import java.util.List;

/**
 * @className: TUser
 * @description:
 * @author: King-Pan(pwpw1218@gmail.com)
 * @date: 2019-07-07 14:34
 */
@Data
public class TUser {
    private Integer id;

    private String userName;

    private String realName;

    private Byte sex;

    private String mobile;

    private String email;

    private String note;

    private TPosition position;

    private List<TJobHistory> jobs;

    private List<TRole> roles;
}
