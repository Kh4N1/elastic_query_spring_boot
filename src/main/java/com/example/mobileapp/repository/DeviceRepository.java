package com.example.mobileapp.repository;

import com.example.mobileapp.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    @Query("SELECT d FROM Device d WHERE " +
            "(:brands IS NULL OR d.manufacturer IN :brands) AND " +
            "(:colors IS NULL OR d.colorCode IN :colors) AND " +
            "(:capacities IS NULL OR d.storageCapacity IN :capacities)")
    List<Device> findDevicesBySpecs(List<String> brands, List<String> colors, List<Integer> capacities);
}