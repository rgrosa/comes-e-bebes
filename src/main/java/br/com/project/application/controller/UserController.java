package br.com.project.application.controller;

import br.com.project.domain.dto.CreateUserDTO;
import br.com.project.domain.dto.UserLoginDTO;
import br.com.project.application.resource.Response;
import br.com.project.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> postLogin(
            @RequestBody final UserLoginDTO userLoginDto) throws Exception {
        return ResponseEntity.ok().
                body(new Response(200,
                        "Success",
                        userService.postLogin(userLoginDto))
                );
    }

    @PostMapping("/login/create-user/client")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> createClient(
            @RequestBody final CreateUserDTO createUserDTO) throws Exception {
        return ResponseEntity.ok().
                body(new Response(200,
                        "Success",
                        userService.createClient(createUserDTO))
                );
    }

    @PostMapping("/login/create-user/owner")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> createOwner(
            @RequestBody final CreateUserDTO createUserDTO) throws Exception {
        return ResponseEntity.ok().
                body(new Response(200,
                        "Success",
                        userService.createOwner(createUserDTO))
                );
    }

}
