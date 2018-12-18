package com.bosch.probe.consumer;

import java.util.Arrays;
import java.util.Set;
import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(
    ids = "com.bosch.probe:scc-producer:+:stubs:8090",
    stubsMode = StubsMode.LOCAL)
public class FirstClientTest {

  FirstDao dao = new FirstDao(UUID.fromString("1fe19d91-2cf1-48be-aeba-21674d47ee01"), 1);
  FirstDao dao1 = new FirstDao(UUID.fromString("2fe19d91-2cf1-48be-aeba-21674d47ee01"), 2);
  FirstDao dao2 = new FirstDao(UUID.fromString("3fe19d91-2cf1-48be-aeba-21674d47ee01"), 3);

  @Autowired private MockMvc mockMvc;

  @Autowired private FirstClient firstClient;

  @Test
  public void shouldReturnFirstDao() throws Exception {
    FirstDao actual = firstClient.getOne(dao.getId().toString());
    Assert.assertEquals(dao, actual);
  }

  @Test
  public void shouldReturnList() throws Exception {
    Set<FirstDao> actual = firstClient.getAll();
    MatcherAssert.assertThat(actual, IsIterableContainingInAnyOrder
        .containsInAnyOrder(dao, dao1, dao2));
  }
}
