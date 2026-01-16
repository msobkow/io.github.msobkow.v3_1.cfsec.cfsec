// Description: Java 25 base object instance implementation for Cluster

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

public class CFSecClusterObj
	implements ICFSecClusterObj
{
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFSecClusterEditObj edit;
	protected ICFSecSchemaObj schema;
	protected Long pKey;
	protected ICFSecCluster rec;
	protected List<ICFSecHostNodeObj> optionalComponentsHostNode;
	protected List<ICFSecTenantObj> optionalComponentsTenant;
	protected List<ICFSecSecGroupObj> optionalComponentsSecGroup;
	protected List<ICFSecSysClusterObj> optionalComponentsSysCluster;

	public CFSecClusterObj() {
		isNew = true;
	}

	public CFSecClusterObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
	}

	@Override
	public int getClassCode() {
		return( ((ICFSecSchemaObj)schema).getClusterTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "Cluster" );
	}

	@Override
	public ICFLibAnyObj getObjScope() {
		return( null );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredFullDomName();
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
		if( subObj == null ) {
			subObj = ((ICFSecSchemaObj)getSchema()).getHostNodeTableObj().readHostNodeByHostNameIdx( getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFSecSchemaObj)getSchema()).getTenantTableObj().readTenantByUNameIdx( getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFSecSchemaObj)getSchema()).getSecGroupTableObj().readSecGroupByUNameIdx( getRequiredId(),
				nextName, false );
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
	public ICFSecClusterObj realise() {
		ICFSecClusterObj retobj = ((ICFSecSchemaObj)getSchema()).getClusterTableObj().realiseCluster(
			(ICFSecClusterObj)this );
		return( (ICFSecClusterObj)retobj );
	}

	@Override
	public void forget() {
		((ICFSecSchemaObj)getSchema()).getClusterTableObj().reallyDeepDisposeCluster( (ICFSecClusterObj)this );
	}

	@Override
	public ICFSecClusterObj read() {
		ICFSecClusterObj retobj = ((ICFSecSchemaObj)getSchema()).getClusterTableObj().readClusterByIdIdx( getPKey(), false );
		return( (ICFSecClusterObj)retobj );
	}

	@Override
	public ICFSecClusterObj read( boolean forceRead ) {
		ICFSecClusterObj retobj = ((ICFSecSchemaObj)getSchema()).getClusterTableObj().readClusterByIdIdx( getPKey(), forceRead );
		return( (ICFSecClusterObj)retobj );
	}

	@Override
	public ICFSecClusterTableObj getClusterTable() {
		return( ((ICFSecSchemaObj)getSchema()).getClusterTableObj() );
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
	public ICFSecCluster getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getCFSecBackingStore().getFactoryCluster().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getCFSecBackingStore().getTableCluster().readDerivedByIdIdx( ((ICFSecSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( ICFSecCluster value ) {
		if( ! ( ( value == null ) || ! ( value instanceof ICFSecCluster ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"CFSecClusterRec" );
		}
		rec = value;
		copyRecToPKey();
	}

	@Override
	public ICFSecCluster getClusterRec() {
		return( (ICFSecCluster)getRec() );
	}

	@Override
	public Long getPKey() {
		return( pKey );
	}

	@Override
	public void setPKey( Long value ) {
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
	public ICFSecClusterEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		ICFSecClusterObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFSecClusterObj)this;
		}
		else {
			lockobj = ((ICFSecSchemaObj)getSchema()).getClusterTableObj().lockCluster( getPKey() );
		}
		edit = ((ICFSecSchemaObj)getSchema()).getClusterTableObj().newEditInstance( lockobj );
		return( (ICFSecClusterEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public ICFSecClusterEditObj getEdit() {
		return( edit );
	}

	@Override
	public ICFSecClusterEditObj getEditAsCluster() {
		return( (ICFSecClusterEditObj)edit );
	}

	@Override
	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ICFSecCluster rec = getRec();
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
			ICFSecCluster rec = getRec();
			updatedBy = ((ICFSecSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( getRec().getUpdatedAt() );
	}

	@Override
	public long getRequiredId() {
		return( getPKey() );
	}

	@Override
	public List<ICFSecHostNodeObj> getOptionalComponentsHostNode() {
		List<ICFSecHostNodeObj> retval;
		retval = ((ICFSecSchemaObj)getSchema()).getHostNodeTableObj().readHostNodeByClusterIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ICFSecHostNodeObj> getOptionalComponentsHostNode( boolean forceRead ) {
		List<ICFSecHostNodeObj> retval;
		retval = ((ICFSecSchemaObj)getSchema()).getHostNodeTableObj().readHostNodeByClusterIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ICFSecTenantObj> getOptionalComponentsTenant() {
		List<ICFSecTenantObj> retval;
		retval = ((ICFSecSchemaObj)getSchema()).getTenantTableObj().readTenantByClusterIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ICFSecTenantObj> getOptionalComponentsTenant( boolean forceRead ) {
		List<ICFSecTenantObj> retval;
		retval = ((ICFSecSchemaObj)getSchema()).getTenantTableObj().readTenantByClusterIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ICFSecSecGroupObj> getOptionalComponentsSecGroup() {
		List<ICFSecSecGroupObj> retval;
		retval = ((ICFSecSchemaObj)getSchema()).getSecGroupTableObj().readSecGroupByClusterIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ICFSecSecGroupObj> getOptionalComponentsSecGroup( boolean forceRead ) {
		List<ICFSecSecGroupObj> retval;
		retval = ((ICFSecSchemaObj)getSchema()).getSecGroupTableObj().readSecGroupByClusterIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ICFSecSysClusterObj> getOptionalComponentsSysCluster() {
		List<ICFSecSysClusterObj> retval;
		retval = ((ICFSecSchemaObj)getSchema()).getSysClusterTableObj().readSysClusterByClusterIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ICFSecSysClusterObj> getOptionalComponentsSysCluster( boolean forceRead ) {
		List<ICFSecSysClusterObj> retval;
		retval = ((ICFSecSchemaObj)getSchema()).getSysClusterTableObj().readSysClusterByClusterIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public String getRequiredFullDomName() {
		return( getClusterRec().getRequiredFullDomName() );
	}

	@Override
	public String getRequiredDescription() {
		return( getClusterRec().getRequiredDescription() );
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
