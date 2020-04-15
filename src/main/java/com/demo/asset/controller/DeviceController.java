package com.demo.asset.controller;

import com.demo.asset.entity.Device;
import com.demo.asset.service.DeviceService;
import com.demo.asset.service.LevelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private HttpSession session;

    @Autowired
    private LevelService levelService;

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public String device(Model model) {
        model.addAttribute("Levels", levelService.findAllLevel1());
        return "device";
    }

    @PostMapping("info")
    public String info(@RequestParam(value = "level1", defaultValue = "") String level1,
                       @RequestParam(value = "level2", defaultValue = "") String level2,
                       @RequestParam(value = "name", defaultValue = "") String name,
                       Model model) {
        if (StringUtils.isNotEmpty(level1)) {
            List<Device> devices = new ArrayList<>();
            levelService.find(Long.parseLong(level1)).getLevel2s().forEach(level -> {
                devices.addAll(deviceService.findAll(level.getId()));
            });
            model.addAttribute("Devices", devices);
        }
        if (StringUtils.isNotEmpty(level2)) {
            model.addAttribute("Devices", deviceService.findAll(Long.parseLong(level2)));
        }
        if (StringUtils.isNotEmpty(name)) {
            model.addAttribute("Devices", deviceService.findAll(name));
        }
        return "deviceInfo";
    }

    @GetMapping("/insert")
    public String insert(Model model) {
        model.addAttribute("Levels", levelService.findAllLevel2());
        return "insert";
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> insert(@RequestBody Device device) {
        device.setUser(String.valueOf(session.getAttribute("User")));
        deviceService.save(device);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
