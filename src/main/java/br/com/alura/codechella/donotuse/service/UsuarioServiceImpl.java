package br.com.alura.codechella.donotuse.service;

import br.com.alura.codechella.infra.persitance.UserEntity;
import br.com.alura.codechella.infra.persitance.UserRepositoryPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UserRepositoryPersistance repository;

    @Override
    public UserEntity cadastrarUsuario(UserEntity usuario) {
        return repository.save(usuario);
    }

    @Override
    public List<UserEntity> listarTodos() {
        return repository.findAll();
    }
}
