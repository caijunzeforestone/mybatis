import dao.UserDao;
import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.InputStream;
import java.util.List;

public class test {

    @Test
    public void test() throws Exception {
        //1.创建sqlSessionFactoryBuilder对象，准备读取核心配置文件
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //2.读取核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("Mybatis-Config.xml");
        //3.创建sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //4.创建会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserDao这个接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //查询
        List<User> all = userDao.all();
        for (User user : all) {
            System.out.println(user);
        }
    }
}
