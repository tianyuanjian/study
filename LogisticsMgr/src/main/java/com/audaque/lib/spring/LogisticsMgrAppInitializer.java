///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package com.audaque.lib.spring;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.context.support.XmlWebApplicationContext;
//import org.springframework.web.filter.HiddenHttpMethodFilter;
//import org.springframework.web.servlet.DispatcherServlet;
//
///**
// *
// * @author [*田园间*]
// */
//public class LogisticsMgrAppInitializer implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext container) throws ServletException {
//        
////        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
////        appContext.register(LogisticsWebConfig.class);
//        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
//        appContext.setConfigLocation("classpath:/META-INF/spring/dispatcher-config.xml");
//        
//        HiddenHttpMethodFilter filter = new HiddenHttpMethodFilter();
//        
//        ServletRegistration.Dynamic registration = container.addServlet("dispatch", new DispatcherServlet(appContext));
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/");
//        
//    }
//}
