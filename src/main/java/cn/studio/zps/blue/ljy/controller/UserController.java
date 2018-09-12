package cn.studio.zps.blue.ljy.controller;

import cn.studio.zps.blue.ljy.domain.User;
import cn.studio.zps.blue.ljy.service.UserService;
import cn.studio.zps.blue.ljy.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="login",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> login(@RequestParam("userName") String userName,
                                                  @RequestParam("password") String password,
                                                  HttpServletRequest request) {
        User user = userService.getUserByLogin(userName,password);
        if(user==null) {
            return Response.getResponseMap(1,"用户不存在或用户名与密码不相符",null);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            Map<String,Object> result = Response.getResponseMap(0,"登录成功",user);
            return result;
        }
    }

    @RequestMapping("logout")
    public @ResponseBody Map<String,Object> logout(HttpSession session) {
        try {
            session.invalidate();
        } catch (Exception e) {
            return Response.getResponseMap(1,"注销失败",null);
        }
        return Response.getResponseMap(0,"注销成功",null);
    }

    @RequestMapping(value="/getUser",method = RequestMethod.POST)
    public @ResponseBody User getUser(@RequestParam("userID") long id) {
        return userService.getUser(id);
    }

    @RequestMapping("getUserByRole")
    public @ResponseBody List<User> getUserByRole(@RequestParam("roleID") int roleID) {
        return userService.getUsersByRole(roleID);
    }

    private Map<String,Object> addUser(User user) {
        if(userService.addUser(user)) {
            return Response.getResponseMap(0,"添加成功",null);
        } else {
            return Response.getResponseMap(1,"添加失败",null);
        }
    }

}