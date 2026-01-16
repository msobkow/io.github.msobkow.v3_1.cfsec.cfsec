// Description: Java 25 base object instance implementation for ISOLang

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

public class CFSecISOLangObj
	implements ICFSecISOLangObj
{
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFSecISOLangEditObj edit;
	protected ICFSecSchemaObj schema;
	protected Short pKey;
	protected ICFSecISOLang rec;
	protected List<ICFSecISOCtryLangObj> optionalChildrenCtry;

	public CFSecISOLangObj() {
		isNew = true;
	}

	public CFSecISOLangObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
	}

	@Override
	public int getClassCode() {
		return( ((ICFSecSchemaObj)schema).getISOLangTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "ISOLang" );
	}

	@Override
	public ICFLibAnyObj getObjScope() {
		return( null );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredISO6392Code();
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
	public ICFSecISOLangObj realise() {
		ICFSecISOLangObj retobj = ((ICFSecSchemaObj)getSchema()).getISOLangTableObj().realiseISOLang(
			(ICFSecISOLangObj)this );
		return( (ICFSecISOLangObj)retobj );
	}

	@Override
	public void forget() {
		((ICFSecSchemaObj)getSchema()).getISOLangTableObj().reallyDeepDisposeISOLang( (ICFSecISOLangObj)this );
	}

	@Override
	public ICFSecISOLangObj read() {
		ICFSecISOLangObj retobj = ((ICFSecSchemaObj)getSchema()).getISOLangTableObj().readISOLangByIdIdx( getPKey(), false );
		return( (ICFSecISOLangObj)retobj );
	}

	@Override
	public ICFSecISOLangObj read( boolean forceRead ) {
		ICFSecISOLangObj retobj = ((ICFSecSchemaObj)getSchema()).getISOLangTableObj().readISOLangByIdIdx( getPKey(), forceRead );
		return( (ICFSecISOLangObj)retobj );
	}

	@Override
	public ICFSecISOLangTableObj getISOLangTable() {
		return( ((ICFSecSchemaObj)getSchema()).getISOLangTableObj() );
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
	public ICFSecISOLang getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getCFSecBackingStore().getFactoryISOLang().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getCFSecBackingStore().getTableISOLang().readDerivedByIdIdx( ((ICFSecSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( ICFSecISOLang value ) {
		if( ! ( ( value == null ) || ! ( value instanceof ICFSecISOLang ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"CFSecISOLangRec" );
		}
		rec = value;
		copyRecToPKey();
	}

	@Override
	public ICFSecISOLang getISOLangRec() {
		return( (ICFSecISOLang)getRec() );
	}

	@Override
	public Short getPKey() {
		return( pKey );
	}

	@Override
	public void setPKey( Short value ) {
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
	public ICFSecISOLangEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		ICFSecISOLangObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFSecISOLangObj)this;
		}
		else {
			lockobj = ((ICFSecSchemaObj)getSchema()).getISOLangTableObj().lockISOLang( getPKey() );
		}
		edit = ((ICFSecSchemaObj)getSchema()).getISOLangTableObj().newEditInstance( lockobj );
		return( (ICFSecISOLangEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public ICFSecISOLangEditObj getEdit() {
		return( edit );
	}

	@Override
	public ICFSecISOLangEditObj getEditAsISOLang() {
		return( (ICFSecISOLangEditObj)edit );
	}

	@Override
	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ICFSecISOLang rec = getRec();
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
			ICFSecISOLang rec = getRec();
			updatedBy = ((ICFSecSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( getRec().getUpdatedAt() );
	}

	@Override
	public short getRequiredISOLangId() {
		return( getPKey() );
	}

	@Override
	public List<ICFSecISOCtryLangObj> getOptionalChildrenCtry() {
		List<ICFSecISOCtryLangObj> retval;
		retval = ((ICFSecSchemaObj)getSchema()).getISOCtryLangTableObj().readISOCtryLangByLangIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ICFSecISOCtryLangObj> getOptionalChildrenCtry( boolean forceRead ) {
		List<ICFSecISOCtryLangObj> retval;
		retval = ((ICFSecSchemaObj)getSchema()).getISOCtryLangTableObj().readISOCtryLangByLangIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public String getRequiredISO6392Code() {
		return( getISOLangRec().getRequiredISO6392Code() );
	}

	@Override
	public String getOptionalISO6391Code() {
		return( getISOLangRec().getOptionalISO6391Code() );
	}

	@Override
	public String getRequiredEnglishName() {
		return( getISOLangRec().getRequiredEnglishName() );
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
