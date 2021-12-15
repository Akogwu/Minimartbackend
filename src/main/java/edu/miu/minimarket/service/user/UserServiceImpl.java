package edu.miu.minimarket.service.user;

import edu.miu.minimarket.model.user.Role;
import edu.miu.minimarket.model.user.User;
import edu.miu.minimarket.repository.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{
    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;
    @Autowired
    private UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;

//    @Autowired
//    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }


    

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if (user == null){
//            throw new UsernameNotFoundException("User not found in database");
//        }
//        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        //Only adding single role, if user has multiple role, we need to loop
//        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
//        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), authorities) ;
//    }
    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findUserByUsername(username);
        Role role = Role.valueOf(roleName);
        log.info("Adding role {} to user {}",roleName, username);
        user.setRole(role);
    }


}
