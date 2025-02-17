package br.com.arquitec.runnables;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailSenderRunnable implements Runnable {
    private final String fromEmailId;
    private final String recipient;
    private final String body;
    private final String subject;
    private final JavaMailSender javaMailSender;

    public EmailSenderRunnable(String fromEmailId, String recipient, String body, String subject, JavaMailSender javaMailSender) {
        this.fromEmailId = fromEmailId;
        this.recipient = recipient;
        this.body = body;
        this.subject = subject;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void run() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromEmailId);
        simpleMailMessage.setTo(recipient);
        simpleMailMessage.setText(body);
        simpleMailMessage.setSubject(subject);

        javaMailSender.send(simpleMailMessage);
    }
}
