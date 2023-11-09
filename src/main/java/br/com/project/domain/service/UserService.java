package br.com.project.domain.service;

import br.com.project.domain.dto.CreateUserDTO;
import br.com.project.domain.dto.LoggedUserDTO;
import br.com.project.domain.dto.UserLoginDTO;
import br.com.project.infrasctructure.exception.PasswordException;
import br.com.project.infrasctructure.exception.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    LoggedUserDTO postLogin(UserLoginDTO userLoginDto) throws PasswordException;

    UserDetails loadUserByUsername(String username) throws ResourceNotFoundException;

    UserDetails createClient(CreateUserDTO createUserDTO) throws Exception;

    UserDetails createOwner(CreateUserDTO createUserDTO) throws Exception;
}
