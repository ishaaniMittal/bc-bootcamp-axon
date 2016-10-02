package fun.commands;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

import java.util.Date;

public class RegisterUserCommand {
    @TargetAggregateIdentifier
    private String id;
    private String userName;
    private Date dateOfBirth;

    public RegisterUserCommand() {
    }

    public RegisterUserCommand(String id, String userName, Date dateOfBirth) {
        this.id = id;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}
