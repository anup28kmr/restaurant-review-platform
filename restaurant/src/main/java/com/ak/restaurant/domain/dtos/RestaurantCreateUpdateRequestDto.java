package com.ak.restaurant.domain.dtos;

import com.ak.restaurant.domain.entities.OperatingHours;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantCreateUpdateRequestDto {
  @NotBlank(message = "Restaurant name is required")
  private String restaurantName;

  @NotBlank(message = "Cuisine Type name is required")
  private String cuisineType;

  @NotBlank(message = "Contact information is required")
  private String contactInformation;

  @Valid
  private AddressDto restaurantAddress;
  @Valid
  private OperatingHoursDto operatingHours;
  @Size(min = 1, message = "Atleast one photo id is provided")
  private List<String> photoIds;
}
