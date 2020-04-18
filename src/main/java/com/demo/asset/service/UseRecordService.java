package com.demo.asset.service;

import com.demo.asset.data.UseRecordRepository;
import com.demo.asset.entity.UseRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseRecordService {

    @Autowired
    UseRecordRepository useRecordRepository;

    public void save(UseRecord useRecord) {
        useRecordRepository.save(useRecord);
    }

    public UseRecord find(long id) {
        return useRecordRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
