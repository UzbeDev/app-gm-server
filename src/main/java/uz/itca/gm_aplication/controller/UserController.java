package uz.itca.gm_aplication.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.itca.gm_aplication.entity.User;
import uz.itca.gm_aplication.security.CurrentUser;
@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/userMe")
    public HttpEntity<?> userMe(@CurrentUser User user) {
        return ResponseEntity.ok(user);
    }
}