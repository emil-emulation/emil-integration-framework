package de.multimedia.emulation.emil.integration.exceptions;

/**
 *
 * Generic exception to indicate something must be wrong with the configuration.
 */
public class ConfigurationException extends RuntimeException {

  public ConfigurationException(String message, Throwable cause) {
    super(message, cause);
  }
  
}
