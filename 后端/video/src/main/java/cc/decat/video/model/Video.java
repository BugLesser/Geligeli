package cc.decat.video.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

public class Video {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String title;
    private String avatar;
    private String introduction;
    private String url;
    private int watch;
    private long time;
    private String user;

    public Video(Integer id, String title, String avatar, String introduction, String url, int watch, long time, String user) {
        this.id = id;
        this.title = title;
        this.avatar = avatar;
        this.introduction = introduction;
        this.url = url;
        this.watch = watch;
        this.time = time;
        this.user = user;
    }

    public Video(String title, String avatar, String introduction, String url, int watch, long time, String user) {
        this.title = title;
        this.avatar = avatar;
        this.introduction = introduction;
        this.url = url;
        this.watch = watch;
        this.time = time;
        this.user = user;
    }

    public Video(String title, String avatar, String introduction, String url) {
        this(title, avatar, introduction, url, 0, 0, "未知用户");
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWatch() {
        return watch;
    }

    public void setWatch(int watch) {
        this.watch = watch;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", avatar='" + avatar + '\'' +
                ", introduction='" + introduction + '\'' +
                ", url='" + url + '\'' +
                ", watch=" + watch +
                ", time=" + time +
                ", user='" + user + '\'' +
                '}';
    }
}
