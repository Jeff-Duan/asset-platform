package com.demo.asset.service;

import com.demo.asset.data.DeviceRepository;
import com.demo.asset.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    public void save(Device device) {
        deviceRepository.save(device);
    }

    public List<Device> findAll(String name) {
        return deviceRepository.findByNameLike(name);
    }

    public List<Device> findAll(long level) {
        return deviceRepository.findByLevel(level);
    }

    public List<Device> findAll(boolean status) {
        return deviceRepository.findByStatus(status);
    }

    public Device find(long id) {
        return deviceRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}
