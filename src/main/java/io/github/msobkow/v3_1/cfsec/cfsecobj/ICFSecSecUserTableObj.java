// Description: Java 25 Table Object interface for CFSec.

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

public interface ICFSecSecUserTableObj
{
	public ICFSecSchemaObj getSchema();
	public void setSchema( ICFSecSchemaObj value );

	public void minimizeMemory();

	public String getTableName();
	public String getTableDbName();

	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	public int getClassCode();

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	// public static int getBackingClassCode();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new SecUser instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecSecUserObj newInstance();

	/**
	 *	Instantiate a new SecUser edition of the specified SecUser instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecSecUserEditObj newEditInstance( ICFSecSecUserObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecSecUserObj realiseSecUser( ICFSecSecUserObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecSecUserObj createSecUser( ICFSecSecUserObj Obj );

	/**
	 *	Read a SecUser-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecUser-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecUserObj readSecUser( CFLibDbKeyHash256 pkey );

	/**
	 *	Read a SecUser-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecUser-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecUserObj readSecUser( CFLibDbKeyHash256 pkey,
		boolean forceRead );

	ICFSecSecUserObj readCachedSecUser( CFLibDbKeyHash256 pkey );

	public void reallyDeepDisposeSecUser( ICFSecSecUserObj obj );

	void deepDisposeSecUser( CFLibDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecSecUserObj lockSecUser( CFLibDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the SecUser-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecUserObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecUserObj> readAllSecUser();

	/**
	 *	Return a sorted map of all the SecUser-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecUserObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecUserObj> readAllSecUser( boolean forceRead );

	List<ICFSecSecUserObj> readCachedAllSecUser();

	/**
	 *	Return a sorted map of a page of the SecUser-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecUserObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecUserObj> pageAllSecUser(CFLibDbKeyHash256 priorSecUserId );

	/**
	 *	Get the CFSecSecUserObj instance for the primary key attributes.
	 *
	 *	@param	SecUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecUserObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecUserObj readSecUserByIdIdx( CFLibDbKeyHash256 SecUserId );

	/**
	 *	Get the CFSecSecUserObj instance for the primary key attributes.
	 *
	 *	@param	SecUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecUserObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecUserObj readSecUserByIdIdx( CFLibDbKeyHash256 SecUserId,
		boolean forceRead );

	/**
	 *	Get the CFSecSecUserObj instance for the unique ULoginIdx key.
	 *
	 *	@param	LoginId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecUserObj cached instance for the unique ULoginIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecUserObj readSecUserByULoginIdx(String LoginId );

	/**
	 *	Get the CFSecSecUserObj instance for the unique ULoginIdx key.
	 *
	 *	@param	LoginId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecUserObj refreshed instance for the unique ULoginIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecUserObj readSecUserByULoginIdx(String LoginId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecUserObj instances sorted by their primary keys for the duplicate EMConfIdx key.
	 *
	 *	@param	EMailConfirmUuid6	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecUserObj cached instances sorted by their primary keys for the duplicate EMConfIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecUserObj> readSecUserByEMConfIdx( CFLibUuid6 EMailConfirmUuid6 );

	/**
	 *	Get the map of CFSecSecUserObj instances sorted by their primary keys for the duplicate EMConfIdx key.
	 *
	 *	@param	EMailConfirmUuid6	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecUserObj cached instances sorted by their primary keys for the duplicate EMConfIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecUserObj> readSecUserByEMConfIdx( CFLibUuid6 EMailConfirmUuid6,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecUserObj instances sorted by their primary keys for the duplicate PwdResetIdx key.
	 *
	 *	@param	PasswordResetUuid6	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecUserObj cached instances sorted by their primary keys for the duplicate PwdResetIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecUserObj> readSecUserByPwdResetIdx( CFLibUuid6 PasswordResetUuid6 );

	/**
	 *	Get the map of CFSecSecUserObj instances sorted by their primary keys for the duplicate PwdResetIdx key.
	 *
	 *	@param	PasswordResetUuid6	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecUserObj cached instances sorted by their primary keys for the duplicate PwdResetIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecUserObj> readSecUserByPwdResetIdx( CFLibUuid6 PasswordResetUuid6,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecUserObj instances sorted by their primary keys for the duplicate DefDevIdx key.
	 *
	 *	@param	DfltDevUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@param	DfltDevName	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecUserObj cached instances sorted by their primary keys for the duplicate DefDevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecUserObj> readSecUserByDefDevIdx( CFLibDbKeyHash256 DfltDevUserId,
		String DfltDevName );

	/**
	 *	Get the map of CFSecSecUserObj instances sorted by their primary keys for the duplicate DefDevIdx key.
	 *
	 *	@param	DfltDevUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@param	DfltDevName	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecUserObj cached instances sorted by their primary keys for the duplicate DefDevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecUserObj> readSecUserByDefDevIdx( CFLibDbKeyHash256 DfltDevUserId,
		String DfltDevName,
		boolean forceRead );

	ICFSecSecUserObj readCachedSecUserByIdIdx( CFLibDbKeyHash256 SecUserId );

	ICFSecSecUserObj readCachedSecUserByULoginIdx( String LoginId );

	List<ICFSecSecUserObj> readCachedSecUserByEMConfIdx( CFLibUuid6 EMailConfirmUuid6 );

	List<ICFSecSecUserObj> readCachedSecUserByPwdResetIdx( CFLibUuid6 PasswordResetUuid6 );

	List<ICFSecSecUserObj> readCachedSecUserByDefDevIdx( CFLibDbKeyHash256 DfltDevUserId,
		String DfltDevName );

	void deepDisposeSecUserByIdIdx( CFLibDbKeyHash256 SecUserId );

	void deepDisposeSecUserByULoginIdx( String LoginId );

	void deepDisposeSecUserByEMConfIdx( CFLibUuid6 EMailConfirmUuid6 );

	void deepDisposeSecUserByPwdResetIdx( CFLibUuid6 PasswordResetUuid6 );

	void deepDisposeSecUserByDefDevIdx( CFLibDbKeyHash256 DfltDevUserId,
		String DfltDevName );

	/**
	 *	Read a page of data as a List of SecUser-derived instances sorted by their primary keys,
	 *	as identified by the duplicate EMConfIdx key attributes.
	 *
	 *	@param	EMailConfirmUuid6	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecUser-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecUserObj> pageSecUserByEMConfIdx( CFLibUuid6 EMailConfirmUuid6,
		CFLibDbKeyHash256 priorSecUserId );

	/**
	 *	Read a page of data as a List of SecUser-derived instances sorted by their primary keys,
	 *	as identified by the duplicate PwdResetIdx key attributes.
	 *
	 *	@param	PasswordResetUuid6	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecUser-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecUserObj> pageSecUserByPwdResetIdx( CFLibUuid6 PasswordResetUuid6,
		CFLibDbKeyHash256 priorSecUserId );

	/**
	 *	Read a page of data as a List of SecUser-derived instances sorted by their primary keys,
	 *	as identified by the duplicate DefDevIdx key attributes.
	 *
	 *	@param	DfltDevUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@param	DfltDevName	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecUser-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecUserObj> pageSecUserByDefDevIdx( CFLibDbKeyHash256 DfltDevUserId,
		String DfltDevName,
		CFLibDbKeyHash256 priorSecUserId );

	/**
	 *	Internal use only.
	 */
	ICFSecSecUserObj updateSecUser( ICFSecSecUserObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecUser( ICFSecSecUserObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecUserId	The SecUser key attribute of the instance generating the id.
	 */
	void deleteSecUserByIdIdx( CFLibDbKeyHash256 SecUserId );

	/**
	 *	Internal use only.
	 *
	 *	@param	LoginId	The SecUser key attribute of the instance generating the id.
	 */
	void deleteSecUserByULoginIdx(String LoginId );

	/**
	 *	Internal use only.
	 *
	 *	@param	EMailConfirmUuid6	The SecUser key attribute of the instance generating the id.
	 */
	void deleteSecUserByEMConfIdx( CFLibUuid6 EMailConfirmUuid6 );

	/**
	 *	Internal use only.
	 *
	 *	@param	PasswordResetUuid6	The SecUser key attribute of the instance generating the id.
	 */
	void deleteSecUserByPwdResetIdx( CFLibUuid6 PasswordResetUuid6 );

	/**
	 *	Internal use only.
	 *
	 *	@param	DfltDevUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@param	DfltDevName	The SecUser key attribute of the instance generating the id.
	 */
	void deleteSecUserByDefDevIdx( CFLibDbKeyHash256 DfltDevUserId,
		String DfltDevName );

	ICFSecSecUserObj getSystemUser();
}
