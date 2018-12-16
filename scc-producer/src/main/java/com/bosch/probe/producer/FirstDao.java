package com.bosch.probe.producer;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor(onConstructor=@__(@JsonCreator))
public class FirstDao {
  private UUID id;
  private Integer value;
}
