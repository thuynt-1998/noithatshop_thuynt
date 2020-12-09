package com.doan.student.config;

import com.doan.student.entity.UserEntity;
import com.doan.student.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig {
    @Bean
    public AuditorAware<UserEntity> auditorProvider() {
        return new AuditorAwareImpl();
    }

    public static class AuditorAwareImpl implements AuditorAware<UserEntity> {
        @Autowired
        private UserRepository userRepository;
        @Override
        public Optional<UserEntity> getCurrentAuditor() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null || !authentication.isAuthenticated())
                return Optional.empty();

            return userRepository.findByUsername(authentication.getName());
        }
    }
}
