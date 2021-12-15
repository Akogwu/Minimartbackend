package edu.miu.minimarket.controller;

import edu.miu.minimarket.model.user.User;
import edu.miu.minimarket.config.JwtUserDetailsService;
import edu.miu.minimarket.util.JwtTokenUtil;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import edu.miu.minimarket.dto.JwtRequest;
import edu.miu.minimarket.service.user.UserServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping(path = "/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        Map<String, Object> response = new HashMap<>();

        final String token = jwtTokenUtil.generateToken(userDetails);
//        final User user = userServiceImpl.findByUserName(authenticationRequest.getUsername());
//        
//        System.out.println(user);
//        response.put("id", user.getId());
//        response.put("name", user.getName());
//        response.put("email", user.getEmail());
//        response.put("token", token);

        return ResponseEntity.ok(response);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            System.out.println("UsernamePasswordAuthenticationToken");

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            System.out.println("User disabled");
            throw new Exception("User disabled", e);
        } catch (BadCredentialsException e) {
            System.out.println("INVALID_CREDENTIALS");

            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
