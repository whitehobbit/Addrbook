package com.whitehobbit.Addrbook.service;

import com.whitehobbit.Addrbook.domain.Addrbook;
import com.whitehobbit.Addrbook.repository.AddrbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by whitehobbit on 2016. 8. 25..
 */
@Service
@Transactional
public class AddrbookService {
    @Autowired
    AddrbookRepository addrbookRepository;

    public List<Addrbook> findAll() { return addrbookRepository.findAll(); }

    public Page<Addrbook> findAll(Pageable pageable) { return addrbookRepository.findAllOrderByName(pageable); }

    public Addrbook findOne(Integer id) { return addrbookRepository.findOne(id); }

    public Addrbook create(Addrbook addrbook) { return addrbookRepository.save(addrbook); }

    public Addrbook update(Addrbook addrbook) { return addrbookRepository.save(addrbook); }

    public void delete(Integer id) { addrbookRepository.delete(id); }

}
