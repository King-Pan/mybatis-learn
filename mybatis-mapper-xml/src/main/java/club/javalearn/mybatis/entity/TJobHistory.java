package club.javalearn.mybatis.entity;

import lombok.Data;

@Data
public class TJobHistory {
    private Integer id;

    private Integer userId;

    private String compName;

    private Integer years;

    private String title;
}