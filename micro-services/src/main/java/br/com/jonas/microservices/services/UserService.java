package br.com.jonas.microservices.services;

import br.com.jonas.microservices.domain.User;

import java.util.List;


public interface UserService {
    User findById(Long id);
    List<User> findAll();
}
