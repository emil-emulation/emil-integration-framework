package de.multimedia.emulation.emil.integration.demo.model;

import org.agileware.test.PropertiesTester;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
public class DemoFileTest {

  public DemoFileTest() {}

  @Before
  public void setUp() {}

  @Test
  public void propertiesShouldWork() throws Exception {
    PropertiesTester propertiesTester = new PropertiesTester();
    propertiesTester.testAll(DemoFile.class);
  }

}
