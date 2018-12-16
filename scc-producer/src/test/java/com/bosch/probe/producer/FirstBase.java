package com.bosch.probe.producer;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.Arrays;
import java.util.UUID;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerApplication.class)
public class FirstBase {

  private static final UUID DAO_ID_1 = UUID.fromString("1fe19d91-2cf1-48be-aeba-21674d47ee01");
  private static final UUID DAO_ID_2 = UUID.fromString("2fe19d91-2cf1-48be-aeba-21674d47ee01");
  private static final UUID DAO_ID_3 = UUID.fromString("3fe19d91-2cf1-48be-aeba-21674d47ee01");
  @MockBean private FirstService firstService;
  @Autowired private FirstController firstController;

  @Before
  public void setup() {
    FirstDao dao1 = FirstDao.builder().id(DAO_ID_1).value(1).build();
    FirstDao dao2 = FirstDao.builder().id(DAO_ID_2).value(2).build();
    FirstDao dao3 = FirstDao.builder().id(DAO_ID_3).value(3).build();
    Mockito.when(firstService.getOne(DAO_ID_1)).thenReturn(dao1);
    Mockito.when(firstService.getAll()).thenReturn(Arrays.asList(dao1, dao2, dao3));

    RestAssuredMockMvc.standaloneSetup(firstController);
  }
}
