package mybatis.mapper;

import mybatis.po.Orders;
import mybatis.po.OrdersCustome;
import mybatis.po.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface OrdersMapper {
    //一对一的resultType实现
/*    public OrdersCustome selectThroughReslutType() throws Exception;*/

    //一对一resultMap实现
   public Orders selectThroughResultMap() throws Exception;

   //一对多实现
    public Orders selectOnePointSomeThroughResultMap() throws  Exception;

    //一对多
    public List<User> selectSomePointSomeThroughResultMap() throws Exception;
}
