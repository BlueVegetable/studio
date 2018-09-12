package cn.studio.zps.blue.ljy.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AccessDaoTest {

    @Autowired
    private AccessDao accessDao;
    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private TaskDao taskDao;

    @Test
    public void test1() {
        ;
    }

}
