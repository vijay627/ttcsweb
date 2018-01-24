package com.ttcs.commons.exception;

//TODO: Auto-Ttcserated Javadoc
/**
* The Class TtcsPersistenceException.
*/
public class TtcsPersistenceException extends TtcsSystemException {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4307010226654660094L;

	/**
	 * Instantiates a new Ttcs persistence exception.
	 * 
	 * @param message the message
	 * @param cause the cause
	 * @param key the key
	 * @param args the args
	 */
	public TtcsPersistenceException(String message, Throwable cause, String key, Object... args) {
		super(message, cause, key, args);
	}

	/**
	 * Instantiates a new Ttcs persistence exception.
	 * 
	 * @param message the message
	 * @param cause the cause
	 * @param key the key
	 */
	public TtcsPersistenceException(String message, Throwable cause, String key) {
		super(message, cause, key);
	}

	/**
	 * Instantiates a new Ttcs persistence exception.
	 * 
	 * @param message the message
	 * @param key the key
	 */
	public TtcsPersistenceException(String message, String key) {
		super(message, key);
	}

	/**
	 * Instantiates a new Ttcs persistence exception.
	 * 
	 * @param cause the cause
	 * @param key the key
	 */
	public TtcsPersistenceException(Throwable cause, String key) {
		super(cause, key);
	}

	/**
	 * The Constructor.
	 * 
	 * @param message the message
	 * @param key the key
	 * @param messageParameters the message parameters
	 */
	public TtcsPersistenceException(String message, String key, Object[] messageParameters) {
		super(message, key, messageParameters);
	}

	/**
	 * The Constructor.
	 * 
	 * @param message the message
	 * @param key the key
	 * @param detail the detail
	 * @param messageParameters the message parameters
	 */
	public TtcsPersistenceException(String message, String key, String detail, Object[] messageParameters) {
		super(message, key, detail, messageParameters);
	}

	/**
	 * The Constructor.
	 * 
	 * @param message the message
	 * @param key the key
	 * @param detail the detail
	 */
	public TtcsPersistenceException(String message, String key, String detail) {
		super(message, key, detail);
	}

	/**
	 * The Constructor.
	 * 
	 * @param message the message
	 * @param cause the cause
	 * @param key the key
	 * @param detail the detail
	 * @param args the args
	 */
	public TtcsPersistenceException(String message, Throwable cause, String key, String detail, Object... args) {
		super(message, cause, key, detail, args);
	}

}

