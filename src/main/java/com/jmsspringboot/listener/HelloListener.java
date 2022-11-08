package com.jmsspringboot.listener;

import com.jmsspringboot.config.JmsConfig;
import com.jmsspringboot.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class HelloListener {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders messageHeaders, Message message) {
        System.out.println("I got message!!!!!");

        System.out.println("Message: " + helloWorldMessage.getMessage());
    }
}
