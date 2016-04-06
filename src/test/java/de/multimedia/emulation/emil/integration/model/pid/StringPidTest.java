package de.multimedia.emulation.emil.integration.model.pid;

import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
public class StringPidTest {

  @Test(expected = IllegalArgumentException.class)
  public void pidMustNotBeEmpty() {
    assertThat(new StringPid(""), is(anything()));
  }

  @Test(expected = IllegalArgumentException.class)
  public void pidMustNotBeNull() {
    assertThat(new StringPid(null), is(anything()));
  }

  @Test
  public void getPidShouldReturnPid() {
    Pid pid = new StringPid("XXXX");
    assertThat(pid.getPid(), is("XXXX"));
  }

  @Test
  public void pidsShouldBeEqualForEqualValue() {
    Pid first = new StringPid("AAA");
    Pid second = new StringPid("AAA");
    assertThat(first, is(second));
  }


  @Test
  public void pidShouldNotEqualOtherType() {
    Pid first = new StringPid("AAA");
    assertThat(first, is(not("AAA")));
  }

  @Test
  public void hashCodeShouldBeEqualForEqualPids() {
    Pid first = new StringPid("AAA");
    Pid second = new StringPid("AAA");
    assertThat(first.hashCode(), is(second.hashCode()));
  }

}
