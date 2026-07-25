package com.masjedy.Domain.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "activity_subscriptions",
    uniqueConstraints = @UniqueConstraint(
        name = "UQ_user_activity",
        columnNames = {"user_id", "activity_id"}
    )
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivitySubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "activity_id", nullable = false)
    private Activity activity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime creationAt;

    @PrePersist
    public void prePersist() {
        if (creationAt == null) {
            creationAt = LocalDateTime.now();
        }
    }

    public Long getUserId() {
        return user != null ? user.getId() : null;
    }

    public Long getActivityId() {
        return activity != null ? activity.getId() : null;
    }
}