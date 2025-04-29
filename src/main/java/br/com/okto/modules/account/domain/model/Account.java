package br.com.okto.modules.account.domain.model;

import br.com.okto.modules.user.domain.model.User;
import br.com.okto.shared.exception.NegativeValueException;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public abstract class Account {
    private UUID id;
    private String name;
    private BigDecimal balance;

    private final Set<User> users = new HashSet<>();

    public Account(UUID id, String name, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Set<User> getUsers() {
        return Collections.unmodifiableSet(users);
    }

    public void addUser(User user) {
        Objects.requireNonNull(user, "user must not be null");
        if (users.add(user)) {
            user.addAccount(this);
        }
    }

    public void removeUser(User user) {
        if (users.remove(user)) {
            user.removeAccount(this);
        }
    }

    public void addToBalance(BigDecimal newValue){
        if(newValue == null || newValue.compareTo(BigDecimal.ZERO) <= 0){
            throw new NegativeValueException(Account.class.getSimpleName(), "addToBalance");
        }

        this.balance = getBalance().add(newValue);
    }

    public void subtractFromBalance(BigDecimal subtractValue){
        if(subtractValue == null || subtractValue.compareTo(BigDecimal.ZERO) <= 0){
            throw new NegativeValueException(Account.class.getSimpleName(), "subtractFromBalance");
        }

        this.balance = getBalance().subtract(subtractValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", users=" + users +
                '}';
    }
}
