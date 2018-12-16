package com.bosch.probe.consumer;

import java.util.Set;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "firstClient", url = "${feign.client.config.firstClient.url}")
public interface FirstClient {

  @GetMapping
  Set<FirstDao> getAll();

  @GetMapping("/{id}")
  FirstDao getOne(@PathVariable String id);

  @PutMapping
  void add(@RequestBody FirstDao dao);
}
