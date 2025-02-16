package com.ridebookapp.project.uber.uberApp.services.Impl;

import com.ridebookapp.project.uber.uberApp.dto.RideDto;
import com.ridebookapp.project.uber.uberApp.dto.WalletDto;
import com.ridebookapp.project.uber.uberApp.dto.WalletTransactionDto;
import com.ridebookapp.project.uber.uberApp.entities.Ride;
import com.ridebookapp.project.uber.uberApp.entities.User;
import com.ridebookapp.project.uber.uberApp.entities.Wallet;
import com.ridebookapp.project.uber.uberApp.entities.WalletTransaction;
import com.ridebookapp.project.uber.uberApp.entities.enums.TransactionMethod;
import com.ridebookapp.project.uber.uberApp.entities.enums.TransactionType;
import com.ridebookapp.project.uber.uberApp.exceptions.ResourceNotFoundException;
import com.ridebookapp.project.uber.uberApp.repositories.WalletRepository;
import com.ridebookapp.project.uber.uberApp.services.WalletService;
import com.ridebookapp.project.uber.uberApp.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;
    private final WalletTransactionService walletTransactionService;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public Wallet addMoneyToWallet(User user, Double amount, String transactionId , Ride ride , TransactionMethod transactionMethod) {
        Wallet wallet = findByUser(user);
        wallet.setBalance(wallet.getBalance()+amount);

        WalletTransaction walletTransaction = WalletTransaction.builder()
                .transactionId(transactionId)
                .ride(ride)
                .wallet(wallet)
                .transactionType(TransactionType.CREDIT)
                .transactionMethod(transactionMethod)
                .amount(amount)
                .build();
        walletTransactionService.createNewWalletTransaction(walletTransaction);

        return walletRepository.save(wallet);

    }

    @Override
    @Transactional
    public Wallet deductMoneyFromWallet(User user, Double amount, String transactionId ,
                                        Ride ride , TransactionMethod transactionMethod) {
        Wallet wallet = findByUser(user);
        wallet.setBalance(wallet.getBalance()-amount);

        WalletTransaction walletTransaction = WalletTransaction.builder()
                .transactionId(transactionId)
                .ride(ride)
                .wallet(wallet)
                .transactionType(TransactionType.DEBIT)
                .transactionMethod(transactionMethod)
                .amount(amount)
                .build();

        walletTransactionService.createNewWalletTransaction(walletTransaction);

      //  wallet.getTransactions().add(walletTransaction);

        return walletRepository.save(wallet);
    }

    @Override
    public void withdrawAllMyMoneyFromWallet() {

    }

    @Override
    public Wallet findWalletById(Long walletId) {
        return walletRepository.findById(walletId)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not found with id: "+walletId));
    }

    @Override
    public Wallet createNewWallet(User user) {
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet findByUser(User user) {
        return walletRepository.findByUser(user)
                .orElseThrow(()->new ResourceNotFoundException("wallet not found for user with id : "+user.getId()));
    }
}
