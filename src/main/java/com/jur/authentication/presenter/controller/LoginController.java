package com.jur.authentication.presenter.controller;

import com.jur.authentication.presenter.controller.request.LoginRequest;
import com.jur.authentication.presenter.controller.response.LoginResponse;
import com.jur.authentication.usecase.LoginUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    private LoginUsecase usecase;

    public LoginController(LoginUsecase usecase){
        this.usecase = usecase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(
                LoginResponse.from(usecase.login(request))
        );
    }
}
