package pojo;

public class AddSong {
    private String songname;
    private String singername;
    private String songtype;
    private int age;
    private String sex;

    @Override
    public String toString() {
        return "AddSong{" +
                "songname='" + songname + '\'' +
                ", singername='" + singername + '\'' +
                ", songtype='" + songtype + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getSingername() {
        return singername;
    }

    public void setSingername(String singername) {
        this.singername = singername;
    }

    public String getSongtype() {
        return songtype;
    }

    public void setSongtype(String songtype) {
        this.songtype = songtype;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
