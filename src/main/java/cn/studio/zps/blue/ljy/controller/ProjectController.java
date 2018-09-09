package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Project;
import cn.studio.zps.blue.ljy.service.ProjectService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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
        List<Long> userIDs = (List<Long>) data.get("userIDs");
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
        if(projectService.addProject(project,userIDs)) {
            return Response.getResponseMap(1,"添加成功",null);
        } else {
            return Response.getResponseMap(0,"添加失败",null);
        }
    }

    @ResponseBody
    @RequestMapping("getAllProjects")
    public Map<String,Object> getAllProjects() {
        Map<String,Object> result = Response.getResponseMap(1,"数据访问出错",null);
        try {
            List<Project> projects = projectService.getAllProjects();
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

}
