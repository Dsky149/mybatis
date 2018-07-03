package mybatis;
import mybatis.dao.UserDaoImpl;
import mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class OriginalDaoMybatis {
    public static void main(String[] args) throws Exception {
        //import the xml file
        try {
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            //创建会话工厂
            SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);

            //添加用户
            User user = new User();
            user.setName("hahha");
            user.setTel("111111");
            //
            UserDaoImpl userDao = new UserDaoImpl(sqlSessionFactory);
            userDao.insertUser(user);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
