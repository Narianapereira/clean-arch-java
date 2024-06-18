package br.com.alura.codechella.domain.entities;

import br.com.alura.codechella.domain.Address;

import java.time.LocalDate;

public class UserBuilder {

    private User user;

    public User withNameCpfBirthDate(String name, String cpf, LocalDate birthDate){
        this.user = new User(cpf, name, birthDate, "");
        return this.user;
    }

    public User includeAddress(String postalCode, Integer number, String extra){
        this.user.setAddress(new Address(postalCode, number, extra));
        return this.user;
    }
}
