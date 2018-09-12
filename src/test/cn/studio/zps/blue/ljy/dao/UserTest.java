package cn.studio.zps.blue.ljy.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void test1() {
        System.out.println(userDao.getUserByLogin("蔡荣镔","052028c968fcb9011d8120cf3fafc8da"));
    }

}
