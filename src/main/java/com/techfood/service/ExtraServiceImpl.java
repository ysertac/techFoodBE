package com.techfood.service;

import com.techfood.entity.Extra;
import com.techfood.repository.ExtraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExtraServiceImpl implements ExtraService {

    private final ExtraRepository extraRepository;

    @Autowired
    ExtraServiceImpl(ExtraRepository extraRepository) {
        this.extraRepository = extraRepository;
    }

    @Override
    public List<Extra> findAll() {
        return extraRepository.findAll();
    }

    @Override
    public Extra findById(long id) {
        Optional<Extra> optionalExtra = extraRepository.findById(id);
        if (optionalExtra.isPresent()) {
            return optionalExtra.get();
        } else {
            throw new RuntimeException("This product does not exist");
        }
    }

    @Override
    public Extra save(Extra extra) {
        return extraRepository.save(extra);
    }

    @Override
    public Extra delete(Extra extra) {
        extraRepository.delete(extra);
        return extra;
    }
}
