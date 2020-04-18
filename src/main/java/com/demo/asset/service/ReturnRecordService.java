package com.demo.asset.service;

import com.demo.asset.data.ReturnRecordRepository;
import com.demo.asset.entity.ReturnRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnRecordService {

    @Autowired
    ReturnRecordRepository returnRecordRepository;

    public void save(ReturnRecord returnRecord) {
        returnRecordRepository.save(returnRecord);
    }
}
