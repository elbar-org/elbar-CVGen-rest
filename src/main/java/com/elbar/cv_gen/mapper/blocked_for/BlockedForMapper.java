package com.elbar.cv_gen.mapper.blocked_for;

import com.elbar.cv_gen.dto.GenericDTO;
import com.elbar.cv_gen.dto.blocked_for.BlockedForCreateDTO;
import com.elbar.cv_gen.dto.blocked_for.BlockedForGetDTO;
import com.elbar.cv_gen.entity.blocked_for.BlockedForEntity;
import com.elbar.cv_gen.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BlockedForMapper extends GenericMapper<BlockedForCreateDTO, GenericDTO, BlockedForGetDTO, BlockedForEntity> {
}
