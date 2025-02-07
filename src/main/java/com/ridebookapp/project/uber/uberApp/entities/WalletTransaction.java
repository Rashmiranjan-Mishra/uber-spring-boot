package com.ridebookapp.project.uber.uberApp.entities;

import com.ridebookapp.project.uber.uberApp.entities.enums.TransactionMethod;
import com.ridebookapp.project.uber.uberApp.entities.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(indexes = {
        @Index(name = "idx_wallet_transaction_wallet", columnList = "wallet_id"),
        @Index(name = "idx_wallet_transaction_ride", columnList = "ride_id")
})
public class WalletTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private TransactionType transactionType;

    private TransactionMethod transactionMethod;

    @ManyToOne  //there can be two transactions for a ride say for a driver or a rider
    private Ride ride;

    private String transactionId;

    @ManyToOne
    private Wallet wallet;     //Many wallet transactions can be done for a single wallet

    @CreationTimestamp
    private LocalDateTime timeStamp;

}
