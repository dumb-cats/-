package service;

import mapper.SongMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Singer;
import pojo.Song;
import pojo.SongCondition;
import pojo.UpdateSong;
import tool.GetSqlsession;

import java.io.IOException;
import java.util.List;

public class Songservice {
    /**
     * 查询所有歌曲信息
     * @return 歌曲对象集合
     * @throws IOException
     */
    public List<Song> getAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = GetSqlsession.getFactor();
        SqlSession sqlSession =sqlSessionFactory.openSession();
        SongMapper mapper =sqlSession.getMapper(SongMapper.class);
        List<Song> songs=mapper.selectAll();
        sqlSession.close();
        return songs;
    }

    /**
     * 获得歌手id
     * @param singername
     * @return
     * @throws IOException
     */
    public Integer getSingerId(String singername) throws IOException {
        SqlSessionFactory sqlSessionFactory = GetSqlsession.getFactor();
        SqlSession sqlSession =sqlSessionFactory.openSession();
        SongMapper mapper =sqlSession.getMapper(SongMapper.class);
        Integer i=mapper.selectSingerIdByname(singername);
        sqlSession.close();
        return i;
    }

    /**
     * 添加歌曲
     * @param songname
     * @param singername
     * @param songtype
     * @param age
     * @param sex
     */
    public boolean addSong ( String songname, String singername, String songtype, int age, String sex) throws IOException {
        SqlSessionFactory sqlSessionFactory = GetSqlsession.getFactor();
        SqlSession sqlSession =sqlSessionFactory.openSession(true);
        SongMapper mapper =sqlSession.getMapper(SongMapper.class);
        Integer singerId = getSingerId(singername);
        if (singerId!=null)
        {
            //歌手存在
             boolean ans=mapper.addSong(songname,songtype,singerId.intValue());
             sqlSession.close();
             return ans;
        } else {
            //歌手不存在
            addSinger(singername,age,sex);
            Integer i = mapper.selectSingerIdByname(singername);
            if (i!=null)
            {
                boolean ans=mapper.addSong(songname,songtype,singerId.intValue());
                sqlSession.close();
                return ans;
            }
        }
        return false;
    }

    /**
     * 添加歌手
     * @param singername
     * @param age
     * @param sex
     * @throws IOException
     */
    public void addSinger(String singername,int age, String sex) throws IOException {
        SqlSessionFactory sqlSessionFactory = GetSqlsession.getFactor();
        SqlSession sqlSession =sqlSessionFactory.openSession(true);
        SongMapper mapper =sqlSession.getMapper(SongMapper.class);
        mapper.addSinger(singername,sex,age);
        sqlSession.close();
    }

    /**
     * 删除歌曲通过id
     * @param id
     * @return
     * @throws IOException
     */
    public boolean deletSongById(int id) throws IOException {
        SqlSessionFactory sqlSessionFactory = GetSqlsession.getFactor();
        SqlSession sqlSession =sqlSessionFactory.openSession(true);
        SongMapper mapper =sqlSession.getMapper(SongMapper.class);
        return mapper.deletsongById(id);
    }

    /**
     * 返回数据库的总页数
     * @return
     * @throws IOException
     */
    public int getAllTotal() throws IOException {
        SqlSessionFactory sqlSessionFactory = GetSqlsession.getFactor();
        SqlSession sqlSession =sqlSessionFactory.openSession(true);
        SongMapper mapper =sqlSession.getMapper(SongMapper.class);
        int total = mapper.selectAllTotal();
        sqlSession.close();
        return total;
    }

    /**
     * 查询该页的总数据
     * @param currentPage
     * @param size
     * @return
     * @throws IOException
     */
    public List<Song> getPageTotal(int currentPage,int size) throws IOException {
        SqlSessionFactory sqlSessionFactory = GetSqlsession.getFactor();
        SqlSession sqlSession =sqlSessionFactory.openSession(true);
        SongMapper mapper =sqlSession.getMapper(SongMapper.class);
        int being=(currentPage-1)*size;
        List<Song> Pagesongs = mapper.selectByPage(being, size);
        sqlSession.close();
        return Pagesongs;
    }

    /**
     * 分页条件查询
     * @param currentPage
     * @param size
     * @param songCondition
     * @return
     * @throws IOException
     */
    public List<Song> getPageTotalByCondition(int currentPage, int size,SongCondition songCondition ) throws IOException {
        SqlSessionFactory sqlSessionFactory = GetSqlsession.getFactor();
        SqlSession sqlSession =sqlSessionFactory.openSession(true);
        SongMapper mapper =sqlSession.getMapper(SongMapper.class);
        int being=(currentPage-1)*size;
        List<Song> Pagesongs = mapper.selectPageByCondition(being, size,songCondition.getSongname(),songCondition.getSingername());
        sqlSession.close();
        return Pagesongs;
    }

    /**
     * 分页条件查询的总数
     * @param songCondition
     * @return
     * @throws IOException
     */
    public int getAllTotalByCondition(SongCondition songCondition) throws IOException {
        SqlSessionFactory sqlSessionFactory = GetSqlsession.getFactor();
        SqlSession sqlSession =sqlSessionFactory.openSession(true);
        SongMapper mapper =sqlSession.getMapper(SongMapper.class);
        int total = mapper.selectAllTotalByCondition(songCondition.getSongname(),songCondition.getSingername());
        sqlSession.close();
        return total;
    }
    public boolean updatesong(UpdateSong updateSong) throws IOException {
        SqlSessionFactory sqlSessionFactory = GetSqlsession.getFactor();
        SqlSession sqlSession =sqlSessionFactory.openSession(true);
        SongMapper mapper =sqlSession.getMapper(SongMapper.class);
        Integer i = mapper.selectSingerIdByname(updateSong.getSingername());
        if (i!=null) {
            //歌手存在
            boolean b = mapper.updateById(updateSong.getSongname(), updateSong.getSongtype(), i, updateSong.getId());
            sqlSession.close();
            return b;

        } else{
            //歌手不存在
            addSinger(updateSong.getSingername(), 26,"男");
            Integer ii = mapper.selectSingerIdByname(updateSong.getSingername());
            if (ii!=null) {
                boolean b = mapper.updateById(updateSong.getSongname(), updateSong.getSongtype(), ii, updateSong.getId());
                sqlSession.close();
                return b;
            }
        }
        return false;
    }
}
