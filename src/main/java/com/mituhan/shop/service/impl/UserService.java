package com.mituhan.shop.service.impl;

import com.mituhan.shop.converter.UserConverter;
import com.mituhan.shop.dto.UserDTO;
import com.mituhan.shop.entity.RoleEntity;
import com.mituhan.shop.entity.UserEntity;
import com.mituhan.shop.repository.RoleRepository;
import com.mituhan.shop.repository.UserRepository;
import com.mituhan.shop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO save(UserDTO objectDTO) {
        UserEntity userEntity = new UserEntity();
        if(objectDTO.getId() != null){
            UserEntity oldUser = userRepository.getOne(objectDTO.getId());
            userEntity = userConverter.toEntity(objectDTO, oldUser);
        }else {
            userEntity = userConverter.toEntity(objectDTO);
        }
        userEntity.setPassword(passwordEncoder.encode(objectDTO.getUsername()));
        if (objectDTO.getRoleName() == null){
            userEntity.getRoles().add(roleRepository.findByName("ROLE_MEMBER"));
        }
        List<RoleEntity> newRole = new ArrayList<>();
        objectDTO.getRoleName().forEach(r->{
            newRole.add(roleRepository.findByName(r));
        });
        userEntity.getRoles().removeAll(newRole);
        userEntity.getRoles().addAll(newRole);
        userEntity.setStatus(1);
        userEntity.setVendor(0);
        userEntity = userRepository.save(userEntity);
        return userConverter.toDTO(userEntity);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id: ids){
            userRepository.deleteById(id);
        }

    }

    @Override
    public int totalItem() {
        return (int) userRepository.count();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Boolean isUserExist(UserDTO userDTO) {
        UserEntity userEntity = userRepository.findByUsername(userDTO.getUsername());
        if(userEntity == null){
            return false;
        }else {
            return true;
        }
    }
}
