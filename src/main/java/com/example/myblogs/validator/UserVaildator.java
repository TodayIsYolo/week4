//package com.example.myblogs.validator;
//
//
//import com.example.myblogs.domain.User;
//import com.example.myblogs.dto.SignupRequestDto;
//import org.springframework.stereotype.Component;
//
//import java.util.Objects;
//import java.util.Optional;
//
//
//@Component
//public class UserVaildator {
//    public static void validateUserInput(SignupRequestDto requestDto, Optional<User> found){
//        String username = requestDto.getUsername();
//        String password = requestDto.getPassword();
//        String checkPassword = requestDto.getPasswordCheck();
//
//        if (found.isPresent()) {
//            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
//        }
//
//        if (password.contains(username)){
//            throw new IllegalArgumentException("비밀번호에 아이디를 포함할 수 없습니다.");
//        }
//
//        if (!Objects.equals(checkPassword, password)){
//            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
//        }
//    }
//}
