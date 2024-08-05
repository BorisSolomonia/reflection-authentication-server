package com.boris.authentication_server.repo;


import com.boris.authentication_server.constant.Provider;
import com.boris.authentication_server.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailRepo extends JpaRepository<UserDetail, Long> {
    Optional<UserDetail> findByUsernameAndProvider(String user_name, Provider provider);
}
