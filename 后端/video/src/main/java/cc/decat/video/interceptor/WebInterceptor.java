package cc.decat.video.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

@Component
public class WebInterceptor extends HandlerInterceptorAdapter {
    private static int count = 0;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(++count);

        System.out.println("\n\n");
        System.out.println(request.getRequestURI());
        Enumeration<String> en = request.getHeaderNames();
        while(en.hasMoreElements()) {
            String name = en.nextElement();
            System.out.println(name + ": " + request.getHeader(name));
        }
        /*
        HTTP/1.1 301 Moved Permanently
        Server: kangle/3.5.19.4
        Date: Wed, 15 Apr 2020 07:40:26 GMT
        Location: https://lajiao-bo.com/20190505/eSeo737F/800kb/hls/YikYbi5257005.ts
        Content-Length: 0
        */

//        if(count == 1) {
//            response.setStatus(301);
//            response.setHeader("Location", "http://localhost:8081/b.mp4");
        if(request.getRequestURI().equals("/a.mp4")) {
            response.sendRedirect("/b.mp4");
            return true;

        }
//        }

//        Iterator<String> iterator = response.getHeaderNames().iterator();
//        while(iterator.hasNext()) {
//            String name = iterator.next();
//            System.out.println(name + ": " + response.getHeader(name));
//        }

        return super.preHandle(request, response, handler);
    }
}
