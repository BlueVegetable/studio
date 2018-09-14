package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
public interface TaskDao {

    /**
     * 添加任务
     * @param projectID 任务所属项目ID
     * @param task 任务本体
     * @return 添加的任务的数量
     */
    int addTask(@Param("projectID") int projectID, @Param("task") Task task);

    int deleteTask(int taskID);

    Task getTaskByID(int taskID);

    List<Task> getTasksByProjectID(int projectID);

    int updateTask(Task task);

}
