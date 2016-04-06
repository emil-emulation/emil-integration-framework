package de.multimedia.emulation.emil.integration.exceptions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
public class ConfigurationExceptionTest {

  @Test
  public void constructorSetsThrowable() {
    Throwable cause = new Throwable();
    Exception exception = new ConfigurationException("Test", cause);
    assertThat(exception.getCause(), is(cause));
  }


  @Test
  public void constructorSetsMessage() {
    Exception exception = new ConfigurationException("Test", new Throwable());
    assertThat(exception.getMessage(), is("Test"));
  }

}
