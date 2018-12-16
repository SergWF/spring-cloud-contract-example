package com.bosch.probe.producer;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
@AllArgsConstructor
public class FirstController {

  private final FirstService firstService;


  @GetMapping("/{id}")
  public FirstDao getOne(@PathVariable UUID id){
    return firstService.getOne(id);
  }

  @GetMapping
  public List<FirstDao> getAll() {
    return firstService.getAll();

  }

  @PutMapping
  public void addOrUpdate(@RequestBody FirstDao dao){
    firstService.addOrUpdate(dao);
  }


}
