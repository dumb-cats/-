package pojo;

public class SongCondition {
    private String songname;
    private String singername;

    @Override
    public String toString() {
        return "SongCondition{" +
                "songname='" + songname + '\'' +
                ", singername='" + singername + '\'' +
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
}

