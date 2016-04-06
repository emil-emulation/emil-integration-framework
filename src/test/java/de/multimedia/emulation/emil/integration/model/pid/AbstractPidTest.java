package de.multimedia.emulation.emil.integration.model.pid;

import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
public class AbstractPidTest {

  class TestPid extends AbstractPid {
    public TestPid(String pid) {
      super(pid);
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void pidMustNotBeEmpty() {
    assertThat(new TestPid(""), is(anything()));
  }

  @Test(expected = IllegalArgumentException.class)
  public void pidMustNotBeNull() {
    assertThat(new TestPid(null), is(anything()));
  }

  @Test
  public void getPidShouldReturnPid() {
    Pid pid = new TestPid("XXXX");
    assertThat(pid.getPid(), is("XXXX"));
  }

  @Test
  public void pidsShouldBeEqualForEqualValue() {
    Pid first = new TestPid("AAA");
    Pid second = new TestPid("AAA");
    assertThat(first, is(second));
  }

  @Test
  public void hashCodeShouldBeEqualForEqualPids() {
    Pid first = new TestPid("AAA");
    Pid second = new TestPid("AAA");
    assertThat(first.hashCode(), is(second.hashCode()));
  }

}
