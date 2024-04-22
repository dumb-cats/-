package pojo;

public class Song {
    private int id;//歌曲编号
    private String songname;//歌曲名称
    private String songtype;//歌曲类型
    private String singername;//歌手姓名
    private String sex;//歌手性别
    private String age;//歌手年龄

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getSongtype() {
        return songtype;
    }

    public void setSongtype(String songtype) {
        this.songtype = songtype;
    }

    public String getSingername() {
        return singername;
    }

    public void setSingername(String singername) {
        this.singername = singername;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songname='" + songname + '\'' +
                ", songtype='" + songtype + '\'' +
                ", singername='" + singername + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
