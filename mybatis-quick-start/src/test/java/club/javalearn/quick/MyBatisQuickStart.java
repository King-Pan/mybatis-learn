package club.javalearn.quick;

import club.javalearn.entity.TUser;
import club.javalearn.mapper.TUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @className: MyBatisQuickStart
 * @description:
 * @author: King-Pan(pwpw1218@gmail.com)
 * @date: 2019-07-07 11:22
 */
public class MyBatisQuickStart {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 1.读取mybatis配置文件创SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }


    @Test
    // 快速入门
    public void quickStart() throws IOException {
        // 2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.获取对应mapper
        TUserMapper mapper = sqlSession.getMapper(TUserMapper.class);
        System.out.println(mapper.getClass());
        // 4.执行查询语句并返回结果
        TUser user = mapper.selectByPrimaryKey(1);
        System.out.println(user.toString());

    }
}
