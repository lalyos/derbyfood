package com.acme.lunch.logging;

import org.eclipse.persistence.logging.AbstractSessionLog;
import org.eclipse.persistence.logging.SessionLog;
import org.eclipse.persistence.logging.SessionLogEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A custom EclipseLink session log that redirects to SLF4J.
 * 
 * @author Romain Deltour
 * 
 */
public class CustomSessionLog extends AbstractSessionLog implements SessionLog {
	private final Logger logger = LoggerFactory.getLogger("EclipseLink");

	@Override
	public void log(SessionLogEntry entry) {
		switch (entry.getLevel()) {
		case SessionLog.OFF:
			break;
		case SessionLog.FINEST:
			if (logger.isTraceEnabled()) {
				logger.trace(entry.getMessage());
			}
			break;
		case SessionLog.FINER:
			if (logger.isTraceEnabled()) {
				logger.trace(entry.getMessage());
			}
			break;
		case SessionLog.FINE:
			if (logger.isDebugEnabled()) {
				logger.debug(entry.getMessage());
			}
			break;
		case SessionLog.CONFIG:
			if (logger.isDebugEnabled()) {
				logger.debug(entry.getMessage());
			}
			break;
		case SessionLog.INFO:
			if (logger.isInfoEnabled()) {
				logger.info(entry.getMessage());
			}
			break;
		case SessionLog.WARNING:
			if (logger.isWarnEnabled()) {
				logger.warn(entry.getMessage());
			}
			break;
		case SessionLog.SEVERE:
			if (logger.isErrorEnabled()) {
				logger.error(entry.getMessage());
			}
			break;
		default:
			if (logger.isInfoEnabled()) {
				logger.info(entry.getMessage());
			}
			break;
		}
	}
}