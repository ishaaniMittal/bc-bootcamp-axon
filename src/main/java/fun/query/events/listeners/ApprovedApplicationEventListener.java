package fun.query.events.listeners;

import fun.data.ApplicationDao;
import fun.data.vo.ApplicationVO;
import fun.domains.events.ApplicationApprovedEvent;
import fun.domains.model.ApplicationStatus;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by imittal on 10/4/16.
 */
@Component
public class ApprovedApplicationEventListener {

    @Autowired
    private ApplicationDao applicationDao;

    @EventHandler
    public void on(ApplicationApprovedEvent event) {
        String applicationId = event.getApplicationId();
        ApplicationVO application = applicationDao.getApplication(applicationId);
        application.setStatus(ApplicationStatus.APPROVED);
        applicationDao.saveApplication(applicationId, application);
    }
}
