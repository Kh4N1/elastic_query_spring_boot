package com.example.mobileapp.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String manufacturer;
    private String model;
    private String colorCode;
    private Integer storageCapacity;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private DeviceStatus status;

    @Column(name = "in_stock")
    private boolean available;
}
