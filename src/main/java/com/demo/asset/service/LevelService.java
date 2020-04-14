package com.demo.asset.service;

import com.demo.asset.data.LevelRepository;
import com.demo.asset.entity.Level1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelService {

    @Autowired
    LevelRepository levelRepository;

    public List<Level1> findAll() {
        return levelRepository.findAll();
    }

    public Level1 find(long level) {
        return levelRepository.findById(level).orElseThrow(RuntimeException::new);
    }

}
