/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.slee.resource.xcapclient.handler;

import java.net.URI;

import org.mobicents.slee.resource.xcapclient.XCAPClientResourceAdaptor;
import org.mobicents.slee.resource.xcapclient.XCAPResourceAdaptorActivityHandle;
import org.mobicents.xcap.client.XcapResponse;
import org.mobicents.xcap.client.auth.Credentials;
import org.mobicents.xcap.client.header.Header;

/**
 * Handles an async delete if ETag matches none request.
 * 
 * @author emmartins
 * 
 */
public class AsyncDeleteIfNoneMatchHandler extends AbstractAsyncHandler {

	protected String eTag;

	public AsyncDeleteIfNoneMatchHandler(XCAPClientResourceAdaptor ra,
			XCAPResourceAdaptorActivityHandle handle, URI uri, String eTag,
			Header[] additionalRequestHeaders, Credentials credentials) {
		super(ra, handle, ra.getDeleteResponseEventType(), uri, additionalRequestHeaders, credentials);
		this.eTag = eTag;
	}

	@Override
	protected XcapResponse doRequest() throws Exception {
		return ra.getClient().deleteIfNoneMatch(uri, eTag,
				additionalRequestHeaders, credentials);
	}

}