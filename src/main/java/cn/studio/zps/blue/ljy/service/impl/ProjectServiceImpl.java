package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.ProjectDao;
import cn.studio.zps.blue.ljy.domain.Project;
import cn.studio.zps.blue.ljy.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public boolean addProject(Project project,List<Long> userIDs) {
        int result = projectDao.addProject(project);
        if(result < 0) {
            return false;
        }
        if(projectDao.linkProjectUser(project.getId(),userIDs)>0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteProject(int projectID) {
        return projectDao.deleteProject(projectID)>0;
    }

    @Override
    public int countTasks(int projectID) {
        return projectDao.countTasks(projectID);
    }

    @Override
    public boolean existProject(String projectName) {
        return projectDao.existProject(projectName);
    }

    @Override
    public Project getProjectById(int projectID) {
        return projectDao.getProjectByID(projectID);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectDao.getAllProjects();
    }

    @Override
    public boolean updateProject(Project project) {
        return projectDao.updateProject(project)>0;
    }
}
