package com.peaksoft.gadgetariumj7.mapper;

import com.peaksoft.gadgetariumj7.model.dto.MailRequest;
import com.peaksoft.gadgetariumj7.model.dto.MailResponse;
import com.peaksoft.gadgetariumj7.model.entities.Email;
import org.springframework.stereotype.Component;

@Component
public class MailMapper {

    public Email mapToEntity(MailRequest request){
        Email email = new Email();
        email.setEmail(request.getSender());
        email.setMassage(request.getMassage());
        return email;
    }

    public MailResponse mapToMailResponse(Email email){
        return MailResponse.builder()
                .id(email.getId())
                .sender(email.getEmail())
                .massage(email.getMassage())
                .build();
    }
}
