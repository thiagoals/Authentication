package com.jur.authentication.core.services;

import com.jur.authentication.core.models.UserModel;
import com.jur.authentication.external.services.AuthenticationService;
import com.jur.authentication.external.services.VerifyLoginService;
import com.jur.authentication.presenter.controller.request.LoginRequest;
import com.jur.authentication.usecase.LoginUsecase;

public class LoginService implements LoginUsecase {

    private VerifyLoginService verifyLoginService;

    public LoginService(VerifyLoginService verifyLoginService){
        this.verifyLoginService = verifyLoginService;
    }
    @Override
    public UserModel login(LoginRequest request) {
        return verifyLoginService.login(request);
    }
}
