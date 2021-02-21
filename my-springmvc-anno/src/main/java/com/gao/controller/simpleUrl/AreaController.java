package com.gao.controller.simpleUrl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//这里必须用@Component，不能用@Controller,因为SimpleUrlHandlerMapping在注册url-handler的映射关系时，会通过
//applicationContext.getBean来获取controller实例，所以这个bean需交给spring父容器管理
@Component
public class AreaController implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("======AreaController");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>==========Jack</h1>");
        writer.flush();
        writer.close();
    }

}
