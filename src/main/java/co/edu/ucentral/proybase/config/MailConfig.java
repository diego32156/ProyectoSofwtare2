package co.edu.ucentral.proybase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        // Configura los detalles del servidor SMTP
        mailSender.setHost("smtp.example.com");
        mailSender.setPort(587);
        mailSender.setUsername("your-email@example.com");
        mailSender.setPassword("your-email-password");
        return mailSender;
    }
}
