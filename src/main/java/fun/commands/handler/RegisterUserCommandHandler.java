package fun.commands.handler;

import fun.commands.RegisterUserCommand;
import fun.domains.model.User;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserCommandHandler {


    private Repository<User> users;

    @Autowired
    public RegisterUserCommandHandler(Repository<User> users) {
        this.users = users;
    }

    @CommandHandler
    public void on(RegisterUserCommand command){

        users.add(new User(command.getId(),
                command.getUserName(),
                command.getDateOfBirth()));
    }
}
