package com.hmm.expenses_api_transactions.infrastructure.adapter.messaging.transaction;

import com.hmm.expenses_api_transactions.application.domain.models.Transaction;
import com.hmm.expenses_api_transactions.configuration.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendTransaction(Transaction transaction){
        String routingKey = "routing.transactions";
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, routingKey, transaction);
    }
}
