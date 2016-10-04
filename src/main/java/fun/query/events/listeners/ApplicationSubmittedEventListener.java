package fun.query.events.listeners;

import fun.data.ApplicationDao;
import fun.data.vo.ApplicationVO;
import fun.domains.events.ApplicationSubmittedEvent;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by imittal on 10/3/16.
 */
@Component
public class ApplicationSubmittedEventListener {

    @Autowired
    private ApplicationDao applicationDao;


    @EventHandler
    public void on(ApplicationSubmittedEvent applicationSubmittedEvent) {
        System.out.println("Got Event : " + applicationSubmittedEvent);
        ApplicationVO applicationVO = getApplicationVO(applicationSubmittedEvent);
        applicationDao.saveApplication(applicationSubmittedEvent.getapplicationId(), applicationVO);

    }

    private ApplicationVO getApplicationVO(ApplicationSubmittedEvent applicationSubmittedEvent) {
        ApplicationVO applicationVO = new ApplicationVO();
        applicationVO.setApplicant(applicationSubmittedEvent.getApplicant());
        applicationVO.setApplicationId(applicationSubmittedEvent.getapplicationId());
        applicationVO.setLoanAmount(applicationSubmittedEvent.getLoanAmount());
        return applicationVO;
    }


}
