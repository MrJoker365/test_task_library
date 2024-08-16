package com.example.library.repo;

import com.example.library.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembersRepo extends JpaRepository<Members, Long> {

    Optional<Members> findByName(String name);
}

