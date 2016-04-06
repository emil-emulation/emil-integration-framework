package de.multimedia.emulation.emil.integration.demo.model;

import de.multimedia.emulation.emil.integration.model.object.FileType;
import org.agileware.test.PropertiesTester;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
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

  @Test(expected = RuntimeException.class)
  public void getUrlShouldThrowExceptionForMalformedUrl() {
    DemoFile demoFile = new DemoFile();
    demoFile.setUrl("abc");
    assertThat(demoFile.getUrl(), is(not(anything())));
  }

  @Test
  public void getTypeShouldReturnEnum() {
    DemoFile demoFile = new DemoFile();
    demoFile.setType("iso");
    assertThat(demoFile.getType(), is(FileType.ISO));
  }

}
