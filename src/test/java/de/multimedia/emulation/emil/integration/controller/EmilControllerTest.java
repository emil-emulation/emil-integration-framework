package de.multimedia.emulation.emil.integration.controller;

import de.multimedia.emulation.emil.integration.demo.service.DemoService;
import de.multimedia.emulation.emil.integration.model.object.ArchiveObject;
import de.multimedia.emulation.emil.integration.model.pid.Pid;
import de.multimedia.emulation.emil.integration.service.ArchiveService;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
public class EmilControllerTest {

  private EmilController controller;

  private DemoService demoService;

  private ArchiveService archiveService;

  @Before
  public void setUp() {
    archiveService = mock(ArchiveService.class);
    demoService = mock(DemoService.class);
    controller = new EmilController(archiveService, demoService);
  }

  @Test
  public void getShouldReturnDemoObjectForSpecialId() throws Exception {
    ArchiveObject archiveObject = mock(ArchiveObject.class);
    when(demoService.isDemoObjectId("abcdef")).thenReturn(true);
    when(demoService.getDemoObject()).thenReturn(archiveObject);
    assertThat(controller.get("abcdef"), is(archiveObject));
  }

  @Test
  public void getShouldReturnArchiveObject() throws Exception {
    ArchiveObject archiveObject = mock(ArchiveObject.class);
    Pid pid = mock(Pid.class);
    when(archiveService.getPid("abcdef")).thenReturn(pid);
    when(archiveService.getArchiveObject(pid)).thenReturn(archiveObject);
    assertThat(controller.get("abcdef"), is(archiveObject));
  }

}
