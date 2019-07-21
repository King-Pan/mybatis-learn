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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void foreachTest1(){
        // 2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.获取对应mapper
        TRoleMapper mapper = sqlSession.getMapper(TRoleMapper.class);
        //4.执行
        List<Integer> ids = new ArrayList<>(10);
        ids.add(1);
        ids.add(2);
        ids.add(3);
        List<TRole> roleList = mapper.selectByIds(ids);
        System.out.println(roleList);
    }

    @Test
    public void foreachTest2(){
        // 2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.获取对应mapper
        TRoleMapper mapper = sqlSession.getMapper(TRoleMapper.class);
        //4.执行
        List<Integer> ids = new ArrayList<>(10);
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        List<TRole> roleList = mapper.selectByArray(ids.toArray(new Integer[]{}));
        System.out.println(roleList);
    }

    @Test
    public void foreachInsertByMapTest(){
        // 2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.获取对应mapper
        TRoleMapper mapper = sqlSession.getMapper(TRoleMapper.class);
        //4.执行
        Map<String,Object> map = new HashMap<>(10);
        map.put("id",5);
        map.put("role_name","supper man");
        map.put("note","超级管理员");
        int result = mapper.insertByMap(map);
        sqlSession.commit();
        System.out.println(result);
    }

    @Test
    public void foreachSelectByMapTest(){
        // 2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.获取对应mapper
        TRoleMapper mapper = sqlSession.getMapper(TRoleMapper.class);
        //4.执行
        Map<String,Object> map = new HashMap<>(10);
        map.put("ids",new Integer[]{1,3,5,6});
        map.put("roleName","supper");
        map.put("note","超级管理员");
        List<TRole> roleList = mapper.selectByMap(map);
        System.out.println(roleList);
    }



}
