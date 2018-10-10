package com.swa.swamobileteam.ui.authorization;

import com.swa.swamobileteam.data.UserAuthenticationRepository;
import com.swa.swamobileteam.data.UserAuthenticationRepositoryImpl;

import io.reactivex.Completable;

public class AuthorizationModel implements AuthorizationContract.Model {
    private UserAuthenticationRepository authRepository;

    public AuthorizationModel() {
        this.authRepository = new UserAuthenticationRepositoryImpl();
    }

    @Override
    public Completable authenticate(String login, String password) {
        return authRepository.authenticate(login, password);
    }
}
