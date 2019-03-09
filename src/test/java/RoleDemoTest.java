import com.itheima.zero.mapper.RoleMapper;
import com.itheima.zero.pojo.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.apache.ibatis.io.Resources.*;

public class RoleDemoTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void before() throws IOException {
        InputStream inputStream = getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(inputStream);
        inputStream.close();
    }
    @Test
    public void TestqueryRoleWithUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roleList = mapper.queryRoleWithUser();
        if(roleList != null && roleList.size() > 0){
            for (Role role : roleList) {
                System.out.println(role);
            }
        }

    }
}
