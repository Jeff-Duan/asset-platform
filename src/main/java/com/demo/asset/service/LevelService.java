package com.demo.asset.service;

import com.demo.asset.data.LevelRepository;
import com.demo.asset.entity.Level1;
import com.demo.asset.entity.Level2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LevelService {

    @Autowired
    LevelRepository levelRepository;

    public List<Level1> findAllLevel1() {
        return levelRepository.findAll();
    }

    public List<Level2> findAllLevel2() {
        List<Level2> level2s = new ArrayList<>();
        findAllLevel1().forEach(level1 -> {
            level2s.addAll(level1.getLevel2s());
        });
        return level2s;
    }

    public Level1 find(long level) {
        return levelRepository.findById(level).orElseThrow(RuntimeException::new);
    }

}
