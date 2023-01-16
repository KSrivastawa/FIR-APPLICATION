package com.apps.fir.service;

import com.apps.fir.entity.FirModel;
import com.apps.fir.entity.UserModel;
import com.apps.fir.exception.UserException;

import java.util.List;

public interface UserModelService {

    public UserModel registerUser(UserModel userModel)throws UserException;
    public List<FirModel> getFirlist(String key) throws UserException;
    public String deleteFire(Long id, String key) throws UserException;

}
