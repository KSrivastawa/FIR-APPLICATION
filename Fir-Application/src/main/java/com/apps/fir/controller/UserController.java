package com.apps.fir.controller;


import com.apps.fir.entity.FirModel;
import com.apps.fir.entity.UserModel;
import com.apps.fir.exception.UserException;
import com.apps.fir.serviceimpl.UserModelServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/masaifir/user")
public class UserController {

    @Autowired
    private UserModelServiceImpl userModelService;


    @PostMapping("/registerUser")
    public ResponseEntity<UserModel> registerUser(@Valid @RequestBody UserModel userModel) throws UserException {

        return ResponseEntity.ok(userModelService.registerUser(userModel));
    }

    @GetMapping("/getFirList")
    public ResponseEntity<List<FirModel>> getFirList(@RequestParam String key) throws UserException {

        return ResponseEntity.ok(userModelService.getFirlist(key));
    }

    @DeleteMapping("/deleteFir/{id}")
    public ResponseEntity<String> deleteFir(@PathVariable Long id, @RequestParam String key) throws UserException {

        return ResponseEntity.ok(userModelService.deleteFire(id, key));
    }

}
