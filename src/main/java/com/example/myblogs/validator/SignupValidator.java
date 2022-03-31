package com.example.myblogs.validator;

import com.example.myblogs.domain.User;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class SignupValidator {
    public void signupValidate(String username, String password, String checkPassword, Optional<User> found) {
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }

        else if (username.length()<3){
            throw new IllegalArgumentException("아이디는 3자리 이상입니다.");
        }

        else if (password.length()<4){
            throw new IllegalArgumentException("비밀번호는 4자리 이상입니다.");
        }

        else if(!PW(password)){
            throw new IllegalArgumentException("비밀번호는 영어와 숫자만 포함합니다.");
        }


        else if (password.contains(username)){
            throw new IllegalArgumentException("비밀번호에 아이디를 포함할 수 없습니다.");
        }

        else if (!Objects.equals(checkPassword, password)){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }

    public boolean PW(String password){
        String passwordPolicy = "((?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9]).{8,})";

        Pattern pattern_pwd = Pattern.compile(passwordPolicy);
        Matcher matcher_pwd = pattern_pwd.matcher(password);

        return matcher_pwd.matches();
    }
}
