package com.doan.student.service.impl;

import com.doan.student.common.Constant;
import com.doan.student.entity.UserEntity;
import com.doan.student.repository.UserRepository;
import com.doan.student.service.JwtUserDetailsService;
import com.doan.student.service.UserService;
import com.doan.student.untils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
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

    @Override
    public String deleteUser(String username) {
        try{
            userRepository.deleteByUsername(username);
            return Constant.YES;
        }
        catch (Exception  e){
            return Constant.NO;
        }

    }

    @Override
    public String updatePassword(String password, String username) {
        UserEntity userEntity = userRepository.findByUsername(username).get();
        userEntity.setPassword(passwordEncoder.encode(password));
        try{
            userRepository.save(userEntity);
            return Constant.YES;
        }
        catch (Exception e){
            return Constant.NO;
        }
    }
}
