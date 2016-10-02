package fun.commands.handler;

import fun.commands.RegisterUserCommand;
import fun.domains.events.UserCreatedEvent;
import fun.domains.model.User;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Date;


public class CreateUserCommandHandlerTest {

    private FixtureConfiguration<User> fixture;
    private RegisterUserCommandHandler commandHandler;

    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(User.class);
        commandHandler = new RegisterUserCommandHandler(fixture.getRepository());
        fixture.registerAnnotatedCommandHandler(commandHandler);
    }

    @Test
    public void shouldCreateUser() throws Exception {
        RegisterUserCommand command = new RegisterUserCommand("userId", "name", new Date());
        fixture
                .given(Collections.emptyList())
                .when(command)
                .expectEvents(new UserCreatedEvent(command.getId(), command.getUserName(), command.getDateOfBirth()));
    }
}