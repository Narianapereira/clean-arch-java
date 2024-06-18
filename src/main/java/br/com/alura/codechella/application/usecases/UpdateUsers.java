package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateway.UserRepository;
import br.com.alura.codechella.domain.entities.User;

public class UpdateUsers {

    private final UserRepository repository;

    public UpdateUsers(UserRepository repository) {
        this.repository = repository;
    }

    public User updateUser(User user) {
        return repository.updateUser(user);
    }
}
