package br.com.okto.modules.account.domain.model;

import br.com.okto.modules.account.domain.model.account.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Objects;
import java.util.UUID;

public class BalanceHistory {
    private UUID id;
    private YearMonth month;
    private BigDecimal previousBalance;
    private BigDecimal transactionAmount;
    private BigDecimal remainingBalance;
    private LocalDateTime createdAt;

    private Account account;

    public BalanceHistory(UUID id, YearMonth month, BigDecimal previousBalance, BigDecimal remainingBalance, LocalDateTime createdAt, Account account) {
        this.id = id;
        this.month = month;
        this.previousBalance = previousBalance;
        this.remainingBalance = remainingBalance;
        this.account = account;
        this.transactionAmount = defineTransactionAmount();
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public YearMonth getMonth() {
        return month;
    }

    public void setMonth(YearMonth month) {
        this.month = month;
    }

    public BigDecimal getPreviousBalance() {
        return previousBalance;
    }

    public void setPreviousBalance(BigDecimal previousBalance) {
        this.previousBalance = previousBalance;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public BigDecimal getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(BigDecimal remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    private BigDecimal defineTransactionAmount(){
        return remainingBalance.subtract(previousBalance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BalanceHistory that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BalanceHistory{" +
                "id=" + id +
                ", month=" + month +
                ", previousBalance=" + previousBalance +
                ", transactionAmount=" + transactionAmount +
                ", remainingBalance=" + remainingBalance +
                ", createdAt=" + createdAt +
                ", account=" + account +
                '}';
    }
}
