package fun.commands;

import fun.domains.model.Applicant;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Created by imittal on 10/3/16.
 */
public class SubmitApplicationCommand {

    @TargetAggregateIdentifier
    private String applicationId;
    private double loanAmount;
    private Applicant applicant;

    public SubmitApplicationCommand(String applicationId, double loanAmount, Applicant applicant) {
        this.applicationId = applicationId;
        this.loanAmount = loanAmount;
        this.applicant = applicant;
    }

    public SubmitApplicationCommand() {
    }

    public String getApplicationId() {
        return applicationId;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public Applicant getApplicant() {
        return applicant;
    }
}
