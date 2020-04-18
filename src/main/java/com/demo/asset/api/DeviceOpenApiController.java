package com.demo.asset.api;


import com.demo.asset.entity.Device;
import com.demo.asset.service.DeviceService;
import com.demo.asset.service.LevelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/open/api/device")
public class DeviceOpenApiController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private LevelService levelService;

    @GetMapping
    public List<Device> find(@RequestParam(defaultValue = "") String level1,
                             @RequestParam(defaultValue = "") String level2,
                             @RequestParam(defaultValue = "") String id,
                             @RequestParam(defaultValue = "") String name,
                             @RequestParam boolean status) {
        List<Device> devices = new ArrayList<>();
        if (StringUtils.isNotEmpty(level1)) {
            levelService.find(Long.parseLong(level1)).getLevel2s().forEach(level -> {
                devices.addAll(deviceService.findAll(level.getId()));
            });
        }
        if (StringUtils.isNotEmpty(level2)) {
            devices.addAll(deviceService.findAll(Long.parseLong(level2)));
        }
        if (StringUtils.isNotEmpty(id)) {
            devices.add(deviceService.find(Long.parseLong(id)));
        }
        if (StringUtils.isNotEmpty(name)) {
            devices.addAll(deviceService.findAll(name));
        }
        return devices.stream().filter(Device::isStatus).collect(Collectors.toList());
    }

}
