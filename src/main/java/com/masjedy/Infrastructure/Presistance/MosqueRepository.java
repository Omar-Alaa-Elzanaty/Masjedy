package com.masjedy.Infrastructure.Presistance;

import org.springframework.data.jpa.repository.JpaRepository;
import com.masjedy.Domain.Models.Mosque;

public interface MosqueRepository extends JpaRepository<Mosque, Long> {
    boolean existsByName(String name);
}
