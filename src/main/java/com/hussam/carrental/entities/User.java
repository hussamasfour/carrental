package com.hussam.carrental.entities;

import com.sun.org.apache.xerces.internal.impl.XMLEntityScanner;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "First name can't be blank")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "Last Name can't be blank")
    private String lastName;
    @Column(name = "email", nullable = false, unique = true)
    @NotBlank(message = "Email can't be blank")
    @Email(message = "The email is not valid")
    private String email;
    @Column(name = "password", nullable = false)
    @NotEmpty(message = "password is required")
    private String password;
//    @Column(name="phone_number")
//
//    @Pattern(regexp = "([0-9]{10})")
//    private Long phoneNumber;
    @ManyToMany
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns= @JoinColumn(name="role_id") )
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Long getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(Long phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
