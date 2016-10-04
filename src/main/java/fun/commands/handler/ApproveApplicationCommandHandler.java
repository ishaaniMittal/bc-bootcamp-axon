package fun.commands.handler;

import fun.commands.ApproveApplicationCommand;
import fun.domains.model.Application;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by imittal on 10/3/16.
 */
@Component
public class ApproveApplicationCommandHandler {

    private Repository<Application> applicationRepository;

    @Autowired
    public ApproveApplicationCommandHandler(Repository<Application> applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @CommandHandler
    public void on(ApproveApplicationCommand approveApplicationCommand) {
        Application application = applicationRepository.load(approveApplicationCommand.getApplicationId());
        application.approve();
    }
}
