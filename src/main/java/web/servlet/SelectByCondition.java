package web.servlet;

import com.alibaba.fastjson.JSON;
import pojo.AddSong;
import pojo.PageBean;
import pojo.Song;
import pojo.SongCondition;
import service.Songservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * 分页条件查询
 */
@WebServlet("/selectByCondition")
public class SelectByCondition extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _currentpage=req.getParameter("currentpage");
        String _pagesize=req.getParameter("pagesize");
        String songname=req.getParameter("songname");
        String singername=req.getParameter("singername");
        int currentpage = Integer.parseInt(_currentpage);
        int pagesize = Integer.parseInt(_pagesize);

        Songservice songservice=new Songservice();

        SongCondition songCondition=new SongCondition();
        songCondition.setSongname(songname);
        songCondition.setSingername(singername);

        List<Song> pageTotalByCondition = songservice.getPageTotalByCondition(currentpage,pagesize,songCondition);
        int allTotalByCondition = songservice.getAllTotalByCondition(songCondition);
        PageBean pageBean=new PageBean();
        pageBean.setTotalCount(allTotalByCondition);
        pageBean.setRows(pageTotalByCondition);
        String jsonString = JSON.toJSONString(pageBean);
        resp.setContentType("text/json;charset=UTF-8");
        resp.getWriter().write(jsonString);
    }
}
