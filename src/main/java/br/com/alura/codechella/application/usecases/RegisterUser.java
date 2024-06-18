package br.com.alura.codechella.application.usecases;


import br.com.alura.codechella.application.gateway.UserRepository;
import br.com.alura.codechella.domain.entities.User;

public class RegisterUser {

    private final UserRepository repository;

    public RegisterUser(UserRepository repository) {
        this.repository = repository;
    }

    public User registerUser(User user) {
        return repository.registerUser(user);
    }
}