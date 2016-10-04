package fun.query.events.listeners;

import fun.commands.ApproveApplicationCommand;
import fun.data.vo.ApplicationVO;
import fun.domains.events.ApplicationSubmittedEvent;
import fun.domains.service.DecisioningService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by imittal on 10/4/16.
 */
@Component
public class DecideOnApplicationEventListener {

    @Autowired
    private DecisioningService decisioningService;

    @Autowired
    CommandGateway gateway;

    @EventHandler
    public void on(ApplicationSubmittedEvent applicationSubmittedEvent) {
        ApplicationVO applicationVO = getApplicationVO(applicationSubmittedEvent);
        if (decisioningService.getDecision(applicationVO)) {
            gateway.send(new ApproveApplicationCommand(applicationVO.getApplicationId()));
        }
    }

    private ApplicationVO getApplicationVO(ApplicationSubmittedEvent applicationSubmittedEvent) {
        ApplicationVO applicationVO = new ApplicationVO();
        applicationVO.setApplicant(applicationSubmittedEvent.getApplicant());
        applicationVO.setApplicationId(applicationSubmittedEvent.getapplicationId());
        applicationVO.setLoanAmount(applicationSubmittedEvent.getLoanAmount());
        return applicationVO;
    }
}
