package kr.allparking.bpm_AllParking.dto;

import kr.allparking.bpm_AllParking.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class UserDTO {



    private Long id;
    private String username;
    private String password;
    private String name;
    private String useremail;
    private String phone;
    private String carNum;

    public static UserDTO toUserDTO(UserEntity userEntity){
        UserDTO userDTO= new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setUseremail(userEntity.getUseremail());
        userDTO.setPhone(userEntity.getPhone());
        userDTO.setCarNum(userEntity.getCarNum());

        return userDTO;
    }

}
