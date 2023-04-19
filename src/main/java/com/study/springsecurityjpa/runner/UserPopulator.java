package com.study.springsecurityjpa.runner;

import com.study.springsecurityjpa.persistence.AppUser;
import com.study.springsecurityjpa.persistence.AppUserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class UserPopulator {

    @Bean
    ApplicationRunner populateUsers(AppUserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            AppUser user = new AppUser();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("123"));
            user.setAuthorities(Set.of("USER"));

            userRepository.save(user);

            AppUser admin = new AppUser();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("123"));
            admin.setAuthorities(Set.of("USER", "ADMIN"));

            userRepository.save(admin);
        };
    }
}
