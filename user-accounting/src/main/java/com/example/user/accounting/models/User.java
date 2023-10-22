package com.example.user.accounting.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, length = 30)
    @Size(min = 2, message = "Минимальная длина 2 символов")
    @Size(max = 30, message = "Максимальная длина 30 символов")
    private String username;

    @Column(name = "password", length = 255)
    private String password;

    @Transient
    private String passwordConfirm;

    @Column(name = "email", length = 30)
    @Size(min = 2, message = "Минимальная длина 2 символа")
    private String email;

    @Column(name = "name", length = 30)
    @Size(min = 2, message = "Минимальная длина 2 символа")
    private String name;

    @Column(name = "surname", length = 30)
    @Size(min = 2, message = "Минимальная длина 2 символа")
    private String surname;

    @Column(name = "role", length = 10)
    private String role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(passwordConfirm, user.passwordConfirm) && Objects.equals(email, user.email) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, passwordConfirm, email, name, surname, role);
    }
    /*
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
    joinColumns = @JoinColumn(name = "users_id"),
    inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Role> roles;
    */
    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(passwordConfirm, user.passwordConfirm) && Objects.equals(email, user.email) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, passwordConfirm, email, name, surname, roles);
    }*/
}
