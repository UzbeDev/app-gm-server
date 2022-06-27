package uz.itca.gm_aplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.itca.gm_aplication.entity.User;
import uz.itca.gm_aplication.payload.ApiResponse;
import uz.itca.gm_aplication.payload.ReqLogin;
import uz.itca.gm_aplication.payload.ReqRegister;
import uz.itca.gm_aplication.payload.ResToken;
import uz.itca.gm_aplication.repository.UserRepository;
import uz.itca.gm_aplication.security.JwtTokenProvider;
import uz.itca.gm_aplication.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public HttpEntity<?> register(@RequestBody ReqRegister reqRegister) {
        ApiResponse response = authService.register(reqRegister);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT)
                .body(response.isSuccess() ? new ApiResponse(response.getMessage(), true, generateToken(reqRegister.getPhoneNumber())) : response);
    }


    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody ReqLogin request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getPhoneNumber(), request.getPassword())
        );
        return ResponseEntity.ok(new ResToken(generateToken(request.getPhoneNumber())));
    }

    private String generateToken(String phoneNumber) {
        User user = userRepository.findByPhoneNumber(phoneNumber).orElseThrow(() -> new UsernameNotFoundException("getUser"));
        return jwtTokenProvider.generateToken(user.getId());
    }
}
