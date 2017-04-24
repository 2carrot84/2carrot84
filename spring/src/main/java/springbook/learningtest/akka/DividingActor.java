package springbook.learningtest.akka;

import akka.actor.OneForOneStrategy;
import akka.actor.SupervisorStrategy;
import akka.actor.UntypedActor;
import akka.japi.Function;
import scala.concurrent.duration.Duration;

/**
 * Created by eguns on 2017. 4. 13..
 */
public class DividingActor extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Throwable {
        if(o instanceof Integer) {
            Integer n = (Integer)o;
            int result = 10 / n;
            this.getSender().tell(result, getSelf());
        }
    }

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return new OneForOneStrategy(10, Duration.Inf(),
                new Function<Throwable, SupervisorStrategy.Directive>() {
                    @Override
                    public SupervisorStrategy.Directive apply(Throwable throwable) throws Exception {
                        return SupervisorStrategy.restart();
                    }
                });
    }
}
