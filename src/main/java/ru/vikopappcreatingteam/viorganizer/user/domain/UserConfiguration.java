package ru.vikopappcreatingteam.viorganizer.user.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.vikopappcreatingteam.viorganizer.user.UserService;

@Configuration
class UserConfiguration {

    @Bean
    UserService userService(UserRepository userRepository) {
        return new DefaultUserService(userRepository, new UserDomainTranslator());
    }

}
