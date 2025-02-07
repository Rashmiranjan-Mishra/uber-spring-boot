package com.ridebookapp.project.uber.uberApp.strategies.Impl;

import com.ridebookapp.project.uber.uberApp.dto.RideRequestDto;
import com.ridebookapp.project.uber.uberApp.entities.Driver;
import com.ridebookapp.project.uber.uberApp.entities.RideRequest;
import com.ridebookapp.project.uber.uberApp.repositories.DriverRepository;
import com.ridebookapp.project.uber.uberApp.strategies.DriverMatchingStrategy;
import jakarta.persistence.PreUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional()
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenNearbyTopRatedDrivers(rideRequest.getPickupLocation());
    }
}
