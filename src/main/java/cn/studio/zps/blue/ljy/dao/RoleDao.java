package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Role;

import java.util.List;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
public interface RoleDao {

    /**
     * 根据用户id获取用户的所有角色
     * @param amindID 用户id
     * @return 用户角色列表
     */
    List<Role> getRoleByAdminID(long amindID);

}
