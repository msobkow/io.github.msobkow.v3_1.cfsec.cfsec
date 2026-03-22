// Description: Java 25 edit object instance implementation for CFSec SecTentGrpInc.

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

public class CFSecSecTentGrpIncEditObj
	implements ICFSecSecTentGrpIncEditObj
{
	protected ICFSecSecTentGrpIncObj orig;
	protected ICFSecSecTentGrpInc rec;
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;

	public CFSecSecTentGrpIncEditObj( ICFSecSecTentGrpIncObj argOrig ) {
		orig = argOrig;
		getRec();
		ICFSecSecTentGrpInc origRec = orig.getRec();
		rec.set( origRec );
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
		return( ((ICFSecSchemaObj)orig.getSchema()).getSecTentGrpIncTableObj().getClassCode() );
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
		// We realise this so that it's record will get copied to orig during realization
		ICFSecSecTentGrpIncObj retobj = getSchema().getSecTentGrpIncTableObj().realiseSecTentGrpInc( (ICFSecSecTentGrpIncObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSecTentGrpInc().forget();
	}

	@Override
	public ICFSecSecTentGrpIncObj read() {
		ICFSecSecTentGrpIncObj retval = getOrigAsSecTentGrpInc().read();
		if( retval != orig ) {
			throw new CFLibStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ICFSecSecTentGrpIncObj read( boolean forceRead ) {
		ICFSecSecTentGrpIncObj retval = getOrigAsSecTentGrpInc().read( forceRead );
		if( retval != orig ) {
			throw new CFLibStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ICFSecSecTentGrpIncObj create() {
		copyRecToOrig();
		ICFSecSecTentGrpIncObj retobj = ((ICFSecSchemaObj)getOrigAsSecTentGrpInc().getSchema()).getSecTentGrpIncTableObj().createSecTentGrpInc( getOrigAsSecTentGrpInc() );
		if( retobj == getOrigAsSecTentGrpInc() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public CFSecSecTentGrpIncEditObj update() {
		getSchema().getSecTentGrpIncTableObj().updateSecTentGrpInc( (ICFSecSecTentGrpIncObj)this );
		return( null );
	}

	@Override
	public CFSecSecTentGrpIncEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSecTentGrpIncTableObj().deleteSecTentGrpInc( getOrigAsSecTentGrpInc() );
		return( null );
	}

	@Override
	public ICFSecSecTentGrpIncTableObj getSecTentGrpIncTable() {
		return( orig.getSchema().getSecTentGrpIncTableObj() );
	}

	@Override
	public ICFSecSecTentGrpIncEditObj getEdit() {
		return( (ICFSecSecTentGrpIncEditObj)this );
	}

	@Override
	public ICFSecSecTentGrpIncEditObj getEditAsSecTentGrpInc() {
		return( (ICFSecSecTentGrpIncEditObj)this );
	}

	@Override
	public ICFSecSecTentGrpIncEditObj beginEdit() {
		throw new CFLibEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ICFSecSecTentGrpIncObj getOrig() {
		return( orig );
	}

	@Override
	public ICFSecSecTentGrpIncObj getOrigAsSecTentGrpInc() {
		return( (ICFSecSecTentGrpIncObj)orig );
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
	public ICFSecSecTentGrpInc getRec() {
		if( rec == null ) {
			rec = getOrigAsSecTentGrpInc().getSchema().getCFSecBackingStore().getFactorySecTentGrpInc().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ICFSecSecTentGrpInc value ) {
		if( rec != value ) {
			rec = value;
		}
	}

	@Override
	public ICFSecSecTentGrpInc getSecTentGrpIncRec() {
		return( (ICFSecSecTentGrpInc)getRec() );
	}

	@Override
	public ICFSecSecTentGrpIncPKey getPKey() {
		return( orig.getPKey() );
	}

	@Override
	public void setPKey( ICFSecSecTentGrpIncPKey value ) {
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
	public CFLibDbKeyHash256 getRequiredSecTentGrpId() {
		return( getPKey().getRequiredSecTentGrpId() );
	}

	@Override
	public void setRequiredSecTentGrpId(CFLibDbKeyHash256 secTentGrpId) {
		if ((getPKey().getRequiredSecTentGrpId() != secTentGrpId ) || ( getSecTentGrpIncRec().getRequiredSecTentGrpId() != secTentGrpId )) {
			getPKey().setRequiredSecTentGrpId(secTentGrpId);
			getSecTentGrpIncRec().setRequiredSecTentGrpId( secTentGrpId );
		}
	}

	@Override
	public String getRequiredIncName() {
		return( getPKey().getRequiredIncName() );
	}

	@Override
	public void setRequiredIncName(String incName) {
		getPKey().setRequiredIncName(incName);
		if( getSecTentGrpIncRec().getRequiredIncName() != value ) {
			getSecTentGrpIncRec().setRequiredIncName( value );
		}
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			rec.getPKey().setRequiredSecTentGrpId(getPKey().getRequiredSecTentGrpId());
			rec.getPKey().setRequiredIncName(getPKey().getRequiredIncName());
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			getPKey().setRequiredSecTentGrpId(rec.getPKey().getRequiredSecTentGrpId());
			getPKey().setRequiredIncName(rec.getPKey().getRequiredIncName());
		}
	}

	@Override
	public void copyRecToOrig() {
		ICFSecSecTentGrpInc origRec = getOrigAsSecTentGrpInc().getSecTentGrpIncRec();
		ICFSecSecTentGrpInc myRec = getSecTentGrpIncRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ICFSecSecTentGrpInc origRec = getOrigAsSecTentGrpInc().getSecTentGrpIncRec();
		ICFSecSecTentGrpInc myRec = getSecTentGrpIncRec();
		myRec.set( origRec );
	}
}
