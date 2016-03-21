package de.multimedia.emulation.emil.integration.demo.service;

import de.multimedia.emulation.emil.integration.demo.config.DemoConfig;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;


public class DemoServiceTest {

  @Test
  public void demoServiceShouldGetObjectIdFromConfig() {
    DemoConfig config = new DemoConfig();
    config.setObjectId("ID12345");
    DemoService demoService = new DemoService(config);
    assertThat(demoService.getDemoObject().getId(), is("ID12345"));
  }

}
