package fun.commands.handler;

import fun.commands.SubmitApplicationCommand;
import fun.domains.model.Application;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by imittal on 10/3/16.
 */
@Component
public class SubmitApplicationCommandHandler {

    @Autowired
    private Repository<Application> applicationRepository;

    @Autowired
    public SubmitApplicationCommandHandler(Repository<Application> applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @CommandHandler
    public void on(SubmitApplicationCommand submitApplicationCommand){
        applicationRepository.add(new Application(submitApplicationCommand.getApplicationId(),submitApplicationCommand.getApplicant(),submitApplicationCommand.getLoanAmount()));
    }
}
