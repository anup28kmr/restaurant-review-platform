package com.ak.restaurant.domain.dtos;

import com.ak.restaurant.domain.entities.TimeRange;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperatingHoursDto {

  @Valid
  private TimeRangeDto monday;
  @Valid
  private TimeRange tuesday;
  @Valid
  private TimeRange wednesday;
  @Valid
  private TimeRange thursday;
  @Valid
  private TimeRange friday;
  @Valid
  private TimeRange saturday;
  @Valid
  private TimeRange sunday;
}
