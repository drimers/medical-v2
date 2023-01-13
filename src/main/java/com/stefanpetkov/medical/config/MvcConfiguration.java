//package com.stefanpetkov.medical.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;
//import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
//@EnableWebMvc
//@Configuration
//@ComponentScan(basePackages = { "com.stefanpetkov.medical.controllers" })
//public class MvcConfiguration implements WebMvcConfigurer {
//    /**
//     * The following configurations are for loading the thymeleaf files instead of the default paths from SB
//     */
//
//
//
//
//    @Bean
//    public ClassLoaderTemplateResolver templateResolver() {
//
//        var templateResolver = new ClassLoaderTemplateResolver();
//
//        templateResolver.setPrefix("/templates/");
//        templateResolver.setCacheable(false);
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML5");
//        templateResolver.setCharacterEncoding("UTF-8");
//
//        return templateResolver;
//    }
//
//    @Bean
//    public SpringTemplateEngine templateEngine(@Autowired ClassLoaderTemplateResolver templateResolver) {
//
//        var templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver);
//
//        return templateEngine;
//    }
//
//    @Bean
//    public ViewResolver viewResolver(@Autowired SpringTemplateEngine templateEngine) {
//
//        var viewResolver = new ThymeleafViewResolver();
//
//        viewResolver.setTemplateEngine(templateEngine);
//        viewResolver.setCharacterEncoding("UTF-8");
//
//        return viewResolver;
//    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
////        registry.addViewController("/login.html").setViewName("login");
////        registry.addViewController("/home.html").setViewName("home");
////        registry.addViewController("/patient/").setViewName("patient");
////        registry.addViewController("/display_form.html").setViewName("display_form");
////        registry.addViewController("/doctor/doctor").setViewName("doctor");
//
//    }
//}
