package com.elbar.cv_gen.service;

import com.elbar.cv_gen.mapper.BaseMapper;
import com.elbar.cv_gen.repository.BaseRepository;
import com.elbar.cv_gen.validator.BaseValidator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractService<V extends BaseValidator, M extends BaseMapper, R extends BaseRepository> implements BaseService {
    protected final V validator;
    protected final M mapper;
    protected final R repository;
}
