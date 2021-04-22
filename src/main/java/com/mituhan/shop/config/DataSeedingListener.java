package com.mituhan.shop.config;



import com.mituhan.shop.entity.RoleEntity;
import com.mituhan.shop.entity.UserEntity;
import com.mituhan.shop.repository.RoleRepository;
import com.mituhan.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// Roles
		if (roleRepository.findByName("ROLE_ADMIN") == null) {
			roleRepository.save(new RoleEntity("ROLE_ADMIN"));
		}
		
		if (roleRepository.findByName("ROLE_MEMBER") == null) {
			roleRepository.save(new RoleEntity("ROLE_MEMBER"));
		}
		
//		// Admin account
//		if (userRepository.findByUsername("admin") == null) {
//			UserEntity admin = new UserEntity();
//			admin.setUsername("admin");
//			admin.setPassword(passwordEncoder.encode("123456"));
//			admin.getRoles().add(roleRepository.findByName("ROLE_ADMIN"));
//			admin.getRoles().add(roleRepository.findByName("ROLE_MEMBER"));
//			userRepository.save(admin);
//		}
//
//		// Member account
//		if (userRepository.findByUsername("member") == null) {
//			UserEntity user = new UserEntity();
//			user.setUsername("member");
//			user.setPassword(passwordEncoder.encode("123456"));
//			user.getRoles().add(roleRepository.findByName("ROLE_MEMBER"));
//			userRepository.save(user);
//		}
	}

}
