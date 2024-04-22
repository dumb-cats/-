package pojo;

public class UpdateSong {
    private int id;
    private String songname;
    private String singername;
    private String songtype;

    @Override
    public String toString() {
        return "UpdateSong{" +
                "songname='" + songname + '\'' +
                ", singername='" + singername + '\'' +
                ", songtype='" + songtype + '\'' +
                '}';
    }

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
}
