package com.ridebookapp.project.uber.uberApp.entities;

import com.ridebookapp.project.uber.uberApp.entities.enums.PaymentMethod;
import com.ridebookapp.project.uber.uberApp.entities.enums.RideRequestStatus;
import com.ridebookapp.project.uber.uberApp.entities.enums.RideStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(indexes = {
        @Index(name = "idx_ride_rider", columnList = "rider_id"),    //index created for rider_id column name in Ride table
        @Index(name = "idx_ride_driver", columnList = "driver_id")   //index created for driver_id column name in Ride table
})
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point pickupLocation;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point dropOffLocation;

    @CreationTimestamp
    private LocalDateTime createdTime;

    @ManyToOne(fetch = FetchType.LAZY) //This means multiple rides can be done by a rider or One rider can have many many ride id
    private Rider rider;
    @ManyToOne(fetch = FetchType.LAZY) //This means multiple rides can be done by a driver
    private Driver driver;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private RideStatus rideStatus;

    private String otp;

    private Double fare;

    private LocalDateTime startedAt;

    private LocalDateTime endedAt;
}
