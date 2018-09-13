package ru.vikopappcreatingteam.viorganizer.user.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.vikopappcreatingteam.viorganizer.user.UserService;

@Configuration
class UserWebConfiguration {

    @Bean
    UserController userController(UserService userService) {
        return new UserController(userService, new UserWebTranslator());
    }

}
