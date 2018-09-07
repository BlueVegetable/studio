package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
public interface TaskDao {

    int addTask(@Param("projectID") int projectID, @Param("task") Task task);

    int deleteTask(int taskID);

    Task getTaskByID(int taskID);

    List<Task> getTasksByProjectID(int projectID);

    int updateTask(Task task);

}
