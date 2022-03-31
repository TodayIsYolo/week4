package com.example.myblogs.service;


import com.example.myblogs.domain.User;
import com.example.myblogs.dto.SignupRequestDto;
import com.example.myblogs.repository.UserRepository;
import com.example.myblogs.validator.SignupValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final SignupValidator signupValidator;


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, SignupValidator signupValidator) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.signupValidator = signupValidator;
    }

//    public void registerUser(SignupRequestDto requestDto) {
//
//        String username = requestDto.getUsername();
//        Optional<User> found = userRepository.findByUsername(username);
//        //테스트용
//        UserVaildator.validateUserInput(requestDto, found);
//
//        //비밀번호 암호화
//        String password = requestDto.getPassword();
//        if (username!=null && password !=null)
//            password = passwordEncoder.encode(requestDto.getPassword());
//        User user = new User(username, password);
//        userRepository.save(user);
//    }
public void registerUser(SignupRequestDto requestDto) {
// 회원 ID 중복 확인
    String username = requestDto.getUsername();
    String password = requestDto.getPassword();
    String checkPassword = requestDto.getPasswordCheck();
    Optional<User> found = userRepository.findByUsername(username);
    System.out.println(found);
    signupValidator.signupValidate(username, password, checkPassword, found);

// 패스워드 암호화
    if (username!=null && password !=null){
        //System.out.println("암호화");
        password = passwordEncoder.encode(requestDto.getPassword());}

    User user = new User(username, password);
    userRepository.save(user);

}

//서버 테스트용
//    private void signupValidate(String username, String password, String checkPassword, Optional<User> found) {
//        if (found.isPresent()) {
//            System.out.println("중복된 사용자 ID 가 존재합니다.");
//            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
//        }
//
//        else if (password.contains(username)){
//            System.out.println("비밀번호에 아이디를 포함할 수 없습니다.");
//            throw new IllegalArgumentException("비밀번호에 아이디를 포함할 수 없습니다.");
//        }
//
//        else if (!Objects.equals(checkPassword, password)){
//            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
//        }
//    }


    //회원가입용 중복체크
    public int nameCheck(SignupRequestDto requestDto){
        Optional<User> found = userRepository.findByUsername(requestDto.getUsername());
        if (found.isPresent()){
            return 1;
        } else {
            return 0;
        }
    }

    //비밀번호에 아이디가 포함되어있는지 체크
    public int namePasswordCheck(SignupRequestDto requestDto){
        String password = requestDto.getPassword();
        String name = requestDto.getUsername();
        if (password.contains(name)){
            return 0;
        } else {
            return 1;
        }
    }

    //회원가입용 비밀번호 일치 체크
    public int checkPassword(SignupRequestDto requestDto){
        String password = requestDto.getPassword();
        String checkPassword = requestDto.getPasswordCheck();
        if (Objects.equals(checkPassword, password)){
            return 2;
        }else {
            return 3;
        }
    }

}

