package mapper;

import org.apache.ibatis.annotations.*;
import pojo.Song;
import pojo.SongCondition;

import java.util.List;

public interface SongMapper {
    /**
     * 查询所有歌曲信息
     * @return 歌曲对象集合
     */
    List<Song> selectAll();

    /**
     * 添加歌曲
     * @return
     */
    @Insert("insert into song values(null,#{songname},#{songtype},#{singerid})")
    boolean addSong(@Param("songname")String songname,@Param("songtype")String songtype,@Param("singerid")int singerid);
    /**
     * 添加歌手
     */
    @Insert("insert into singer values(null,#{singername},#{sex},#{age})")
    boolean addSinger(@Param("singername") String singername,@Param("sex") String sex,@Param("age") int age);
    /**
     * 获得歌手的id值
     * @param singername
     * @return
     */
    @Select("select id from singer where singername=#{singernane}")
    Integer selectSingerIdByname(String singername);

    /**
     * 删除歌曲
     * @param id
     * @return
     */
    @Delete("delete from song where id=#{id}")
    boolean deletsongById(int id);

    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */

    List<Song> selectByPage(@Param("begin")int begin,@Param("size") int size);
    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from song")
    int selectAllTotal();

    /**
     * 分页条件查询
     * @return
     */
    List<Song> selectPageByCondition(@Param("begin")int begin, @Param("size") int size, @Param("songname")String songname,@Param("singername")String singername);

    /**
     * 分页总数条件查询
     * @param
     * @return
     */
    int selectAllTotalByCondition(@Param("songname")String songname,@Param("singername")String singername);

    /**
     * 修改歌曲信息
     * @param songname
     * @param songtype
     * @param singerid
     * @return
     */

    boolean updateById(@Param("songname")String songname,@Param("songtype")String songtype,@Param("singerid")int singerid,@Param("id")int id);

}
