package dev.alexandre.apirest.service.impl;

import dev.alexandre.apirest.domain.model.User;
import dev.alexandre.apirest.domain.repository.UserRepository;
import dev.alexandre.apirest.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists!");
        }
        return userRepository.save(userToCreate);
    }
}
