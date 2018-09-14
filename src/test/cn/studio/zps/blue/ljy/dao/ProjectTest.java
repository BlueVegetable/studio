package cn.studio.zps.blue.ljy.dao;

import cn.studio.zps.blue.ljy.service.ProjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ProjectTest {

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private ProjectService projectService;

    @Test
    public void test1() {
        System.out.println(projectDao.getAllProjects());
    }

}
