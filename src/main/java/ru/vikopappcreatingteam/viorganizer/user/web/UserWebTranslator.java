package ru.vikopappcreatingteam.viorganizer.user.web;

import ru.vikopappcreatingteam.viorganizer.user.CreateUpdateUserCommand;
import ru.vikopappcreatingteam.viorganizer.user.User;

class UserWebTranslator {

    CreateUpdateUserCommand toCreateUpdateCommand(CreateUpdateUserDto createUpdateUserDto) {
        return CreateUpdateUserCommand.builder()
                .username(createUpdateUserDto.getUsername())
                .password(createUpdateUserDto.getPassword())
                .build();
    }

    UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }

}
