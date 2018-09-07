package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.Project;
import cn.studio.zps.blue.ljy.service.ProjectService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

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
