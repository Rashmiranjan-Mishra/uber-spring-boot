package com.ridebookapp.project.uber.uberApp.strategies;

import com.ridebookapp.project.uber.uberApp.dto.RideRequestDto;
import com.ridebookapp.project.uber.uberApp.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FAIR_MULTIPLIER = 10;

    double calculateFare(RideRequest rideRequest);
}
