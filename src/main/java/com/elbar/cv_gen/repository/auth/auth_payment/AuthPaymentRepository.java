package com.elbar.cv_gen.repository.auth.auth_payment;

import com.elbar.cv_gen.entity.auth.user_payment.UserPaymentEntity;
import com.elbar.cv_gen.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthPaymentRepository extends JpaRepository<UserPaymentEntity, Integer>, BaseRepository {
    boolean existsByUserIdAndTransactionIdAndTemplateIdAndDeletedFalse(Integer userId,Integer tranId,Integer temId);
    Optional<UserPaymentEntity> findByIdAndDeletedFalse(Integer integer);
    Page<UserPaymentEntity> findAllByDeletedFalse(Pageable pageable);
}
