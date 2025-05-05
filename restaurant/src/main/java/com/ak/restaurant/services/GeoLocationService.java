package com.ak.restaurant.services;

import com.ak.restaurant.domain.GeoLocation;
import com.ak.restaurant.domain.entities.Address;

public interface GeoLocationService {
  GeoLocation getGeoLocation(Address address);
}
