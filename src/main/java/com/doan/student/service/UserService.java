package com.doan.student.service;

import com.doan.student.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
public interface UserService {
    Boolean checkExistsByUserName(String username);
    Boolean checkValidTokenWithUsername(String username,String token);
    String deleteUser(String username);
    String updatePassword(String password, String username);
}
