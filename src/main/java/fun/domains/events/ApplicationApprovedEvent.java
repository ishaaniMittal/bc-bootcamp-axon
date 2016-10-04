package fun.domains.events;

/**
 * Created by imittal on 10/4/16.
 */
public class ApplicationApprovedEvent {
    private String applicationId;

    public ApplicationApprovedEvent(String applicationId) {
        this.applicationId = applicationId;
    }

    public ApplicationApprovedEvent() {
    }

    public String getApplicationId() {
        return applicationId;
    }

}
