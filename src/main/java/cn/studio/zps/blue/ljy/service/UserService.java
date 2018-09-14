package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.User;

import java.util.List;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
public interface UserService {

    /**
     * 游客的角色ID
     */
    int TOURIST_ROLE_ID = 9;

    boolean addUser(User user);

    User getUserByLogin(String userName, String password);

    User getTourist();

    User getUser(long id);

    List<User> getUsersByRole(int roleID);

}
