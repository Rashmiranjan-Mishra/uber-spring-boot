package com.ridebookapp.project.uber.uberApp.services;

import com.ridebookapp.project.uber.uberApp.entities.Payment;
import com.ridebookapp.project.uber.uberApp.entities.Ride;
import com.ridebookapp.project.uber.uberApp.entities.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus status);

}
