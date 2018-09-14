package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.TaskDao;
import cn.studio.zps.blue.ljy.domain.Task;
import cn.studio.zps.blue.ljy.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public boolean addTask(int projectID, Task task) {
        return taskDao.addTask(projectID,task)>0;
    }

    @Override
    public boolean deleteTask(int taskID) {
        return taskDao.deleteTask(taskID)>0;
    }

    @Override
    public List<Task> getTasksByProjectID(int projectID) {
        return taskDao.getTasksByProjectID(projectID);
    }

    @Override
    public Task getTaskByID(int taskID) {
        return taskDao.getTaskByID(taskID);
    }

    @Override
    public int countTasksByAdminID(int adminID) {
        return 0;
    }

    @Override
    public boolean updateTask(Task task) {
        return taskDao.updateTask(task)>0;
    }
}
