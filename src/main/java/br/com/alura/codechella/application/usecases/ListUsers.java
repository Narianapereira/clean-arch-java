package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateway.UserRepository;
import br.com.alura.codechella.domain.entities.User;
import br.com.alura.codechella.infra.persitance.UserRepositoryPersistance;

import java.util.List;

public class ListUsers {

    private final UserRepository userRepository;

    public ListUsers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return this.userRepository.listAll();
    }
}
