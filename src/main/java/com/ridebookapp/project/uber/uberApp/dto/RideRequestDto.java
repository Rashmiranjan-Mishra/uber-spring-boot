package com.ridebookapp.project.uber.uberApp.dto;

import com.ridebookapp.project.uber.uberApp.entities.enums.PaymentMethod;
import com.ridebookapp.project.uber.uberApp.entities.enums.RideRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDto {

    private Long id;

    private PointDto pickupLocation; //Point specifies geospatial points

    private PointDto dropOffLocation;

    private PaymentMethod paymentMethod;

    private LocalDateTime requestedTime;

    private RiderDto rider;

    private Double fare;

    private RideRequestStatus rideRequestStatus;
}
