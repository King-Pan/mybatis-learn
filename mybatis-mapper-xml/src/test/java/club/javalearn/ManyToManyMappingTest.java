package club.javalearn;

import club.javalearn.mybatis.entity.TRole;
import club.javalearn.mybatis.entity.TUser;
import club.javalearn.mybatis.mapper.TRoleMapper;
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
 * @Author: King-Pan(pwpw1218@gmail.com)
 * @CreateTime: 2019-07-26 22:55
 * @Description: 多对多映射关系测试
 */
public class ManyToManyMappingTest {
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
     * 关联查询：多对多
     */
    @Test
    public void manyToMany(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        TUserMapper tUserMapper = sqlSession.getMapper(TUserMapper.class);
        List<TUser> users = tUserMapper.selectUserRole();
        for (TUser user:users){
            System.out.println(user);
        }

    }

    /**
     * 关联查询：1-1,按需延迟加载
     */
    @Test
    public void manyToMany2(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        TRoleMapper tRoleMapper = sqlSession.getMapper(TRoleMapper.class);
        List<TRole> roles = tRoleMapper.selectRoleUser();
        for (TRole role:roles){
            System.out.println(role);
        }

    }
}
