
// Description: Java 25 DbIO interface for SecUser.

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

package io.github.msobkow.v3_1.cfsec.cfsec;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import io.github.msobkow.v3_1.cflib.*;
import io.github.msobkow.v3_1.cflib.dbutil.*;
import io.github.msobkow.v3_1.cfsec.cfsecobj.*;

/*
 *	CFSecSecUserTable database interface for SecUser
 */
public interface ICFSecSecUserTable
{

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecSecUser createSecUser( ICFSecAuthorization Authorization,
		ICFSecSecUser rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecSecUser updateSecUser( ICFSecAuthorization Authorization,
		ICFSecSecUser rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteSecUser( ICFSecAuthorization Authorization,
		ICFSecSecUser rec );
	/**
	 *	Delete the SecUser instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSecUserByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argKey );
	/**
	 *	Delete the SecUser instances identified by the key ULoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecUser key attribute of the instance generating the id.
	 */
	void deleteSecUserByULoginIdx( ICFSecAuthorization Authorization,
		String argLoginId );

	/**
	 *	Delete the SecUser instances identified by the key ULoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecUserByULoginIdx( ICFSecAuthorization Authorization,
		ICFSecSecUserByULoginIdxKey argKey );
	/**
	 *	Delete the SecUser instances identified by the key EMConfIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EMailConfirmUuid6	The SecUser key attribute of the instance generating the id.
	 */
	void deleteSecUserByEMConfIdx( ICFSecAuthorization Authorization,
		CFLibUuid6 argEMailConfirmUuid6 );

	/**
	 *	Delete the SecUser instances identified by the key EMConfIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecUserByEMConfIdx( ICFSecAuthorization Authorization,
		ICFSecSecUserByEMConfIdxKey argKey );
	/**
	 *	Delete the SecUser instances identified by the key PwdResetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PasswordResetUuid6	The SecUser key attribute of the instance generating the id.
	 */
	void deleteSecUserByPwdResetIdx( ICFSecAuthorization Authorization,
		CFLibUuid6 argPasswordResetUuid6 );

	/**
	 *	Delete the SecUser instances identified by the key PwdResetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecUserByPwdResetIdx( ICFSecAuthorization Authorization,
		ICFSecSecUserByPwdResetIdxKey argKey );
	/**
	 *	Delete the SecUser instances identified by the key DefDevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DfltDevUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@param	DfltDevName	The SecUser key attribute of the instance generating the id.
	 */
	void deleteSecUserByDefDevIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argDfltDevUserId,
		String argDfltDevName );

	/**
	 *	Delete the SecUser instances identified by the key DefDevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecUserByDefDevIdx( ICFSecAuthorization Authorization,
		ICFSecSecUserByDefDevIdxKey argKey );


	/**
	 *	Read the derived SecUser record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecUser instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecUser readDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the derived SecUser record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecUser instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecUser lockDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all SecUser instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecSecUser[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived SecUser record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecUser readDerivedByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read the derived SecUser record instance identified by the unique key ULoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecUser readDerivedByULoginIdx( ICFSecAuthorization Authorization,
		String LoginId );

	/**
	 *	Read an array of the derived SecUser record instances identified by the duplicate key EMConfIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EMailConfirmUuid6	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecUser[] readDerivedByEMConfIdx( ICFSecAuthorization Authorization,
		CFLibUuid6 EMailConfirmUuid6 );

	/**
	 *	Read an array of the derived SecUser record instances identified by the duplicate key PwdResetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PasswordResetUuid6	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecUser[] readDerivedByPwdResetIdx( ICFSecAuthorization Authorization,
		CFLibUuid6 PasswordResetUuid6 );

	/**
	 *	Read an array of the derived SecUser record instances identified by the duplicate key DefDevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DfltDevUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@param	DfltDevName	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecUser[] readDerivedByDefDevIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 DfltDevUserId,
		String DfltDevName );

	/**
	 *	Read the specific SecUser record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecUser instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecUser readRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the specific SecUser record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecUser instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecUser lockRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all the specific SecUser record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecUser instances in the database accessible for the Authorization.
	 */
	ICFSecSecUser[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecUser record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecUser instances in the database accessible for the Authorization.
	 */
	ICFSecSecUser[] pageAllRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 priorSecUserId );

	/**
	 *	Read the specific SecUser record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecUser readRecByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read the specific SecUser record instance identified by the unique key ULoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecUser readRecByULoginIdx( ICFSecAuthorization Authorization,
		String LoginId );

	/**
	 *	Read an array of the specific SecUser record instances identified by the duplicate key EMConfIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EMailConfirmUuid6	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecUser[] readRecByEMConfIdx( ICFSecAuthorization Authorization,
		CFLibUuid6 EMailConfirmUuid6 );

	/**
	 *	Read an array of the specific SecUser record instances identified by the duplicate key PwdResetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PasswordResetUuid6	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecUser[] readRecByPwdResetIdx( ICFSecAuthorization Authorization,
		CFLibUuid6 PasswordResetUuid6 );

	/**
	 *	Read an array of the specific SecUser record instances identified by the duplicate key DefDevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DfltDevUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@param	DfltDevName	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecUser[] readRecByDefDevIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 DfltDevUserId,
		String DfltDevName );

	/**
	 *	Read a page array of the specific SecUser record instances identified by the duplicate key EMConfIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EMailConfirmUuid6	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecUser[] pageRecByEMConfIdx( ICFSecAuthorization Authorization,
		CFLibUuid6 EMailConfirmUuid6,
		CFLibDbKeyHash256 priorSecUserId );

	/**
	 *	Read a page array of the specific SecUser record instances identified by the duplicate key PwdResetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PasswordResetUuid6	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecUser[] pageRecByPwdResetIdx( ICFSecAuthorization Authorization,
		CFLibUuid6 PasswordResetUuid6,
		CFLibDbKeyHash256 priorSecUserId );

	/**
	 *	Read a page array of the specific SecUser record instances identified by the duplicate key DefDevIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	DfltDevUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@param	DfltDevName	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecUser[] pageRecByDefDevIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 DfltDevUserId,
		String DfltDevName,
		CFLibDbKeyHash256 priorSecUserId );
}
