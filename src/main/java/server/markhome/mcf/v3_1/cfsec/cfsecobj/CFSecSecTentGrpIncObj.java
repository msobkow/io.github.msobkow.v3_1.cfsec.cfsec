// Description: Java 25 base object instance implementation for SecTentGrpInc

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
import server.markhome.mcf.v3_1.cfsec.cfsec.*;

public class CFSecSecTentGrpIncObj
	implements ICFSecSecTentGrpIncObj
{
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFSecSecTentGrpIncEditObj edit;
	protected ICFSecSchemaObj schema;
	protected ICFSecSecTentGrpIncPKey pKey;
	protected ICFSecSecTentGrpInc rec;

	public CFSecSecTentGrpIncObj() {
		isNew = true;
	}

	public CFSecSecTentGrpIncObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
	}

	@Override
	public int getClassCode() {
		return( ((ICFSecSchemaObj)schema).getSecTentGrpIncTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecTentGrpInc" );
	}

	@Override
	public ICFLibAnyObj getObjScope() {
		return( null );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredIncName();
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
	public ICFSecSecTentGrpIncObj realise() {
		ICFSecSecTentGrpIncObj retobj = ((ICFSecSchemaObj)getSchema()).getSecTentGrpIncTableObj().realiseSecTentGrpInc(
			(ICFSecSecTentGrpIncObj)this );
		return( (ICFSecSecTentGrpIncObj)retobj );
	}

	@Override
	public void forget() {
		((ICFSecSchemaObj)getSchema()).getSecTentGrpIncTableObj().reallyDeepDisposeSecTentGrpInc( (ICFSecSecTentGrpIncObj)this );
	}

	@Override
	public ICFSecSecTentGrpIncObj read() {
		ICFSecSecTentGrpIncObj retobj = ((ICFSecSchemaObj)getSchema()).getSecTentGrpIncTableObj().readSecTentGrpIncByIdIdx( getPKey().getRequiredSecTentGrpId(),
			getPKey().getRequiredIncName(), false );
		return( (ICFSecSecTentGrpIncObj)retobj );
	}

	@Override
	public ICFSecSecTentGrpIncObj read( boolean forceRead ) {
		ICFSecSecTentGrpIncObj retobj = ((ICFSecSchemaObj)getSchema()).getSecTentGrpIncTableObj().readSecTentGrpIncByIdIdx( getPKey().getRequiredSecTentGrpId(),
			getPKey().getRequiredIncName(), forceRead );
		return( (ICFSecSecTentGrpIncObj)retobj );
	}

	@Override
	public ICFSecSecTentGrpIncTableObj getSecTentGrpIncTable() {
		return( ((ICFSecSchemaObj)getSchema()).getSecTentGrpIncTableObj() );
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
	public ICFSecSecTentGrpInc getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getCFSecBackingStore().getFactorySecTentGrpInc().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getCFSecBackingStore().getTableSecTentGrpInc().readDerivedByIdIdx( ((ICFSecSchemaObj)getSchema()).getAuthorization(),
						getPKey().getRequiredSecTentGrpId(),
						getPKey().getRequiredIncName() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( ICFSecSecTentGrpInc value ) {
		if( ! ( ( value == null ) || ! ( value instanceof ICFSecSecTentGrpInc ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"CFSecSecTentGrpIncRec" );
		}
		rec = value;
		copyRecToPKey();
	}

	@Override
	public ICFSecSecTentGrpInc getSecTentGrpIncRec() {
		return( (ICFSecSecTentGrpInc)getRec() );
	}

	@Override
	public ICFSecSecTentGrpIncPKey getPKey() {
		if( pKey == null ) {
			pKey = getSchema().getCFSecBackingStore().getFactorySecTentGrpInc().newPKey();
		}
		return( pKey );
	}

	@Override
	public void setPKey( ICFSecSecTentGrpIncPKey value ) {
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
	public ICFSecSecTentGrpIncEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		ICFSecSecTentGrpIncObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFSecSecTentGrpIncObj)this;
		}
		else {
			lockobj = ((ICFSecSchemaObj)getSchema()).getSecTentGrpIncTableObj().lockSecTentGrpInc( getPKey() );
		}
		edit = ((ICFSecSchemaObj)getSchema()).getSecTentGrpIncTableObj().newEditInstance( lockobj );
		return( (ICFSecSecTentGrpIncEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public ICFSecSecTentGrpIncEditObj getEdit() {
		return( edit );
	}

	@Override
	public ICFSecSecTentGrpIncEditObj getEditAsSecTentGrpInc() {
		return( (ICFSecSecTentGrpIncEditObj)edit );
	}

	@Override
	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ICFSecSecTentGrpInc rec = getRec();
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
			ICFSecSecTentGrpInc rec = getRec();
			updatedBy = ((ICFSecSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( getRec().getUpdatedAt() );
	}

	@Override
	public CFLibDbKeyHash256 getRequiredSecTentGrpId() {
		return( getPKey().getRequiredSecTentGrpId() );
	}

	@Override
	public String getRequiredIncName() {
		return( getPKey().getRequiredIncName() );
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			rec.getPKey().setRequiredSecTentGrpId(getPKey().getRequiredSecTentGrpId());
			rec.getPKey().setRequiredIncName(getPKey().getRequiredIncName());
		}
		if( edit != null ) {
			edit.copyPKeyToRec();
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			getPKey().setRequiredSecTentGrpId(rec.getPKey().getRequiredSecTentGrpId());
			getPKey().setRequiredIncName(rec.getPKey().getRequiredIncName());
		}
	}
}
