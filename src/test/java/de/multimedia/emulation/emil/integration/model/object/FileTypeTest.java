package de.multimedia.emulation.emil.integration.model.object;

import static de.multimedia.emulation.emil.integration.model.object.FileType.CDROM;
import static de.multimedia.emulation.emil.integration.model.object.FileType.FLOPPY;
import static de.multimedia.emulation.emil.integration.model.object.FileType.UNKNOWN;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;


public class FileTypeTest {

  @Test
  public void fromExtensionShouldIgnoreCase() {
    assertThat(FileType.fromExtension("IsO"), is(CDROM));
  }

  @Test
  public void fromExtensionShouldRecognizeIsoFiles() {
    assertThat(FileType.fromExtension("ISO"), is(CDROM));
  }

  @Test
  public void fromExtensionShouldRecognizeFloppyFiles() {
    assertThat(FileType.fromExtension("IMG"), is(FLOPPY));
  }

  @Test
  public void fromExtensionShouldNotRecognizeOthers() {
    assertThat(FileType.fromExtension("ABC"), is(UNKNOWN));
  }

}
