package ru.vikopappcreatingteam.viorganizer.user.web;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
class CreateUpdateUserDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
