package br.com.project.domain.service.imp;

import br.com.project.domain.dto.CreateUserDTO;
import br.com.project.domain.dto.LoggedUserDTO;
import br.com.project.domain.dto.LoggedUserDetailsDTO;
import br.com.project.domain.dto.UserLoginDTO;
import br.com.project.domain.entity.RestaurantEntity;
import br.com.project.domain.entity.UserEntity;
import br.com.project.domain.repository.RestaurantRepository;
import br.com.project.infrasctructure.exception.PasswordException;
import br.com.project.infrasctructure.exception.ResourceNotFoundException;
import br.com.project.domain.repository.UserRepository;
import br.com.project.domain.service.UserService;
import br.com.project.infrasctructure.util.auth.CryptPassword;
import br.com.project.infrasctructure.util.auth.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    CryptPassword cryptPassword;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    private final static int C_CLIENT_ID = 1;
    private final static int C_OWNER_ID = 2;

    @Override
    public LoggedUserDTO postLogin(UserLoginDTO userLoginDto) throws PasswordException {
        try {
            return  generateUserLogin(userLoginDto);
        } catch (Exception ex) {
            throw new PasswordException(ex.getMessage());
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws ResourceNotFoundException {
        try {
            return new LoggedUserDetailsDTO(makeLoggedUser(findUserByName(username)));
        } catch (Exception ex) {
            throw new ResourceNotFoundException(ex.getMessage());
        }
    }

    @Override
    public UserDetails createClient(CreateUserDTO createUserDTO) throws Exception {
        UserEntity userEntity;
        try{
            findUserByName(createUserDTO.getUsername());
        }catch(Exception ex){
            UserEntity user = new UserEntity();
            user.setAddress(createUserDTO.getAddress());
            user.setUserName(createUserDTO.getUsername());
            user.setRestaurantId(null);
            user.setUserTypeId(C_CLIENT_ID);
            user.setStatus(createUserDTO.getStatus());
            user.setPassword(cryptPassword.encode(createUserDTO.getPassword()));
            user.setRegistrationDocument(createUserDTO.getRegistrationDocument());
            userRepository.save(user);
            userEntity = findUserByName(user.getUserName());
            userEntity.setPassword(null);
            return new LoggedUserDetailsDTO(makeLoggedUser(userEntity));
        }
            throw new Exception("User already exist");
    }

    @Override
    public UserDetails createOwner(CreateUserDTO createUserDTO) throws Exception {
        UserEntity userEntity;
        try{
            findUserByName(createUserDTO.getUsername());
        }catch (Exception ex){
            RestaurantEntity restaurant = new RestaurantEntity();
            restaurant.setAddress(createUserDTO.getRestaurant().getAddress());
            restaurant.setRestaurantName(createUserDTO.getRestaurant().getRestaurantName());
            restaurant.setWorkTime(createUserDTO.getRestaurant().getWorkTime());
            restaurant = restaurantRepository.save(restaurant);
            UserEntity user = new UserEntity();
            user.setAddress(createUserDTO.getAddress());
            user.setUserName(createUserDTO.getUsername());
            user.setRestaurantId(restaurant.getId());
            user.setUserTypeId(C_OWNER_ID);
            user.setStatus(createUserDTO.getStatus());
            user.setPassword(cryptPassword.encode(createUserDTO.getPassword()));
            user.setRegistrationDocument(createUserDTO.getRegistrationDocument());
            userEntity = userRepository.save(user);
            userEntity.setPassword(null);
            return new LoggedUserDetailsDTO(makeLoggedUser(userEntity));
        }
            throw new Exception("User already exist");
    }

    private LoggedUserDTO generateUserLogin(UserLoginDTO userLoginDto) throws PasswordException {
        UserEntity userEntity = findUserByName(userLoginDto.getUserName());

        if(!cryptPassword.matches(userLoginDto.getPassword(), userEntity.getPassword())){
            throw new PasswordException("Invalid user");
        }
        return makeResponseDto(userEntity);
    }

    private UserEntity findUserByName(String userName) throws PasswordException {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserName(userName);
        return optionalUserEntity.orElseThrow(() -> new PasswordException("Invalid user"));
    }

    private LoggedUserDTO makeResponseDto(UserEntity userEntity) {
        LoggedUserDetailsDTO userDetails = new LoggedUserDetailsDTO(makeLoggedUser(userEntity));
        userDetails.getLoggedUser().setJwtToken(jwtTokenUtil.generateToken(userDetails));
        userDetails.getLoggedUser().setPassword(null); //não vou retornar o password para frontend
        return userDetails.getLoggedUser();
    }

    private static LoggedUserDTO makeLoggedUser(UserEntity userEntity){
        return new LoggedUserDTO(
                userEntity.getId(),
                userEntity.getUserName(),
                userEntity.getPassword(),
                null,
                userEntity.getUserTypeId(),
                userEntity.getAddress(),
                userEntity.getRegistrationDocument(),
                userEntity.getUpdatedAt(),
                userEntity.getCreatedAt(),
                userEntity.getRestaurantId(),
                userEntity.getStatus()
        );
    }
}
