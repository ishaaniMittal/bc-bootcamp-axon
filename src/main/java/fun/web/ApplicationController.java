package fun.web;

import fun.commands.ChangeAddressCommand;
import fun.commands.SubmitApplicationCommand;
import fun.data.ApplicationDao;
import fun.data.vo.ApplicationVO;
import fun.domains.model.Address;
import fun.domains.model.Applicant;
import fun.web.request.ChangeAddressRequest;
import fun.web.request.SubmitApplicationRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

/**
 * Created by imittal on 10/4/16.
 */
@RestController
public class ApplicationController {

    @Autowired
    CommandGateway commandGateway;

    @Autowired
    ApplicationDao dao;


    @RequestMapping(value = "/api/application", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> submitApplication(@RequestBody SubmitApplicationRequest request) {

        UUID applicationId = UUID.randomUUID();
        SubmitApplicationCommand command = new SubmitApplicationCommand(applicationId.toString(),
                request.getLoanAmount(),
                new Applicant(request.getName(), new Address(request.getHouseNumber(), request.getCity())));
        commandGateway.send(command);
        Map returnMap = new HashMap();
        returnMap.put("applicationId", applicationId);
        return ok().body(returnMap);

    }

    @RequestMapping(value = "/api/application/{applicationId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getApplicationStatus(@PathVariable String applicationId) {
        ApplicationVO application = dao.getApplication(applicationId);
        Map returnMap = new HashMap();
        returnMap.put("applicationStatus", application.getStatus());
        return ok().body(returnMap);
    }

    @RequestMapping(value = "/api/application/address", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> changeApplicationAddress(ChangeAddressRequest request) {
        ChangeAddressCommand command = new ChangeAddressCommand(request.getApplicationId(), request.getNewApplicationAddress());
        commandGateway.send(command);
        Map returnMap = new HashMap();
        returnMap.put("status", "Changed");
        return ok().body(returnMap);
    }
}
