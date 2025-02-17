package br.com.arquitec.models.enums;

public enum EmailSubject {
    NEW_ACCOUNT("Ativar Conta");

    private final String message;

    EmailSubject(String message) {
        this.message = message;
    }
}
