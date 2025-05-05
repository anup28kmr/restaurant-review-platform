package com.ak.restaurant.services;

import com.ak.restaurant.domain.RestaurantCreateUpdateRequest;
import com.ak.restaurant.domain.entities.Restaurant;

public interface RestaurantService {
  Restaurant createRestaurant(RestaurantCreateUpdateRequest restaurant);
}
