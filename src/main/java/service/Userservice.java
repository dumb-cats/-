package service;

import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.User;
import tool.GetSqlsession;

import java.io.IOException;
import java.io.InputStream;

/**
 * 用户类，
 * 用于登录，注册。
 */

public class Userservice {

    /**
     * 登录servic
     * @param username
     * @param password
     * @return
     * @throws IOException
     */
    public User login(String username,String password) throws IOException {
        SqlSessionFactory sqlSessionFactory = GetSqlsession.getFactor();
        SqlSession sqlSession =sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.select(username,password);
        sqlSession.close();
        return user;
    }

    /**
     * 判断用户是否已经存在
     * @param username
     * @return
     * @throws IOException
     */
    public User registed(String username) throws IOException {
        SqlSessionFactory sqlSessionFactory = GetSqlsession.getFactor();
        SqlSession sqlSession =sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByname(username);
        sqlSession.close();
        return user;
    }

    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     * @throws IOException
     */
    public int regist(String username,String password) throws IOException {
        SqlSessionFactory sqlSessionFactory = GetSqlsession.getFactor();
        SqlSession sqlSession =sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i=mapper.regist(username,password);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }
}
