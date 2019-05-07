/*
 * EntityStatus.java
 *
 * Copyright (c) 1990-2014 TYBASOFT, Inc. All Rights Reserved.
 */
package com.quick.pickup.commun;

/**
 * The Enum EntityStatus.
 * 
 * @author M.BEN BOUBKER
 */
public enum EntityStatus {

	/** The enabled. */
	ENABLED("ENABLED"),
	/** The disabled. */
	DISABLED("DISABLED"),
	/** The deleted. */
	DELETED("DELETED");

	/** The status code. */
	private String statusCode;

	/**
	 * Instantiates a new entity status.
	 * 
	 * @param s
	 *            the s
	 */
	private EntityStatus(String s) {
		statusCode = s;
	}

	/**
	 * Gets the status code.
	 * 
	 * @return the status code
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * Gets the statut.
	 * 
	 * @param statutCode
	 *            the statut code
	 * @return the statut
	 */
	public static EntityStatus getStatut(String statutCode) {
		for (EntityStatus e : values()) {
			if (e.statusCode.equals(statutCode)) {
				return e;
			}
		}
		return null;
	}
}
