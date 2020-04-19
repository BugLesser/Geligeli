package cc.decat.video.service;

import cc.decat.video.model.Video;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface VideoService extends IService<Video> {

    public void addVideo(Video video);
    public List<Video> searchVideo(String s);
}
