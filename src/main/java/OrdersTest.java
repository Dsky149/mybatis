import mybatis.mapper.OrdersMapper;
import mybatis.po.Orders;
import mybatis.po.OrdersCustome;
import mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

public class OrdersTest {
    public static void main(String[] args) {
        try {
            //加载XML
           InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
           //初始化会话工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //初始化session
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //生成Mapper对象
            OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

            //一对一生成
//            OrdersCustome ordersCustome = ordersMapper.selectThroughReslutType();

            //一对一resultMap实现
//              Orders orders = ordersMapper.selectThroughResultMap();

              //一对多特殊需求
//            Orders orders = ordersMapper.selectOnePointSomeThroughResultMap();

            //一对多测试
            List<User> users = ordersMapper.selectSomePointSomeThroughResultMap();
            System.out.println("------------------"+users);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
