package com.doan.student.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
public interface UserService {
    Boolean checkExistsByUserName(String username);
    Boolean checkValidTokenWithUsername(String username,String token);

}
