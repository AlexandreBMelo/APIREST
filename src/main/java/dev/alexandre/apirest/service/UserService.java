package dev.alexandre.apirest.service;

import dev.alexandre.apirest.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
