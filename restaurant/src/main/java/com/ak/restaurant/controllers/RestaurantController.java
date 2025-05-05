package com.ak.restaurant.controllers;

import com.ak.restaurant.domain.RestaurantCreateUpdateRequest;
import com.ak.restaurant.domain.dtos.RestaurantCreateUpdateRequestDto;
import com.ak.restaurant.domain.dtos.RestaurantDto;
import com.ak.restaurant.domain.entities.Restaurant;
import com.ak.restaurant.mappers.RestaurantMapper;
import com.ak.restaurant.services.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
  private final RestaurantService restaurantService;
  private final RestaurantMapper restaurantMapper;

  @PostMapping
  public ResponseEntity<RestaurantDto> createRestaurant(@Valid @RequestBody RestaurantCreateUpdateRequestDto requestDto) {

    RestaurantCreateUpdateRequest restaurantCreateUpdateRequest = restaurantMapper.toRestaurantCreateUpdateRequest(requestDto);
    Restaurant restaurant =restaurantService.createRestaurant(restaurantCreateUpdateRequest);
    RestaurantDto restaurantDto = restaurantMapper.toRestaurantDto(restaurant);
    return new ResponseEntity<>(restaurantDto, HttpStatus.CREATED);
  }
}
