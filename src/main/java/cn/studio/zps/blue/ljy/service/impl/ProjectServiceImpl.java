package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.ProjectDao;
import cn.studio.zps.blue.ljy.domain.Project;
import cn.studio.zps.blue.ljy.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public boolean addProject(Project project,Long userID) {
        return projectDao.addProject(project,userID) > 0;
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
    public Map<String,Object> getProjectById(int projectID) {
        return projectDao.getProjectByID(projectID);
    }

    @Override
    public List<Map<String,Object>> getAllProjects() {
        return projectDao.getAllProjects();
    }

    @Override
    public boolean updateProject(Project project,Long principalID) {
        return projectDao.updateProject(project,principalID)>0;
    }
}
