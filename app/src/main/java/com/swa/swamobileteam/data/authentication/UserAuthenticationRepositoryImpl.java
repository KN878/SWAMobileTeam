package com.swa.swamobileteam.data.authentication;

import io.reactivex.Completable;

public class UserAuthenticationRepositoryImpl implements UserAuthenticationRepository {
    @Override
    public Completable authenticate(String login, String password) {
        if (login.equals("login") && password.equals("password")) {
            return Completable.complete();
        } else {
            return Completable.error(new Error("Incorrect Login or Password"));
        }
    }
}
