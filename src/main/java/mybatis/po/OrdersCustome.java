package mybatis.po;

/**
 * orders 订单的扩展类
 */
public class OrdersCustome   extends  Orders{
    //属性名和数据库字段对应
    private  String id;
    private  String name;
    private  String tel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
