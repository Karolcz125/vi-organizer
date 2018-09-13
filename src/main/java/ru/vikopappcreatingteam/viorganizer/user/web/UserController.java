package ru.vikopappcreatingteam.viorganizer.user.web;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.vikopappcreatingteam.viorganizer.user.CreateUpdateUserCommand;
import ru.vikopappcreatingteam.viorganizer.user.UserNotFoundException;
import ru.vikopappcreatingteam.viorganizer.user.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
class UserController {

    private final UserService userService;
    private final UserWebTranslator webTranslator;

    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable("userId") String userId) throws UserNotFoundException {
        return webTranslator.toDto(userService.getUser(userId));
    }

    @GetMapping
    public UserDto getUserByUserName(@RequestParam("username") String username) throws UserNotFoundException {
        return webTranslator.toDto(userService.getUserByUsername(username));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addUser(@Validated @RequestBody CreateUpdateUserDto createUpdateUserDto) {
        CreateUpdateUserCommand createUpdateUser = webTranslator.toCreateUpdateCommand(createUpdateUserDto);
        return webTranslator.toDto(userService.createUser(createUpdateUser));
    }

    @PutMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto updateUser(@PathVariable("userId") String userId, @Validated @RequestBody CreateUpdateUserDto createUpdateUserDto) throws UserNotFoundException {
        CreateUpdateUserCommand createUpdateUser = webTranslator.toCreateUpdateCommand(createUpdateUserDto);
        return webTranslator.toDto(userService.updateUser(userId, createUpdateUser));
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("userId") String userId) throws UserNotFoundException {
        userService.deleteUser(userId);
    }

}
