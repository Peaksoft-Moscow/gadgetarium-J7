package com.peaksoft.gadgetariumj7.service;

import com.peaksoft.gadgetariumj7.mapper.MailingMapper;
import com.peaksoft.gadgetariumj7.model.dto.EmailRequest;
import com.peaksoft.gadgetariumj7.model.dto.EmailResponse;
import com.peaksoft.gadgetariumj7.model.entities.Mailing;
import com.peaksoft.gadgetariumj7.model.entities.User;
import com.peaksoft.gadgetariumj7.repository.MailRepository;
import com.peaksoft.gadgetariumj7.repository.UserRepository;
import jakarta.mail.MessagingException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MailingService {

    JavaMailSender javaMailSender;
    MailRepository mailRepository;
    MailingMapper mailingMapper;
    UserRepository userRepository;

    @Autowired
    public MailingService(@Qualifier("Bektursun") JavaMailSender javaMailSender, MailRepository mailRepository, MailingMapper mailingMapper, UserRepository userRepository) {
        this.javaMailSender = javaMailSender;
        this.mailRepository = mailRepository;
        this.mailingMapper = mailingMapper;
        this.userRepository = userRepository;
    }

    public EmailResponse createMailing(EmailRequest request) throws MessagingException {
        Mailing mailing = mailingMapper.mapToEntity(request);
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.isSubscribe()) {
                try {
                    sendMailing(request.getImage(), request.getMailingName(), request.getMassage());
                } catch (MailSendException e) {
                    throw new MessagingException("Error sending mailing", e);
                }
            }
        }
        mailRepository.save(mailing);
        return mailingMapper.mapToMailResponse(mailing);
    }

    private void sendMailing(String email, String sender, String massage) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject(sender);
        simpleMailMessage.setText(massage);
        javaMailSender.send(simpleMailMessage);
    }
}