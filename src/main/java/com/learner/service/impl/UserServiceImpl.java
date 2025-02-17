package com.learner.service.impl;

import com.learner.dto.UserDto;
import com.learner.entity.User;
import com.learner.mapper.UserMapper;
import com.learner.repository.UserRepository;
import com.learner.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userRepository.save(UserMapper.INSTANCE.mapToUser(userDto));
        return UserMapper.INSTANCE.mapToUserDto(user);
    }

    @Override
    public UserDto getUserById(long id) {
        Optional<User> userById = userRepository.findById(id);
        if(userById.isPresent()){
            return UserMapper.INSTANCE.mapToUserDto(userById.get());
        }else{ //throw exception
            return new UserDto();
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream()
                .map(UserMapper.INSTANCE::mapToUserDto)
                .toList();
    }

    @Override
    public UserDto updateUser(UserDto user) {

        Optional<User> userByID = userRepository.findById(user.getId());

        if(userByID.isPresent()){
            User existingUser = userByID.get();
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());

            User savedUser = userRepository.save(existingUser);
            return UserMapper.INSTANCE.mapToUserDto(savedUser);
        }

        return null;
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

}
