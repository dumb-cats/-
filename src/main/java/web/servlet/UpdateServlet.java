package web.servlet;

import com.alibaba.fastjson.JSON;
import pojo.UpdateSong;
import service.Songservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        UpdateSong updateSong = JSON.parseObject(s, UpdateSong.class);
        boolean b = new Songservice().updatesong(updateSong);
        resp.getWriter().write(String.valueOf(b));
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req, resp);
    }
}
