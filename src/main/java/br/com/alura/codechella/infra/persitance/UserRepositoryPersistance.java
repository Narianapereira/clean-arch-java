package br.com.alura.codechella.infra.persitance;

import br.com.alura.codechella.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryPersistance extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByCpf(String cpf);

}
