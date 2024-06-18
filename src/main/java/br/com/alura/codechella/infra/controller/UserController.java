package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.DeleteUsers;
import br.com.alura.codechella.application.usecases.ListUsers;
import br.com.alura.codechella.application.usecases.RegisterUser;
import br.com.alura.codechella.application.usecases.UpdateUsers;
import br.com.alura.codechella.domain.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private final RegisterUser registerUser;
    private final ListUsers listUsers;
    private final UpdateUsers updateUsers;
    private final DeleteUsers deleteUsers;

    public UserController(RegisterUser registerUser, ListUsers listUsers,
                          UpdateUsers updateUsers, DeleteUsers deleteUsers) {
        this.registerUser = registerUser;
        this.listUsers = listUsers;
        this.updateUsers = updateUsers;
        this.deleteUsers = deleteUsers;
    }

    @PostMapping
    public UserDTO registerUser(@RequestBody UserDTO dto) {
       User saved = registerUser.registerUser(new User(dto.cpf(), dto.nome(), dto.nascimento(),
                dto.email()));
       return new UserDTO(saved.getCpf(), saved.getNome(), saved.getNascimento(), saved.getEmail());
    }

    @PutMapping
    public UserDTO updateUser(@RequestBody UserDTO dto) {
        User saved = updateUsers.updateUser(new User(dto.cpf(), dto.nome(), dto.nascimento(),
                dto.email()));
        return new UserDTO(saved.getCpf(), saved.getNome(), saved.getNascimento(), saved.getEmail());
    }

    @GetMapping
    public List<UserDTO> listUsers(){
        return listUsers.getAllUsers().stream()
                .map(u -> new UserDTO(u.getCpf(), u.getNome(),
                        u.getNascimento(), u.getEmail()))
                .collect(Collectors.toList());
    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestBody UserDTO dto) {
        try {
            deleteUsers.deleteUser(new User(dto.cpf(), dto.nome(), dto.nascimento(),
                    dto.email()));
            return ResponseEntity.ok().build();
        }catch (Exception ers){
            return (ResponseEntity) ResponseEntity.badRequest();
        }


    }
}
