package fun.data.vo;

import fun.domains.model.Applicant;
import fun.domains.model.ApplicationStatus;

/**
 * Created by imittal on 10/3/16.
 */
public class ApplicationVO {
    private String applicationId;
    private Applicant applicant;
    private double loanAmount;
    private ApplicationStatus status;


    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public ApplicationStatus getStatus() {
        return status;
    }


}
