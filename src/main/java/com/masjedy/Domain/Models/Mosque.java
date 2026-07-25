package com.masjedy.Domain.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mosques")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mosque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Capital 'I' fixed to lower 'i'

    @Column(nullable = false, length = 150)
    private String name; // Changed from Integer to String

    private String location;

    @Column(name = "image_url")
    private String image;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "mosque", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<User> users = new ArrayList<>();
}