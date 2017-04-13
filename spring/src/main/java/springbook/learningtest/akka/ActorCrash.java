package springbook.learningtest.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * Created by eguns on 2017. 4. 13..
 */
public class ActorCrash extends UntypedActor {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("actorSystem");
        final ActorRef crashRef = system.actorOf(Props.create(ActorCrash.class));
        final ActorRef dividingActorRef = system.actorOf(Props.create(DividingActor.class));

        dividingActorRef.tell(5, crashRef);
        dividingActorRef.tell(0, crashRef);
        dividingActorRef.tell(1, crashRef);
    }

    @Override

    public void onReceive(Object o) throws Throwable {
        System.out.printf("Received result : [%s]%n", o);
    }
}
