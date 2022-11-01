package com.elbar.cv_gen.repository.auth.blocked_for;

import com.elbar.cv_gen.entity.auth.blocked_for.BlockedForEntity;
import com.elbar.cv_gen.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockedForRepository extends JpaRepository<BlockedForEntity, Integer>, BaseRepository {

    boolean existsByCodeEquals(String code);

}
