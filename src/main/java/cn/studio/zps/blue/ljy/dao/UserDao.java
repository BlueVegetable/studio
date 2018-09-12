package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
public interface UserDao {

    /**
     * 登录：输入用户名和密码，如果存在且用户名与密码正确，则返回数据，否则返回null
     * @param userName 用户名
     * @param password 密码
     * @return 用户所有信息
     */
    User getUserByLogin(@Param("userName") String userName, @Param("password") String password);

    /**
     * 增加用户
     * @param user 待增加的用户
     * @return 增加的用户数
     */
    int addUser(User user);

    /**
     * 通过用户id获取用户的基本信息,不包括权限
     * @param userId 传入用户id
     * @return 用户的所有信息
     */
    User getBaseUser(long userId);

    /**
     * 通过角色获取该类角色的用户
     * @param roleID 角色ID
     * @return 用户列表
     */
    List<User> getUsersByRole(int roleID);

}