package br.com.okto.modules.account.domain.model.account;

import br.com.okto.modules.user.domain.model.User;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class UserAccount extends Account{

    private final Set<User> users = new HashSet<>();

    public UserAccount(UUID id, String name, BigDecimal balance) {
        super(id, name, balance);
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
}
