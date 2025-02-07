package com.ridebookapp.project.uber.uberApp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne   //Rider - User  >> One Rider can have only assigned with  one user or vice versa , user_id column is the foreign key referencing the User table
    @JoinColumn(name = "user_id")
    private User user;

    private Double rating;  //average rating of the rider

}
