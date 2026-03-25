// Description: Java 25 base object instance implementation for SecClusGrpInc

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

public class CFSecSecClusGrpIncObj
	implements ICFSecSecClusGrpIncObj
{
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFSecSecClusGrpIncEditObj edit;
	protected ICFSecSchemaObj schema;
	protected ICFSecSecClusGrpIncPKey pKey;
	protected ICFSecSecClusGrpInc rec;

	public CFSecSecClusGrpIncObj() {
		isNew = true;
	}

	public CFSecSecClusGrpIncObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
	}

	@Override
	public int getClassCode() {
		return( ((ICFSecSchemaObj)schema).getSecClusGrpIncTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecClusGrpInc" );
	}

	@Override
	public ICFLibAnyObj getObjScope() {
		return( null );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredInclName();
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
	public ICFSecSecClusGrpIncObj realise() {
		ICFSecSecClusGrpIncObj retobj = ((ICFSecSchemaObj)getSchema()).getSecClusGrpIncTableObj().realiseSecClusGrpInc(
			(ICFSecSecClusGrpIncObj)this );
		return( (ICFSecSecClusGrpIncObj)retobj );
	}

	@Override
	public void forget() {
		((ICFSecSchemaObj)getSchema()).getSecClusGrpIncTableObj().reallyDeepDisposeSecClusGrpInc( (ICFSecSecClusGrpIncObj)this );
	}

	@Override
	public ICFSecSecClusGrpIncObj read() {
		ICFSecSecClusGrpIncObj retobj = ((ICFSecSchemaObj)getSchema()).getSecClusGrpIncTableObj().readSecClusGrpIncByIdIdx( getPKey().getRequiredSecClusGrpId(),
			getPKey().getRequiredInclName(), false );
		return( (ICFSecSecClusGrpIncObj)retobj );
	}

	@Override
	public ICFSecSecClusGrpIncObj read( boolean forceRead ) {
		ICFSecSecClusGrpIncObj retobj = ((ICFSecSchemaObj)getSchema()).getSecClusGrpIncTableObj().readSecClusGrpIncByIdIdx( getPKey().getRequiredSecClusGrpId(),
			getPKey().getRequiredInclName(), forceRead );
		return( (ICFSecSecClusGrpIncObj)retobj );
	}

	@Override
	public ICFSecSecClusGrpIncTableObj getSecClusGrpIncTable() {
		return( ((ICFSecSchemaObj)getSchema()).getSecClusGrpIncTableObj() );
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
	public ICFSecSecClusGrpInc getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getCFSecBackingStore().getFactorySecClusGrpInc().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getCFSecBackingStore().getTableSecClusGrpInc().readDerivedByIdIdx( ((ICFSecSchemaObj)getSchema()).getAuthorization(),
						getPKey().getRequiredSecClusGrpId(),
						getPKey().getRequiredInclName() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( ICFSecSecClusGrpInc value ) {
		if( ! ( ( value == null ) || ! ( value instanceof ICFSecSecClusGrpInc ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"CFSecSecClusGrpIncRec" );
		}
		rec = value;
		copyRecToPKey();
	}

	@Override
	public ICFSecSecClusGrpInc getSecClusGrpIncRec() {
		return( (ICFSecSecClusGrpInc)getRec() );
	}

	@Override
	public ICFSecSecClusGrpIncPKey getPKey() {
		if( pKey == null ) {
			pKey = getSchema().getCFSecBackingStore().getFactorySecClusGrpInc().newPKey();
		}
		return( pKey );
	}

	@Override
	public void setPKey( ICFSecSecClusGrpIncPKey value ) {
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
	public ICFSecSecClusGrpIncEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		ICFSecSecClusGrpIncObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFSecSecClusGrpIncObj)this;
		}
		else {
			lockobj = ((ICFSecSchemaObj)getSchema()).getSecClusGrpIncTableObj().lockSecClusGrpInc( getPKey() );
		}
		edit = ((ICFSecSchemaObj)getSchema()).getSecClusGrpIncTableObj().newEditInstance( lockobj );
		return( (ICFSecSecClusGrpIncEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public ICFSecSecClusGrpIncEditObj getEdit() {
		return( edit );
	}

	@Override
	public ICFSecSecClusGrpIncEditObj getEditAsSecClusGrpInc() {
		return( (ICFSecSecClusGrpIncEditObj)edit );
	}

	@Override
	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ICFSecSecClusGrpInc rec = getRec();
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
			ICFSecSecClusGrpInc rec = getRec();
			updatedBy = ((ICFSecSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( getRec().getUpdatedAt() );
	}

	@Override
	public CFLibDbKeyHash256 getRequiredSecClusGrpId() {
		return( getPKey().getRequiredSecClusGrpId() );
	}

	@Override
	public String getRequiredInclName() {
		return( getPKey().getRequiredInclName() );
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			rec.getPKey().setRequiredSecClusGrpId(getPKey().getRequiredSecClusGrpId());
			rec.getPKey().setRequiredInclName(getPKey().getRequiredInclName());
		}
		if( edit != null ) {
			edit.copyPKeyToRec();
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			getPKey().setRequiredSecClusGrpId(rec.getPKey().getRequiredSecClusGrpId());
			getPKey().setRequiredInclName(rec.getPKey().getRequiredInclName());
		}
	}
}
