package marques.vitor.santander_dev_week_2023.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import marques.vitor.santander_dev_week_2023.domain.User;
import marques.vitor.santander_dev_week_2023.service.UserService;


@RestController
@RequestMapping("/users")
public class UserRestController {

    private final UserService userService;
    
    public UserRestController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
    
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        var userCreated = userService.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(userCreated.getId())
        .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }

}
