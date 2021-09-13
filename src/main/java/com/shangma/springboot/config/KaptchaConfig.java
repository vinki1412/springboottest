package com.shangma.springboot.config;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.google.code.kaptcha.util.Config;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author：vinki
 * @Version：1.0
 * @Date：2021/9/11-20:31
 * @Since:jdk1.8
 * @Description:TODO
 */
@Configuration
public class KaptchaConfig {

    @Bean
    public DefaultKaptcha getKaptchaBean() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty(Constants.KAPTCHA_BORDER_COLOR, "blue");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "8");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING, "王火人木头四通八达七上八下");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "宋体,楷体,微软雅黑");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

    @Bean
    public KaptchaServlet getKaptchaServlet(){
        return new KaptchaServlet();
    }

    //注册KaptchaServlet并配置init属性来自定义验证码。
    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new KaptchaServlet(), "/Kaptcha.jpg");
        servletRegistrationBean.addInitParameter("kaptcha.textproducer.font.color", "blue");
        servletRegistrationBean.addInitParameter(Constants.KAPTCHA_BORDER_COLOR, "blue");
        servletRegistrationBean.addInitParameter(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "8");
        servletRegistrationBean.addInitParameter(Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING, "王火人木头四通八达七上八下");
        servletRegistrationBean.addInitParameter(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "宋体,楷体,微软雅黑");
        return servletRegistrationBean;
    }

//    @Bean
//    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
//        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
//        registration.getUrlMappings().clear();
//        registration.addUrlMappings("*.do");
//        registration.addUrlMappings("*.json");
//        return registration;
//    }
}
