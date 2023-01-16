package com.apps.fir.serviceimpl;

import com.apps.fir.entity.CurrentUserSession;
import com.apps.fir.entity.FirModel;
import com.apps.fir.entity.UserModel;
import com.apps.fir.exception.UserException;
import com.apps.fir.repository.CurrentUserSessionRepository;
import com.apps.fir.repository.FirModelRepository;
import com.apps.fir.repository.UserModelRepository;
import com.apps.fir.service.UserModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserModelServiceImpl implements UserModelService {

    @Autowired
    private UserModelRepository userModelRepository;
    @Autowired
    private CurrentUserSessionRepository currentUserSessionRepository;
    @Autowired
    private FirModelRepository firModelRepository;

    @Override
    public UserModel registerUser(UserModel userModel) throws UserException {

            UserModel userModel1 = userModelRepository.findByMobileNumber(userModel.getMobileNumber());

            if(userModel1 != null){
                throw new UserException("User Already Exists");
            }
            else{
                return userModelRepository.save(userModel);
            }

    }

    @Override
    public List<FirModel> getFirlist(String key) throws UserException {

        CurrentUserSession currentUserSession = currentUserSessionRepository.findByUuid(key);

        if (currentUserSession == null) {
            throw new UserException("User Not Logged In with this key");
        }
        else {
            List<FirModel> firModelList = userModelRepository.getAllFirById(currentUserSession.getId());

            if (firModelList == null) {
                throw new UserException("No FIRs Found");
            } else {
                return firModelList;
            }
        }
    }

    @Override
    public String deleteFire(Long id, String key) throws UserException {

        CurrentUserSession currentUserSession = currentUserSessionRepository.findByUuid(key);

        UserModel userModel = userModelRepository.findById(currentUserSession.getId()).get();

        List<FirModel> firModelList = userModel.getFirModelList();

        LocalDateTime localDateTime2 = LocalDateTime.now();

        if(userModel != null){
            for(FirModel firModel : firModelList){
                if(firModel.getId() == id){
                    if(firModel.getTimeStamp().plusHours(24).isAfter(localDateTime2)){
                        firModelList.remove(firModel);
                        firModelRepository.deleteById(id);
                        return "FIR Deleted";
                    }else{
                        throw new UserException("FIR Cannot be deleted");
                    }
                }else {
                	throw new UserException("UserId Not Match");
                }
            }
        }
        
        throw new UserException("User Not Found!");
       

    }


}
