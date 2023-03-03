package com.jur.authentication.usecase;

import com.jur.authentication.core.models.UserModel;
import com.jur.authentication.presenter.controller.request.LoginRequest;

public interface LoginUsecase {
    public UserModel login(LoginRequest request);
}
