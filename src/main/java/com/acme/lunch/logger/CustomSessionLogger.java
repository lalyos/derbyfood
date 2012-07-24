package com.acme.lunch.logger;

import org.eclipse.persistence.logging.AbstractSessionLog;
import org.eclipse.persistence.logging.SessionLog;
import org.eclipse.persistence.logging.SessionLogEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomSessionLogger extends AbstractSessionLog implements
		SessionLog {
	public static final Logger logger = LoggerFactory
			.getLogger(CustomSessionLogger.class);

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
