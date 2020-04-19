package cc.decat.video.controller.api;

import cc.decat.video.model.Video;
import cc.decat.video.service.VideoService;
import cc.decat.video.util.JsonResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
public class ApiController {

    @Value("${web_config.upload_path}")
    private String upload_path = "";

    @Resource
    private VideoService videoService;

    @PostMapping("/api/upload")
    public JsonResult upload(@RequestParam("file") MultipartFile file) throws IOException {

        System.out.println("文件类型ContentType=" + file.getContentType());
        System.out.println("文件组件名称Name=" + file.getName());
        System.out.println("文件原名称OriginalFileName=" + file.getOriginalFilename());
        System.out.println("文件大小Size=" + file.getSize() / 1024 + "KB");

        if(!file.isEmpty()) {
            String path = upload_path;
            System.out.println("path = " + path);
            File f = new File(path, file.getOriginalFilename());
            if(!f.getParentFile().exists()) {
                f.getParentFile().mkdirs();
            }
            file.transferTo(f);
            return JsonResult.ok("上传成功！");
        } else {
            return JsonResult.error("上传失败，文件不能为空！！！");
        }
    }


    @PostMapping("/api/getpagelist")
    public PageInfo getVideoList(HttpServletResponse response,
                                 @RequestParam("page") Integer page,
                                 @RequestParam("size") Integer size
                             ) throws InterruptedException {

        response.setHeader("Access-Control-Allow-Origin", "*");
        if(page > 0 && size > 0) {
            PageHelper.startPage(page, size);
            List<Video> videoList = videoService.list();
            return new PageInfo(videoList, 5);
        }
        return new PageInfo();
    }

    @PostMapping("/api/submit")
    public JsonResult submit(HttpServletResponse response,
                             @RequestParam("title") String title,
                             @RequestParam("url") String url,
                             @RequestParam("introduction") String introduction,
                             @RequestParam(value = "avatar", required = false) MultipartFile avatar) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println("response = " + response + ", title = " + title + ", url = " + url + ", introduction = " + introduction + ", avatar = " + avatar);
        if(avatar != null && !avatar.isEmpty()) {
            File file = new File(upload_path, UUID.randomUUID().toString() + ".jpg");
            avatar.transferTo(file);
            Video video = new Video(title, file.getName(), introduction, url);
            videoService.addVideo(video);
            return JsonResult.ok("提交成功~！");
        }
        return JsonResult.error("提交失败！");
    }

    @PostMapping("/api/search")
    public PageInfo search(HttpServletResponse response,
                       @RequestParam("s") String s,
                       @RequestParam("page") Integer page,
                       @RequestParam("size") Integer size) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(page > 0 && size > 0) {
            PageHelper.startPage(page, size);
            List<Video> videoList = videoService.searchVideo(s);
            return new PageInfo(videoList, 5);
        }
        return new PageInfo();
    }
}
