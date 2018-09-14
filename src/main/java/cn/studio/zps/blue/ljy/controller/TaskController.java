package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Task;
import cn.studio.zps.blue.ljy.service.TaskService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
@Controller
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("addTask")
    public @ResponseBody Map<String,Object> addTask(@RequestBody Map<String,Object> parameters) throws InvocationTargetException, IllegalAccessException {
        Task task = new Task();
        BeanUtils.populate(task,parameters);
        int projectID = (int) parameters.get("projectID");
        if(taskService.addTask(projectID,task)) {
            return Response.getResponseMap(0,"添加成功",null);
        } else {
            return Response.getResponseMap(1,"添加失败",null);
        }
    }

    public @ResponseBody Map<String,Object> deleteTask(@RequestParam("taskID") int taskID) {
        if(taskService.deleteTask(taskID)) {
            return Response.getResponseMap(0,"删除失败",null);
        } else {
            return Response.getResponseMap(1,"删除失败",null);
        }
    }

    @ResponseBody
    @RequestMapping("getTaskByID")
    public Task getTaskByID(@RequestParam("taskID") int taskID){
        return taskService.getTaskByID(taskID);
    }

    @ResponseBody
    @RequestMapping("getTasksByProjectID")
    public Map<String,Object> getTasksByProjectID(@RequestParam("projectID") int projectID) {
        List<Task> tasks = taskService.getTasksByProjectID(projectID);
        Map<String,Object> result = Response.getResponseMap(0,"",tasks);
        result.put("count",tasks.size());
        return result;
    }

    @RequestMapping("updateTask")
    public @ResponseBody Map<String,Object> updateTask(@RequestBody Task task) {
        if(taskService.updateTask(task)) {
            return Response.getResponseMap(0,"修改失败",null);
        } else {
            return Response.getResponseMap(1,"修改失败",null);
        }
    }

}