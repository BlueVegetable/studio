package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Project;
import cn.studio.zps.blue.ljy.service.ProjectService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
@Controller
@RequestMapping("project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
     * 此变量是用于表示项目的初始状态
     */
    private static final short INIT_STATE = 1;

    @ResponseBody
    @RequestMapping("addProject")
    public Map<String,Object> addProject(@RequestBody Map<String,Object> data) {
        Project project = new Project();
        Long userID = Long.parseLong((String) data.get("userID"));
        try {
            BeanUtils.populate(project,data);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.getResponseMap(1,"传递数据有误",null);
        }
        if(projectService.existProject(project.getName())) {
            return Response.getResponseMap(1,"该项目存在",null);
        }
        project.setState(INIT_STATE);
        if(projectService.addProject(project,userID)) {
            return Response.getResponseMap(1,"添加成功",null);
        } else {
            return Response.getResponseMap(0,"添加失败",null);
        }
    }

    @RequestMapping("deleteProject")
    public @ResponseBody Map<String,Object> deleteProject(@RequestParam("projectID") Integer projectID) {
        if(projectService.deleteProject(projectID)) {
            return Response.getResponseMap(0,"删除成功",null);
        } else {
            return Response.getResponseMap(1,"删除失败",null);
        }
    }

    @RequestMapping("getProjectByID")
    public @ResponseBody Map<String,Object> getProjectByID(@RequestParam("projectID") int projectID){
        Map<String,Object> project = projectService.getProjectById(projectID);
        if(project==null){
            return Response.getResponseMap(1,"项目不存在",null);
        } else {
            return Response.getResponseMap(0,"获取成功",project);
        }
    }

    @ResponseBody
    @RequestMapping("getAllProjects")
    public Map<String,Object> getAllProjects() {
        Map<String,Object> result = Response.getResponseMap(1,"数据访问出错",null);
        try {
            List<Map<String,Object>> projects = projectService.getAllProjects();
            result.put("code",0);
            result.put("msg","");
            result.put("count",projects.size());
            result.put("data",projects);
        } catch(Exception e) {
            result.put("count",0);
            e.printStackTrace();;
        }
        return result;
    }

    @RequestMapping("updateProject")
    public @ResponseBody Map<String,Object> updateProject(@RequestBody Map<String,Object> data) throws InvocationTargetException, IllegalAccessException {
        Project project = new Project();
        BeanUtils.populate(project,data);
        Long principalID = Long.parseLong((String) data.get("principalID"));
        if(project.getState()==2) {
            project.setFinishTime(new Timestamp(System.currentTimeMillis()));
        } else if(project.getState()==1) {
            project.setFinishTime(null);
        }
        if(projectService.updateProject(project,principalID)) {
            return Response.getResponseMap(0,"修改成功",null);
        } else {
            return Response.getResponseMap(1,"修改失败",null);
        }
    }

}