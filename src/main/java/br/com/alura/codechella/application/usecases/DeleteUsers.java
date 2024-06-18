package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateway.UserRepository;
import br.com.alura.codechella.domain.entities.User;

public class DeleteUsers {

    private final UserRepository repository;

    public DeleteUsers(UserRepository repository) {
        this.repository = repository;
    }

    public void deleteUser(User user) {
        repository.deleteUser(user);
    }
}
