package mybatis.mapper;

import mybatis.po.User;
import mybatis.po.UserCustom;
import mybatis.po.UserQueryVo;

import java.util.List;

public interface UserMapper {
    //根据ID查询用户
    public User findUserById(int id) throws Exception;

    //根据name模糊查询用户

    public List<User> findUserByName(String name) throws Exception;

    //添加用户
    public void insertUser(User user) throws Exception;

    //综合查询
    public List<UserCustom> queryUser(UserQueryVo userQueryVo) throws Exception;

    //综合查询
    public List<UserCustom> queryUserByMap(UserQueryVo userQueryVo) throws Exception;

    //综合查询个数
    public int queryUserCount(UserQueryVo userQueryVo) throws Exception;
}
