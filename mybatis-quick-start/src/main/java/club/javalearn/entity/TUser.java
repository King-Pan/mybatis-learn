package club.javalearn.entity;


import lombok.Data;

@Data
public class TUser {
    private Integer id;

    private String userName;

    private String realName;

    private Byte sex;

    private String mobile;

    private String email;

    private String note;

    private Integer positionId;

}