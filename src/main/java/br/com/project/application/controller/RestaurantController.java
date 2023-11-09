package br.com.project.application.controller;

import br.com.project.application.resource.Response;
import br.com.project.domain.dto.ItemDTO;
import br.com.project.domain.dto.UserLoginDTO;
import br.com.project.domain.service.RestaurantService;
import br.com.project.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/restaurant")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> getRestaurantList() throws Exception {
        return ResponseEntity.ok().
                body(new Response(200,
                        "Success",
                        restaurantService.getRestaurantList())
                );
    }


    @PostMapping("/restaurant/item")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> postItem(
            @RequestBody final ItemDTO itemDTO) throws Exception {
        return ResponseEntity.ok().
                body(new Response(200,
                        "Success",
                        restaurantService.postItem(itemDTO))
                );
    }

    @GetMapping("/restaurant/by-id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> getRestaurantById(@RequestParam  Long restaurantId) throws Exception {
        return ResponseEntity.ok().
                body(new Response(200,
                        "Success",
                        restaurantService.getRestaurantById(restaurantId))
                );
    }

    @GetMapping("/restaurant/user-id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> getRestaurantByUserId(@RequestParam Long userId) throws Exception {
        return ResponseEntity.ok().
                body(new Response(200,
                        "Success",
                        restaurantService.getRestaurantByUserId(userId))
                );
    }

}

