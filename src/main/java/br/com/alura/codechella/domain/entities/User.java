package br.com.alura.codechella.domain.entities;

import br.com.alura.codechella.domain.Address;

import java.time.LocalDate;

public class User {

    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;
    private Address address;

    public User(String cpf, String nome, LocalDate nascimento, String email) {
        if(cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")){
            throw new IllegalArgumentException("CPF invalido");
        }
        int birthYear = nascimento.getYear();
        LocalDate now = LocalDate.now();
        int actualYear = now.getYear();
        int diff = actualYear - birthYear;
        if(diff < 18){
            throw new IllegalArgumentException("Idade deve ser maior de 18 anos");
        }

        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }

    public static void main(String[] args) {
        User user = new User("087.313.939-93",
                "Nari", LocalDate.parse("1994-03-02"), "nariana@teste");
    }
}
