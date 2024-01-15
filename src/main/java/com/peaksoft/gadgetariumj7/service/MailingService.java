package com.peaksoft.gadgetariumj7.service;

import com.peaksoft.gadgetariumj7.exception.IncorrectCodeException;
import com.peaksoft.gadgetariumj7.mapper.MailingMapper;
import com.peaksoft.gadgetariumj7.model.dto.MailingRequest;
import com.peaksoft.gadgetariumj7.model.dto.MailingResponse;
import com.peaksoft.gadgetariumj7.model.entities.Mailing;
import com.peaksoft.gadgetariumj7.model.entities.User;
import com.peaksoft.gadgetariumj7.repository.MailingRepository;
import com.peaksoft.gadgetariumj7.repository.UserRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MailingService {

    JavaMailSender javaMailSender;
    MailingRepository mailingRepository;
    MailingMapper mailMapper;
    UserRepository userRepository;

    @Autowired
    public MailingService(@Qualifier("Bektursun") JavaMailSender javaMailSender, MailingRepository mailingRepository, MailingMapper mailMapper, UserRepository userRepository) {
        this.javaMailSender = javaMailSender;
        this.mailingRepository = mailingRepository;
        this.mailMapper = mailMapper;
        this.userRepository = userRepository;
    }

    public MailingResponse createMailing(MailingRequest request) {
        Mailing email = mailMapper.mapToEntity(request);
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.isSubscribe()) {
                try {
                    sendMailing(request.getEmail(), request.getSender(), request.getMassage());
                } catch (MailSendException e) {
                    log.info("Error sending email");
                    throw new IncorrectCodeException("Error sending email");
                }
            }
        }
        mailingRepository.save(email);
        return mailMapper.mapToMailResponse(email);
    }

    private void sendMailing(String email, String sender, String massage) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject(sender);
        simpleMailMessage.setText(massage);
        javaMailSender.send(simpleMailMessage);
    }
}