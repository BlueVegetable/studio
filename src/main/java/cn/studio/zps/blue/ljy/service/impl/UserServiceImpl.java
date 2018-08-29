package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.AccessDao;
import cn.studio.zps.blue.ljy.dao.UserDao;
import cn.studio.zps.blue.ljy.domain.Access;
import cn.studio.zps.blue.ljy.domain.Role;
import cn.studio.zps.blue.ljy.domain.User;
import cn.studio.zps.blue.ljy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
    public User getUser(long id) {
        final User user = userDao.getBaseUser(id);
        Set<Access> accesses = new HashSet<>();
        for(Role role : user.getRoles()) {
            accesses.addAll(accessDao.getAccessByRoleID(role.getId()));
        }
        user.setAccesses(accesses);
        return user;
    }
}
