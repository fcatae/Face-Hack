package br.com.bb.big.library.exception;

import javax.ws.rs.core.Response.Status;

public class VelmaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3118881636575281598L;

	private Status status = null;

    public VelmaException(String message) {
        this(message, null);
    }

    public VelmaException(Status status, String message) {
        this(status, message, null);
    }

    public VelmaException(Throwable cause) {
        this(cause.getMessage(), cause);
    }

    public VelmaException(Status status, Throwable cause) {
        this(status, cause.getMessage(), cause);
    }

    public VelmaException(String message, Throwable cause) {
        this(Status.INTERNAL_SERVER_ERROR, message, cause);
    }

    public VelmaException(Status status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
	
}