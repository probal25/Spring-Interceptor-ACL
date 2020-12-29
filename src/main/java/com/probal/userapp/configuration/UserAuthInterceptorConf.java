package com.probal.userapp.configuration;

import com.probal.userapp.interceptor.UserAuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class UserAuthInterceptorConf implements WebMvcConfigurer {

    @Autowired
    UserAuthorizationInterceptor userAuthorizationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userAuthorizationInterceptor);
    }
}
