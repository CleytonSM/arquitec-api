package br.com.arquitec.services;

import br.com.arquitec.helpers.EmailHelper;
import br.com.arquitec.models.entities.User;
import br.com.arquitec.models.enums.EmailSubject;
import br.com.arquitec.runnables.EmailSenderRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class EmailService {
    @Value("${spring.mail.username}")
    private String fromEmailId;
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmailOfNewCustomer(User user) {
        emailOfNewCustomer(user);
    }

    private void emailOfNewCustomer(User user) {
        String body = setUpEmailBodyOfNewCustomer(user.getName(), user.getLastname(), "");

        sendEmail(user.getEmail(), body, EmailSubject.NEW_ACCOUNT.name());
    }

    private String setUpEmailBodyOfNewCustomer(String name, String lastname, String token) {
        return EmailHelper.createEmailBodyOfNewCustomer(name, lastname, token);
    }

    private void sendEmail(String recipient, String body, String subject) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        try {
            EmailSenderRunnable emailSenderRunnable =
                    new EmailSenderRunnable(fromEmailId, recipient, body, subject, javaMailSender);

            executor.submit(emailSenderRunnable);
            executor.shutdown();
        } catch (Exception e) {
            executor.shutdownNow();
        }
    }
}
