package springbook.learningtest.akka;

import akka.actor.UntypedActor;

/**
 * Created by eguns on 2017. 4. 13..
 */
public class LongRunningActor extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Throwable {
        System.out.printf("Being run on ActorRef : %s%n", getSelf());

        Thread.sleep(10000);

        System.out.printf("Received %s%n", o);
    }
}
