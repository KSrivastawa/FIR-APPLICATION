package com.apps.fir.service;

import com.apps.fir.entity.FirModel;
import com.apps.fir.exception.FirException;

public interface FirModelService {

    public FirModel registerFir(String key, FirModel firModel) throws FirException;
}
