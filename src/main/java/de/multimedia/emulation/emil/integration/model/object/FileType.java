package de.multimedia.emulation.emil.integration.model.object;

/**
 *
 * @author Marcus Bitzl <marcus.bitzl@bsb-muenchen.de>
 */
public enum FileType {

  CDROM, DISK, FLOPPY, UNKNOWN;

  public static FileType fromExtension(String extension) {
    switch (extension.toUpperCase()) {
      case "ISO":
        return CDROM;
      case "IMG":
        return FLOPPY;
      default:
        return UNKNOWN;
    }
  }

}
