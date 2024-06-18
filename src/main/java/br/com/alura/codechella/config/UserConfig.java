package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateway.UserRepository;
import br.com.alura.codechella.application.usecases.DeleteUsers;
import br.com.alura.codechella.application.usecases.ListUsers;
import br.com.alura.codechella.application.usecases.RegisterUser;
import br.com.alura.codechella.application.usecases.UpdateUsers;
import br.com.alura.codechella.infra.gateways.UserEntityMapper;
import br.com.alura.codechella.infra.gateways.UserRepositoryJpa;
import br.com.alura.codechella.infra.persitance.UserRepositoryPersistance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    RegisterUser registerUser(UserRepository userRepository){
        return new RegisterUser(userRepository);
    }

    @Bean
    UserRepositoryJpa createUserRepositoryJpa(UserRepositoryPersistance userRepositoryPersistance,
                                              UserEntityMapper entityMapper){
        return new UserRepositoryJpa(userRepositoryPersistance, entityMapper);
    }

    @Bean
    UserEntityMapper createMapper(){
        return new UserEntityMapper();
    }

    @Bean
    ListUsers listUsers(UserRepository userRepository){
        return new ListUsers(userRepository);
    }

    @Bean
    UpdateUsers updateUsers(UserRepository userRepository){
        return new UpdateUsers(userRepository);
    }

    @Bean
    DeleteUsers deleteUsers(UserRepository userRepository){
        return new DeleteUsers(userRepository);
    }
}
