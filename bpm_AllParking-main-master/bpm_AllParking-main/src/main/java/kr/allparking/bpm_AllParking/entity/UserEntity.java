package kr.allparking.bpm_AllParking.entity;

import jakarta.persistence.*;
import kr.allparking.bpm_AllParking.dto.UserDTO;
import lombok.Data;

@Entity
@Data
@Table(name = "member_table")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String useremail;
    @Column(nullable = false)
    private String carNum;
    @Column
    private String role;



}
