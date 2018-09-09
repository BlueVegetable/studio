package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Task;
import cn.studio.zps.blue.ljy.service.TaskService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;

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

}