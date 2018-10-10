package com.swa.swamobileteam.data.authentication;

import io.reactivex.Completable;

public interface UserAuthenticationRepository {
    Completable authenticate(String login, String password);
}
