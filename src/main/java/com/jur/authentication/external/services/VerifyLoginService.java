package com.jur.authentication.external.services;

import com.jur.authentication.core.models.UserModel;
import com.jur.authentication.external.entities.User;
import com.jur.authentication.presenter.controller.request.LoginRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class VerifyLoginService {
    private AuthenticationManager manager;
    private TokenService tokenService;

    public VerifyLoginService(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    public UserModel login(LoginRequest request){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(request.username(), request.password());

        Authentication authentication = this.manager.authenticate(usernamePasswordAuthenticationToken);

        User user = (User) authentication.getPrincipal();

        return user.toUserModel(tokenService.generateToken(user));
    }
}
