package com.bosch.probe.producer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FirstService {

  private static final Map<UUID, FirstDao> storage = new HashMap<>();

  public FirstDao getOne(UUID id) {
    FirstDao firstDao = storage.get(id);
    logger.info("requested one item: {}", firstDao);
    return firstDao;
  }

  public List<FirstDao> getAll() {
    logger.info("requested all items: {}", storage.size());
    return storage.values().stream().collect(Collectors.toList());
  }

  public void addOrUpdate(FirstDao dao) {
    if(null == dao.getId()) {
      dao.setId(UUID.randomUUID());
    }
    logger.info("added new item: {}", dao);
    storage.put(dao.getId(), dao);
  }
}
