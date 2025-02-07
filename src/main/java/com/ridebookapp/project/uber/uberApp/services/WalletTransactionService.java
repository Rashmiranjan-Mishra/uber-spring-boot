package com.ridebookapp.project.uber.uberApp.services;

import com.ridebookapp.project.uber.uberApp.dto.WalletTransactionDto;
import com.ridebookapp.project.uber.uberApp.entities.WalletTransaction;


public interface WalletTransactionService {
    void createNewWalletTransaction(WalletTransaction walletTransaction);
}
