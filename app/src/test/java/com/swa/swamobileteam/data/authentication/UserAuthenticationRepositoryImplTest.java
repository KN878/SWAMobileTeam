package com.swa.swamobileteam.data.authentication;

import org.junit.Test;

import io.reactivex.observers.TestObserver;

import static org.junit.Assert.*;

public class UserAuthenticationRepositoryImplTest {

    @Test
    public void authenticate() {
        TestObserver<Void> observer = new TestObserver<Void>();
        UserAuthenticationRepositoryImpl repository = new UserAuthenticationRepositoryImpl();
        repository.authenticate("login", "password").subscribe(observer);
        observer.assertComplete();
    }

    @Test
    public void authenticateNegative() {
        TestObserver<Void> observer = new TestObserver<Void>();
        UserAuthenticationRepositoryImpl repository = new UserAuthenticationRepositoryImpl();
        repository.authenticate("wronglogin", "wrongpassword").subscribe(observer);
        observer.assertComplete();
    }

    @Test
    public void authenticateNegative2() {
        TestObserver<Void> observer = new TestObserver<Void>();
        UserAuthenticationRepositoryImpl repository = new UserAuthenticationRepositoryImpl();
        repository.authenticate("wronglogin2", "wrongpassword2").subscribe(observer);
        observer.assertComplete();
    }
}