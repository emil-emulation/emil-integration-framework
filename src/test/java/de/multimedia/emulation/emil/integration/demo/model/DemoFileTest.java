package de.multimedia.emulation.emil.integration.demo.model;

import org.agileware.test.PropertiesTester;
import org.junit.Test;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
public class DemoFileTest {

  @Test
  public void propertiesShouldWork() throws Exception {
    PropertiesTester propertiesTester = new PropertiesTester();
    propertiesTester.testAll(DemoFile.class);
  }

}
