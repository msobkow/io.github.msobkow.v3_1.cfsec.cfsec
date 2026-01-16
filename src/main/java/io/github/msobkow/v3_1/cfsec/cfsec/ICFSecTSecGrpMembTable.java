
// Description: Java 25 DbIO interface for TSecGrpMemb.

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
 *	CFSecTSecGrpMembTable database interface for TSecGrpMemb
 */
public interface ICFSecTSecGrpMembTable
{

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecTSecGrpMemb createTSecGrpMemb( ICFSecAuthorization Authorization,
		ICFSecTSecGrpMemb rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecTSecGrpMemb updateTSecGrpMemb( ICFSecAuthorization Authorization,
		ICFSecTSecGrpMemb rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteTSecGrpMemb( ICFSecAuthorization Authorization,
		ICFSecTSecGrpMemb rec );
	/**
	 *	Delete the TSecGrpMemb instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteTSecGrpMembByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argKey );
	/**
	 *	Delete the TSecGrpMemb instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteTSecGrpMembByTenantIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argTenantId );

	/**
	 *	Delete the TSecGrpMemb instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTSecGrpMembByTenantIdx( ICFSecAuthorization Authorization,
		ICFSecTSecGrpMembByTenantIdxKey argKey );
	/**
	 *	Delete the TSecGrpMemb instances identified by the key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TSecGroupId	The TSecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteTSecGrpMembByGroupIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argTSecGroupId );

	/**
	 *	Delete the TSecGrpMemb instances identified by the key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTSecGrpMembByGroupIdx( ICFSecAuthorization Authorization,
		ICFSecTSecGrpMembByGroupIdxKey argKey );
	/**
	 *	Delete the TSecGrpMemb instances identified by the key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The TSecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteTSecGrpMembByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecUserId );

	/**
	 *	Delete the TSecGrpMemb instances identified by the key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTSecGrpMembByUserIdx( ICFSecAuthorization Authorization,
		ICFSecTSecGrpMembByUserIdxKey argKey );
	/**
	 *	Delete the TSecGrpMemb instances identified by the key UUserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	TSecGroupId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecUserId	The TSecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteTSecGrpMembByUUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argTenantId,
		CFLibDbKeyHash256 argTSecGroupId,
		CFLibDbKeyHash256 argSecUserId );

	/**
	 *	Delete the TSecGrpMemb instances identified by the key UUserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTSecGrpMembByUUserIdx( ICFSecAuthorization Authorization,
		ICFSecTSecGrpMembByUUserIdxKey argKey );


	/**
	 *	Read the derived TSecGrpMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TSecGrpMemb instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecTSecGrpMemb readDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the derived TSecGrpMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TSecGrpMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecTSecGrpMemb lockDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all TSecGrpMemb instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecTSecGrpMemb[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived TSecGrpMemb record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TSecGrpMembId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecTSecGrpMemb readDerivedByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TSecGrpMembId );

	/**
	 *	Read an array of the derived TSecGrpMemb record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecTSecGrpMemb[] readDerivedByTenantIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TenantId );

	/**
	 *	Read an array of the derived TSecGrpMemb record instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TSecGroupId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecTSecGrpMemb[] readDerivedByGroupIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TSecGroupId );

	/**
	 *	Read an array of the derived TSecGrpMemb record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecTSecGrpMemb[] readDerivedByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read the derived TSecGrpMemb record instance identified by the unique key UUserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	TSecGroupId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecUserId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecTSecGrpMemb readDerivedByUUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TenantId,
		CFLibDbKeyHash256 TSecGroupId,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read the specific TSecGrpMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TSecGrpMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpMemb readRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the specific TSecGrpMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TSecGrpMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpMemb lockRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all the specific TSecGrpMemb record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific TSecGrpMemb instances in the database accessible for the Authorization.
	 */
	ICFSecTSecGrpMemb[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read a page of all the specific TSecGrpMemb record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific TSecGrpMemb instances in the database accessible for the Authorization.
	 */
	ICFSecTSecGrpMemb[] pageAllRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 priorTSecGrpMembId );

	/**
	 *	Read the specific TSecGrpMemb record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TSecGrpMembId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpMemb readRecByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TSecGrpMembId );

	/**
	 *	Read an array of the specific TSecGrpMemb record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpMemb[] readRecByTenantIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TenantId );

	/**
	 *	Read an array of the specific TSecGrpMemb record instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TSecGroupId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpMemb[] readRecByGroupIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TSecGroupId );

	/**
	 *	Read an array of the specific TSecGrpMemb record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpMemb[] readRecByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read the specific TSecGrpMemb record instance identified by the unique key UUserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	TSecGroupId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecUserId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpMemb readRecByUUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TenantId,
		CFLibDbKeyHash256 TSecGroupId,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read a page array of the specific TSecGrpMemb record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpMemb[] pageRecByTenantIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TenantId,
		CFLibDbKeyHash256 priorTSecGrpMembId );

	/**
	 *	Read a page array of the specific TSecGrpMemb record instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TSecGroupId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpMemb[] pageRecByGroupIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TSecGroupId,
		CFLibDbKeyHash256 priorTSecGrpMembId );

	/**
	 *	Read a page array of the specific TSecGrpMemb record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpMemb[] pageRecByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId,
		CFLibDbKeyHash256 priorTSecGrpMembId );
}
