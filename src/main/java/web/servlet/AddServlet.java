package web.servlet;

import com.alibaba.fastjson.JSON;
import pojo.AddSong;
import service.Songservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

    /**
     * 增加歌曲
     */
 @WebServlet("/addServlet")
 public class AddServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            BufferedReader reader = req.getReader();
            String s = reader.readLine();
            AddSong addSong = JSON.parseObject(s, AddSong.class);
            boolean b = new Songservice().addSong(addSong.getSongname(), addSong.getSingername(),
                    addSong.getSongtype(),
                    addSong.getAge(), addSong.getSex());
            if (b) {
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

