package com.jmsspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JmsSpringbootApplication {

    public static void main(String[] args) throws Exception {

        //This configuration is not necessary for starting embedded server. It's most probably autoconfigured already
        /*ActiveMQServer server = ActiveMQServers.newActiveMQServer(new ConfigurationImpl()
                .setPersistenceEnabled(false)
                .setJournalDirectory("target/data/journal")
                .setSecurityEnabled(false)
                .addAcceptorConfiguration("invm","vm://0" ));

        server.start();*/

        SpringApplication.run(JmsSpringbootApplication.class, args);
    }

}
