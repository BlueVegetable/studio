package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.Project;

import java.util.List;

public interface ProjectService {

    boolean addProject(Project project);

    boolean deleteProject(int projectID);

    int countTasks(int projectID);

    Project getProjectById(int projectID);

    List<Project> getAllProjects();

    boolean updateProject(Project project);

}
