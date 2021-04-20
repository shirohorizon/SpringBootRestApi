package com.mituhan.shop.service.impl;

import com.mituhan.shop.dto.UserDTO;
import com.mituhan.shop.entity.UserEntity;
import com.mituhan.shop.repository.RoleRepository;
import com.mituhan.shop.repository.UserRepository;
import com.mituhan.shop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDTO save(UserDTO objectDTO) {
        UserEntity userEntity = new UserEntity();
        if(objectDTO.getId() != null){
            UserEntity oldUser = userRepository.getOne(objectDTO.getId());
        }else {

        }
        return null;
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
}
