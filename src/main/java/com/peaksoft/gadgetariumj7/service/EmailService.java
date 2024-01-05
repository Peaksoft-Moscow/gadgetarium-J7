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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailService {

    JavaMailSender javaMailSender;
    MailRepository mailRepository;
    MailMapper mailMapper;
    UserRepository userRepository;

    public MailResponse Email(MailRequest request) {
        Email email = mailMapper.mapToEntity(request);
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.isSubscribeToTheNewsletter()) {
                try {
                    sendMassage(request.getSender(), user.getEmail(), request.getMassage());
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        try {
            sendMassage(request.getEmail(), request.getSender(), request.getMassage());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        mailRepository.save(email);
        return mailMapper.mapToMailResponse(email);
    }

    private void sendMassage(String email, String sender, String massage) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject(mimeMessage.getSubject());
        mimeMessageHelper.setText(mimeMessage.getMessageID());
        javaMailSender.send(mimeMessage);
    }
}