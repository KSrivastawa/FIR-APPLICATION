package com.apps.fir.service;

import com.apps.fir.dto.LoginDto;
import com.apps.fir.exception.LoginException;

public interface LoginService {

    public String logIntoAccount(LoginDto dto)throws LoginException;

    public String logOutFromAccount(String key)throws LoginException;
}
