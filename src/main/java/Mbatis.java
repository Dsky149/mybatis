import mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mbatis {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = null;
        try {
            //引入mybaitis配置文件，其实为总文件
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            //创建会话工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //创建工厂得到SqlSession
            sqlSession = sqlSessionFactory.openSession();
            //通过SqlSession操作数据库
            //更具用户ID
            /*User user = sqlSession.selectOne("test.findUserById",1);*/
//            //根据用户名称模糊查询
//            List<User> user =  sqlSession.selectList("test.findUserByName","张");
//            //输出
//            System.out.println(user);

            //插入
            User user = new User();
            user.setName("王x二");
            user.setTel("123");

            //插入
            sqlSession.insert("test.insertUser", user);

            //删除
//            sqlSession.delete("test.deleteUser","1");
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }
}
