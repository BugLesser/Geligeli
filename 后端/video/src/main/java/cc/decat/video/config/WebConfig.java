package cc.decat.video.config;

import cc.decat.video.interceptor.WebInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Resource
    WebInterceptor webInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(webInterceptor).addPathPatterns("/*/**");
    }
}
