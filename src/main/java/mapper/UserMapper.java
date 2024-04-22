package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pojo.User;

public interface UserMapper {
    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    @Select("select * from tb_user where username=#{username} and password=#{password}")
    User select(@Param("username") String username, @Param("password") String password);

    /**
     * 添加用户
     * @param username
     * @param password
     * @return
     */
    @Update("insert into tb_user(username,password) values(#{username},#{password})")
    int regist(@Param("username") String username,@Param("password")String password);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @Select("select *from tb_user where username=#{username}")
    User selectByname(String username);

}
