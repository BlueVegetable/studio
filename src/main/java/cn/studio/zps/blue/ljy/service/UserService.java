package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.User;

import java.util.List;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
public interface UserService {

    boolean addUser(User user);

    User getUserByLogin(String userName, String password);

    User getUser(long id);

    List<User> getUsersByRole(int roleID);

}
