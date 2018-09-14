package ru.vikopappcreatingteam.viorganizer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.vikopappcreatingteam.viorganizer.user.CreateUpdateUserCommand;
import ru.vikopappcreatingteam.viorganizer.user.UserService;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
class ExampleDataInitializer {
    private final UserService userService;

    @PostConstruct
    public void saveExampleData() {
        userService.createUser(CreateUpdateUserCommand.builder()
                .username("root")
                .password("root")
                .build());
    }

}
