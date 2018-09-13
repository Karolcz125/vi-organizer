package ru.vikopappcreatingteam.viorganizer.user.domain;

import ru.vikopappcreatingteam.viorganizer.user.CreateUpdateUserCommand;
import ru.vikopappcreatingteam.viorganizer.user.User;

class UserDomainTranslator {

    User toNewUser(CreateUpdateUserCommand createUpdateUserCommand) {
        return User.builder()
                .username(createUpdateUserCommand.getUsername())
                .password(createUpdateUserCommand.getPassword())
                .build();
    }
}
