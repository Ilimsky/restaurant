package com.example.restaurant.controllers;

import com.example.restaurant.dtos.Pagination;
import com.example.restaurant.dtos.eatery.CreateEateryRequest;
import com.example.restaurant.dtos.eatery.EateryDTO;
import com.example.restaurant.dtos.eatery.UpdateEateryRequest;
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
    public ResponseEntity<EateryDTO> saveEatery(@Valid @RequestBody CreateEateryRequest createEateryRequest) {
        return new ResponseEntity<>(service.createEatery(createEateryRequest), HttpStatus.CREATED);
    }

    @GetMapping("/eateries")
    public ResponseEntity<Pagination<EateryDTO>> getAllByPagination(@RequestParam(required = false, defaultValue = "0") int pageNo,
                                                                    @RequestParam(required = false, defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(service.getAllEateries(pageNo, pageSize));
    }

    @GetMapping("/eateries/{id}")
    public ResponseEntity<EateryDTO> getEateryDtoById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEateryDtoById(id));
    }

    @DeleteMapping("/eateries/delete/{id}")
    public ResponseEntity<Long> deleteEateryById(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteEateryById(id));
    }

    @PutMapping("/eateries/update/{id}")
    public ResponseEntity<EateryDTO> updateEateryById(@Valid @RequestBody UpdateEateryRequest updateEateryRequest,
                                                      @PathVariable Long id) {
        return ResponseEntity.ok(service.updateEatery(updateEateryRequest, id));
    }
}
