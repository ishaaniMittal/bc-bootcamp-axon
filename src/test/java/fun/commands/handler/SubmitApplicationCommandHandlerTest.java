package fun.commands.handler;

import fun.commands.SubmitApplicationCommand;
import fun.domains.events.ApplicationSubmittedEvent;
import fun.domains.model.Address;
import fun.domains.model.Applicant;
import fun.domains.model.Application;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

/**
 * Created by imittal on 10/4/16.
 */
public class SubmitApplicationCommandHandlerTest {

    private FixtureConfiguration<Application> fixture;
    private SubmitApplicationCommandHandler commandHandler;

    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(Application.class);
        commandHandler = new SubmitApplicationCommandHandler(fixture.getRepository());
        fixture.registerAnnotatedCommandHandler(commandHandler);
    }

    @Test
    public void shouldSubmitApplication() throws Exception {
        SubmitApplicationCommand command = new SubmitApplicationCommand("applicationId",
                1000, new Applicant("name", new Address("house", "city")));
        fixture
                .given(Collections.emptyList())
                .when(command)
                .expectEvents(new ApplicationSubmittedEvent(command.getApplicationId(),
                        command.getApplicant(),command.getLoanAmount()));
    }
}
