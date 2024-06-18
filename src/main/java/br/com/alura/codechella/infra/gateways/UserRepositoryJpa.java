package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateway.UserRepository;
import br.com.alura.codechella.domain.entities.User;
import br.com.alura.codechella.infra.persitance.UserEntity;
import br.com.alura.codechella.infra.persitance.UserRepositoryPersistance;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepositoryJpa implements UserRepository {

    private final UserRepositoryPersistance repository;
    private final UserEntityMapper mapper;

    public UserRepositoryJpa(UserRepositoryPersistance repository,
                             UserEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public User registerUser(User user) {
        UserEntity entity = mapper.toEntity(user);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<User> listAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public User updateUser(User user) {
        Optional<UserEntity> optionalUserEntity = repository.findByCpf(user.getCpf());
        UserEntity userEntity = null;
        if (optionalUserEntity.isPresent()) {
            userEntity = optionalUserEntity.get();
            if (!userEntity.getNome().equals(user.getNome())) {
                userEntity.setNome(user.getNome());
            }
            if (!userEntity.getEmail().equals(user.getEmail())) {
                userEntity.setEmail(user.getEmail());
            }
        }
        assert userEntity != null;
        repository.save(userEntity);
        return mapper.toDomain(userEntity);
    }

    @Override
    public void deleteUser(User user) {
        repository.delete(mapper.toEntity(user));
    }


}
