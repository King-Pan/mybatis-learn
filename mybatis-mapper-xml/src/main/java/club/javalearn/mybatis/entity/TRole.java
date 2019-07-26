package club.javalearn.mybatis.entity;


import lombok.Data;

import java.util.List;

@Data
public class TRole {

    private Integer id;

    private String roleName;

    private String note;

    private List<TUser> users;
}