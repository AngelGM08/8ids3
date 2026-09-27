package com.apibackend._ids3.service;

import com.apibackend._ids3.dto.request.UserRequestDTO;
import com.apibackend._ids3.dto.response.UserResponseDTO;
import com.apibackend._ids3.exception.UserHasPoliciesException;
import com.apibackend._ids3.exception.UserNotFoundException;
import com.apibackend._ids3.mapper.UserMapper;
import com.apibackend._ids3.model.Policy;
import com.apibackend._ids3.model.Role;
import com.apibackend._ids3.model.User;
import com.apibackend._ids3.repository.PolicyRepository;
import com.apibackend._ids3.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final PolicyRepository policyRepository;
    
    public UserService(UserRepository userRepository, RoleService roleService, UserMapper userMapper, PasswordEncoder passwordEncoder, PolicyRepository policyRepository) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.policyRepository = policyRepository;
    }
    
    public UserResponseDTO saveUser(UserRequestDTO dto) {
        Role role = roleService.getById(dto.getRoleId());
        
        User user = userMapper.toEntity(dto, role);
        
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        
        User saveUser = userRepository.save(user);
        
        return userMapper.toResponseDTO(saveUser);
    }
    
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toResponseDTO).toList();
    }
    
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return userMapper.toResponseDTO(user);
    }
    
    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        Role role = roleService.getById(dto.getRoleId());
        
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRfc(dto.getRfc());
        user.setContact(dto.getContact());
        user.setPhoneContact(dto.getPhoneContact());
        user.setAddress(dto.getAddress());
        user.setRole(role);
        
        User updatedUser = userRepository.save(user);
        return userMapper.toResponseDTO(updatedUser);
    }
    
    public void deleteUser(Long id) {
        User user =  userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        
        if(policyRepository.existsByClientId(id)){
            throw new UserHasPoliciesException(id);
        }
        
        userRepository.delete(user);
    }
    
    public User getClientById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        if(!user.getRole().getName().equalsIgnoreCase("CLIENTE")){
            throw new IllegalArgumentException("El usuario con id " + id + " no es un cliente");
        }
        return user;
    }
}
