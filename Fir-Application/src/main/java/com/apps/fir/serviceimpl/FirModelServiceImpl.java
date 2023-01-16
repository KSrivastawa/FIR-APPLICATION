package com.apps.fir.serviceimpl;

import com.apps.fir.entity.CurrentUserSession;
import com.apps.fir.entity.FirModel;
import com.apps.fir.entity.UserModel;
import com.apps.fir.exception.FirException;
import com.apps.fir.repository.CurrentUserSessionRepository;
import com.apps.fir.repository.FirModelRepository;
import com.apps.fir.repository.UserModelRepository;
import com.apps.fir.service.FirModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FirModelServiceImpl implements FirModelService {

    @Autowired
    private FirModelRepository firModelRepository;

    @Autowired
    private CurrentUserSessionRepository currentUserSessionRepository;
    @Autowired
    private UserModelRepository userModelRepository;

    @Override
    public FirModel registerFir(String key, FirModel firModel) throws FirException {

        CurrentUserSession currentUserSession = currentUserSessionRepository.findByUuid(key);

        UserModel userModel = userModelRepository.findById(currentUserSession.getId()).orElseThrow(() -> new FirException("User Not Found"));

        userModel.getFirModelList().add(firModel);
        firModel.setUserModel(userModel);

        return firModelRepository.save(firModel);
    }

}
