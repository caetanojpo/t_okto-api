package br.com.okto.modules.user.adapter.out.security;

import br.com.okto.modules.user.application.port.out.security.EncryptPassword;
import jakarta.enterprise.context.ApplicationScoped;
import org.mindrot.jbcrypt.BCrypt;

@ApplicationScoped
public class BcryptEncryptPassword implements EncryptPassword {
    @Override
    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public boolean compare(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}