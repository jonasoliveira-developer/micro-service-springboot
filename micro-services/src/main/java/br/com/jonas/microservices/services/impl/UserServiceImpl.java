package br.com.jonas.microservices.services.impl;

import br.com.jonas.microservices.domain.User;
import br.com.jonas.microservices.repositories.UserRepository;
import br.com.jonas.microservices.services.UserService;
import br.com.jonas.microservices.services.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final Environment env;

    @Override
    public User findById(Long id) {
        log.info("USER_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");
        return repository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Object not found "));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
