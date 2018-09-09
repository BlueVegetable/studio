package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.Task;

import java.util.List;

public interface TaskService {

    int addTask(Task task);

    int deleteTask(int task);

    List<Task> getTasksByProjectID(int projectID);

    Task getTaskByID(int taskID);

    int countTasksByAdminID(int adminID);

    int updateTask(Task task);

}
