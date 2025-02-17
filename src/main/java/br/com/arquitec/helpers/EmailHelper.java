package br.com.arquitec.helpers;

public class EmailHelper {
    public static String createEmailBodyOfNewCustomer(String name, String lastname, String token) {
        return String.format("Olá, %s %s! Ative sua conta clicando no link abaixo\n" +
                "http://localhost:5173/activate-account?token=%s", name, lastname, token);
    }
}
