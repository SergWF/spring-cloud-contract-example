package com.bosch.probe.consumer;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FirstDao {
  private UUID id;
  private Integer value;
}
