package springbook.learningtest.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

import java.util.Date;

/**
 * Created by eguns on 2017. 4. 13..
 */
public class MessageActor extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Throwable {
        if(o instanceof Message) {
            Message m = (Message)o;
            System.out.printf("Message [%s] received at %s%n", m.getMessage(), new Date().toString());
        }
    }

    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("actorSystem");
        final ActorRef actorRef = system.actorOf(Props.create(MessageActor.class),"messageProcessor");

        actorRef.tell(new Message("Hello acor system"),null);

    }
}
