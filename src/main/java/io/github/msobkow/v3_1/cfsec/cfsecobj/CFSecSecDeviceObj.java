// Description: Java 25 base object instance implementation for SecDevice

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

public class CFSecSecDeviceObj
	implements ICFSecSecDeviceObj
{
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFSecSecDeviceEditObj edit;
	protected ICFSecSchemaObj schema;
	protected ICFSecSecDevicePKey pKey;
	protected ICFSecSecDevice rec;
	protected ICFSecSecUserObj requiredContainerSecUser;

	public CFSecSecDeviceObj() {
		isNew = true;
		requiredContainerSecUser = null;
	}

	public CFSecSecDeviceObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerSecUser = null;
	}

	@Override
	public int getClassCode() {
		return( ((ICFSecSchemaObj)schema).getSecDeviceTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecDevice" );
	}

	@Override
	public ICFLibAnyObj getObjScope() {
		ICFSecSecUserObj scope = getRequiredContainerSecUser();
		return( scope );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredDevName();
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
	public ICFSecSecDeviceObj realise() {
		ICFSecSecDeviceObj retobj = ((ICFSecSchemaObj)getSchema()).getSecDeviceTableObj().realiseSecDevice(
			(ICFSecSecDeviceObj)this );
		return( (ICFSecSecDeviceObj)retobj );
	}

	@Override
	public void forget() {
		((ICFSecSchemaObj)getSchema()).getSecDeviceTableObj().reallyDeepDisposeSecDevice( (ICFSecSecDeviceObj)this );
	}

	@Override
	public ICFSecSecDeviceObj read() {
		ICFSecSecDeviceObj retobj = ((ICFSecSchemaObj)getSchema()).getSecDeviceTableObj().readSecDeviceByIdIdx( getPKey().getRequiredSecUserId(),
			getPKey().getRequiredDevName(), false );
		return( (ICFSecSecDeviceObj)retobj );
	}

	@Override
	public ICFSecSecDeviceObj read( boolean forceRead ) {
		ICFSecSecDeviceObj retobj = ((ICFSecSchemaObj)getSchema()).getSecDeviceTableObj().readSecDeviceByIdIdx( getPKey().getRequiredSecUserId(),
			getPKey().getRequiredDevName(), forceRead );
		return( (ICFSecSecDeviceObj)retobj );
	}

	@Override
	public ICFSecSecDeviceTableObj getSecDeviceTable() {
		return( ((ICFSecSchemaObj)getSchema()).getSecDeviceTableObj() );
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
	public ICFSecSecDevice getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getCFSecBackingStore().getFactorySecDevice().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getCFSecBackingStore().getTableSecDevice().readDerivedByIdIdx( ((ICFSecSchemaObj)getSchema()).getAuthorization(),
						getPKey().getRequiredSecUserId(),
						getPKey().getRequiredDevName() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( ICFSecSecDevice value ) {
		if( ! ( ( value == null ) || ! ( value instanceof ICFSecSecDevice ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"CFSecSecDeviceRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredContainerSecUser = null;
	}

	@Override
	public ICFSecSecDevice getSecDeviceRec() {
		return( (ICFSecSecDevice)getRec() );
	}

	@Override
	public ICFSecSecDevicePKey getPKey() {
		if( pKey == null ) {
			pKey = getSchema().getCFSecBackingStore().getFactorySecDevice().newPKey();
		}
		return( pKey );
	}

	@Override
	public void setPKey( ICFSecSecDevicePKey value ) {
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
	public ICFSecSecDeviceEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		ICFSecSecDeviceObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFSecSecDeviceObj)this;
		}
		else {
			lockobj = ((ICFSecSchemaObj)getSchema()).getSecDeviceTableObj().lockSecDevice( getPKey() );
		}
		edit = ((ICFSecSchemaObj)getSchema()).getSecDeviceTableObj().newEditInstance( lockobj );
		return( (ICFSecSecDeviceEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public ICFSecSecDeviceEditObj getEdit() {
		return( edit );
	}

	@Override
	public ICFSecSecDeviceEditObj getEditAsSecDevice() {
		return( (ICFSecSecDeviceEditObj)edit );
	}

	@Override
	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ICFSecSecDevice rec = getRec();
			createdBy = ((ICFSecSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getCreatedByUserId() );
		}
		return( createdBy );
	}

	@Override
	public LocalDateTime getCreatedAt() {
		return( getRec().getCreatedAt() );
	}

	@Override
	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			ICFSecSecDevice rec = getRec();
			updatedBy = ((ICFSecSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( getRec().getUpdatedAt() );
	}

	@Override
	public CFLibDbKeyHash256 getRequiredSecUserId() {
		return( getPKey().getRequiredSecUserId() );
	}

	@Override
	public String getRequiredDevName() {
		return( getPKey().getRequiredDevName() );
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
				requiredContainerSecUser = ((ICFSecSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( getPKey().getRequiredSecUserId(), forceRead );
			}
		}
		return( requiredContainerSecUser );
	}

	@Override
	public String getOptionalPubKey() {
		return( getSecDeviceRec().getOptionalPubKey() );
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			rec.getPKey().setRequiredContainerSecUser(getPKey().getRequiredContainerSecUser());
			rec.getPKey().setRequiredDevName(getPKey().getRequiredDevName());
		}
		if( edit != null ) {
			edit.copyPKeyToRec();
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			getPKey().setRequiredContainerSecUser(rec.getPKey().getRequiredContainerSecUser());
			getPKey().setRequiredDevName(rec.getPKey().getRequiredDevName());
		}
	}
}
