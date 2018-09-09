package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.domain.Project;
import cn.studio.zps.blue.ljy.service.ProjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ProjectTest {

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private ProjectService projectService;

    @Test
    public void test1() {
        Project project = projectDao.getProjectByID(1);
        List<Long> userIDs = new ArrayList<>();
        userIDs.add(1l);
        userIDs.add(2l);
        userIDs.add(3l);
        userIDs.add(4l);
        userIDs.add(5l);
        userIDs.add(6l);
        project.setId(8);
//        Object result = projectDao.linkProjectUser(3,userIDs);
        Object result = projectService.addProject(project,userIDs);
        System.out.println(result);
    }

}
