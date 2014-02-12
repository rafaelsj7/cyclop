package org.cyclop.service.cassandra.impl;

import net.jcip.annotations.NotThreadSafe;
import org.cyclop.model.CqlKeySpace;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import javax.inject.Named;

/** @author Maciej Miklas */
@NotThreadSafe
@Named
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
// TODO move from impl package because CompletionHelper references it
public class QueryScope {

	private CqlKeySpace activeKeySpace;

	public CqlKeySpace getActiveKeySpace() {
		return activeKeySpace;
	}

	protected void setActiveKeySpace(CqlKeySpace activeSpace) {
		this.activeKeySpace = activeSpace;
	}
}
