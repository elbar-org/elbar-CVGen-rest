package com.elbar.cv_gen.repository.project.transaction;

import com.elbar.cv_gen.entity.project.transaction.TransactionEntity;
import com.elbar.cv_gen.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer>, BaseRepository {
}
