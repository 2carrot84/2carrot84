package springbook.learningtest.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.RoundRobinPool;

/**
 * Created by eguns on 2017. 4. 13..
 */
public class MultiActors {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("actorSystem");
//        final ActorRef ref = system.actorOf(Props.create(LongRunningActor.class));
        final ActorRef ref = system.actorOf(Props.create(LongRunningActor.class).withRouter(new RoundRobinPool(3)));

        System.out.println("Sending m1");
        ref.tell("Message 1", null);
        System.out.println("Sending m2");
        ref.tell("Message 2", null);
        System.out.println("Sending m3");
        ref.tell("Message 3", null);

    }
}
