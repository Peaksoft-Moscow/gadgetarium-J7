package com.peaksoft.gadgetariumj7.mapper;

import com.peaksoft.gadgetariumj7.model.dto.EmailRequest;
import com.peaksoft.gadgetariumj7.model.dto.EmailResponse;
import com.peaksoft.gadgetariumj7.model.entities.Mailing;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MailingMapper {

    public Mailing mapToEntity(EmailRequest request) {
        Mailing mailing = new Mailing();
        mailing.setMailingName(request.getMailingName());
        mailing.setNewsletterDescription(request.getNewsletterDescription());
        mailing.setMassage(request.getMassage());
        mailing.setImage(request.getImage());
        mailing.setPromotionStartDate(request.getPromotionStartDate());
        mailing.setPromotionEndDate(request.getPromotionEndDate());
        mailing.setCreateDate(LocalDate.now());
        return mailing;
    }

    public EmailResponse mapToMailResponse(Mailing mailing) {
        return EmailResponse.builder()
                .id(mailing.getId())
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
