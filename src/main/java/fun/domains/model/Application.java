package fun.domains.model;

import fun.domains.events.ApplicationApprovedEvent;
import fun.domains.events.ApplicationSubmittedEvent;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

/**
 * Created by imittal on 10/3/16.
 */
public class Application extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private String applicationId;

    private Applicant applicant;
    private double loanAmount;

    private ApplicationStatus status;

    public Application() {

    }

    public Application(String applicationId, Applicant applicant, double loanAmount) {
        apply(new ApplicationSubmittedEvent(applicationId, applicant, loanAmount));
    }

    @EventSourcingHandler
    public void on(ApplicationSubmittedEvent event) {
        this.status = ApplicationStatus.SUBMITTED;
        this.applicationId = event.getapplicationId();
    }

    @EventSourcingHandler
    public void on(ApplicationApprovedEvent event) {
        this.status = ApplicationStatus.APPROVED;
    }

    public void approve() {
        apply(new ApplicationApprovedEvent(this.applicationId));
    }

}
