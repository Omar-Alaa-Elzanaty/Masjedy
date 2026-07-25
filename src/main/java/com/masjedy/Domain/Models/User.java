package com.masjedy.Domain.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "user_name", nullable = false, unique = true, length = 100)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password; 

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mosque_id")
    private Mosque mosque;

    public Long getMosqueId() {
        return mosque != null ? mosque.getId() : null;
    }
}