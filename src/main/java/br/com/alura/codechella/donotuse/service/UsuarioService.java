package br.com.alura.codechella.donotuse.service;

import br.com.alura.codechella.infra.persitance.UserEntity;

import java.util.List;

public interface UsuarioService {
    UserEntity cadastrarUsuario(UserEntity usuario);

    List<UserEntity> listarTodos();
}
