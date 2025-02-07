package com.ridebookapp.project.uber.uberApp.strategies;

import com.ridebookapp.project.uber.uberApp.entities.Driver;
import com.ridebookapp.project.uber.uberApp.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {
    List<Driver> findMatchingDriver(RideRequest rideRequest);

}
