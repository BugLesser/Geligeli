package cc.decat.video.service.impl;

import cc.decat.video.mapper.VideoMapper;
import cc.decat.video.model.Video;
import cc.decat.video.service.VideoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Resource
    private VideoMapper videoMapper;


    @Override
    public void addVideo(Video video) {
        videoMapper.insert(video);
    }

    @Override
    public List<Video> searchVideo(String s) {
//        return videoMapper.selectList(new QueryWrapper<Video>().like("title", s).or().like("introduction", s));
        return videoMapper.selectList(new QueryWrapper<Video>().like("title", s));
    }
}
