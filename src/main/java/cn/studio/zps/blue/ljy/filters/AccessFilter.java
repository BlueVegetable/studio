package cn.studio.zps.blue.ljy.filters;

import cn.studio.zps.blue.ljy.utils.Response;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class AccessFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String identity = request.getParameter("identity");
        Map<String,Object> result;
        if(identity==null) {
            result = Response.getResponseMap(1,"请求错误",null);
            print(result,response);
            return ;
        }
        HttpSession session = request.getSession();
        String trueIdentity = (String) session.getAttribute("trueIdentity");
        if(trueIdentity==null) {
            result = Response.getResponseMap(1,"请先登录",null);
            print(result,response);
            return ;
        }
        if(trueIdentity.equals(identity)) {
            chain.doFilter(req, resp);
        } else {
            result = Response.getResponseMap(1, "身份错误",null);
            print(result,response);
            return ;
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    private void print(Map<String,Object> result, HttpServletResponse response) throws IOException {

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
