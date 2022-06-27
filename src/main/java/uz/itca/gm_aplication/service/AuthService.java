package uz.itca.gm_aplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.itca.gm_aplication.entity.User;
import uz.itca.gm_aplication.entity.enums.RoleName;
import uz.itca.gm_aplication.payload.ApiResponse;
import uz.itca.gm_aplication.payload.ReqRegister;
import uz.itca.gm_aplication.repository.RoleRepository;
import uz.itca.gm_aplication.repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public ApiResponse register(ReqRegister request) {
        try {
            if (ageIsValid(request.getBirthDate())) {
                if (request.getPassword().equals(request.getPrePassword())) {
                    if (userRepository.existsByPhoneNumber(request.getPhoneNumber())) {
                        return new ApiResponse("Bunday pasport egasi mavjud", false);
                    }
                    User user = new User(
                            request.getFirstName(),
                            request.getLastName(),
                            request.getMiddleName(),
                            request.getBirthDate(),
                            request.getPhoneNumber(),
                            passwordEncoder.encode(request.getPassword()),
                            Collections.singleton(roleRepository.findByRoleName(RoleName.ROLE_USER))
                    );
                    userRepository.save(user);
                    return new ApiResponse("User saqlandi", true);
                } else {
                    return new ApiResponse("Parollar mos emas", false);
                }
            }
            return new ApiResponse("Yoshingiz yetmaydi", false);
        } catch (Exception e) {
            return new ApiResponse("Xatolik", false);
        }
    }


    public boolean ageIsValid(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        Integer client = Integer.valueOf(simpleDateFormat.format(date));
        Integer now = Integer.valueOf(simpleDateFormat.format(new Date()));
        return now - client > 0;
    }

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        return userRepository.findByPhoneNumber(phoneNumber).orElseThrow(() -> new UsernameNotFoundException("getUser"));

    }

    public UserDetails getUserById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getUser"));
    }


}
