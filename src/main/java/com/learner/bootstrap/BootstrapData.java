package com.learner.bootstrap;

import com.learner.dto.UserDto;
import com.learner.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {


    private UserService userService;

    public BootstrapData(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("BootstrapData.run");

        userService.createUser(new UserDto("firstname1", "lastname1", "firstname1.lastname1@gmail.com"));
        userService.createUser(new UserDto("firstname2", "lastname2", "firstname2.lastname2@gmail.com"));
        userService.createUser(new UserDto("firstname3", "lastname3", "firstname3.lastname3@gmail.com"));
        userService.createUser(new UserDto("firstname4", "lastname4", "firstname4.lastname4@gmail.com"));
        userService.createUser(new UserDto("firstname5", "lastname5", "firstname5.lastname5@gmail.com"));
    }
}
