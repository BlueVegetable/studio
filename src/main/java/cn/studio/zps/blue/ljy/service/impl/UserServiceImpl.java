package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.UserDao;
import cn.studio.zps.blue.ljy.domain.User;
import cn.studio.zps.blue.ljy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 蔡荣镔
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }
}
