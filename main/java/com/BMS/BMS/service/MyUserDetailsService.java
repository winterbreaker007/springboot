package com.blackwater.blackwaterbillingmanagementsystem.service;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.ValueListSetting;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.UserRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.ValueListSettingRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.naming.InvalidNameException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by samgi on 4/8/2021.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

  private UserRepository userRepository;
  private ValueListSettingRepository valueListSettingRepository;
  private static final Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

  public MyUserDetailsService(
      UserRepository userRepository,
      ValueListSettingRepository valueListSettingRepository) {
    this.userRepository = userRepository;
    this.valueListSettingRepository = valueListSettingRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    com.blackwater.blackwaterbillingmanagementsystem.db.model.User user = userRepository
        .findUserBySystemEmailAddress(username);

    if(Objects.nonNull(user)){
      return new User(
          user.getSystemEmailAddress(),
          user.getPassword(),
          Collections.singletonList(
              new SimpleGrantedAuthority(getUserRole(user))));
    } else {
      throw new UsernameNotFoundException("user email: " + username + " was not found!");
    }
  }

  private String getUserRole(com.blackwater.blackwaterbillingmanagementsystem.db.model.User user){
    String userRole = "USER";
    if(user.getRole().equals(3)){
      userRole = "ADMIN";
    }
    return userRole;
  }
}
