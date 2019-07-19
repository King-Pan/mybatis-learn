package club.javalearn;

import club.javalearn.mybatis.entity.TUser;
import club.javalearn.mybatis.mapper.TUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @className: MybatisSymbolTest
 * @description:
 * @author: King-Pan(pwpw1218@gmail.com)
 * @date: 2019-07-10 18:24
 */
public class MybatisSymbolTest {

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
    public void ifTest(){
        // 2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.获取对应mapper
        TUserMapper mapper = sqlSession.getMapper(TUserMapper.class);
        TUser user = new TUser();
        user.setRealName("xxxx");
        user.setUserName("aaa");
        List<TUser> list = mapper.selectByUser(user);
        System.out.println(list);


    }

    @Test
    public void whereTest(){

    }

    @Test
    public void setTest(){

    }

    @Test
    public void trimTest(){

    }

}
