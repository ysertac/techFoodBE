package com.techfood.service;

import com.techfood.entity.Extra;

import java.util.List;

public interface ExtraService {

    List<Extra> findAll();
    Extra findById(long id);
    Extra save(Extra extra);
    Extra delete(Extra extra);
}
