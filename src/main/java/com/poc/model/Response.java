package com.poc.model;

import java.io.Serializable;

/*
 * unique response class to represent unique response for all rest services.
 * 
 */
public class Response<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Status status;
	private T data;

	/**
	 * 
	 * @return The status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status
	 *            The status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * 
	 * @return The data
	 */
	public T getData() {
		return data;
	}

	/**
	 * 
	 * @param data
	 *            The data
	 */
	public void setData(T data) {
		this.data = data;
	}

	public static class Status implements Serializable {

		private static final long serialVersionUID = 1L;

		private int code;
		private String message;

		/**
		 * 
		 * @return The code
		 */
		public int getCode() {
			return code;
		}

		/**
		 * 
		 * @param code
		 *            The code
		 */
		public void setCode(int code) {
			this.code = code;
		}

		/**
		 * 
		 * @return The message
		 */
		public String getMessage() {
			return message;
		}

		/**
		 * 
		 * @param message
		 *            The message
		 */
		public void setMessage(String message) {
			this.message = message;
		}
	}
}