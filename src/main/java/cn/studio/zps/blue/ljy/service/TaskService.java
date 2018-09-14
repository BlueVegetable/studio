package cn.studio.zps.blue.ljy.service;

import cn.studio.zps.blue.ljy.domain.Task;

import java.util.List;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
public interface TaskService {

    /**
     * 添加任务
     * @param projectID 任务所属项目ID
     * @param task 任务本体
     * @return 添加的任务的数量
     */
    boolean addTask(int projectID,Task task);

    boolean deleteTask(int taskID);

    List<Task> getTasksByProjectID(int projectID);

    Task getTaskByID(int taskID);

    int countTasksByAdminID(int adminID);

    boolean updateTask(Task task);

}
