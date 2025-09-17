package io.edu.user.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.edu.user.dto.ChangePassDTO;
import io.edu.user.dto.UserCreateDTO;
import io.edu.user.dto.UserDTO;
import io.edu.user.mapper.UserMapper;
import io.edu.user.model.User;
import io.edu.user.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @PersistenceContext
    private EntityManager entityManager;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO createUser (UserCreateDTO userCreateDTO) {
        if (userRepository.existsByEmail(userCreateDTO.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already in use");
        }
        userCreateDTO.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
        User user = userMapper.toEntity(userCreateDTO);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Cacheable("users")
    public UserDTO getUserById(Long id) {
        // Simulate delay
        try {
            Thread.sleep(3000); // 3 seconds delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return userMapper.toDto(user);
    }

    //TODO: demo only - remove
    public UserDTO getUserByIdNoCache(Long id) {
        //simulate delay
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return userMapper.toDto(user);
    }

    public ChangePassDTO changePassword(Long id, String oldPassword, String newPassword) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Old password is incorrect");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);

        return new ChangePassDTO(oldPassword, newPassword);
    }

    //TODO: demo only - remove
    public UserDTO replaceUser(Long id, UserCreateDTO userCreateDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        user.setEmail(userCreateDTO.getEmail());
        user.setRole(userCreateDTO.getRole());
        user.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    //TODO demo only - remove
    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        userRepository.deleteById(id);
        userRepository.flush();
        entityManager.clear();
    }
}
