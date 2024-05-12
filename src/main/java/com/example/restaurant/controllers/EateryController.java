package com.example.restaurant.controllers;

import com.example.restaurant.dtos.eatery.CreateEateryRequest;
import com.example.restaurant.dtos.eatery.EateryDTO;
import com.example.restaurant.services.EateryServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@AllArgsConstructor
public class EateryController {

    private EateryServiceImpl service;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the unprotected page";
    }

    @PostMapping("/eateries")
//    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<EateryDTO> saveEatery(@Valid @RequestBody CreateEateryRequest createEateryRequest){
        return new ResponseEntity<>(service.createEatery(createEateryRequest), HttpStatus.CREATED);
    }











//    @GetMapping("{id}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public Eatery establishmentByID(@PathVariable int id) {
//        return service.establishmentByID(id);
//    }


}
