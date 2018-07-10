import mybatis.dao.UserDaoImpl;
import mybatis.mapper.UserMapper;
import mybatis.po.User;
import mybatis.po.UserCustom;
import mybatis.po.UserQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MappperMybatis {
    public static void main(String[] args) {
        try {
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            //创建会话工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //添加用户
            User user = new User();
            user.setName("bbbbdasdasdddd");
            user.setTel("111111");

            //生成代理对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //生成mapper对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
          /*  userMapper.insertUser(user);
            sqlSession.commit();*/
            UserCustom userCustom = new UserCustom();
            userCustom.setId("2");
            userCustom.setName("王");

            //声明IDS
            List<Integer> ids = new ArrayList<Integer>();
            ids.add(123);
            ids.add(111);
            UserQueryVo userQueryVo = new UserQueryVo();
            userQueryVo.setUserCustom(userCustom);
            userQueryVo.setIds(ids);

            List<UserCustom> userCustoms= userMapper.queryUserByMap(userQueryVo);
            System.out.println(userCustoms);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
