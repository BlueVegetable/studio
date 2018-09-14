package cn.studio.zps.blue.ljy.filters;

import cn.studio.zps.blue.ljy.domain.Access;
import cn.studio.zps.blue.ljy.domain.Role;
import cn.studio.zps.blue.ljy.domain.User;
import cn.studio.zps.blue.ljy.service.RoleService;
import cn.studio.zps.blue.ljy.service.UserService;
import cn.studio.zps.blue.ljy.utils.Response;
import com.sun.istack.internal.NotNull;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 蔡荣镔
 * @version 1.0
 */
@Component("AccessFilter")
public class AccessFilter implements Filter {

    @Autowired
    private UserService userService;

    public AccessFilter(){}

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        String identity = request.getParameter("identity");
        User user;
        if(identity == null|| identity.equals("")) {
            user = userService.getTourist();
            request.setAttribute("user",user);
        } else {
            String identityTrue = (String) session.getAttribute("identity");
            if(identityTrue == null) {
                Map<String,Object> result = Response.getResponseMap(1,"请先登录",null);
                print(result,response);
                return ;
            }
            if(!identity.equals(identityTrue)) {
                print(Response.getResponseMap(1,"操作用户错误",null),response);
                return ;
            } else {
                user = (User) session.getAttribute("user");
            }
        }
        Set<Access> accesses = user.getAccesses();
        boolean flag = false;
        for(Access access:accesses) {
            if(request.getRequestURI().endsWith(access.getUrl())) {
                flag = true;
                break;
            }
        }
        if(flag) {
            chain.doFilter(req,resp);
        } else {
            print(Response.getResponseMap(1,"权限不足",null),response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    private void print(Map<String,Object> result,@NotNull HttpServletResponse response) throws IOException {

        //这句话的意思，是让浏览器用utf8来解析返回的数据
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        //这句话的意思，是告诉servlet用UTF-8转码，而不是用默认的ISO8859
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();

        writer.println(JSONObject.fromObject(result));
        writer.flush();
        writer.close();
    }

}
