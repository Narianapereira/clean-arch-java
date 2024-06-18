package br.com.alura.codechella.domain;

import br.com.alura.codechella.domain.entities.User;
import br.com.alura.codechella.domain.entities.UserBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UserTest {
    @Test
    public void DoNotRegisterUserWithInvalidCpf() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("08731393993", "Nari", LocalDate.parse("1994-02-03"),
                        "email@email.com"));
    }

    @Test
    public void DoNotRegisterMinorUser() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("087.313.939-93", "Nari", LocalDate.parse("2020-02-03"),
                        "email@email.com"));
    }

    @Test
    public void shouldCreateUserUsingFactory(){
        UserBuilder userFactory = new UserBuilder();
        User user = userFactory.withNameCpfBirthDate("Nariana",
                "087.313.939-93", LocalDate.parse("1994-02-03"));

        Assertions.assertEquals("Nariana", user.getNome());

        user = userFactory.includeAddress("89239800", 12, "casa");
        Assertions.assertEquals("casa", user.getAddress().getExtra());
    }
}
