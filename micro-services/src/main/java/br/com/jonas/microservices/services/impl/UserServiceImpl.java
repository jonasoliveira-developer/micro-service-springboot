package br.com.jonas.microservices.services.impl;

import br.com.jonas.microservices.domain.User;
import br.com.jonas.microservices.repositories.UserRepository;
import br.com.jonas.microservices.services.UserService;
import br.com.jonas.microservices.services.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Object not found "));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
