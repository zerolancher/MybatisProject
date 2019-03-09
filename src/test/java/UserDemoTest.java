import com.itheima.zero.mapper.UserMapper;
import com.itheima.zero.pojo.QueryVo;

import com.itheima.zero.pojo.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserDemoTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(inputStream);
        inputStream.close();
    }
    @Test
    public void testQueryUserBywhere() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        //user.setSex("1");
        user.setUsername("%王%");
        List<User> list = mapper.queryUserByWhere(user);
        if(list != null && list.size()>0){
            for (User user1 : list) {
                System.out.println(user1);
            }
        }
    }


    @Test
    public void testQueryUserByForeach() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        List<User> userList = mapper.queryUserByForeach(list);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryUserByArray() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
       int[] array = new int[]{1,2,3};
        List<User> userList = mapper.queryUserByArray(array);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryUserByPojo() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
       Integer[] array = new Integer[]{1,2,31};
        QueryVo vo = new QueryVo();
        vo.setIdsArray(array);
        List<User> userList = mapper.queryUserByPojo(vo);
        for (User user : userList) {
            System.out.println(user);
        }
    }


    @Test
    public void TestQueryUserByOrdersUID() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.queryUserByOrdersUID();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();

    }

    @Test
    public void TestQueryUserFromRole() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.QueryUserFromRole();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
