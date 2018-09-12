package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.AccessDao;
import cn.studio.zps.blue.ljy.dao.UserDao;
import cn.studio.zps.blue.ljy.domain.Access;
import cn.studio.zps.blue.ljy.domain.Role;
import cn.studio.zps.blue.ljy.domain.User;
import cn.studio.zps.blue.ljy.service.UserService;
import cn.studio.zps.blue.ljy.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public User getUser(long id) {
        final User user = userDao.getBaseUser(id);
        Set<Access> accesses = new HashSet<>();
        for(Role role : user.getRoles()) {
            accesses.addAll(accessDao.getAccessByRoleID(role.getId()));
        }
        user.setAccesses(accesses);
        return user;
    }

    @Override
    public List<User> getUsersByRole(int roleID) {
        return userDao.getUsersByRole(roleID);
    }
}
