//package com.mituhan.shop.service.impl;
//
//import com.mituhan.shop.entity.RoleEntity;
//import com.mituhan.shop.entity.UserEntity;
//import com.mituhan.shop.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//	@Transactional
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserEntity user = userRepository.findByUsername(username);
//		if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//		List<RoleEntity> roles = user.getRoles();
//		for (RoleEntity role : roles) {
//			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//		}
//		return new org.springframework.security.core.userdetails.User(
//				user.getUsername(), user.getPassword(), grantedAuthorities);
//	}
//
//}
