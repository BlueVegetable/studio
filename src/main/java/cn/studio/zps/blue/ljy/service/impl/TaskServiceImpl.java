package cn.studio.zps.blue.ljy.service.impl;

import cn.studio.zps.blue.ljy.dao.TaskDao;
import cn.studio.zps.blue.ljy.domain.Task;
import cn.studio.zps.blue.ljy.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public int addTask(Task task) {
        return 0;
    }

    @Override
    public int deleteTask(int task) {
        return 0;
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
    public int updateTask(Task task) {
        return 0;
    }
}
