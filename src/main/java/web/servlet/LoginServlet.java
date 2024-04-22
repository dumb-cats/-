package web.servlet;

import pojo.User;
import service.Userservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *登录服务器
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    /**
     * 登录逻辑判断代码
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Userservice userservice=new Userservice();
        User user=userservice.login(username,password);
        resp.setContentType("text/html;charset=UTF-8");
        if (user!=null) {
            if (user.getUsername().equals("goudan")&&user.getPassword().equals("123456")) {
                resp.sendRedirect("/Javaweb_Version1/main.html");
            }else {
                resp.sendRedirect("/Javaweb_Version1/usermain.html");
            }
        }else {
            req.setAttribute("login_msg","账号或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
