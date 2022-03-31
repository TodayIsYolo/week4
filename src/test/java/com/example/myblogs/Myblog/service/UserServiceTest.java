//package com.example.myblogs.service;
//
//import com.example.myblogs.dto.SignupRequestDto;
//import com.example.myblogs.repository.UserRepository;
//import com.example.myblogs.validator.SignupValidator;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.when;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//
//@ExtendWith(MockitoExtension.class)
//class UserServiceTest {
//    @Mock
//    UserRepository userRepository;
//    PasswordEncoder passwordEncoder;
//    SignupValidator signupValidator;
//
//
//
//    //given
//    String username = "ab12";
//    String password = "1234";
//    String checkPassword = "1234";
//
//    SignupRequestDto requestDto = new SignupRequestDto(
//      username,password,checkPassword
//    );
//
//    UserService userService = new UserService(userRepository, passwordEncoder, signupValidator);
//
//    //when
//    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//        userService.registerUser(requestDto);
//    });
//    //then
//
//
//}