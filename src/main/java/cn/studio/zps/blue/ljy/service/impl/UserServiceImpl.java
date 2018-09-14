package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.AccessDao;
import cn.studio.zps.blue.ljy.dao.RoleDao;
import cn.studio.zps.blue.ljy.dao.UserDao;
import cn.studio.zps.blue.ljy.domain.Access;
import cn.studio.zps.blue.ljy.domain.Role;
import cn.studio.zps.blue.ljy.domain.User;
import cn.studio.zps.blue.ljy.service.UserService;
import cn.studio.zps.blue.ljy.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 蔡荣镔
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private AccessDao accessDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user)>0;
    }

    @Override
    public User getUserByLogin(String userName, String password) {
        password = MD5.toMD5(password);
        return userDao.getUserByLogin(userName,password);
    }

    @Override
    public User getTourist() {
        User user = new User();
        List<Role> roles = new ArrayList<>();
        roles.add(roleDao.getRole(TOURIST_ROLE_ID));
        user.setRoles(roles);
        user.setAccesses(accessDao.getAccessByRoleID(TOURIST_ROLE_ID));
        return user;
    }

    @Override
    public User getUser(long id,byte all) {
        if(all == GET_USER_ALL_INFO) {
            return userDao.getUser(id);
        } else if(all == GET_USER_SIMPLE_INFO) {
            return userDao.getSimpleUserByID(id);
        } else {
            return null;
        }
    }

    @Override
    public List<User> getUsersByRole(int roleID) {
        return userDao.getUsersByRole(roleID);
    }
}
