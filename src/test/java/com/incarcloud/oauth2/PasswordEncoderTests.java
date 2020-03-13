package com.incarcloud.oauth2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * PasswordEncoderTests
 *
 * @author Aaric, created on 2020-03-13T15:25.
 * @version 0.2.1-SNAPSHOT
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PasswordEncoderTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testEncode() {
        // secret: $2a$10$/FdlWQWV0JNGNF4WU4tJIeMT8QQMrg9jq8jPu7QGkTMypZ6Eb6wVa
        // 123456: $2a$10$OZjuEUV1.se6xxp50Fj47Ov56Aex5wSK9hVGcNxaX00VThBaQvJ6u
        System.out.println("secret: " + passwordEncoder.encode("secret"));
        System.out.println("123456: " + passwordEncoder.encode("123456"));
    }
}
