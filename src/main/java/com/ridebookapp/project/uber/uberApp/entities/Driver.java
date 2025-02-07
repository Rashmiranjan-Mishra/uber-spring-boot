package com.ridebookapp.project.uber.uberApp.entities;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(indexes = {
        @Index(name = "idx_driver_vehicle_id", columnList = "vehicleId")   // index created for vehicleid column
})
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne    //each driver can have only one user id and user_id is the foreign key references app_user table
    @JoinColumn(name = "user_id")
    private User user;

    private Double rating;  //an average rating of the driver

    private Boolean available;

    private String vehicleId;

    @Column(columnDefinition = "Geometry(Point, 4326)")  //point specifies Earth coordinates
    Point currentLocation;
}
