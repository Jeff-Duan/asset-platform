package com.demo.asset.controller;

import com.demo.asset.entity.Device;
import com.demo.asset.entity.ReturnRecord;
import com.demo.asset.entity.UseRecord;
import com.demo.asset.service.DeviceService;
import com.demo.asset.service.LevelService;
import com.demo.asset.service.ReturnRecordService;
import com.demo.asset.service.UseRecordService;
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

    @Autowired
    private UseRecordService useRecordService;

    @Autowired
    private ReturnRecordService returnRecordService;

    @GetMapping
    public String device(Model model) {
        model.addAttribute("Levels", levelService.findAllLevel1());
        return "device/device";
    }

    @GetMapping("/all")
    public String device(@RequestParam(value = "level1", defaultValue = "") String level1,
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
        return "device/info";
    }

    @GetMapping("/insert")
    public String insert(Model model) {
        model.addAttribute("Levels", levelService.findAllLevel2());
        return "device/insert";
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> insert(@RequestBody Device device) {
        device.setUser(String.valueOf(session.getAttribute("User")));
        deviceService.save(device);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/use")
    public String useDevice(Model model) {
        model.addAttribute("Levels", levelService.findAllLevel1());
        return "device/use";
    }

    @PostMapping("/use")
    @ResponseBody
    public ResponseEntity<?> useDevice(@RequestBody UseRecord useRecord) {
        useRecordService.save(useRecord);
        Device device = deviceService.find(useRecord.getDeviceId());
        device.setStatus(false);
        deviceService.save(device);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/return")
    public String returnDevice(Model model) {
        model.addAttribute("Levels", levelService.findAllLevel1());
        return "device/return";
    }

    @PostMapping("/return")
    @ResponseBody
    public ResponseEntity<?> returnDevice(@RequestBody ReturnRecord returnRecord) {
        returnRecordService.save(returnRecord);
        UseRecord useRecord = useRecordService.find(returnRecord.getUseId());
        Device device = deviceService.find(useRecord.getDeviceId());
        device.setStatus(true);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
