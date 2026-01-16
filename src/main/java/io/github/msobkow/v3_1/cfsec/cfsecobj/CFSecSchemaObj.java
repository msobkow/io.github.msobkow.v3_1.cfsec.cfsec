// Description: Java 25 Schema Object implementation for CFSec.

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

package io.github.msobkow.v3_1.cfsec.cfsecobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import io.github.msobkow.v3_1.cflib.*;
import io.github.msobkow.v3_1.cflib.dbutil.*;
import io.github.msobkow.v3_1.cfsec.cfsec.*;
import io.github.msobkow.v3_1.cfsec.cfsec.*;

public class CFSecSchemaObj
	implements ICFSecSchemaObj
{
	public static String SCHEMA_NAME = "CFSec";
	public static String SCHEMA_DBNAME = "cfsec31";
	protected ICFSecAuthorization authorization = null;
	protected String secClusterName = "system";
	protected String secTenantName = "system";
	protected String secUserName = "system";
	protected ICFSecClusterObj secCluster = null;
	protected long secClusterId = 0L;
	protected ICFSecTenantObj secTenant = null;
	protected CFLibDbKeyHash256 secTenantId = null;
	protected ICFSecSecUserObj secUser = null;
	protected CFLibDbKeyHash256 secSessionUserId = null;
	protected ICFSecSecSessionObj secSession = null;
	protected CFLibDbKeyHash256 secSessionSessionId = null;
	protected String schemaDbName = SCHEMA_DBNAME;
	protected String lowerDbSchemaName = SCHEMA_DBNAME.toLowerCase();

	protected ICFSecSchema cfsecBackingStore;
	protected ICFSecClusterTableObj clusterTableObj;
	protected ICFSecHostNodeTableObj hostNodeTableObj;
	protected ICFSecISOCcyTableObj iSOCcyTableObj;
	protected ICFSecISOCtryTableObj iSOCtryTableObj;
	protected ICFSecISOCtryCcyTableObj iSOCtryCcyTableObj;
	protected ICFSecISOCtryLangTableObj iSOCtryLangTableObj;
	protected ICFSecISOLangTableObj iSOLangTableObj;
	protected ICFSecISOTZoneTableObj iSOTZoneTableObj;
	protected ICFSecSecDeviceTableObj secDeviceTableObj;
	protected ICFSecSecGroupTableObj secGroupTableObj;
	protected ICFSecSecGrpIncTableObj secGrpIncTableObj;
	protected ICFSecSecGrpMembTableObj secGrpMembTableObj;
	protected ICFSecSecSessionTableObj secSessionTableObj;
	protected ICFSecSecUserTableObj secUserTableObj;
	protected ICFSecServiceTableObj serviceTableObj;
	protected ICFSecServiceTypeTableObj serviceTypeTableObj;
	protected ICFSecSysClusterTableObj sysClusterTableObj;
	protected ICFSecTSecGroupTableObj tSecGroupTableObj;
	protected ICFSecTSecGrpIncTableObj tSecGrpIncTableObj;
	protected ICFSecTSecGrpMembTableObj tSecGrpMembTableObj;
	protected ICFSecTenantTableObj tenantTableObj;

	public CFSecSchemaObj() {

		cfsecBackingStore = null;
		clusterTableObj = new CFSecClusterTableObj( this );
		hostNodeTableObj = new CFSecHostNodeTableObj( this );
		iSOCcyTableObj = new CFSecISOCcyTableObj( this );
		iSOCtryTableObj = new CFSecISOCtryTableObj( this );
		iSOCtryCcyTableObj = new CFSecISOCtryCcyTableObj( this );
		iSOCtryLangTableObj = new CFSecISOCtryLangTableObj( this );
		iSOLangTableObj = new CFSecISOLangTableObj( this );
		iSOTZoneTableObj = new CFSecISOTZoneTableObj( this );
		secDeviceTableObj = new CFSecSecDeviceTableObj( this );
		secGroupTableObj = new CFSecSecGroupTableObj( this );
		secGrpIncTableObj = new CFSecSecGrpIncTableObj( this );
		secGrpMembTableObj = new CFSecSecGrpMembTableObj( this );
		secSessionTableObj = new CFSecSecSessionTableObj( this );
		secUserTableObj = new CFSecSecUserTableObj( this );
		serviceTableObj = new CFSecServiceTableObj( this );
		serviceTypeTableObj = new CFSecServiceTypeTableObj( this );
		sysClusterTableObj = new CFSecSysClusterTableObj( this );
		tSecGroupTableObj = new CFSecTSecGroupTableObj( this );
		tSecGrpIncTableObj = new CFSecTSecGrpIncTableObj( this );
		tSecGrpMembTableObj = new CFSecTSecGrpMembTableObj( this );
		tenantTableObj = new CFSecTenantTableObj( this );
		}

	public void setSecClusterName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				"setClusterName",
				1,
				"value" );
		}
		secClusterName = value;
		secCluster = null;
	}

	public String getSecClusterName() {
		return( secClusterName );
	}

	public ICFSecClusterObj getSecCluster() {
		if( secCluster == null ) {
			if( authorization != null ) {
				secCluster = getClusterTableObj().readClusterByIdIdx( authorization.getSecClusterId() );
			}
			else {
				secCluster = getClusterTableObj().readClusterByUDomNameIdx( secClusterName );
				if( ( secCluster == null ) && ( secClusterId > 0 ) ) {
					secCluster = getClusterTableObj().readClusterByIdIdx( secClusterId );
				}
			}
			if( secCluster != null ) {
				secClusterName = secCluster.getRequiredFullDomName();
				secClusterId = secCluster.getRequiredId();
				if( authorization != null ) {
					authorization.setSecCluster( secCluster );
				}
			}
		}
		return( secCluster );
	}

	public void setSecCluster( ICFSecClusterObj value ) {
		secCluster = value;
		if( secCluster == null ) {
			return;
		}
		secClusterId = secCluster.getRequiredId();
		secClusterName = secCluster.getRequiredFullDomName();
		if( authorization != null ) {
			authorization.setSecCluster( secCluster );
		}
	}

	public long getSecClusterId() {
		return( secClusterId );
	}

	public void setSecTenantName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				"setTenantName",
				1,
				"value" );
		}
		secTenantName = value;
		secTenant = null;
	}

	public String getSecTenantName() {
		return( secTenantName );
	}

	public ICFSecTenantObj getSecTenant() {
		if( secTenant == null ) {
			if( authorization != null ) {
				secTenant = getTenantTableObj().readTenantByIdIdx( authorization.getSecTenantId() );
			}
			else {
				secTenant = getTenantTableObj().readTenantByUNameIdx( getSecCluster().getRequiredId(), secTenantName );
				if( ( secTenant == null && secTenantId != null && !secTenantId.isNull() ) ) {
					secTenant = getTenantTableObj().readTenantByIdIdx( secTenantId );
				}
			}
			if( secTenant != null ) {
				secTenantName = secTenant.getRequiredTenantName();
				secTenantId = secTenant.getRequiredId();
				if( authorization != null ) {
					authorization.setSecTenant( secTenant );
				}
			}
		}
		return( secTenant );
	}

	public void setSecTenant( ICFSecTenantObj value ) {
		secTenant = value;
		if( secTenant == null ) {
			return;
		}
		secTenantId = secTenant.getRequiredId();
		secTenantName = secTenant.getRequiredTenantName();
		if( authorization != null ) {
			authorization.setSecTenant( secTenant );
		}
	}

	public CFLibDbKeyHash256 getSecTenantId() {
		return( secTenantId );
	}

	public void setSecUserName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				"setUserName",
				1,
				"value" );
		}
		secUserName = value;
		secUser = null;
	}

	public String getSecUserName() {
		return( secUserName );
	}

	public ICFSecSecUserObj getSecUser() {
		if( secUser == null ) {
			if( authorization != null ) {
				secUser = getSecUserTableObj().readSecUserByIdIdx( authorization.getSecUserId() );
			}
			else {
				secUser = getSecUserTableObj().readSecUserByULoginIdx( secUserName );
				if( ( secUser == null ) && ( secSessionUserId != null ) ) {
					secUser = getSecUserTableObj().readSecUserByIdIdx( secSessionUserId );
				}
			}
			if( secUser != null ) {
				secUserName = secUser.getRequiredLoginId();
				secSessionUserId = secUser.getRequiredSecUserId();
			}
		}
		return( secUser );
	}

	public void setSecUser( ICFSecSecUserObj value ) {
		secUser = value;
		if( secUser != null ) {
			secUserName = secUser.getRequiredLoginId();
			secSessionUserId = secUser.getRequiredSecUserId();
		}
	}
	public ICFSecSecSessionObj getSecSession() {
		if( secSession == null ) {
			if( authorization != null ) {
				secSession = getSecSessionTableObj().readSecSessionByIdIdx( authorization.getSecSessionId() );
			}
			else if( secSessionSessionId != null ) {
				secSession = getSecSessionTableObj().readSecSessionByIdIdx( secSessionSessionId );
			}
			if( secSession != null ) {
				secSessionSessionId = secSession.getRequiredSecSessionId();
				secSessionUserId = secSession.getRequiredSecUserId();
			}
		}
		return( secSession );
	}

	public void setSecSession( ICFSecSecSessionObj value ) {
		secSession = value;
		if( secSession == null ) {
			return;
		}
		secSessionSessionId = secSession.getRequiredSecSessionId();
		secSessionUserId = secSession.getRequiredSecUserId();
		if( authorization != null ) {
			authorization.setSecSession( secSession );
		}
	}

	public void setSecSessionId( CFLibDbKeyHash256 value ) {
		secSessionSessionId = value;
	}

	public CFLibDbKeyHash256 getSecSessionSessionId() {
		return( secSessionSessionId );
	}

	public CFLibDbKeyHash256 getSecSessionUserId() {
		return( secSessionUserId );
	}

	public ICFSecAuthorization getAuthorization() {
		return( authorization );
	}

	public void setAuthorization( ICFSecAuthorization value ) {
		authorization = value;
	}

	@Override
	public ICFSecSchema getCFSecBackingStore() {
		return( cfsecBackingStore );
	}

	@Override
	public void setCFSecBackingStore(ICFSecSchema cfsecBackingStore) {
		if (cfsecBackingStore == null) {
			throw new CFLibNullArgumentException(getClass(), "setCFSecBackingStore", 1, "cfsecBackingStore");
		}
		this.cfsecBackingStore = cfsecBackingStore;
	}

	public String getSchemaName() {
		return( SCHEMA_NAME );
	}

	public void minimizeMemory() {
		if( clusterTableObj != null ) {
			clusterTableObj.minimizeMemory();
		}
		if( hostNodeTableObj != null ) {
			hostNodeTableObj.minimizeMemory();
		}
		if( iSOCcyTableObj != null ) {
			iSOCcyTableObj.minimizeMemory();
		}
		if( iSOCtryTableObj != null ) {
			iSOCtryTableObj.minimizeMemory();
		}
		if( iSOCtryCcyTableObj != null ) {
			iSOCtryCcyTableObj.minimizeMemory();
		}
		if( iSOCtryLangTableObj != null ) {
			iSOCtryLangTableObj.minimizeMemory();
		}
		if( iSOLangTableObj != null ) {
			iSOLangTableObj.minimizeMemory();
		}
		if( iSOTZoneTableObj != null ) {
			iSOTZoneTableObj.minimizeMemory();
		}
		if( secDeviceTableObj != null ) {
			secDeviceTableObj.minimizeMemory();
		}
		if( secGroupTableObj != null ) {
			secGroupTableObj.minimizeMemory();
		}
		if( secGrpIncTableObj != null ) {
			secGrpIncTableObj.minimizeMemory();
		}
		if( secGrpMembTableObj != null ) {
			secGrpMembTableObj.minimizeMemory();
		}
		if( secSessionTableObj != null ) {
			secSessionTableObj.minimizeMemory();
		}
		if( secUserTableObj != null ) {
			secUserTableObj.minimizeMemory();
		}
		if( serviceTableObj != null ) {
			serviceTableObj.minimizeMemory();
		}
		if( serviceTypeTableObj != null ) {
			serviceTypeTableObj.minimizeMemory();
		}
		if( sysClusterTableObj != null ) {
			sysClusterTableObj.minimizeMemory();
		}
		if( tSecGroupTableObj != null ) {
			tSecGroupTableObj.minimizeMemory();
		}
		if( tSecGrpIncTableObj != null ) {
			tSecGrpIncTableObj.minimizeMemory();
		}
		if( tSecGrpMembTableObj != null ) {
			tSecGrpMembTableObj.minimizeMemory();
		}
		if( tenantTableObj != null ) {
			tenantTableObj.minimizeMemory();
		}
	}

	public void logout() {
		if( authorization == null ) {
			return;
		}
		setAuthorization( null );
		CFLibDbKeyHash256 secSessionId = authorization.getSecSessionId();
		if( secSessionId != null ) {
			ICFSecSecSessionObj secSession = getSecSessionTableObj().readSecSessionByIdIdx( secSessionId );
			if( secSession != null ) {
				if( secSession.getOptionalFinish() == null ) {
					ICFSecSecSessionEditObj editSecSession = secSession.beginEdit();
					editSecSession.setOptionalFinish( LocalDateTime.now() );
					editSecSession.update();
					editSecSession = null;
				}
			}
		}
	}

	public ICFSecClusterTableObj getClusterTableObj() {
		return( clusterTableObj );
	}

	public ICFSecHostNodeTableObj getHostNodeTableObj() {
		return( hostNodeTableObj );
	}

	public ICFSecISOCcyTableObj getISOCcyTableObj() {
		return( iSOCcyTableObj );
	}

	public ICFSecISOCtryTableObj getISOCtryTableObj() {
		return( iSOCtryTableObj );
	}

	public ICFSecISOCtryCcyTableObj getISOCtryCcyTableObj() {
		return( iSOCtryCcyTableObj );
	}

	public ICFSecISOCtryLangTableObj getISOCtryLangTableObj() {
		return( iSOCtryLangTableObj );
	}

	public ICFSecISOLangTableObj getISOLangTableObj() {
		return( iSOLangTableObj );
	}

	public ICFSecISOTZoneTableObj getISOTZoneTableObj() {
		return( iSOTZoneTableObj );
	}

	public ICFSecSecDeviceTableObj getSecDeviceTableObj() {
		return( secDeviceTableObj );
	}

	public ICFSecSecGroupTableObj getSecGroupTableObj() {
		return( secGroupTableObj );
	}

	public ICFSecSecGrpIncTableObj getSecGrpIncTableObj() {
		return( secGrpIncTableObj );
	}

	public ICFSecSecGrpMembTableObj getSecGrpMembTableObj() {
		return( secGrpMembTableObj );
	}

	public ICFSecSecSessionTableObj getSecSessionTableObj() {
		return( secSessionTableObj );
	}

	public ICFSecSecUserTableObj getSecUserTableObj() {
		return( secUserTableObj );
	}

	public ICFSecServiceTableObj getServiceTableObj() {
		return( serviceTableObj );
	}

	public ICFSecServiceTypeTableObj getServiceTypeTableObj() {
		return( serviceTypeTableObj );
	}

	public ICFSecSysClusterTableObj getSysClusterTableObj() {
		return( sysClusterTableObj );
	}

	public ICFSecTSecGroupTableObj getTSecGroupTableObj() {
		return( tSecGroupTableObj );
	}

	public ICFSecTSecGrpIncTableObj getTSecGrpIncTableObj() {
		return( tSecGrpIncTableObj );
	}

	public ICFSecTSecGrpMembTableObj getTSecGrpMembTableObj() {
		return( tSecGrpMembTableObj );
	}

	public ICFSecTenantTableObj getTenantTableObj() {
		return( tenantTableObj );
	}
}
