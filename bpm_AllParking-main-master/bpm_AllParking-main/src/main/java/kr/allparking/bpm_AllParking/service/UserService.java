package kr.allparking.bpm_AllParking.service;

import kr.allparking.bpm_AllParking.dto.UserDTO;
import kr.allparking.bpm_AllParking.entity.UserEntity;
import kr.allparking.bpm_AllParking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.IllformedLocaleException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public void userProcess(UserDTO userDTO){
        boolean isUser = userRepository.existsByUsername(userDTO.getUsername());
        if (isUser){
            return;
        }

        //db에 이미 동일한 username을 가진 회원이 존재하는지 ?
        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userEntity.setName(userDTO.getName());
        userEntity.setUseremail(userDTO.getUseremail());
        userEntity.setPhone(userDTO.getPhone());
        userEntity.setCarNum(userDTO.getCarNum());
        userEntity.setRole("ROLE_USER");

        userRepository.save(userEntity);

    }
//    public Long userSave(UserDTO userDTO) {
//
//        UserEntity userEntity = new UserEntity();
////
//        userEntity.setUsername(userDTO.getUsername());
//        userEntity.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
//        userEntity.setName(userDTO.getName());
//        userEntity.setUseremail(userDTO.getUseremail());
//        userEntity.setPhone(userDTO.getPhone());
//        userEntity.setCarNum(userDTO.getCarNum());
//        userEntity.setRole("ROLE_USER");
//
//        return userRepository.save(userEntity).getId();
//
//    }
    public UserDTO login(UserDTO userDTO) {
        Optional<UserEntity> byUserName= userRepository.findByUsername(userDTO.getUsername());
        if(byUserName.isPresent()){
            UserEntity userEntity =byUserName.get();
            if(userEntity.getPassword().equals(userDTO.getPassword())){
                UserDTO dto = UserDTO.toUserDTO(userEntity);
                return dto;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }



}
