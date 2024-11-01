package br.com.giuliosousa.gestao_vagas.exceptions;

public class UserExistsException extends RuntimeException{
    public UserExistsException() {
        super("Usuário já existe");
    }
}
