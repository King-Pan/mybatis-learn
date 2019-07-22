package club.javalearn.mybatis;

import club.javalearn.mybatis.entity.TUser;
import club.javalearn.mybatis.entity.TUserExample;
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
 * @className: MybatisExampleTest
 * @description:
 * @author: King-Pan(pwpw1218@gmail.com)
 * @date: 2019-07-21 15:16
 */
public class MybatisExampleTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before()throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 1.读取mybatis配置文件创SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }


    @Test
    public void testQueryExample(){
        //2. 获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取mapper
        TUserMapper mapper = sqlSession.getMapper(TUserMapper.class);

        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailLike("%163.com");
        criteria.andSexEqualTo((byte) 2);

        List<TUser> userList = mapper.selectByExample(example);
        System.out.println(userList);

    }

}
