// Description: Java 25 edit object instance implementation for CFSec SecClusGrpInc.

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

public class CFSecSecClusGrpIncEditObj
	implements ICFSecSecClusGrpIncEditObj
{
	protected ICFSecSecClusGrpIncObj orig;
	protected ICFSecSecClusGrpInc rec;
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;

	public CFSecSecClusGrpIncEditObj( ICFSecSecClusGrpIncObj argOrig ) {
		orig = argOrig;
		getRec();
		ICFSecSecClusGrpInc origRec = orig.getRec();
		rec.set( origRec );
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
		return( ((ICFSecSchemaObj)orig.getSchema()).getSecClusGrpIncTableObj().getClassCode() );
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
	public ICFSecSecClusGrpIncObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ICFSecSecClusGrpIncObj retobj = getSchema().getSecClusGrpIncTableObj().realiseSecClusGrpInc( (ICFSecSecClusGrpIncObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSecClusGrpInc().forget();
	}

	@Override
	public ICFSecSecClusGrpIncObj read() {
		ICFSecSecClusGrpIncObj retval = getOrigAsSecClusGrpInc().read();
		if( retval != orig ) {
			throw new CFLibStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ICFSecSecClusGrpIncObj read( boolean forceRead ) {
		ICFSecSecClusGrpIncObj retval = getOrigAsSecClusGrpInc().read( forceRead );
		if( retval != orig ) {
			throw new CFLibStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ICFSecSecClusGrpIncObj create() {
		copyRecToOrig();
		ICFSecSecClusGrpIncObj retobj = ((ICFSecSchemaObj)getOrigAsSecClusGrpInc().getSchema()).getSecClusGrpIncTableObj().createSecClusGrpInc( getOrigAsSecClusGrpInc() );
		if( retobj == getOrigAsSecClusGrpInc() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public CFSecSecClusGrpIncEditObj update() {
		getSchema().getSecClusGrpIncTableObj().updateSecClusGrpInc( (ICFSecSecClusGrpIncObj)this );
		return( null );
	}

	@Override
	public CFSecSecClusGrpIncEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSecClusGrpIncTableObj().deleteSecClusGrpInc( getOrigAsSecClusGrpInc() );
		return( null );
	}

	@Override
	public ICFSecSecClusGrpIncTableObj getSecClusGrpIncTable() {
		return( orig.getSchema().getSecClusGrpIncTableObj() );
	}

	@Override
	public ICFSecSecClusGrpIncEditObj getEdit() {
		return( (ICFSecSecClusGrpIncEditObj)this );
	}

	@Override
	public ICFSecSecClusGrpIncEditObj getEditAsSecClusGrpInc() {
		return( (ICFSecSecClusGrpIncEditObj)this );
	}

	@Override
	public ICFSecSecClusGrpIncEditObj beginEdit() {
		throw new CFLibEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ICFSecSecClusGrpIncObj getOrig() {
		return( orig );
	}

	@Override
	public ICFSecSecClusGrpIncObj getOrigAsSecClusGrpInc() {
		return( (ICFSecSecClusGrpIncObj)orig );
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
	public ICFSecSecClusGrpInc getRec() {
		if( rec == null ) {
			rec = getOrigAsSecClusGrpInc().getSchema().getCFSecBackingStore().getFactorySecClusGrpInc().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ICFSecSecClusGrpInc value ) {
		if( rec != value ) {
			rec = value;
		}
	}

	@Override
	public ICFSecSecClusGrpInc getSecClusGrpIncRec() {
		return( (ICFSecSecClusGrpInc)getRec() );
	}

	@Override
	public ICFSecSecClusGrpIncPKey getPKey() {
		return( orig.getPKey() );
	}

	@Override
	public void setPKey( ICFSecSecClusGrpIncPKey value ) {
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
	public CFLibDbKeyHash256 getRequiredSecClusGrpId() {
		return( getPKey().getRequiredSecClusGrpId() );
	}

	@Override
	public void setRequiredSecClusGrpId(CFLibDbKeyHash256 secClusGrpId) {
		if ((getPKey().getRequiredSecClusGrpId() != secClusGrpId ) || ( getSecClusGrpIncRec().getRequiredSecClusGrpId() != secClusGrpId )) {
			getPKey().setRequiredSecClusGrpId(secClusGrpId);
			getSecClusGrpIncRec().setRequiredSecClusGrpId( secClusGrpId );
		}
	}

	@Override
	public String getRequiredIncName() {
		return( getPKey().getRequiredIncName() );
	}

	@Override
	public void setRequiredIncName(String incName) {
		getPKey().setRequiredIncName(incName);
		if( getSecClusGrpIncRec().getRequiredIncName() != value ) {
			getSecClusGrpIncRec().setRequiredIncName( value );
		}
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			rec.getPKey().setRequiredSecClusGrpId(getPKey().getRequiredSecClusGrpId());
			rec.getPKey().setRequiredIncName(getPKey().getRequiredIncName());
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			getPKey().setRequiredSecClusGrpId(rec.getPKey().getRequiredSecClusGrpId());
			getPKey().setRequiredIncName(rec.getPKey().getRequiredIncName());
		}
	}

	@Override
	public void copyRecToOrig() {
		ICFSecSecClusGrpInc origRec = getOrigAsSecClusGrpInc().getSecClusGrpIncRec();
		ICFSecSecClusGrpInc myRec = getSecClusGrpIncRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ICFSecSecClusGrpInc origRec = getOrigAsSecClusGrpInc().getSecClusGrpIncRec();
		ICFSecSecClusGrpInc myRec = getSecClusGrpIncRec();
		myRec.set( origRec );
	}
}
