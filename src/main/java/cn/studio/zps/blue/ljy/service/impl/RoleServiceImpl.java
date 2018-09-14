package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.RoleDao;
import cn.studio.zps.blue.ljy.domain.Role;
import cn.studio.zps.blue.ljy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author 蔡荣镔
 * @version 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role getRoleByID(int roleID) {
        return roleDao.getRole(roleID);
    }
}
