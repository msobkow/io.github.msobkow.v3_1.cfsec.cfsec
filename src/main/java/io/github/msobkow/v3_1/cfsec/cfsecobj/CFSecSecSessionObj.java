// Description: Java 25 base object instance implementation for SecSession

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

public class CFSecSecSessionObj
	implements ICFSecSecSessionObj
{
	protected boolean isNew;
	protected ICFSecSecSessionEditObj edit;
	protected ICFSecSchemaObj schema;
	protected CFLibDbKeyHash256 pKey;
	protected ICFSecSecSession rec;
	protected ICFSecSecUserObj requiredContainerSecUser;
	protected ICFSecSecUserObj requiredParentSecProxy;

	public CFSecSecSessionObj() {
		isNew = true;
		requiredContainerSecUser = null;
		requiredParentSecProxy = null;
	}

	public CFSecSecSessionObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerSecUser = null;
		requiredParentSecProxy = null;
	}

	@Override
	public int getClassCode() {
		return( ((ICFSecSchemaObj)schema).getSecSessionTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecSession" );
	}

	@Override
	public ICFLibAnyObj getObjScope() {
		ICFSecSecUserObj scope = getRequiredContainerSecUser();
		return( scope );
	}

	@Override
	public String getObjName() {
		String objName;
		CFLibDbKeyHash256 val = rec.getRequiredSecSessionId();
		if (val != null) {
			objName = val.toString();
		}
		else {
			objName = "";
		}
		return( objName );
	}

	@Override
	public ICFLibAnyObj getObjQualifier( Class qualifyingClass ) {
		ICFLibAnyObj container = this;
		if( qualifyingClass != null ) {
			while( container != null ) {
				if( container instanceof ICFSecClusterObj ) {
					break;
				}
				else if( container instanceof ICFSecTenantObj ) {
					break;
				}
				else if( qualifyingClass.isInstance( container ) ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		else {
			while( container != null ) {
				if( container instanceof ICFSecClusterObj ) {
					break;
				}
				else if( container instanceof ICFSecTenantObj ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		return( container );
	}

	@Override
	public ICFLibAnyObj getNamedObject( Class qualifyingClass, String objName ) {
		ICFLibAnyObj topContainer = getObjQualifier( qualifyingClass );
		if( topContainer == null ) {
			return( null );
		}
		ICFLibAnyObj namedObject = topContainer.getNamedObject( objName );
		return( namedObject );
	}

	@Override
	public ICFLibAnyObj getNamedObject( String objName ) {
		String nextName;
		String remainingName;
		ICFLibAnyObj subObj = null;
		ICFLibAnyObj retObj;
		int nextDot = objName.indexOf( '.' );
		if( nextDot >= 0 ) {
			nextName = objName.substring( 0, nextDot );
			remainingName = objName.substring( nextDot + 1 );
		}
		else {
			nextName = objName;
			remainingName = null;
		}
		if( remainingName == null ) {
			retObj = subObj;
		}
		else if( subObj == null ) {
			retObj = null;
		}
		else {
			retObj = subObj.getNamedObject( remainingName );
		}
		return( retObj );
	}

	@Override
	public String getObjQualifiedName() {
		String qualName = getObjName();
		ICFLibAnyObj container = getObjScope();
		String containerName;
		while( container != null ) {
			if( container instanceof ICFSecClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFSecTenantObj ) {
				container = null;
			}
			else {
				containerName = container.getObjName();
				qualName = containerName + "." + qualName;
				container = container.getObjScope();
			}
		}
		return( qualName );
	}

	@Override
	public String getObjFullName() {
		String fullName = getObjName();
		ICFLibAnyObj container = getObjScope();
		String containerName;
		while( container != null ) {
			if( container instanceof ICFSecClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFSecTenantObj ) {
				container = null;
			}
			else {
				containerName = container.getObjName();
				fullName = containerName + "." + fullName;
				container = container.getObjScope();
			}
		}
		return( fullName );
	}

	@Override
	public ICFSecSecSessionObj realise() {
		ICFSecSecSessionObj retobj = ((ICFSecSchemaObj)getSchema()).getSecSessionTableObj().realiseSecSession(
			(ICFSecSecSessionObj)this );
		return( (ICFSecSecSessionObj)retobj );
	}

	@Override
	public void forget() {
		((ICFSecSchemaObj)getSchema()).getSecSessionTableObj().reallyDeepDisposeSecSession( (ICFSecSecSessionObj)this );
	}

	@Override
	public ICFSecSecSessionObj read() {
		ICFSecSecSessionObj retobj = ((ICFSecSchemaObj)getSchema()).getSecSessionTableObj().readSecSessionByIdIdx( getPKey(), false );
		return( (ICFSecSecSessionObj)retobj );
	}

	@Override
	public ICFSecSecSessionObj read( boolean forceRead ) {
		ICFSecSecSessionObj retobj = ((ICFSecSchemaObj)getSchema()).getSecSessionTableObj().readSecSessionByIdIdx( getPKey(), forceRead );
		return( (ICFSecSecSessionObj)retobj );
	}

	@Override
	public ICFSecSecSessionTableObj getSecSessionTable() {
		return( ((ICFSecSchemaObj)getSchema()).getSecSessionTableObj() );
	}

	@Override
	public ICFSecSchemaObj getSchema() {
		return( schema );
	}

	@Override
	public void setSchema( ICFSecSchemaObj value ) {
		schema = value;
	}

	@Override
	public ICFSecSecSession getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getCFSecBackingStore().getFactorySecSession().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getCFSecBackingStore().getTableSecSession().readDerivedByIdIdx( ((ICFSecSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( ICFSecSecSession value ) {
		if( ! ( ( value == null ) || ! ( value instanceof ICFSecSecSession ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"CFSecSecSessionRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredContainerSecUser = null;
		requiredParentSecProxy = null;
	}

	@Override
	public ICFSecSecSession getSecSessionRec() {
		return( (ICFSecSecSession)getRec() );
	}

	@Override
	public CFLibDbKeyHash256 getPKey() {
		return( pKey );
	}

	@Override
	public void setPKey( CFLibDbKeyHash256 value ) {
		if( pKey != value ) {
       		pKey = value;
			copyPKeyToRec();
		}
	}

	@Override
	public boolean getIsNew() {
		return( isNew );
	}

	@Override
	public void setIsNew( boolean value ) {
		isNew = value;
	}

	@Override
	public ICFSecSecSessionEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		ICFSecSecSessionObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFSecSecSessionObj)this;
		}
		else {
			lockobj = ((ICFSecSchemaObj)getSchema()).getSecSessionTableObj().lockSecSession( getPKey() );
		}
		edit = ((ICFSecSchemaObj)getSchema()).getSecSessionTableObj().newEditInstance( lockobj );
		return( (ICFSecSecSessionEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public ICFSecSecSessionEditObj getEdit() {
		return( edit );
	}

	@Override
	public ICFSecSecSessionEditObj getEditAsSecSession() {
		return( (ICFSecSecSessionEditObj)edit );
	}

	@Override
	public CFLibDbKeyHash256 getRequiredSecSessionId() {
		return( getPKey() );
	}

	@Override
	public ICFSecSecUserObj getRequiredContainerSecUser() {
		return( getRequiredContainerSecUser( false ) );
	}

	@Override
	public ICFSecSecUserObj getRequiredContainerSecUser( boolean forceRead ) {
		if( ( requiredContainerSecUser == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerSecUser = ((ICFSecSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( getSecSessionRec().getRequiredSecUserId(), forceRead );
			}
		}
		return( requiredContainerSecUser );
	}

	@Override
	public ICFSecSecUserObj getRequiredParentSecProxy() {
		return( getRequiredParentSecProxy( false ) );
	}

	@Override
	public ICFSecSecUserObj getRequiredParentSecProxy( boolean forceRead ) {
		if( ( requiredParentSecProxy == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getSecSessionRec().getOptionalSecProxyId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				requiredParentSecProxy = ((ICFSecSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( getSecSessionRec().getOptionalSecProxyId(), forceRead );
			}
		}
		return( requiredParentSecProxy );
	}

	@Override
	public CFLibDbKeyHash256 getRequiredSecUserId() {
		return( getSecSessionRec().getRequiredSecUserId() );
	}

	@Override
	public String getOptionalSecDevName() {
		return( getSecSessionRec().getOptionalSecDevName() );
	}

	@Override
	public LocalDateTime getRequiredStart() {
		return( getSecSessionRec().getRequiredStart() );
	}

	@Override
	public LocalDateTime getOptionalFinish() {
		return( getSecSessionRec().getOptionalFinish() );
	}

	@Override
	public CFLibDbKeyHash256 getOptionalSecProxyId() {
		return( getSecSessionRec().getOptionalSecProxyId() );
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			if (getPKey() != rec.getPKey()) {
				rec.setPKey(getPKey());
			}
		}
		if( edit != null ) {
			edit.copyPKeyToRec();
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			if (getPKey() != rec.getPKey()) {
				setPKey(rec.getPKey());
			}
		}
	}
}
