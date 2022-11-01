package com.elbar.cv_gen.service.blocked_for;

import com.elbar.cv_gen.criteria.blocked_for.BlockedForCriteria;
import com.elbar.cv_gen.dto.blocked_for.BlockedForCreateDTO;
import com.elbar.cv_gen.dto.blocked_for.BlockedForGetDTO;
import com.elbar.cv_gen.service.BaseService;
import com.elbar.cv_gen.service.GenericGLService;

public interface BlockedForService extends GenericGLService<BlockedForGetDTO, BlockedForCriteria, Integer>, BaseService {

    void create(BlockedForCreateDTO dto);

    void delete(Integer id);

}
