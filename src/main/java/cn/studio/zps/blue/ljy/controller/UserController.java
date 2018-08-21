package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.User;
import cn.studio.zps.blue.ljy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/getUser",method = RequestMethod.POST)
    public @ResponseBody User getUser(@RequestParam("userID") long id) {
        return userService.getUser(id);
    }

}
