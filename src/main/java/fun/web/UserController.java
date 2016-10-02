package fun.web;


import fun.commands.RegisterUserCommand;
import fun.domains.model.User;
import fun.web.request.AddUserRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class UserController {

    @Autowired
    CommandGateway commandGateway;


    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    @ResponseBody
    public List<User> users() {
        return Collections.emptyList();
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> registerUser(@RequestBody AddUserRequest request) {

        System.out.println("request.getDateOfBirth() = " + request.getDateOfBirth());


        UUID userId = UUID.randomUUID();
        RegisterUserCommand command = new RegisterUserCommand(userId.toString(),
                request.getUserName(),
                request.getDateOfBirth());
        commandGateway.send(command);
        Map returnMap = new HashMap();
        returnMap.put("userId", userId);
        return ok().body(returnMap);

    }

    @RequestMapping(value = "/api/user/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getUser(@PathVariable String userId) {
        return ok("User ");
    }
}
