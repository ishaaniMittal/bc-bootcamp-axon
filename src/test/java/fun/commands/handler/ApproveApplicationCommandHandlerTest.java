package fun.commands.handler;

import fun.commands.ApproveApplicationCommand;
import fun.domains.events.ApplicationApprovedEvent;
import fun.domains.events.ApplicationSubmittedEvent;
import fun.domains.model.Address;
import fun.domains.model.Applicant;
import fun.domains.model.Application;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by imittal on 10/4/16.
 */
public class ApproveApplicationCommandHandlerTest {

    private FixtureConfiguration<Application> fixture;
    private ApproveApplicationCommandHandler commandHandler;

    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(Application.class);
        commandHandler = new ApproveApplicationCommandHandler(fixture.getRepository());
        fixture.registerAnnotatedCommandHandler(commandHandler);
    }

    @Test
    public void shouldApproveApplication() throws Exception {
        ApproveApplicationCommand command = new ApproveApplicationCommand("applicationId");
        fixture
                .given(new ApplicationSubmittedEvent("applicationId", new Applicant("name", new Address("house", "city")), 1000))
                .when(command)
                .expectEvents(new ApplicationApprovedEvent(command.getApplicationId()));
    }
}
