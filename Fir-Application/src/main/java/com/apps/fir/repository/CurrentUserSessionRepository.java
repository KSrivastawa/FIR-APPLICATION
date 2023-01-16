package com.apps.fir.repository;

import com.apps.fir.entity.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentUserSessionRepository extends JpaRepository<CurrentUserSession, Long> {

    public CurrentUserSession findByUuid(String key);

}
