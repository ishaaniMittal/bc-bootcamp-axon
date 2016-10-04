package fun.web.request;

import fun.domains.model.Address;

/**
 * Created by imittal on 10/4/16.
 */
public class ChangeAddressRequest {
    private String applicationId;
    private Address newApplicationAddress;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public Address getNewApplicationAddress() {
        return newApplicationAddress;
    }

    public void setNewApplicationAddress(Address newApplicationAddress) {
        this.newApplicationAddress = newApplicationAddress;
    }
}
