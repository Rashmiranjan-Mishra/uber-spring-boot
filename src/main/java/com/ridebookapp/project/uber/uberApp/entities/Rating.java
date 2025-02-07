package com.ridebookapp.project.uber.uberApp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(indexes = {
        @Index(name = "idx_rating_rider", columnList = "rider_id"),
        @Index(name = "idx_rating_driver", columnList = "driver_id")
})
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Ride ride;    //one ride can have only one rating associated

    @ManyToOne
    private Rider rider;  //one rider can have multiple ratings

    @ManyToOne
    private Driver driver; //one driver  can have multiple ratings

    private Integer driverRating; //rating for the driver
    private Integer riderRating; //rating for the rider
}
