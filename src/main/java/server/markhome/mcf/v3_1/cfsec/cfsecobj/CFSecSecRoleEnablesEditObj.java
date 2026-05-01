// Description: Java 25 edit object instance implementation for CFSec SecRoleEnables.

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

public class CFSecSecRoleEnablesEditObj
	implements ICFSecSecRoleEnablesEditObj
{
	protected ICFSecSecRoleEnablesObj orig;
	protected ICFSecSecRoleEnables rec;
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected ICFSecSecRoleObj requiredContainerRole;
	protected ICFSecSecSysGrpObj requiredParentEnableGroup;

	public CFSecSecRoleEnablesEditObj( ICFSecSecRoleEnablesObj argOrig ) {
		orig = argOrig;
		getRec();
		ICFSecSecRoleEnables origRec = orig.getRec();
		rec.set( origRec );
		requiredContainerRole = null;
		requiredParentEnableGroup = null;
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
	public void setCreatedBy( ICFSecSecUserObj value ) {
		createdBy = value;
		if( value != null ) {
			getRec().setCreatedByUserId( value.getRequiredSecUserId() );
		}
	}

	@Override
	public void setCreatedAt( LocalDateTime value ) {
		getRec().setCreatedAt( value );
	}

	@Override
	public void setUpdatedBy( ICFSecSecUserObj value ) {
		updatedBy = value;
		if( value != null ) {
			getRec().setUpdatedByUserId( value.getRequiredSecUserId() );
		}
	}

	@Override
	public void setUpdatedAt( LocalDateTime value ) {
		getRec().setUpdatedAt( value );
	}

	@Override
	public int getClassCode() {
		return( ((ICFSecSchemaObj)orig.getSchema()).getSecRoleEnablesTableObj().getClassCode() );
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
		// We realise this so that it's record will get copied to orig during realization
		ICFSecSecRoleEnablesObj retobj = getSchema().getSecRoleEnablesTableObj().realiseSecRoleEnables( (ICFSecSecRoleEnablesObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSecRoleEnables().forget();
	}

	@Override
	public ICFSecSecRoleEnablesObj read() {
		ICFSecSecRoleEnablesObj retval = getOrigAsSecRoleEnables().read();
		if( retval != orig ) {
			throw new CFLibStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ICFSecSecRoleEnablesObj read( boolean forceRead ) {
		ICFSecSecRoleEnablesObj retval = getOrigAsSecRoleEnables().read( forceRead );
		if( retval != orig ) {
			throw new CFLibStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ICFSecSecRoleEnablesObj create() {
		copyRecToOrig();
		ICFSecSecRoleEnablesObj retobj = ((ICFSecSchemaObj)getOrigAsSecRoleEnables().getSchema()).getSecRoleEnablesTableObj().createSecRoleEnables( getOrigAsSecRoleEnables() );
		if( retobj == getOrigAsSecRoleEnables() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public CFSecSecRoleEnablesEditObj update() {
		getSchema().getSecRoleEnablesTableObj().updateSecRoleEnables( (ICFSecSecRoleEnablesObj)this );
		return( null );
	}

	@Override
	public CFSecSecRoleEnablesEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSecRoleEnablesTableObj().deleteSecRoleEnables( getOrigAsSecRoleEnables() );
		return( null );
	}

	@Override
	public ICFSecSecRoleEnablesTableObj getSecRoleEnablesTable() {
		return( orig.getSchema().getSecRoleEnablesTableObj() );
	}

	@Override
	public ICFSecSecRoleEnablesEditObj getEdit() {
		return( (ICFSecSecRoleEnablesEditObj)this );
	}

	@Override
	public ICFSecSecRoleEnablesEditObj getEditAsSecRoleEnables() {
		return( (ICFSecSecRoleEnablesEditObj)this );
	}

	@Override
	public ICFSecSecRoleEnablesEditObj beginEdit() {
		throw new CFLibEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ICFSecSecRoleEnablesObj getOrig() {
		return( orig );
	}

	@Override
	public ICFSecSecRoleEnablesObj getOrigAsSecRoleEnables() {
		return( (ICFSecSecRoleEnablesObj)orig );
	}

	@Override
	public ICFSecSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	@Override
	public void setSchema( ICFSecSchemaObj value ) {
		orig.setSchema(value);
	}

	@Override
	public ICFSecSecRoleEnables getRec() {
		if( rec == null ) {
			rec = getOrigAsSecRoleEnables().getSchema().getCFSecBackingStore().getFactorySecRoleEnables().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ICFSecSecRoleEnables value ) {
		if( rec != value ) {
			rec = value;
			requiredContainerRole = null;
			requiredParentEnableGroup = null;
		}
	}

	@Override
	public ICFSecSecRoleEnables getSecRoleEnablesRec() {
		return( (ICFSecSecRoleEnables)getRec() );
	}

	@Override
	public ICFSecSecRoleEnablesPKey getPKey() {
		return( orig.getPKey() );
	}

	@Override
	public void setPKey( ICFSecSecRoleEnablesPKey value ) {
		orig.setPKey( value );
		copyPKeyToRec();
	}

	@Override
	public boolean getIsNew() {
		return( orig.getIsNew() );
	}

	@Override
	public void setIsNew( boolean value ) {
		orig.setIsNew( value );
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
		if( forceRead || ( requiredContainerRole == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFSecSecRoleObj obj = ((ICFSecSchemaObj)getOrigAsSecRoleEnables().getSchema()).getSecRoleTableObj().readSecRoleByIdIdx( getPKey().getRequiredSecRoleId() );
				requiredContainerRole = obj;
				if( obj != null ) {
					requiredContainerRole = obj;
				}
			}
		}
		return( requiredContainerRole );
	}

	@Override
	public void setRequiredContainerRole( ICFSecSecRoleObj value ) {
		if( rec == null ) {
			getSecRoleEnablesRec();
		}
		if( value != null ) {
			requiredContainerRole = value;
			getSecRoleEnablesRec().setRequiredContainerRole(value.getSecRoleRec());
		}
		requiredContainerRole = value;
	}

	@Override
	public ICFSecSecSysGrpObj getRequiredParentEnableGroup() {
		return( getRequiredParentEnableGroup( false ) );
	}

	@Override
	public ICFSecSecSysGrpObj getRequiredParentEnableGroup( boolean forceRead ) {
		if( forceRead || ( requiredParentEnableGroup == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFSecSecSysGrpObj obj = ((ICFSecSchemaObj)getOrigAsSecRoleEnables().getSchema()).getSecSysGrpTableObj().readSecSysGrpByUNameIdx( getPKey().getRequiredEnableName() );
				requiredParentEnableGroup = obj;
			}
		}
		return( requiredParentEnableGroup );
	}

	@Override
	public void setRequiredParentEnableGroup( ICFSecSecSysGrpObj value ) {
		if( rec == null ) {
			getSecRoleEnablesRec();
		}
		if( value != null ) {
			requiredParentEnableGroup = value;
			getSecRoleEnablesRec().setRequiredParentEnableGroup(value.getSecSysGrpRec());
		}
		else {
			requiredParentEnableGroup = null;
			getSecRoleEnablesRec().setRequiredParentEnableGroup((ICFSecSecSysGrp)null);
		}
		requiredParentEnableGroup = value;
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			rec.getPKey().setRequiredContainerRole(getPKey().getRequiredContainerRole());
			rec.getPKey().setRequiredParentEnableGroup(getPKey().getRequiredParentEnableGroup());
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			getPKey().setRequiredContainerRole(rec.getPKey().getRequiredContainerRole());
			getPKey().setRequiredParentEnableGroup(rec.getPKey().getRequiredParentEnableGroup());
		}
	}

	@Override
	public void copyRecToOrig() {
		ICFSecSecRoleEnables origRec = getOrigAsSecRoleEnables().getSecRoleEnablesRec();
		ICFSecSecRoleEnables myRec = getSecRoleEnablesRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ICFSecSecRoleEnables origRec = getOrigAsSecRoleEnables().getSecRoleEnablesRec();
		ICFSecSecRoleEnables myRec = getSecRoleEnablesRec();
		myRec.set( origRec );
	}
}
