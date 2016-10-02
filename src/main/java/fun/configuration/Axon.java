package fun.configuration;

import fun.domains.model.User;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Axon extends Default {

    @Bean
    public EventSourcingRepository<User> users(EventStore eventStore, EventBus eventBus){
        EventSourcingRepository<User> users = new EventSourcingRepository<>(User.class, eventStore);
        users.setEventBus(eventBus);
        return users;
    }

}
