package com.example.mobileapp.service;

import com.example.mobileapp.model.Device;
import com.example.mobileapp.repository.DeviceRepository;
import com.example.mobileapp.dto.SearchCriteria;
import com.example.mobileapp.dto.DeviceResponse;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceService {
    private final DeviceRepository repository;

    public DeviceService(DeviceRepository repository) {
        this.repository = repository;
    }

    public List<DeviceResponse> searchDevices(SearchCriteria criteria) {
        List<Device> devices = repository.findDevicesBySpecs(
                criteria.getManufacturers(),
                criteria.getColors(),
                criteria.getStorageCapacities()
        );

        return devices.stream()
                .filter(device -> device.isAvailable())
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    private DeviceResponse convertToResponse(Device device) {
        return new DeviceResponse(
                device.getManufacturer(),
                device.getModel(),
                device.getColorCode(),
                device.getStorageCapacity(),
                device.getPrice(),
                device.getStatus()
        );
    }
}