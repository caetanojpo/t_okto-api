package br.com.okto.modules.account.domain.model;

import br.com.okto.modules.account.domain.model.account.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class FixedExpense {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal amount;
    private int dueDay;
    private boolean isPaid;
    private ExpenseCategory category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Account familyAccount;

    public FixedExpense(UUID id, String name, String description, BigDecimal amount, int dueDay, boolean isPaid, ExpenseCategory category, LocalDateTime createdAt, LocalDateTime updatedAt, Account familyAccount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.dueDay = dueDay;
        this.isPaid = isPaid;
        this.category = category;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.familyAccount = familyAccount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getDueDay() {
        return dueDay;
    }

    public void setDueDay(int dueDay) {
        this.dueDay = dueDay;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Account getFamilyAccount() {
        return familyAccount;
    }

    public void setFamilyAccount(Account familyAccount) {
        this.familyAccount = familyAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FixedExpense that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "FixedExpense{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", dueDay=" + dueDay +
                ", isPaid=" + isPaid +
                ", category=" + category +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", familyAccount=" + familyAccount +
                '}';
    }
}
