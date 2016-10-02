package fun.query.events.listeners;

import fun.domains.events.UserCreatedEvent;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedEventListener {

    @EventHandler
    public void on(UserCreatedEvent userCreatedEvent) {
        System.out.println("Got Event : " + userCreatedEvent);
    }


}
