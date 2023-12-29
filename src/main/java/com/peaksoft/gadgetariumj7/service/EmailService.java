package com.peaksoft.gadgetariumj7.service;

import com.peaksoft.gadgetariumj7.mapper.MailMapper;
import com.peaksoft.gadgetariumj7.model.dto.MailRequest;
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
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailService {

    MailMapper mailMapper;
    MailRepository mailRepository;
    JavaMailSender javaMailSender;
    UserRepository userRepository;

    public String mail(MailRequest request) {
//        Email email = mailMapper.mapToEntity(request);
        List<User> users = userRepository.findAll();
//        for (User user : users) {
//            if (user.isSent()) {
        try {
            sendMassage("amanovbektur764@gmail.com");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        //}
        //  }
        //  mailRepository.save(email);
        return "successfully created";
    }

    private void sendMassage(String email) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("hello");
        mimeMessageHelper.setText("delete");
        javaMailSender.send(message);


//       SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(request.getSender());
//        message.setTo("ozis2604@gmail.com");
//        message.setSubject("Hello world");
//        message.setText(request.getMassage());
//        javaMailSender.send(message);
    }

//    public void sendEmail(String to, String subject, String body) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(body);
//        javaMailSender.send(message);
//    }

}



