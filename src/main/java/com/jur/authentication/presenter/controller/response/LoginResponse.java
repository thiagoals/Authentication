package com.jur.authentication.presenter.controller.response;

import com.jur.authentication.core.models.UserModel;
import com.jur.authentication.presenter.controller.request.LoginRequest;
import org.springframework.http.HttpStatus;

public record LoginResponse (String name, String email,String token, int status){

    public static LoginResponse from(UserModel login) {
        return new LoginResponse(login.name(),login.email(),login.token(),HttpStatus.OK.value());
    }
}
