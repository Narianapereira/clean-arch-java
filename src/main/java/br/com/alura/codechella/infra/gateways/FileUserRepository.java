package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateway.UserRepository;
import br.com.alura.codechella.domain.entities.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUserRepository implements UserRepository {

    List<User> users = new ArrayList<>();

    @Override
    public User registerUser(User user) {
        this.users.add(user);
        return user;
    }

    @Override
    public List<User> listAll() {
        return this.users;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }

    public void saveFile(String fileName) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(this.users.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
