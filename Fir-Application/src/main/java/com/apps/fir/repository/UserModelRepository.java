package com.apps.fir.repository;

import com.apps.fir.entity.FirModel;
import com.apps.fir.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserModelRepository extends JpaRepository<UserModel, Long> {

    public UserModel findByMobileNumber(String mobileNumber);

    @Query("select f from FirModel f where f.userModel.id = ?1")
    public List<FirModel> getAllFirById(Long id);

    public void deleteFirById(Long id);
}
