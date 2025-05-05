package com.ak.restaurant.services.impl;

import com.ak.restaurant.domain.GeoLocation;
import com.ak.restaurant.domain.RestaurantCreateUpdateRequest;
import com.ak.restaurant.domain.entities.Address;
import com.ak.restaurant.domain.entities.Photo;
import com.ak.restaurant.domain.entities.Restaurant;
import com.ak.restaurant.repositories.RestaurantRepository;
import com.ak.restaurant.services.GeoLocationService;
import com.ak.restaurant.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

  private final RestaurantRepository restaurantRepository;
  private final GeoLocationService geoLocationService;

  @Override
  public Restaurant createRestaurant(RestaurantCreateUpdateRequest request) {
    Address address = request.getRestaurantAddress();
    GeoLocation geoLocation = geoLocationService.getGeoLocation(address);
    GeoPoint geoPoint = new GeoPoint(geoLocation.getLatitude(), geoLocation.getLongitude());

    List<String> photoIds = request.getPhotoIds();
    List<Photo> photos = photoIds.stream().map(photoUrl ->
        Photo.builder()
            .url(photoUrl)
            .uploadDate(LocalDateTime.now())
            .build()).toList();

    Restaurant restaurant = Restaurant.builder()
        .name(request.getRestaurantName())
        .address(address)
        .cuisineType(request.getCuisineType())
        .contactInformation(request.getContactInformation())
        .geoLocation(geoPoint)
        .operatingHours(request.getOperatingHours())
        .photos(photos)
        .averageRating(0f)
        .build();

    return restaurantRepository.save(restaurant);
  }
}
