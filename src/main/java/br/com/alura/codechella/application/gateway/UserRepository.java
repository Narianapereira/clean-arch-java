package br.com.alura.codechella.application.gateway;

import br.com.alura.codechella.domain.entities.User;

import java.util.List;

public interface UserRepository {

    User registerUser(User user);

    List<User> listAll();

    User updateUser(User user);

    void deleteUser(User user);
}
