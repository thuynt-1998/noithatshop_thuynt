package com.doan.student.service.impl;

import com.doan.student.repository.UserRepository;
import com.doan.student.service.JwtUserDetailsService;
import com.doan.student.service.UserService;
import com.doan.student.untils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;
    @Override
    public Boolean checkExistsByUserName(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean checkValidTokenWithUsername(String username, String token) {
        UserDetailsImpl userDetails= (UserDetailsImpl) jwtUserDetailsService.loadUserByUsername(username);
        if (token != null && jwtTokenUtil.validateToken(token,userDetails)) {
            return true;
        }
        return false;
    }
}
