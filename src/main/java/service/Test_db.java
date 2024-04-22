package service;

import mapper.SongMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Song;
import pojo.UpdateSong;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test_db {
    public static void main(String[] args) throws IOException {
        UpdateSong updateSong=new UpdateSong();
        updateSong.setId(16);
        updateSong.setSongname("雅俗共赏");
        updateSong.setSingername("许嵩");
        System.out.println(updateSong);
        System.out.println(new Songservice().updatesong(updateSong));
    }
}
