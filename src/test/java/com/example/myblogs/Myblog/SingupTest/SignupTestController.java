//싳패

//package com.example.myblogs.Myblog.SingupTest;
//
//import com.example.myblogs.controller.UserController;
//import com.example.myblogs.dto.SignupRequestDto;
//import com.example.myblogs.service.KakaoUserService;
//import com.example.myblogs.service.UserService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//
//@ExtendWith(MockitoExtension.class)
//public class SignupTestController {
//    @Mock
//    UserService userService;
//    KakaoUserService kakaoUserService;
//
//    UserController userController = new UserController(userService, kakaoUserService);
//
//    @Test
//    @DisplayName("닉네임 비었음")
//    void username_blank(){
//        String username = "";
//        String password = "1234";
//        String checkPassword = "1234";
//       // BindingResult bindingResult;
//
//        SignupRequestDto requestDto = new SignupRequestDto(username, password,checkPassword);
//
//        //userController.registerUser(requestDto, bindingResult);
//
//       // bindingResult.getFieldError().getDefaultMessage();
//
//
//    }
//
//
//
//
//
//}
