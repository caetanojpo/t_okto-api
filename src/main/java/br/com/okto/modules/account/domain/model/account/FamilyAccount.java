package br.com.okto.modules.account.domain.model.account;

import java.math.BigDecimal;
import java.util.UUID;

public class FamilyAccount extends Account{
    public FamilyAccount(UUID id, String name, BigDecimal balance) {
        super(id, name, balance);
    }
}
