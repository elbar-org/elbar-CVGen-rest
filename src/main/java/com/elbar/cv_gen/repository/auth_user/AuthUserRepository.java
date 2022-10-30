package com.elbar.cv_gen.repository.auth_user;

import com.elbar.cv_gen.entity.auth_user.AuthUserEntity;
import com.elbar.cv_gen.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUserEntity, Integer>,
        JpaSpecificationExecutor<AuthUserEntity>, BaseRepository {

    boolean existsByPhoneEquals(String phone);

    Optional<AuthUserEntity> findByPhoneEquals(String phone);

}
