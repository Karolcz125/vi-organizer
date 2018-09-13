package ru.vikopappcreatingteam.viorganizer.user.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import ru.vikopappcreatingteam.viorganizer.user.CreateUpdateUserCommand;
import ru.vikopappcreatingteam.viorganizer.user.User;
import ru.vikopappcreatingteam.viorganizer.user.UserNotFoundException;
import ru.vikopappcreatingteam.viorganizer.user.UserService;

@RequiredArgsConstructor
class DefaultUserService implements UserService {
    private final UserRepository userRepository;
    private final UserDomainTranslator domainTranslator;

    @Override
    @Transactional
    public User createUser(CreateUpdateUserCommand createUpdateUserCommand) {
        User newUser = domainTranslator.toNewUser(createUpdateUserCommand);
        return userRepository.save(newUser);
    }

    @Override
    @Transactional
    public User updateUser(String userId, CreateUpdateUserCommand updateUserCommand) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        user.setUsername(updateUserCommand.getUsername());
        user.setPassword(updateUserCommand.getPassword());
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(String userId) throws UserNotFoundException {
        return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByUsername(String username) throws UserNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
    }

    @Override
    @Transactional
    public void deleteUser(String userId) throws UserNotFoundException {
        userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        userRepository.deleteById(userId);
    }
}