package kr.allparking.bpm_AllParking.controller;

import jakarta.servlet.http.HttpSession;
import kr.allparking.bpm_AllParking.dto.UserDTO;
import kr.allparking.bpm_AllParking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/join")
    public String saveForm(){
        return "join";

    }
    @PostMapping("/joinProc")
    public String save (UserDTO userDTO){
        System.out.println("userDTO = " + userDTO);
        userService.userProcess(userDTO);
        return "/login";
    }
//    @PostMapping("/joinProc")
//    public @ResponseBody String save(@ModelAttribute UserDTO userDTO){
//        System.out.println("userDTO = " + userDTO);
//        Long userId=userService.userSave(userDTO);
//        if(userId==null){
//            return "save_fail";
//        }else {
//            return "save_success";
//        }
//
//    }
    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }
//    @PostMapping("/loginProc")
//    public String login(@ModelAttribute UserDTO userDTO, HttpSession session) {
//        UserDTO loginResult =userService.login(userDTO);
//        if(loginResult!=null){
//            session.setAttribute("loginId",loginResult.getUsername());
//            return "redirect:/";
//        }else {
//            return "login";
//        }
//
//    }
    @PostMapping("/loginProc")
    public String login(@ModelAttribute UserDTO userDTO, HttpSession session) {
        return "redirect:/";

    }
    @GetMapping("/update")
    public String updateForm(){
        return "editmy";
    }



}
