package com.ak.restaurant.services.impl;

import com.ak.restaurant.domain.GeoLocation;
import com.ak.restaurant.domain.entities.Address;
import com.ak.restaurant.services.GeoLocationService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomGeoLocationService implements GeoLocationService {

  private static final float MIN_LATITUDE = -90.0f;
  private static final float MAX_LATITUDE = 90.0f;
  private static final float MIN_LONGITUDE = -180.0f;
  private static final float MAX_LONGITUDE = 180.0f;

  @Override
  public GeoLocation getGeoLocation(Address address) {
    Random rand = new Random();
    double latitude = MIN_LATITUDE + rand.nextDouble() * (MAX_LATITUDE - MIN_LATITUDE);
    double longitude = MIN_LONGITUDE + rand.nextDouble() * (MAX_LONGITUDE - MIN_LONGITUDE);
    return GeoLocation.builder()
        .latitude(latitude)
        .longitude(longitude)
        .build();
  }
}
