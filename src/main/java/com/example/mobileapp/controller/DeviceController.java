package com.example.mobileapp.controller;

import com.example.mobileapp.service.DeviceService;
import com.example.mobileapp.dto.SearchCriteria;
import com.example.mobileapp.dto.DeviceResponse;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/devices")
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping("/search")
    public List<DeviceResponse> searchDevices(@RequestBody SearchCriteria criteria) {
        return deviceService.searchDevices(criteria);
    }
}