package com.jur.authentication.external.configs;

import com.jur.authentication.core.services.LoginService;
import com.jur.authentication.external.services.VerifyLoginService;
import com.jur.authentication.usecase.LoginUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginBeans {
    @Autowired
    private VerifyLoginService service;

    @Bean
    public LoginUsecase loginUsecase(){
        return new LoginService(service);
    }
}
