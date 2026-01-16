// Description: Java 25 CFSec Authorization Implementation

/*
 *	io.github.msobkow.CFSec
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFSec - Security Services
 *	
 *	This file is part of Mark's Code Fractal CFSec.
 *	
 *	Mark's Code Fractal CFSec is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU Library General Public License,
 *	Version 3 or later.
 *	
 *	Mark's Code Fractal CFSec is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU Library General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFSec is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU Library General Public License
 *	along with Mark's Code Fractal CFSec.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes in order to
 *	tie it to proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 *	
 */

package io.github.msobkow.v3_1.cfsec.cfsec;

import java.lang.reflect.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import io.github.msobkow.v3_1.cflib.*;
import io.github.msobkow.v3_1.cflib.dbutil.*;
import io.github.msobkow.v3_1.cfsec.cfsecobj.ICFSecClusterObj;
import io.github.msobkow.v3_1.cfsec.cfsecobj.ICFSecTenantObj;
import io.github.msobkow.v3_1.cfsec.cfsecobj.ICFSecSecSessionObj;

/*
 *	A CFSecAuthorization is an authorization ticket
 *	for the system providing services.  Most modern authorizations
 *      are based on OAuth2 tickets, but I haven't gotten there yet...
 */
public class CFSecAuthorization implements ICFSecAuthorization, Serializable
{
	protected CFLibUuid6 authUuid6;
	protected String authUuid6Str;

	protected long secClusterId = 0L;
	protected CFLibDbKeyHash256 secTenantId = new CFLibDbKeyHash256(0);
	protected CFLibDbKeyHash256 secSessionId = new CFLibDbKeyHash256(0);
	protected CFLibDbKeyHash256 secUserId = new CFLibDbKeyHash256(0);

	public CFSecAuthorization() {
		authUuid6 = CFLibUuid6.generateUuid6();
		authUuid6Str = authUuid6.toString();
	}

	public CFLibUuid6 getAuthUuid6() {
		return( authUuid6 );
	}

	public void setAuthUuid6( CFLibUuid6 value ) {
		authUuid6 = value;
		authUuid6Str = authUuid6.toString();
	}

	public String getAuthUuid6Str() {
		return( authUuid6Str );
	}

	public long getSecClusterId() {
		return( secClusterId );
	}

	public void setSecClusterId( long clusterId ) {
		secClusterId = clusterId;
	}

	public void setSecCluster( ICFSecClusterObj value ) {
		// The cluster id is never cleared to 0 after it's been set
		if( value != null ) {
			secClusterId = value.getRequiredId();
		}
	}

	public CFLibDbKeyHash256 getSecTenantId() {
		return( secTenantId );
	}

	public void setSecTenantId( CFLibDbKeyHash256 tenantId ) {
		secTenantId = tenantId;
	}

	public void setSecTenant( ICFSecTenantObj value ) {
		// The tenant id is never cleared to 0 after it's been set
		if( value != null ) {
			secTenantId = value.getRequiredId();
		}
	}

	public CFLibDbKeyHash256 getSecSessionId() {
		return( secSessionId );
	}

	public void setSecSessionId( CFLibDbKeyHash256 sessionId ) {
		secSessionId = sessionId;
	}

	public void setSecSession( ICFSecSecSessionObj value )
	{
		// The session and user id are never cleared after they've been set
		if( value != null ) {
			secSessionId = value.getRequiredSecSessionId();
			secUserId = value.getRequiredSecUserId();
		}
	}

	public CFLibDbKeyHash256 getSecUserId() {
		return( secUserId );
	}

	public void setSecUserId( CFLibDbKeyHash256 userId ) {
		secUserId = userId;
	}
}
