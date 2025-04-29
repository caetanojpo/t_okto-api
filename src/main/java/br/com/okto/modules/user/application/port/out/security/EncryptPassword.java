package br.com.okto.modules.user.application.port.out.security;

public interface EncryptPassword {
    String hash(String password);
    boolean compare(String plainPassword, String hashedPassword);
}
