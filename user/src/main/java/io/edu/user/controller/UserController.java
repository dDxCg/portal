package io.edu.user.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.edu.user.dto.ChangePassDTO;
import io.edu.user.dto.UserCreateDTO;
import io.edu.user.dto.UserDTO;
import io.edu.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public Map<String, String> getDynamicChartCode() {
        Map<String, String> response = new HashMap<>();

        // Minimal JS code sent from server
        response.put("script", """
            const div = document.createElement('div');
            div.innerText = 'Hello, Code on Demand!';
            document.body.appendChild(div);
        """);

        return response;
    }

    @PostMapping("/account")
    public ResponseEntity<String> createUser(@RequestBody @Valid UserCreateDTO userCreateDTO) {
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok("User created successfully");
    }

    //TODO: demo only - remove
    @GetMapping("/{id}/non-cache")
    public UserDTO getUserByIdNoCache(@PathVariable Long id) {
        return userService.getUserByIdNoCache(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(120, TimeUnit.SECONDS).cachePublic()) // Cache for 2 minutes
                .body(user);
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<String> changePassword(
            @PathVariable Long id,
            @RequestBody @Valid ChangePassDTO changePassDTO) {
        userService.changePassword(id, changePassDTO.getOldPassword(), changePassDTO.getNewPassword());
        return ResponseEntity.ok("Password changed successfully");
    }
    
    //TODO: demo only - remove
    @PutMapping("/{id}")
    public ResponseEntity<String> replaceUser(@PathVariable Long id, @RequestBody @Valid UserCreateDTO userCreateDTO) {
        userService.replaceUser(id, userCreateDTO);
        return ResponseEntity.ok("Replace user successfully");
    }

    //TODO demo only - remove
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

}