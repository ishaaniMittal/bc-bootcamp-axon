package fun.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Created by imittal on 10/3/16.
 */
public class ApproveApplicationCommand {

    @TargetAggregateIdentifier
    private String applicationId;

    public ApproveApplicationCommand(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationId() {
        return applicationId;
    }
}
