package fun.domains.events;

import fun.domains.model.Applicant;

/**
 * Created by imittal on 10/3/16.
 */
public class ApplicationSubmittedEvent {

    private String applicationId;
    private Applicant applicant;
    private double loanAmount;

    public ApplicationSubmittedEvent() {
    }

    public ApplicationSubmittedEvent(String applicationId, Applicant applicant, double loanAmount) {

        this.applicationId = applicationId;
        this.applicant = new Applicant(applicant.getName(),applicant.getAddress());
        this.loanAmount = loanAmount;
    }

    public String getapplicationId() {
        return applicationId;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public double getLoanAmount() {
        return loanAmount;
    }
}
