//package com.example.myblogs.service;
//
//import com.example.myblogs.domain.User;
//import com.example.myblogs.dto.SignupRequestDto;
//import com.example.myblogs.repository.UserRepository;
//import com.example.myblogs.validator.SignupValidator;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//@ExtendWith(MockitoExtension.class)
//class UserServiceRegisterTest {
//    @Mock
//    UserRepository userRepository;
//    PasswordEncoder passwordEncoder;
//    SignupValidator signupValidator;
//
//    //@Test
//    //given
//
//        String username = "12qw";
//        String password = "1234";
//        String checkPassword = "1234";
//        //Optional<User> found = Optional.empty();
//
//        SignupRequestDto requestDto = new SignupRequestDto(
//                username, password ,checkPassword
//        );
//
//
//        UserService userService = new UserService(userRepository, passwordEncoder, signupValidator);
//        when(userRepository.findByUsername(username))
//            .thenReturn(Optional.empty());
//
//
//
//}
//






















//
//public class UserService {
//    private final c
//
//    @Autowired
//    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, SignupValidator signupValidator) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.signupValidator = signupValidator;
//    }
//
//    public void registerUser(SignupRequestDto requestDto) {
//// 회원 ID 중복 확인
//        String username = requestDto.getUsername();
//        String password = requestDto.getPassword();
//        String checkPassword = requestDto.getPasswordCheck();
//        Optional<User> found = userRepository.findByUsername(username);
//        System.out.println(found);
//        signupValidator.signupValidate(username, password, checkPassword, found);
//
//// 패스워드 암호화
//        if (username!=null && password !=null){
//            //System.out.println("암호화");
//            password = passwordEncoder.encode(requestDto.getPassword());}
//
//        User user = new User(username, password);
//        userRepository.save(user);
//    }
