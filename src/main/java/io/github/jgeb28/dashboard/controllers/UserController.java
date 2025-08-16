package io.github.jgeb28.dashboard.controllers;

import io.github.jgeb28.dashboard.models.dtos.AspectDto;
import io.github.jgeb28.dashboard.models.dtos.UserScoreDto;
import io.github.jgeb28.dashboard.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}/score")
    public ResponseEntity<UserScoreDto> getUserScore(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserScore(id));
    }

    @GetMapping("/{id}/aspects")
    public ResponseEntity<List<AspectDto>> getUserAspects(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getAllAspectsForUser(id));
    }

    @GetMapping("/{id}/aspects/worst")
    public ResponseEntity<List<AspectDto>> getUserWorstAspects(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getWorstAspectsForUser(id));
    }
}
