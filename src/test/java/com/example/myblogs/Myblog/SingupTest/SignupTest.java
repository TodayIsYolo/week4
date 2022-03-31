package com.example.myblogs.Myblog.SingupTest;

import com.example.myblogs.domain.User;
import com.example.myblogs.dto.SignupRequestDto;
import com.example.myblogs.validator.SignupValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class SignupTest {
    @Nested
    @DisplayName("회원가입 정보 생성")
    class CreateSignup{
        private String username;
        private String password;
        private String checkPassword;
        private User user = new User();
        private Optional<User> found;



        @BeforeEach
        void setup() {
            username = "ab12";
            password = "1234";
            checkPassword = "1234";
            found = Optional.empty();
        }


        @Test
        @DisplayName("정상케이스")
        void nomal(){

            SignupValidator signupValidator = new SignupValidator();
            signupValidator.signupValidate(username, password, checkPassword, found);

            assertEquals(Optional.empty(), found);
            assertEquals(password,checkPassword);

        }

        @Nested
        @DisplayName("실패케이스")
        class FailCases{
            @Nested
            @DisplayName("비밀번호")
            class PW{
                @Test
                @DisplayName("불일치")
                void fail1() {

                    checkPassword = "1111";
                    SignupValidator signupValidator = new SignupValidator();


                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        signupValidator.signupValidate(username, password, checkPassword, found);
                    });
                    assertEquals("비밀번호가 일치하지 않습니다.", exception.getMessage());

                }

                @Test
                @DisplayName("아이디 포함")
                void fail2(){
                    password = "ab1234";
                    checkPassword = "ab1234";

                    SignupValidator signupValidator = new SignupValidator();


                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        signupValidator.signupValidate(username, password, checkPassword, found);
                    });
                    assertEquals("비밀번호에 아이디를 포함할 수 없습니다.", exception.getMessage());

                }

                @Test
                @DisplayName("비밀번호 4자리 이상")
                void fail3(){

                    password = "212";
                    checkPassword = "212";

                    SignupValidator signupValidator = new SignupValidator();

                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        signupValidator.signupValidate(username, password, checkPassword, found);
                    });
                    assertEquals("비밀번호는 4자리 이상입니다.", exception.getMessage());

                }

                @Test
                @DisplayName("비밀번호 특수문자 포함")
                void fail4(){

                    password = "가나#$%";
                    checkPassword = "가나#$%";

                    SignupValidator signupValidator = new SignupValidator();

                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        signupValidator.signupValidate(username, password, checkPassword, found);
                    });
                    assertEquals("비밀번호는 영어와 숫자만 포함합니다.", exception.getMessage());

                }
            }
            @Nested
            @DisplayName("아이디 존재")
            class ID{
                @Test
                @DisplayName("이미 있는 닉네임")
                void fail1(){

                    found = Optional.of(user);

                    SignupValidator signupValidator = new SignupValidator();

                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        signupValidator.signupValidate(username, password, checkPassword, found);
                    });
                    assertEquals("중복된 사용자 ID 가 존재합니다.", exception.getMessage());

                }

                @Test
                @DisplayName("아이디 3자리 이상")
                void fail2(){

                    username = "12";

                    SignupValidator signupValidator = new SignupValidator();

                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        signupValidator.signupValidate(username, password, checkPassword, found);
                    });
                    assertEquals("아이디는 3자리 이상입니다.", exception.getMessage());

                }


            }

        }


    }








}
