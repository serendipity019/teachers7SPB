package gr.aueb.cf.teacherapp.repository;

import gr.aueb.cf.teacherapp.core.enums.Role;
import gr.aueb.cf.teacherapp.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByRole(Role role);
    Optional<UserEntity> findByUsername(String username);
    Long countByRole(Role role);
}
