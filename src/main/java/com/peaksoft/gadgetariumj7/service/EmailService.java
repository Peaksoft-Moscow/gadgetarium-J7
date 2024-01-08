package com.peaksoft.gadgetariumj7.service;

import com.peaksoft.gadgetariumj7.mapper.MailMapper;
import com.peaksoft.gadgetariumj7.model.dto.MailRequest;
import com.peaksoft.gadgetariumj7.model.dto.MailResponse;
import com.peaksoft.gadgetariumj7.model.entities.Email;
import com.peaksoft.gadgetariumj7.model.entities.User;
import com.peaksoft.gadgetariumj7.repository.MailRepository;
import com.peaksoft.gadgetariumj7.repository.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailService {

    JavaMailSender javaMailSender;
    MailRepository mailRepository;
    MailMapper mailMapper;
    UserRepository userRepository;

    public MailResponse email(MailRequest request) throws MessagingException {
        Email email = mailMapper.mapToEntity(request);
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.isSubscribeToTheNewsletter()) {
                try {
                    sendEmail(user.getEmail(), request.getMassage(), request.getSender());
                } catch (MailSendException e) {
                    throw new MessagingException("Error sending email", e);
                }
            }
        }
        mailRepository.save(email);
        return mailMapper.mapToMailResponse(email);
    }

    private void sendEmail(String email, String sender, String massage) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject(sender);
        simpleMailMessage.setText(massage);
        javaMailSender.send(simpleMailMessage);
    }
}