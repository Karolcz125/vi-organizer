package ru.vikopappcreatingteam.viorganizer.common.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import ru.vikopappcreatingteam.viorganizer.user.UserNotFoundException;

@ControllerAdvice(annotations = RestController.class)
class DomainExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class, UsernameNotFoundException.class})
    public ResponseEntity<ErrorDto> handle(UserNotFoundException ex) {
        return new ResponseEntity<>(ErrorDto.builder()
                .message("User could not be found")
                .build(), HttpStatus.NOT_FOUND);
    }

}
