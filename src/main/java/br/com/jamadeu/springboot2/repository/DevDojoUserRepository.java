package br.com.jamadeu.springboot2.repository;

import br.com.jamadeu.springboot2.domain.DevDojoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevDojoUserRepository extends JpaRepository<DevDojoUser, Long> {
    DevDojoUser findByUsername(String username);
}
