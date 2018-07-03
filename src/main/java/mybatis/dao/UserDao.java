package mybatis.dao;

import mybatis.po.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserDao {
    //根据ID查询用户
    public User findUserById(int id) throws Exception;

    //根据name模糊查询用户

    public List<User> findUserByName(String name) throws Exception;

    //添加用户
    public void insertUser(User user) throws Exception;
}
