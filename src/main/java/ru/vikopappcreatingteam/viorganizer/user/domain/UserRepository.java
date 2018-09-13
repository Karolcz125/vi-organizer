package ru.vikopappcreatingteam.viorganizer.user.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.vikopappcreatingteam.viorganizer.user.User;

import java.util.Optional;

@Repository
interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);

}