package com.bosch.probe.consumer;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FirstDao {
  private UUID id;
  private Integer value;
}
