package com.doan.student.service;

import com.doan.student.entity.CustomerEntity;
import com.doan.student.entity.RoleEntity;
import com.doan.student.entity.UserEntity;
import com.doan.student.payload.request.SignUpAdminRequest;
import com.doan.student.payload.request.SignUpCustomerRequest;
import com.doan.student.repository.CustomerRepository;
import com.doan.student.repository.RoleRepository;
import com.doan.student.repository.UserRepository;
import com.doan.student.service.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity= userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found with username: " + username));
        return  UserDetailsImpl.build(userEntity);
    }

    public CustomerEntity saveCustomer(SignUpCustomerRequest request){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getPhone());
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        Set<RoleEntity> roles=new HashSet<>();
        RoleEntity role=roleRepository.findByName("ROLE_CLIENT").orElseThrow(()->new RuntimeException("Error: Role is not found."));
        roles.add(role);
        userEntity.setRoles(roles);
        CustomerEntity customerEntity= new CustomerEntity();
        customerEntity.setCode(request.getCode());
        customerEntity.setAccount(request.getAccount());
        customerEntity.setUserEntity(userRepository.save(userEntity));
        return customerRepository.save(customerEntity);
    }
    public UserEntity saveAdmin(SignUpAdminRequest request){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        Set<RoleEntity> roles=new HashSet<>();
        for (String role: Arrays.asList("ROLE_ADMIN","ROLE_USER")) {
            roles.add(roleRepository.findByName(role).orElseThrow(()->new RuntimeException("Error: Role is not found.")));
        }
        userEntity.setRoles(roles);
        return userRepository.save(userEntity);
    }
}
