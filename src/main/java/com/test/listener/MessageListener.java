package com.test.listener;

import com.google.common.net.MediaType;
import com.google.pubsub.v1.PubsubMessage;
import com.test.model.Message;
import io.micronaut.gcp.pubsub.annotation.MessageId;
import io.micronaut.gcp.pubsub.annotation.PubSubListener;
import io.micronaut.gcp.pubsub.annotation.Subscription;
import io.micronaut.gcp.pubsub.annotation.Topic;
import io.micronaut.gcp.pubsub.bind.PubSubMessageIdBinder;
import io.micronaut.messaging.Acknowledgement;
import io.micronaut.messaging.annotation.Body;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PubSubListener()
public class MessageListener {

    Logger l = LoggerFactory.getLogger(this.getClass());

    @Subscription(value = "visualizacao")
    public void receive(@Body Message m ,Acknowledgement acknowledgement){
        acknowledgement.ack();
        l.info("Mensagem recebida");
    }
}
