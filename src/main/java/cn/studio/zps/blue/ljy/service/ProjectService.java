package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.Project;

import java.util.List;
import java.util.Map;

public interface ProjectService {

    boolean addProject(Project project,Long userIDs);

    boolean deleteProject(int projectID);

    int countTasks(int projectID);

    boolean existProject(String projectName);

    Map<String,Object> getProjectById(int projectID);

    List<Map<String,Object>> getAllProjects();

    boolean updateProject(Project project,Long principalID);

}
