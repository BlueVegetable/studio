package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Access;

import java.util.Set;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
public interface AccessDao {

    Set<Access> getAccessByRoleID(int roleID);

}
