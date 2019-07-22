package club.javalearn.mybatis;

import club.javalearn.mybatis.entity.TUser;
import club.javalearn.mybatis.mapper.TUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * @className: MybatisBatchTest
 * @description: Mybatis批量操作测试类
 * @author: King-Pan(pwpw1218@gmail.com)
 * @date: 2019-07-21 15:42
 */
public class MybatisBatchTest {

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
    // Foreach用于批量插入
    public void testForeach4Insert() {
        // 2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.获取对应mapper
        TUserMapper mapper = sqlSession.getMapper(TUserMapper.class);

        TUser user1 = new TUser();
        user1.setUserName("king");
        user1.setRealName("李小京");
        user1.setEmail("li@qq.com");
        user1.setMobile("18754548787");
        user1.setNote("king's note");
        user1.setSex((byte)1);
        user1.setPositionId(1);
        TUser user2 = new TUser();
        user2.setUserName("deer");
        user2.setRealName("陈大林");
        user2.setEmail("chen@qq.com");
        user2.setMobile("18723138787");
        user2.setNote("deer's note");
        user2.setSex((byte)1);
        user2.setPositionId(1);


        int i = mapper.insertForeach4Batch(Arrays.asList(user1,user2));
        System.out.println(i);
    }

    @Test
    // 批量更新
    public void testBatchExecutor() {
        // 2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, true);
        // 3.获取对应mapper
        TUserMapper mapper = sqlSession.getMapper(TUserMapper.class);

        TUser user = new TUser();
        user.setUserName("mark");
        user.setRealName("毛毛");
        user.setEmail("xxoo@163.com");
        user.setMobile("18695988747");
        user.setNote("mark's note");
        user.setSex((byte) 1);
        user.setPositionId(1);
        System.out.println(mapper.insertSelective(user));

        TUser user1 = new TUser();
        user1.setUserName("cindy");
        user1.setRealName("王美丽");
        user1.setEmail("xxoo@163.com");
        user1.setMobile("18695988747");
        user1.setNote("cindy's note");
        user1.setSex((byte) 2);
        user1.setPositionId(1);
        System.out.println(mapper.insertSelective(user1));

        sqlSession.commit();
        System.out.println("----------------");

    }
}
