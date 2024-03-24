package com.example.WebAPI.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    @NotBlank(message = "Username is required")
    @Size(max = 50, message = "Username must be less than 50 characters")
    private String username;

    @Column(name = "password", length = 250, nullable = false)
    @NotBlank(message = "Password is required")
    private String password;

    @Column(name = "email", length = 50)
    @Size(max = 50, message = "Email must be less than 50 characters")
    @NotBlank(message = "Email is required")
    private String email;

    @Column(name = "name", length = 50, nullable = false)
    @Size(max = 50, message = "Your name must be less than 50 characters")
    @NotBlank(message = "Your name is required")
    private String fullName;

    @Column(name = "phoneNumber", nullable = false)
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @Column(name = "address", length = 250, nullable = false)
    @NotBlank(message = "Address is required")
    private String address;

    @Column(name = "setResetCode", length = 250, nullable = true)
    private String setResetCode;

    @Column(name = "resetCodeExpiryTime", nullable = true)
    private LocalDateTime resetCodeExpiryTime;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<TotalQuestionsScore> totalScoresQuizzes;

    public void setResetCode(String resetCode) {
        this.setResetCode = resetCode;
    }

    public Object getResetCode() {
        return setResetCode;
    }
}