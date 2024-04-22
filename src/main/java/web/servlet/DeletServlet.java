package web.servlet;

import service.Songservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletServlet")
public class DeletServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int songid = Integer.parseInt(req.getParameter("songid"));
        if (new Songservice().deletSongById(songid)) {
            resp.getWriter().write(String.valueOf(true));
        }else {
            resp.getWriter().write(String.valueOf(false));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
