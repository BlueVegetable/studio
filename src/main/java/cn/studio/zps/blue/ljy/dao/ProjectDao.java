package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
public interface ProjectDao {

    int addProject(@Param("project") Project project,@Param("userID") Long userID);

    int deleteProject(int projectID);

    int countTasks(int projectID);

    boolean existProject(String projectName);

    Project getProjectByID(int projectID);

    List<Project> getAllProjects();

    int updateProject(Project project);

}
