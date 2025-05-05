package com.ak.restaurant.domain;

import com.ak.restaurant.domain.entities.Address;
import com.ak.restaurant.domain.entities.OperatingHours;
import com.ak.restaurant.domain.entities.Photo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantCreateUpdateRequest {
  private String restaurantName;
  private String cuisineType;
  private String contactInformation;
  private Address restaurantAddress;
  private OperatingHours operatingHours;
  private List<String> photoIds;
}
