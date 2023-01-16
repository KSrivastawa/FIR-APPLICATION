package com.apps.fir.controller;

import com.apps.fir.dto.LoginDto;
import com.apps.fir.exception.LoginException;
import com.apps.fir.serviceimpl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/masaifir/user")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) throws LoginException {

        return ResponseEntity.ok(loginService.logIntoAccount(loginDto));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestParam(required = false) String key) throws LoginException {

        return ResponseEntity.ok(loginService.logOutFromAccount(key));
    }


}
