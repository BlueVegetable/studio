package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Project;

import java.util.List;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
public interface ProjectDao {

    int addProject(Project project);

    int deleteProject(int projectID);

    int countTasks(int projectID);

    Project getProjectByID(int projectID);

    List<Project> getAllProjects();

    int updateProject(Project project);

}
