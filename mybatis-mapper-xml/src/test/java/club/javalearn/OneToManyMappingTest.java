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
 * @BelongsProject: mybatis-learn
 * @BelongsPackage: club.javalearn
 * @Author: king-pan
 * @CreateTime: 2019-07-26 16:35
 * @Description: 一对多关系映射
 */
public class OneToManyMappingTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before()throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 1.读取mybatis配置文件创SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }


    /**
     * 关联查询：1-1,内连接查询
     */
    @Test
    public void oneToMany(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        TUserMapper tUserMapper = sqlSession.getMapper(TUserMapper.class);
        List<TUser> users = tUserMapper.selectJobs1();
        for (TUser user:users){
            System.out.println(user);
        }

    }

    /**
     * 关联查询：1-1,按需延迟加载
     */
    @Test
    public void oneToMany2(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        TUserMapper tUserMapper = sqlSession.getMapper(TUserMapper.class);
        List<TUser> users = tUserMapper.selectJobs2();
        for (TUser user:users){
            System.out.println(user);
            System.out.println(user.getJobs().size());
        }

    }
}
