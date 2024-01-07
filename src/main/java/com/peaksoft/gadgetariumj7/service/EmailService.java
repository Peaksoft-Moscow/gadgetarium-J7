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


    public void sendEmailToSubscribedUsers() {
        List<User> subscribedUsers = userRepository.findBySubscribeIsTrue();
        for (User user : subscribedUsers) {
            sendEmailToUser(user);
        }
    }

    private void sendEmailToUser(User user) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setFrom("gad");
        mailMessage.setSubject("Subject of the Email");

        String message = "Your message here from GiftList";
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }

//    public MailResponse Email(MailRequest request) {
//        Email email = mailMapper.mapToEntity(request);
//        List<User> users = userRepository.findAll();
//        for (User user : users) {
//            if (user.isSubscribeToTheNewsletter()) {
//                try {
//                    sendEmail(user.getEmail(), request.getSender(), request.getMassage());
//                } catch (MessagingException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//        mailRepository.save(email);
//        return mailMapper.mapToMailResponse(email);
//    }
//
//    private void sendEmail(String email, String sender, String massage) throws MessagingException {
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setTo(email);
//        simpleMailMessage.setSubject(sender);
//        simpleMailMessage.setText(massage);
//        javaMailSender.send(simpleMailMessage);
//    }
}


//    public MailResponse Email(MailRequest request) {
//        Email email = mailMapper.mapToEntity(request);
//        List<User> users = userRepository.findAll();
//        for (User user : users) {
//            if (user.isSubscribeToTheNewsletter()) {
//                try {
//                    sendMassage(user.getEmail(), request.getSender(), request.getMassage());
//                } catch (MessagingException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//        mailRepository.save(email);
//        return mailMapper.mapToMailResponse(email);
//    }
//
//    private void sendMassage(String email, String sender, String massage) throws MessagingException {
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
//        mimeMessageHelper.setTo(email);
//        mimeMessageHelper.setSubject(sender);
//        mimeMessageHelper.setText(massage);
//        javaMailSender.send(mimeMessage);
//    }
//}