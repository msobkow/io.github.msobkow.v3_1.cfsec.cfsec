// Description: Java 25 base object instance implementation for SecRoleEnables

/*
 *	server.markhome.mcf.CFSec
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFSec - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Mark's Code Fractal CFSec.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.mcf.v3_1.cfsec.cfsecobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.xml.CFLibXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;

public class CFSecSecRoleEnablesObj
	implements ICFSecSecRoleEnablesObj
{
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFSecSecRoleEnablesEditObj edit;
	protected ICFSecSchemaObj schema;
	protected ICFSecSecRoleEnablesPKey pKey;
	protected ICFSecSecRoleEnables rec;
	protected ICFSecSecRoleObj requiredContainerRole;
	protected ICFSecSecSysGrpObj requiredParentEnableGroup;

	public CFSecSecRoleEnablesObj() {
		isNew = true;
		requiredContainerRole = null;
		requiredParentEnableGroup = null;
	}

	public CFSecSecRoleEnablesObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerRole = null;
		requiredParentEnableGroup = null;
	}

	@Override
	public int getClassCode() {
		return( ((ICFSecSchemaObj)schema).getSecRoleEnablesTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecRoleEnables" );
	}

	@Override
	public ICFLibAnyObj getObjScope() {
		ICFSecSecRoleObj scope = getRequiredContainerRole();
		return( scope );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredEnableName();
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
	public ICFSecSecRoleEnablesObj realise() {
		ICFSecSecRoleEnablesObj retobj = ((ICFSecSchemaObj)getSchema()).getSecRoleEnablesTableObj().realiseSecRoleEnables(
			(ICFSecSecRoleEnablesObj)this );
		return( (ICFSecSecRoleEnablesObj)retobj );
	}

	@Override
	public void forget() {
		((ICFSecSchemaObj)getSchema()).getSecRoleEnablesTableObj().reallyDeepDisposeSecRoleEnables( (ICFSecSecRoleEnablesObj)this );
	}

	@Override
	public ICFSecSecRoleEnablesObj read() {
		ICFSecSecRoleEnablesObj retobj = ((ICFSecSchemaObj)getSchema()).getSecRoleEnablesTableObj().readSecRoleEnablesByIdIdx( getPKey().getRequiredSecRoleId(),
			getPKey().getRequiredEnableName(), false );
		return( (ICFSecSecRoleEnablesObj)retobj );
	}

	@Override
	public ICFSecSecRoleEnablesObj read( boolean forceRead ) {
		ICFSecSecRoleEnablesObj retobj = ((ICFSecSchemaObj)getSchema()).getSecRoleEnablesTableObj().readSecRoleEnablesByIdIdx( getPKey().getRequiredSecRoleId(),
			getPKey().getRequiredEnableName(), forceRead );
		return( (ICFSecSecRoleEnablesObj)retobj );
	}

	@Override
	public ICFSecSecRoleEnablesTableObj getSecRoleEnablesTable() {
		return( ((ICFSecSchemaObj)getSchema()).getSecRoleEnablesTableObj() );
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
	public ICFSecSecRoleEnables getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getCFSecBackingStore().getFactorySecRoleEnables().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getCFSecBackingStore().getTableSecRoleEnables().readDerivedByIdIdx( ((ICFSecSchemaObj)getSchema()).getAuthorization(),
						getPKey().getRequiredSecRoleId(),
						getPKey().getRequiredEnableName() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( ICFSecSecRoleEnables value ) {
		if( ! ( ( value == null ) || ! ( value instanceof ICFSecSecRoleEnables ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"CFSecSecRoleEnablesRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredContainerRole = null;
		requiredParentEnableGroup = null;
	}

	@Override
	public ICFSecSecRoleEnables getSecRoleEnablesRec() {
		return( (ICFSecSecRoleEnables)getRec() );
	}

	@Override
	public ICFSecSecRoleEnablesPKey getPKey() {
		if( pKey == null ) {
			pKey = getSchema().getCFSecBackingStore().getFactorySecRoleEnables().newPKey();
		}
		return( pKey );
	}

	@Override
	public void setPKey( ICFSecSecRoleEnablesPKey value ) {
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
	public ICFSecSecRoleEnablesEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		ICFSecSecRoleEnablesObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFSecSecRoleEnablesObj)this;
		}
		else {
			lockobj = ((ICFSecSchemaObj)getSchema()).getSecRoleEnablesTableObj().lockSecRoleEnables( getPKey() );
		}
		edit = ((ICFSecSchemaObj)getSchema()).getSecRoleEnablesTableObj().newEditInstance( lockobj );
		return( (ICFSecSecRoleEnablesEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public ICFSecSecRoleEnablesEditObj getEdit() {
		return( edit );
	}

	@Override
	public ICFSecSecRoleEnablesEditObj getEditAsSecRoleEnables() {
		return( (ICFSecSecRoleEnablesEditObj)edit );
	}

	@Override
	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ICFSecSecRoleEnables rec = getRec();
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
			ICFSecSecRoleEnables rec = getRec();
			updatedBy = ((ICFSecSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( getRec().getUpdatedAt() );
	}

	@Override
	public CFLibDbKeyHash256 getRequiredSecRoleId() {
		return( getPKey().getRequiredSecRoleId() );
	}

	@Override
	public String getRequiredEnableName() {
		return( getPKey().getRequiredEnableName() );
	}

	@Override
	public ICFSecSecRoleObj getRequiredContainerRole() {
		return( getRequiredContainerRole( false ) );
	}

	@Override
	public ICFSecSecRoleObj getRequiredContainerRole( boolean forceRead ) {
		if( ( requiredContainerRole == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerRole = ((ICFSecSchemaObj)getSchema()).getSecRoleTableObj().readSecRoleByIdIdx( getPKey().getRequiredSecRoleId(), forceRead );
			}
		}
		return( requiredContainerRole );
	}

	@Override
	public ICFSecSecSysGrpObj getRequiredParentEnableGroup() {
		return( getRequiredParentEnableGroup( false ) );
	}

	@Override
	public ICFSecSecSysGrpObj getRequiredParentEnableGroup( boolean forceRead ) {
		if( ( requiredParentEnableGroup == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredParentEnableGroup = ((ICFSecSchemaObj)getSchema()).getSecSysGrpTableObj().readSecSysGrpByUNameIdx( getPKey().getRequiredEnableName(), forceRead );
			}
		}
		return( requiredParentEnableGroup );
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			rec.getPKey().setRequiredContainerRole(getPKey().getRequiredContainerRole());
			rec.getPKey().setRequiredParentEnableGroup(getPKey().getRequiredParentEnableGroup());
		}
		if( edit != null ) {
			edit.copyPKeyToRec();
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			getPKey().setRequiredContainerRole(rec.getPKey().getRequiredContainerRole());
			getPKey().setRequiredParentEnableGroup(rec.getPKey().getRequiredParentEnableGroup());
		}
	}
}
