package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.User;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
public interface UserDao {

    /**
     * 通过用户id获取用户的基本信息,不包括权限
     * @param userId 传入用户id
     * @return 用户的所有信息
     */
    User getBaseUser(long userId);

}
