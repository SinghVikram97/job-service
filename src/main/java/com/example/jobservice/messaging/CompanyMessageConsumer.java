package com.example.jobservice.messaging;

import com.example.jobservice.dto.CompanyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CompanyMessageConsumer {
    private static final Logger logger = LoggerFactory.getLogger(CompanyMessageConsumer.class);

    @RabbitListener(queues = "q.delete-jobs")
    public void consumeMessage(CompanyMessage companyMessage) {
        logger.info("Message received with companyId: {}",companyMessage.getCompanyId());
    }
}
