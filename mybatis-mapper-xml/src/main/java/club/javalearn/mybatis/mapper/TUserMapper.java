package club.javalearn.mybatis.mapper;

import club.javalearn.mybatis.entity.TUser;
import club.javalearn.mybatis.vo.NameNoteBen;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @className: TUserMapper
 * @description:
 * @author: King-Pan(pwpw1218@gmail.com)
 * @date: 2019-07-07 14:40
 */

public interface TUserMapper {

    TUser selectById(Integer id);

    List<TUser> selectPosition1();

    List<TUser> selectPosition2();

    List<TUser> selectByUser(TUser user);

    List<TUser> selectByNameAndEmail(Map<String, Object> map);

    List<TUser> selectByNameAndAge(@Param("name") String name, @Param("age") Integer age);

    List<TUser> selectByNameAndNote(NameNoteBen nameNoteBen);

    Integer insert(TUser tUser);

    Integer insert2(TUser tUser);

    /**
     * 预编译: #{}将传入的数据都当初一个字符串，会对自动传入的数据加一个双引号，能够很大程度防止sql注入
     * 传值: ${} 传入的数据执行显示在生成的sql中，无法防止sql注入
     * 表名、选取的列是动态的，order by 和in操作，可以考虑使用$
     *
     * @param tableName
     * @param inCol
     * @param orderStr
     * @param sex
     * @return
     */
    List<TUser> findListBySymbol(@Param("tableName") String tableName, @Param("inCol") String inCol, @Param("orderStr") String orderStr, @Param("sex") Byte sex);


    @Results(id = "UserResultMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "realName", column = "user_name"),
            @Result(property = "realName", column = "real_name"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "email", column = "email"),
            @Result(property = "note", column = "note"),
            @Result(property = "positionId", column = "position_id")
    })
    @Select(value = "select id, user_name , real_name , sex, mobile, email, note,position_id positionId from t_user")
    List<TUser> findAll();



    @Insert("insert into t_user(id,real_name) values(id,realName)")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Integer insert3(TUser tUser);



    void update(TUser user);

}
