package ru.vikopappcreatingteam.viorganizer.user.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class UserDto {

    private String id;

    private String username;


}
