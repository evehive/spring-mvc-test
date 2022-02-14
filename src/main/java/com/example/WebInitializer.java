package com.example;

import com.example.config.WebConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    System.out.println("WebInitializer starting...");

    AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
    servletAppContext.register(WebConfig.class);

    DispatcherServlet dispatcherServlet = new  DispatcherServlet(servletAppContext);
    ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher",dispatcherServlet);
    // 1번째 실행 서블릿
    servlet.setLoadOnStartup(1);
    // /주소에서 실행
    servlet.addMapping("/");
  }
}
