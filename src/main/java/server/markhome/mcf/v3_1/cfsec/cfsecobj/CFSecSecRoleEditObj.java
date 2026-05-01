// Description: Java 25 edit object instance implementation for CFSec SecRole.

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

public class CFSecSecRoleEditObj
	implements ICFSecSecRoleEditObj
{
	protected ICFSecSecRoleObj orig;
	protected ICFSecSecRole rec;
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected List<ICFSecSecRoleEnablesObj> optionalChildrenEnabledByRole;
	protected List<ICFSecSecRoleMembObj> optionalChildrenMembByRole;

	public CFSecSecRoleEditObj( ICFSecSecRoleObj argOrig ) {
		orig = argOrig;
		getRec();
		ICFSecSecRole origRec = orig.getRec();
		rec.set( origRec );
	}

	@Override
	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ICFSecSecRole rec = getRec();
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
			ICFSecSecRole rec = getRec();
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
		return( ((ICFSecSchemaObj)orig.getSchema()).getSecRoleTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecRole" );
	}

	@Override
	public ICFLibAnyObj getObjScope() {
		return( null );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredName();
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
	public ICFSecSecRoleObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ICFSecSecRoleObj retobj = getSchema().getSecRoleTableObj().realiseSecRole( (ICFSecSecRoleObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSecRole().forget();
	}

	@Override
	public ICFSecSecRoleObj read() {
		ICFSecSecRoleObj retval = getOrigAsSecRole().read();
		if( retval != orig ) {
			throw new CFLibStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ICFSecSecRoleObj read( boolean forceRead ) {
		ICFSecSecRoleObj retval = getOrigAsSecRole().read( forceRead );
		if( retval != orig ) {
			throw new CFLibStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ICFSecSecRoleObj create() {
		copyRecToOrig();
		ICFSecSecRoleObj retobj = ((ICFSecSchemaObj)getOrigAsSecRole().getSchema()).getSecRoleTableObj().createSecRole( getOrigAsSecRole() );
		if( retobj == getOrigAsSecRole() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public CFSecSecRoleEditObj update() {
		getSchema().getSecRoleTableObj().updateSecRole( (ICFSecSecRoleObj)this );
		return( null );
	}

	@Override
	public CFSecSecRoleEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSecRoleTableObj().deleteSecRole( getOrigAsSecRole() );
		return( null );
	}

	@Override
	public ICFSecSecRoleTableObj getSecRoleTable() {
		return( orig.getSchema().getSecRoleTableObj() );
	}

	@Override
	public ICFSecSecRoleEditObj getEdit() {
		return( (ICFSecSecRoleEditObj)this );
	}

	@Override
	public ICFSecSecRoleEditObj getEditAsSecRole() {
		return( (ICFSecSecRoleEditObj)this );
	}

	@Override
	public ICFSecSecRoleEditObj beginEdit() {
		throw new CFLibEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ICFSecSecRoleObj getOrig() {
		return( orig );
	}

	@Override
	public ICFSecSecRoleObj getOrigAsSecRole() {
		return( (ICFSecSecRoleObj)orig );
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
	public ICFSecSecRole getRec() {
		if( rec == null ) {
			rec = getOrigAsSecRole().getSchema().getCFSecBackingStore().getFactorySecRole().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ICFSecSecRole value ) {
		if( rec != value ) {
			rec = value;
		}
	}

	@Override
	public ICFSecSecRole getSecRoleRec() {
		return( (ICFSecSecRole)getRec() );
	}

	@Override
	public CFLibDbKeyHash256 getPKey() {
		return( orig.getPKey() );
	}

	@Override
	public void setPKey( CFLibDbKeyHash256 value ) {
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
		return( getPKey() );
	}

	@Override
	public void setRequiredSecRoleId(CFLibDbKeyHash256 value) {
		if (getPKey() != value) {
			setPKey(value);
			optionalChildrenEnabledByRole = null;
			optionalChildrenMembByRole = null;
		}
	}

	@Override
	public String getRequiredName() {
		return( getSecRoleRec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getSecRoleRec().getRequiredName() != value ) {
			getSecRoleRec().setRequiredName( value );
		}
	}

	@Override
	public List<ICFSecSecRoleEnablesObj> getOptionalChildrenEnabledByRole() {
		List<ICFSecSecRoleEnablesObj> retval;
		retval = ((ICFSecSchemaObj)getSchema()).getSecRoleEnablesTableObj().readSecRoleEnablesByRoleIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ICFSecSecRoleEnablesObj> getOptionalChildrenEnabledByRole( boolean forceRead ) {
		List<ICFSecSecRoleEnablesObj> retval;
		retval = ((ICFSecSchemaObj)getSchema()).getSecRoleEnablesTableObj().readSecRoleEnablesByRoleIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ICFSecSecRoleMembObj> getOptionalChildrenMembByRole() {
		List<ICFSecSecRoleMembObj> retval;
		retval = ((ICFSecSchemaObj)getSchema()).getSecRoleMembTableObj().readSecRoleMembByRoleIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ICFSecSecRoleMembObj> getOptionalChildrenMembByRole( boolean forceRead ) {
		List<ICFSecSecRoleMembObj> retval;
		retval = ((ICFSecSchemaObj)getSchema()).getSecRoleMembTableObj().readSecRoleMembByRoleIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			if (getPKey() != rec.getPKey()) {
				rec.setPKey(getPKey());
			}
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

	@Override
	public void copyRecToOrig() {
		ICFSecSecRole origRec = getOrigAsSecRole().getSecRoleRec();
		ICFSecSecRole myRec = getSecRoleRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ICFSecSecRole origRec = getOrigAsSecRole().getSecRoleRec();
		ICFSecSecRole myRec = getSecRoleRec();
		myRec.set( origRec );
	}
}
