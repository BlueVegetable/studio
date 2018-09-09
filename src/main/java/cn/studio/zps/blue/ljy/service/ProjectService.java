package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.Project;

import java.util.List;

public interface ProjectService {

    boolean addProject(Project project,List<Long> userIDs);

    boolean deleteProject(int projectID);

    int countTasks(int projectID);

    boolean existProject(String projectName);

    Project getProjectById(int projectID);

    List<Project> getAllProjects();

    boolean updateProject(Project project);

}
