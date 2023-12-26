package kr.allparking.bpm_AllParking.repository;

import kr.allparking.bpm_AllParking.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    boolean existsByUsername(String username);

    UserEntity findByUsername(String username);


}
