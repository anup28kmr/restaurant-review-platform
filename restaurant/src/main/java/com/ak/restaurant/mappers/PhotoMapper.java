package com.ak.restaurant.mappers;

import com.ak.restaurant.domain.dtos.PhotoDto;
import com.ak.restaurant.domain.entities.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PhotoMapper {
  PhotoDto toDto(Photo photo);

}
