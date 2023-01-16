package com.apps.fir.serviceimpl;

import com.apps.fir.dto.LoginDto;
import com.apps.fir.entity.CurrentUserSession;
import com.apps.fir.entity.UserModel;
import com.apps.fir.exception.LoginException;
import com.apps.fir.repository.CurrentUserSessionRepository;
import com.apps.fir.repository.UserModelRepository;
import com.apps.fir.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserModelRepository userModelRepository;

    @Autowired
    private CurrentUserSessionRepository currentUserSessionRepository;

    @Override
    public String logIntoAccount(LoginDto dto)throws LoginException{


        UserModel existingUser= userModelRepository.findByMobileNumber(dto.getMobileNumber());

        if(existingUser == null) {

            throw new LoginException("Please Enter a valid mobile number");
        }else{
            Optional<CurrentUserSession> validUserSessionOpt =  currentUserSessionRepository.findById(existingUser.getId());

            if (validUserSessionOpt.isPresent()) {

                throw new LoginException("User already Logged In with this Id");
            }

            if(existingUser.getPassword().equals(dto.getPassword())) {

                String key = existingUser.getMobileNumber() + LocalDateTime.now().toString();

                CurrentUserSession currentUserSession = new CurrentUserSession(existingUser.getId(),key, LocalDateTime.now());
                currentUserSessionRepository.save(currentUserSession);

                return "Login Successful";
            }
            else
                throw new LoginException("Please Enter a valid password");
        }

    }


    @Override
    public String logOutFromAccount(String key)throws LoginException {

        CurrentUserSession validCustomerSession = currentUserSessionRepository.findByUuid(key);

        if(validCustomerSession == null) {
            throw new LoginException("User Not Logged In with this number");

        }
        currentUserSessionRepository.delete(validCustomerSession);

        return "Logged Out !";
    }

}
