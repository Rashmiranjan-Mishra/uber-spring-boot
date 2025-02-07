package com.ridebookapp.project.uber.uberApp.strategies.Impl;

import com.ridebookapp.project.uber.uberApp.dto.RideRequestDto;
import com.ridebookapp.project.uber.uberApp.entities.RideRequest;
import com.ridebookapp.project.uber.uberApp.services.DistanceService;
import com.ridebookapp.project.uber.uberApp.services.Impl.DistanceServiceOSRMImpl;
import com.ridebookapp.project.uber.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RiderFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(),rideRequest.getDropOffLocation());

        return distance*RIDE_FAIR_MULTIPLIER;
    }
}
