package com.zidio.systemuser.service.impl;

import com.zidio.systemuser.dto.CreateUserDTO;
import com.zidio.systemuser.dto.UpdateUserDTO;
import com.zidio.systemuser.dto.UserDTO;
import com.zidio.systemuser.entity.User;
import com.zidio.systemuser.mapper.UserMapper;
import com.zidio.systemuser.repository.UserRepository;
import com.zidio.systemuser.service.SystemUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional 
public class SystemUserServiceImpl implements SystemUserService {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder; 

    public SystemUserServiceImpl(UserRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO create(CreateUserDTO dto) {
        if (repo.existsByUsername(dto.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (repo.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        User u = new User();
        UserMapper.fromCreate(u, dto, passwordEncoder.encode(dto.getPassword())); 
        return UserMapper.toDTO(repo.save(u));
    }

    @Override
    public UserDTO get(Long id) {
        User u = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return UserMapper.toDTO(u);
    }
    
    @Override
    public UserDTO update(Long id, UpdateUserDTO dto) {
        User u = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        if (dto.getEmail() != null && !dto.getEmail().equalsIgnoreCase(u.getEmail()) && repo.existsByEmail(dto.getEmail())) {
             throw new IllegalArgumentException("Email already exists");
        }

        UserMapper.applyUpdate(u, dto);
        return UserMapper.toDTO(repo.save(u));
    }
    
    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new IllegalArgumentException("User not found");
        repo.deleteById(id);
    }
    
    @Override
    @Transactional(Transactional.TxType.SUPPORTS) 
    public List<UserDTO> list() {
        return repo.findAll().stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }
}