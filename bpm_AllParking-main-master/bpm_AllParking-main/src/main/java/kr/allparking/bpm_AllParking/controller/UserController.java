package kr.allparking.bpm_AllParking.controller;

import kr.allparking.bpm_AllParking.dto.UserDTO;
import kr.allparking.bpm_AllParking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/join")
    public String saveForm(){
        return "join";

    }
    @PostMapping("/joinProc")
    public String save (UserDTO userDTO){
        System.out.println("userDTO = " + userDTO);
        userService.userProcess(userDTO);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }
    @PostMapping("/loginProc")
    public String login(){
        return "redirect:/";
    }


}
