package com.peaksoft.gadgetariumj7.mapper;

import com.peaksoft.gadgetariumj7.model.dto.MailingRequest;
import com.peaksoft.gadgetariumj7.model.dto.MailingResponse;
import com.peaksoft.gadgetariumj7.model.entities.Mailing;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MailingMapper {

    public Mailing mapToEntity(MailingRequest request) {
        Mailing mailing = new Mailing();
        mailing.setEmail(request.getEmail());
        mailing.setSender(request.getSender());
        mailing.setMailingName(request.getMailingName());
        mailing.setNewsletterDescription(request.getNewsletterDescription());
        mailing.setMassage(request.getMassage());
        mailing.setImage(request.getImage());
        mailing.setPromotionStartDate(request.getPromotionStartDate());
        mailing.setPromotionEndDate(request.getPromotionEndDate());
        mailing.setCreateDate(LocalDate.now());
        return mailing;
    }

    public MailingResponse mapToMailResponse(Mailing mailing) {
        return MailingResponse.builder()
                .id(mailing.getId())
                .email(mailing.getEmail())
                .sender(mailing.getSender())
                .mailingName(mailing.getMailingName())
                .newsletterDescription(mailing.getNewsletterDescription())
                .massage(mailing.getMassage())
                .image(mailing.getImage())
                .promotionStartDate(mailing.getPromotionStartDate())
                .promotionEndDate(mailing.getPromotionEndDate())
                .createDate(LocalDate.now())
                .build();
    }
}
