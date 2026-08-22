// Description: Java 25 implJustProtementation of a ISOCtryLang buffer

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

package server.markhome.mcf.v3_1.cfsec.cfsec.buff;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import server.markhome.mcf.v3_1.cflib.xml.CFLibXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfsec.cfsecprot.*;
import server.markhome.mcf.v3_1.cfsec.cfsecprotobj.*;

public class CFSecProtBuffISOCtryLang
	implements ICFSecISOCtryLang, Comparable<Object>, Serializable
{
	protected ICFSecISOCtryLangPKey pkeyJustProt = new CFSecProtBuffISOCtryLangPKey();
	protected int requiredRevision;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFSecPubSecUser.S_INIT_CREATED_BY);
	protected CFLibDbKeyHash256 createdBySessionId = CFLibDbKeyHash256.fromHex(ICFSecPubSecSession.S_SECSESSIONID_INIT_VALUE);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFSecPubSecUser.S_INIT_UPDATED_BY);
	protected CFLibDbKeyHash256 updatedBySessionId = CFLibDbKeyHash256.fromHex(ICFSecPubSecSession.S_SECSESSIONID_INIT_VALUE);
	protected LocalDateTime updatedAt = LocalDateTime.now();

	public CFSecProtBuffISOCtryLang() {
		pkeyJustProt = new CFSecProtBuffISOCtryLangPKey();
	}

	@Override
	public ICFSecISOCtryLangPKey getPKey() {
		return(pkeyJustProt);
	}

	@Override
	public void setJustProtPKey(ICFSecISOCtryLangPKey pkeyJustProt ) {
		if (pkeyJustProt == null) {
			throw new CFLibNullArgumentException(getClass(), "setJustProtPKey", 1, "pkeyJustProt");
		}
		else {
			this.pkey = pkeyJustProt;
		}
	}

	@Override
	public short getRequiredISOCtryId() {
		return(getPKey().getRequiredISOCtryId());
	}

	@Override
	public void setRequiredISOCtryId( short value ) {
		if( value < ICFSecPubISOCtryLang.ISOCTRYID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredISOCtryId",
				1,
				"value",
				value,
				ICFSecPubISOCtryLang.ISOCTRYID_MIN_VALUE );
		}
		getPKey().setRequiredISOCtryId(value);
	}

	@Override
	public short getRequiredISOLangId() {
		return(getPKey().getRequiredISOLangId());
	}

	@Override
	public void setRequiredISOLangId( short value ) {
		if( value < ICFSecPubISOCtryLang.ISOLANGID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredISOLangId",
				1,
				"value",
				value,
				ICFSecPubISOCtryLang.ISOLANGID_MIN_VALUE );
		}
		getPKey().setRequiredISOLangId(value);
	}

	@Override
	public ICFSecISOCtry getRequiredContainerCtry() {
		ICFSecSchema targetBackingCFSec = ICFSecSchema.getBackingCFSec();
		if (targetBackingCFSec == null) {
			throw new CFLibNullArgumentException(getClass(), "getRequiredContainerCtry", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecISOCtryTable targetTable = targetBackingCFSec.getTableISOCtry();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "getRequiredContainerCtry", 0, "ICFSecSchema.getBackingCFSec().getTableISOCtry()");
		}
		ICFSecISOCtry targetRec = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredISOCtryId());
		return(targetRec);
	}

	@Override
	public ICFSecISOCtry getRequiredContainerCtry() {
		ICFSecSchema targetBackingCFSec = ICFSecSchema.getBackingCFSec();
		if (targetBackingCFSec == null) {
			throw new CFLibNullArgumentException(getClass(), "getRequiredContainerCtry", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecISOCtryTable targetTable = targetBackingCFSec.getTableISOCtry();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "getRequiredContainerCtry", 0, "ICFSecSchema.getBackingCFSec().getTableISOCtry()");
		}
		ICFSecISOCtry targetRec = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredISOCtryId());
		return(targetRec);
	}

	@Override
	public ICFSecISOCtry getRequiredContainerCtry() {
		ICFSecSchema targetBackingCFSec = ICFSecSchema.getBackingCFSec();
		if (targetBackingCFSec == null) {
			throw new CFLibNullArgumentException(getClass(), "getRequiredContainerCtry", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecISOCtryTable targetTable = targetBackingCFSec.getTableISOCtry();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "getRequiredContainerCtry", 0, "ICFSecSchema.getBackingCFSec().getTableISOCtry()");
		}
		ICFSecPubISOCtry targetRec = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredISOCtryId());
		return(targetRec);
	}

	@Override
	public void setJustProtRequiredContainerCtry(ICFSecISOCtry argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setJustProtContainerCtry", 1, "argObj");
		}
		else {
			setJustProtRequiredISOCtryId(argObj.getRequiredISOCtryId());
		}
	}

	@Override
	public void setJustProtRequiredContainerCtry(ICFSecProtISOCtry argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setJustProtContainerCtry", 1, "argObj");
		}
		else {
			setJustProtRequiredISOCtryId(argObj.getRequiredISOCtryId());
		}
	}

	@Override
	public void setJustProtRequiredContainerCtry(ICFSecPubISOCtry argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setJustProtContainerCtry", 1, "argObj");
		}
		else {
			setJustProtRequiredISOCtryId(argObj.getRequiredISOCtryId());
		}
	}

	@Override
	public ICFSecISOLang getRequiredParentLang() {
		ICFSecSchema targetBackingCFSec = ICFSecSchema.getBackingCFSec();
		if (targetBackingCFSec == null) {
			throw new CFLibNullArgumentException(getClass(), "getRequiredParentLang", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecISOLangTable targetTable = targetBackingCFSec.getTableISOLang();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "getRequiredParentLang", 0, "ICFSecSchema.getBackingCFSec().getTableISOLang()");
		}
		ICFSecISOLang targetRec = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredISOLangId());
		return(targetRec);
	}

	@Override
	public ICFSecISOLang getRequiredParentLang() {
		ICFSecSchema targetBackingCFSec = ICFSecSchema.getBackingCFSec();
		if (targetBackingCFSec == null) {
			throw new CFLibNullArgumentException(getClass(), "getRequiredParentLang", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecISOLangTable targetTable = targetBackingCFSec.getTableISOLang();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "getRequiredParentLang", 0, "ICFSecSchema.getBackingCFSec().getTableISOLang()");
		}
		ICFSecISOLang targetRec = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredISOLangId());
		return(targetRec);
	}

	@Override
	public ICFSecISOLang getRequiredParentLang() {
		ICFSecSchema targetBackingCFSec = ICFSecSchema.getBackingCFSec();
		if (targetBackingCFSec == null) {
			throw new CFLibNullArgumentException(getClass(), "getRequiredParentLang", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecISOLangTable targetTable = targetBackingCFSec.getTableISOLang();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "getRequiredParentLang", 0, "ICFSecSchema.getBackingCFSec().getTableISOLang()");
		}
		ICFSecPubISOLang targetRec = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredISOLangId());
		return(targetRec);
	}

	@Override
	public void setJustProtRequiredParentLang(ICFSecISOLang argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setJustProtParentLang", 1, "argObj");
		}
		else {
			setJustProtRequiredISOLangId(argObj.getRequiredISOLangId());
		}
	}

	@Override
	public void setJustProtRequiredParentLang(ICFSecProtISOLang argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setJustProtParentLang", 1, "argObj");
		}
		else {
			setJustProtRequiredISOLangId(argObj.getRequiredISOLangId());
		}
	}

	@Override
	public void setJustProtRequiredParentLang(ICFSecPubISOLang argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setJustProtParentLang", 1, "argObj");
		}
		else {
			setJustProtRequiredISOLangId(argObj.getRequiredISOLangId());
		}
	}

	@Override
	public CFLibDbKeyHash256 getCreatedByUserId() {
		return( createdByUserId );
	}

	@Override
	public void setJustProtCreatedByUserId( CFLibDbKeyHash256 value ) {
		createdByUserId = value;
	}

	@Override
	public LocalDateTime getCreatedAt() {
		return( createdAt );
	}

	@Override
	public void setJustProtCreatedAt( LocalDateTime value ) {
		createdAt = value;
	}

	@Override
	public CFLibDbKeyHash256 getUpdatedByUserId() {
		return( updatedByUserId );
	}

	@Override
	public void setJustProtUpdatedByUserId( CFLibDbKeyHash256 value ) {
		updatedByUserId = value;
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( updatedAt );
	}

	@Override
	public void setJustProtUpdatedAt( LocalDateTime value ) {
		updatedAt = value;
	}

	@Override
	public int getRequiredRevision() {
		return( requiredRevision );
	}

	@Override
	public void setRequiredRevision( int value ) {
		requiredRevision = value;
	}

	@Override
	public int getClassCode() {
		return( ICFSecISOCtryLang.CLASS_CODE );
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ICFSecProtISOCtryLang rhs ) {
			if( ! getCreatedByUserId().equals( rhs.getCreatedByUserId() ) ) {
				return( false );
			}
			if( ! getCreatedAt().equals( rhs.getCreatedAt() ) ) {
				return( false );
			}
			if( ! getUpdatedByUserId().equals( rhs.getUpdatedByUserId() ) ) {
				return( false );
			}
			if( ! getUpdatedAt().equals( rhs.getUpdatedAt() ) ) {
				return( false );
			}
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecProtISOCtryLangH rhs ) {
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOCtryLangHPKey ) {
			ICFSecProtISOCtryLangHPKey rhs = (ICFSecISOCtryLangHPKey)obj;
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecProtISOCtryLangByCtryIdxKey rhs ) {
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecProtISOCtryLangByLangIdxKey rhs ) {
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecProtISOCtryLang rhs ) {
			if( ! getCreatedByUserId().equals( rhs.getCreatedByUserId() ) ) {
				return( false );
			}
			if( ! getCreatedAt().equals( rhs.getCreatedAt() ) ) {
				return( false );
			}
			if( ! getUpdatedByUserId().equals( rhs.getUpdatedByUserId() ) ) {
				return( false );
			}
			if( ! getUpdatedAt().equals( rhs.getUpdatedAt() ) ) {
				return( false );
			}
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecProtISOCtryLangH rhs ) {
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecProtISOCtryLangHPKey rhs ) {
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecProtISOCtryLangByCtryIdxKey rhs ) {
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecProtISOCtryLangByLangIdxKey rhs ) {
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecPubISOCtryLang rhs ) {
			if( ! getCreatedByUserId().equals( rhs.getCreatedByUserId() ) ) {
				return( false );
			}
			if( ! getCreatedAt().equals( rhs.getCreatedAt() ) ) {
				return( false );
			}
			if( ! getUpdatedByUserId().equals( rhs.getUpdatedByUserId() ) ) {
				return( false );
			}
			if( ! getUpdatedAt().equals( rhs.getUpdatedAt() ) ) {
				return( false );
			}
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecPubISOCtryLangH rhs ) {
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecPubISOCtryLangHPKey rhs ) {
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecProtISOCtryLangByCtryIdxKey rhs ) {
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecProtISOCtryLangByLangIdxKey rhs ) {
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
			return( true );
		}
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		hashCode = hashCode + getCreatedByUserId().hashCode();
		hashCode = hashCode + getCreatedAt().hashCode();
		hashCode = hashCode + getUpdatedByUserId().hashCode();
		hashCode = hashCode + getUpdatedAt().hashCode();
		hashCode = ( hashCode * 0x10000 ) + getRequiredISOCtryId();
		hashCode = ( hashCode * 0x10000 ) + getRequiredISOLangId();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof ICFSecProtISOCtryLang rhs ) {
			cmp = 0;
			{
				cmp = getCreatedByUserId().compareTo( rhs.getCreatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getCreatedAt().compareTo( rhs.getCreatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedByUserId().compareTo( rhs.getUpdatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedAt().compareTo( rhs.getUpdatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getRequiredISOCtryId() < rhs.getRequiredISOCtryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCtryId() > rhs.getRequiredISOCtryId() ) {
				return( 1 );
			}
			if( getRequiredISOLangId() < rhs.getRequiredISOLangId() ) {
				return( -1 );
			}
			else if( getRequiredISOLangId() > rhs.getRequiredISOLangId() ) {
				return( 1 );
			}
			return( 0 );
 		}
		else if( obj instanceof ICFSecProtISOCtryLangHPKey rhs ) {
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if( getRequiredISOCtryId() < rhs.getRequiredISOCtryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCtryId() > rhs.getRequiredISOCtryId() ) {
				return( 1 );
			}
			if( getRequiredISOLangId() < rhs.getRequiredISOLangId() ) {
				return( -1 );
			}
			else if( getRequiredISOLangId() > rhs.getRequiredISOLangId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecProtISOCtryLangH rhs ) {
			cmp = 0;
			if( getRequiredISOCtryId() < rhs.getRequiredISOCtryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCtryId() > rhs.getRequiredISOCtryId() ) {
				return( 1 );
			}
			if( getRequiredISOLangId() < rhs.getRequiredISOLangId() ) {
				return( -1 );
			}
			else if( getRequiredISOLangId() > rhs.getRequiredISOLangId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecISOCtryLangByCtryIdxKey rhs ) {
			if( getRequiredISOCtryId() < rhs.getRequiredISOCtryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCtryId() > rhs.getRequiredISOCtryId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecISOCtryLangByLangIdxKey rhs ) {
			if( getRequiredISOLangId() < rhs.getRequiredISOLangId() ) {
				return( -1 );
			}
			else if( getRequiredISOLangId() > rhs.getRequiredISOLangId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecPubISOCtryLang rhs ) {
			cmp = 0;
			{
				cmp = getCreatedByUserId().compareTo( rhs.getCreatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getCreatedAt().compareTo( rhs.getCreatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedByUserId().compareTo( rhs.getUpdatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedAt().compareTo( rhs.getUpdatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getRequiredISOCtryId() < rhs.getRequiredISOCtryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCtryId() > rhs.getRequiredISOCtryId() ) {
				return( 1 );
			}
			if( getRequiredISOLangId() < rhs.getRequiredISOLangId() ) {
				return( -1 );
			}
			else if( getRequiredISOLangId() > rhs.getRequiredISOLangId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecPubISOCtryLangHPKey rhs ) {
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if( getRequiredISOCtryId() < rhs.getRequiredISOCtryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCtryId() > rhs.getRequiredISOCtryId() ) {
				return( 1 );
			}
			if( getRequiredISOLangId() < rhs.getRequiredISOLangId() ) {
				return( -1 );
			}
			else if( getRequiredISOLangId() > rhs.getRequiredISOLangId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecPubISOCtryLangH rhs ) {
			cmp = 0;
			if( getRequiredISOCtryId() < rhs.getRequiredISOCtryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCtryId() > rhs.getRequiredISOCtryId() ) {
				return( 1 );
			}
			if( getRequiredISOLangId() < rhs.getRequiredISOLangId() ) {
				return( -1 );
			}
			else if( getRequiredISOLangId() > rhs.getRequiredISOLangId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecPubISOCtryLangByCtryIdxKey rhs ) {
			if( getRequiredISOCtryId() < rhs.getRequiredISOCtryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCtryId() > rhs.getRequiredISOCtryId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecPubISOCtryLangByLangIdxKey rhs ) {
			if( getRequiredISOLangId() < rhs.getRequiredISOLangId() ) {
				return( -1 );
			}
			else if( getRequiredISOLangId() > rhs.getRequiredISOLangId() ) {
				return( 1 );
			}			return( 0 );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	@Override
	public void setJustProt( ICFSecISOCtryLang src ) {
		setJustProtISOCtryLang( src );
	}

	@Override
	public void setJustProtISOCtryLang( ICFSecISOCtryLang src ) {
		setJustProtRequiredContainerCtry(src.getRequiredContainerCtry());
		setJustProtRequiredParentLang(src.getRequiredParentLang());
		setJustProtRequiredISOCtryId(src.getRequiredISOCtryId());
		setJustProtRequiredISOLangId(src.getRequiredISOLangId());
		setJustProtRequiredRevision( src.getRequiredRevision() );
		setJustProtCreatedByUserId( src.getCreatedByUserId() );
		setJustProtCreatedAt( src.getCreatedAt() );
		setJustProtUpdatedByUserId( src.getUpdatedByUserId() );
		setJustProtUpdatedAt( src.getUpdatedAt() );
	}

	@Override
	public void setJustProt( ICFSecISOCtryLangH src ) {
		setJustProtISOCtryLang( src );
	}

	@Override
	public void setJustProtISOCtryLang( ICFSecISOCtryLangH src ) {
		setJustProtRequiredContainerCtry(src.getRequiredContainerCtry());
		setJustProtRequiredParentLang(src.getRequiredParentLang());
		setJustProtRequiredISOCtryId(src.getRequiredISOCtryId());
		setJustProtRequiredISOLangId(src.getRequiredISOLangId());
	}

	@Override
	public void setJustProt( ICFSecProtISOCtryLang src ) {
		setJustProtISOCtryLang( src );
	}

	@Override
	public void setJustProtISOCtryLang( ICFSecProtISOCtryLang src ) {
		setJustProtRequiredContainerCtry(src.getRequiredContainerCtry());
		setJustProtRequiredParentLang(src.getRequiredParentLang());
		setJustProtRequiredISOCtryId(src.getRequiredISOCtryId());
		setJustProtRequiredISOLangId(src.getRequiredISOLangId());
		setJustProtRequiredRevision( src.getRequiredRevision() );
		setJustProtCreatedByUserId( src.getCreatedByUserId() );
		setJustProtCreatedAt( src.getCreatedAt() );
		setJustProtUpdatedByUserId( src.getUpdatedByUserId() );
		setJustProtUpdatedAt( src.getUpdatedAt() );
	}

	@Override
	public void setJustProt( ICFSecProtISOCtryLangH src ) {
		setJustProtISOCtryLang( src );
	}

	@Override
	public void setJustProtISOCtryLang( ICFSecProtISOCtryLangH src ) {
		setJustProtRequiredContainerCtry(src.getRequiredContainerCtry());
		setJustProtRequiredParentLang(src.getRequiredParentLang());
		setJustProtRequiredISOCtryId(src.getRequiredISOCtryId());
		setJustProtRequiredISOLangId(src.getRequiredISOLangId());
	}

	@Override
	public void setJustProt( ICFSecPubISOCtryLang src ) {
		setJustProtISOCtryLang( src );
	}

	@Override
	public void setJustProtISOCtryLang( ICFSecPubISOCtryLang src ) {
		setJustProtRequiredContainerCtry(src.getRequiredContainerCtry());
		setJustProtRequiredParentLang(src.getRequiredParentLang());
		setJustProtRequiredISOCtryId(src.getRequiredISOCtryId());
		setJustProtRequiredISOLangId(src.getRequiredISOLangId());
		setJustProtRequiredRevision( src.getRequiredRevision() );
		setJustProtCreatedByUserId( src.getCreatedByUserId() );
		setJustProtCreatedAt( src.getCreatedAt() );
		setJustProtUpdatedByUserId( src.getUpdatedByUserId() );
		setJustProtUpdatedAt( src.getUpdatedAt() );
	}

	@Override
	public void setJustProt( ICFSecPubISOCtryLangH src ) {
		setJustProtISOCtryLang( src );
	}

	@Override
	public void setJustProtISOCtryLang( ICFSecPubISOCtryLangH src ) {
		setJustProtRequiredContainerCtry(src.getRequiredContainerCtry());
		setJustProtRequiredParentLang(src.getRequiredParentLang());
		setJustProtRequiredISOCtryId(src.getRequiredISOCtryId());
		setJustProtRequiredISOLangId(src.getRequiredISOLangId());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = pkey.getXmlAttrFragment() 
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredISOCtryId=" + "\"" + Short.toString( getRequiredISOCtryId() ) + "\""
			+ " RequiredISOLangId=" + "\"" + Short.toString( getRequiredISOLangId() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFSecProtBuffISOCtryLang" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
