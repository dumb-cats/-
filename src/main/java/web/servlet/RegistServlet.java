package web.servlet;

import service.Userservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册服务器
 */
@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
    /**
     * 注册逻辑判断代码
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password=req.getParameter("password");
        resp.setContentType("text/html;charset=UTF-8");
        Userservice userservice=new Userservice();
        if (userservice.registed(username)!=null) {
            req.setAttribute("regist_msg","用户名重复");
            req.getRequestDispatcher("/regist.jsp").forward(req,resp);
        }else {
            userservice.regist(username,password);
            req.setAttribute("username_re",username);
            req.setAttribute("password_re",password);
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
