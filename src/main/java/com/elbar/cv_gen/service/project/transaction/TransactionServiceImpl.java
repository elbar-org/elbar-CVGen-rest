package com.elbar.cv_gen.service.project.transaction;

import com.elbar.cv_gen.criteria.BetweenCriteria;
import com.elbar.cv_gen.criteria.SearchCriteria;
import com.elbar.cv_gen.criteria.project.transaction.TransactionCriteria;
import com.elbar.cv_gen.dto.project.transaction.TransactionCreateDTO;
import com.elbar.cv_gen.dto.project.transaction.TransactionDetailDTO;
import com.elbar.cv_gen.dto.project.transaction.TransactionGetDTO;
import com.elbar.cv_gen.mapper.project.transaction.TransactionMapper;
import com.elbar.cv_gen.repository.project.transaction.TransactionRepository;
import com.elbar.cv_gen.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl extends AbstractService<TransactionMapper, TransactionRepository> implements TransactionService {
    public TransactionServiceImpl(TransactionMapper mapper, TransactionRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void create(TransactionCreateDTO dto) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public TransactionGetDTO get(Integer id) {
        return null;
    }

    @Override
    public TransactionDetailDTO detail(Integer id) {
        return null;
    }

    @Override
    public List<TransactionGetDTO> list(TransactionCriteria criteria) {
        return null;
    }

    @Override
    public List<TransactionGetDTO> list_with_search(SearchCriteria criteria) {
        return null;
    }

    @Override
    public List<TransactionGetDTO> list_with_between(BetweenCriteria criteria) {
        return null;
    }
}
