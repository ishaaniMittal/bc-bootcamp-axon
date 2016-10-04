package fun.commands;

import fun.domains.model.Address;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Created by imittal on 10/4/16.
 */
public class ChangeAddressCommand {

    @TargetAggregateIdentifier
    private String applicationId;
    private Address newApplicationAddress;


    public ChangeAddressCommand(String applicationId, Address newApplicationAddress) {
        this.applicationId = applicationId;
        this.newApplicationAddress = newApplicationAddress;
    }


}
