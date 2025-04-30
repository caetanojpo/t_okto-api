package br.com.okto.modules.account.domain.model;

import br.com.okto.modules.account.domain.enums.TransactionType;
import br.com.okto.modules.account.domain.model.account.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Transaction {
    private UUID id;
    private BigDecimal amount;
    private TransactionType type;
    private String description;
    private ExpenseCategory category;
    private LocalDateTime createdAt;

    private Account relatedAccount;

    public Transaction(UUID id, BigDecimal amount, TransactionType type, String description, ExpenseCategory category, LocalDateTime createdAt, Account relatedAccount) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.description = description;
        this.category = category;
        this.createdAt = createdAt;
        this.relatedAccount = relatedAccount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Account getRelatedAccount() {
        return relatedAccount;
    }

    public void setRelatedAccount(Account relatedAccount) {
        this.relatedAccount = relatedAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", createdAt=" + createdAt +
                ", relatedAccount=" + relatedAccount +
                '}';
    }
}
