package com.jmsspringboot.listener;

import com.jmsspringboot.config.JmsConfig;
import com.jmsspringboot.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HelloListener {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders messageHeaders, Message message) {
        /*System.out.println("I got message!!!!!");

        System.out.println("Message: " + helloWorldMessage.getMessage());*/
    }

    @JmsListener(destination = JmsConfig.MY_SEND_RECEIVE_QUEUE)
    public void listenForHello(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders messageHeaders, Message message,
                               org.springframework.messaging.Message springMessage) throws JMSException {

        HelloWorldMessage messageWorld = HelloWorldMessage.builder()
                .id(UUID.randomUUID())
                .message("world!")
                .build();
        jmsTemplate.convertAndSend(message.getJMSReplyTo(), messageWorld);

        //jmsTemplate.convertAndSend((Destination) springMessage.getHeaders().get("jms_replyTo"), "got it!" )
    }



}
