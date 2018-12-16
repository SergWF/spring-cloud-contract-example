package com.bosch.probe.consumer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FirstConsumer {

  private final FirstClient firstClient;

  public void get(String id) {
    if (null == id) getAll();
    else getSingle(id);
  }

  private void getSingle(String id) {
    System.out.println("requested: " + firstClient.getOne(id));
  }

  private void getAll() {
    firstClient.getAll().forEach(item -> System.out.println("item:" + item));
  }

  public void add(String value) {
    FirstDao dao = FirstDao.builder().value(Integer.valueOf(value)).build();
    System.out.println("Added new item: " + dao);
    firstClient.add(dao);
  }
}
