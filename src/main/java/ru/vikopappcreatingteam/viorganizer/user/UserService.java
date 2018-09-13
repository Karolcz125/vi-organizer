package ru.vikopappcreatingteam.viorganizer.user;

public interface UserService {

    User createUser(CreateUpdateUserCommand createUpdateUser);

    User updateUser(String userId, CreateUpdateUserCommand createUpdateUser) throws UserNotFoundException;

    User getUser(String userId) throws UserNotFoundException;

    User getUserByUsername(String username) throws UserNotFoundException;

    void deleteUser(String userId) throws UserNotFoundException;

}