package com.ridebookapp.project.uber.uberApp.strategies;

import com.ridebookapp.project.uber.uberApp.entities.enums.PaymentMethod;
import com.ridebookapp.project.uber.uberApp.strategies.Impl.CashPaymentStrategy;
import com.ridebookapp.project.uber.uberApp.strategies.Impl.WalletPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {

    private final WalletPaymentStrategy walletPaymentStrategy;
    private final CashPaymentStrategy cashPaymentStrategy;

    public PaymentStrategy paymentStrategy(PaymentMethod paymentMethod){
      return  switch (paymentMethod){
            case WALLET -> walletPaymentStrategy;
            case CASH -> cashPaymentStrategy;
        };
    }
}
