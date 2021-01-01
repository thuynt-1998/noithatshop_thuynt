package com.doan.student.controller;

import com.doan.student.entity.UserEntity;
import com.doan.student.payload.dto.CustomerDTO;
import com.doan.student.payload.request.LoginRequest;
import com.doan.student.payload.request.SignUpAdminRequest;
import com.doan.student.payload.request.SignUpCustomerRequest;
import com.doan.student.payload.response.AuthenticationResponse;
import com.doan.student.payload.response.JwtAdminResponse;
import com.doan.student.payload.response.JwtCustomerResponse;
import com.doan.student.repository.UserRepository;
import com.doan.student.service.CustomerService;
import com.doan.student.service.JwtUserDetailsService;
import com.doan.student.service.UserService;
import com.doan.student.service.impl.UserDetailsImpl;
import com.doan.student.untils.JwtTokenUtil;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/login/admin" , method = RequestMethod.POST)
    public ResponseEntity<?> authenAdmin(@Valid @RequestBody LoginRequest request) throws Exception {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        final String token = jwtTokenUtil.generateToken(userDetails);
        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
        return ResponseEntity.ok(new JwtAdminResponse(token, userDetails.getUsername(), roles));
    }
    @RequestMapping(value = "/login/customer" , method = RequestMethod.POST)
    public ResponseEntity<?> authenCustomer(@Valid @RequestBody LoginRequest request) throws Exception {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        final String token = jwtTokenUtil.generateToken(userDetails);
        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
        return ResponseEntity.ok(new JwtCustomerResponse(token, customerService.getCustomerByUsername( userDetails.getUsername()), roles));
    }
    @RequestMapping(value = "/signup/admin" , method = RequestMethod.POST)
    public ResponseEntity<?> registerAdmin(@Valid @RequestBody SignUpAdminRequest equest) throws Exception {

        userDetailsService.saveAdmin(equest);
        return ResponseEntity.ok("Admin registered successfully!");
    }
    @GetMapping("/exixts/account")
    public  ResponseEntity<Object> existsByAccount(@RequestParam("account") String account){
        return new ResponseEntity<Object>(customerService.ExistsByAccount(account), HttpStatus.OK);
    }
    @RequestMapping(value = "/signup/customer" , method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpCustomerRequest request) throws Exception {

        userDetailsService.saveCustomer(request);
        return ResponseEntity.ok("User registered successfully!");
    }

    @Transactional
    @RequestMapping(value = "/delete/customer" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@RequestParam("username") String username) throws Exception {
        customerService.deleteCustomer(username);
        userService.deleteUser(username);
        return ResponseEntity.ok("User registered successfully!");
    }
    @RequestMapping(value = "/update/customer" , method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerDTO customerDTO) throws Exception {
        return new ResponseEntity<Object>(customerService.updateCustomer(customerDTO), HttpStatus.OK);
    }
    @RequestMapping(value = "/update/userpassword" , method = RequestMethod.PUT)
    public ResponseEntity<?> updatePassword(@RequestParam("password") String password) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<Object>(userService.updatePassword(password,authentication.getName() ), HttpStatus.OK);
    }

//




    public JwtAdminResponse refreshtoken(HttpServletRequest request) throws Exception {
        // From the HttpRequest get the claims
        DefaultClaims claims = (io.jsonwebtoken.impl.DefaultClaims) request.getAttribute("claims");

        Map<String, Object> expectedMap = getMapFromIoJsonwebtokenClaims(claims);
        String token = jwtTokenUtil.doGenerateRefreshToken(expectedMap, expectedMap.get("sub").toString());
        String username= jwtTokenUtil.getUsernameFromToken(token);
        List<String> roles= jwtTokenUtil.getRolesFromToken(token);
        return new JwtAdminResponse(token, username, roles);
    }

    public Map<String, Object> getMapFromIoJsonwebtokenClaims(DefaultClaims claims) {
        Map<String, Object> expectedMap = new HashMap<String, Object>();
        for (Map.Entry<String, Object> entry : claims.entrySet()) {
            expectedMap.put(entry.getKey(), entry.getValue());
        }
        return expectedMap;
    }




//
}
