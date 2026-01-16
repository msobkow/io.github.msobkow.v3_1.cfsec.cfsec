
// Description: Java 25 DbIO interface for SecGrpMemb.

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
 *	CFSecSecGrpMembTable database interface for SecGrpMemb
 */
public interface ICFSecSecGrpMembTable
{

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecSecGrpMemb createSecGrpMemb( ICFSecAuthorization Authorization,
		ICFSecSecGrpMemb rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecSecGrpMemb updateSecGrpMemb( ICFSecAuthorization Authorization,
		ICFSecSecGrpMemb rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteSecGrpMemb( ICFSecAuthorization Authorization,
		ICFSecSecGrpMemb rec );
	/**
	 *	Delete the SecGrpMemb instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSecGrpMembByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argKey );
	/**
	 *	Delete the SecGrpMemb instances identified by the key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecGrpMembByClusterIdx( ICFSecAuthorization Authorization,
		long argClusterId );

	/**
	 *	Delete the SecGrpMemb instances identified by the key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecGrpMembByClusterIdx( ICFSecAuthorization Authorization,
		ICFSecSecGrpMembByClusterIdxKey argKey );
	/**
	 *	Delete the SecGrpMemb instances identified by the key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecGrpMembByGroupIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecGroupId );

	/**
	 *	Delete the SecGrpMemb instances identified by the key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecGrpMembByGroupIdx( ICFSecAuthorization Authorization,
		ICFSecSecGrpMembByGroupIdxKey argKey );
	/**
	 *	Delete the SecGrpMemb instances identified by the key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecGrpMembByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecUserId );

	/**
	 *	Delete the SecGrpMemb instances identified by the key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecGrpMembByUserIdx( ICFSecAuthorization Authorization,
		ICFSecSecGrpMembByUserIdxKey argKey );
	/**
	 *	Delete the SecGrpMemb instances identified by the key UUserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecGrpMembByUUserIdx( ICFSecAuthorization Authorization,
		long argClusterId,
		CFLibDbKeyHash256 argSecGroupId,
		CFLibDbKeyHash256 argSecUserId );

	/**
	 *	Delete the SecGrpMemb instances identified by the key UUserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecGrpMembByUUserIdx( ICFSecAuthorization Authorization,
		ICFSecSecGrpMembByUUserIdxKey argKey );


	/**
	 *	Read the derived SecGrpMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecGrpMemb instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecGrpMemb readDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the derived SecGrpMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecGrpMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecGrpMemb lockDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all SecGrpMemb instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecSecGrpMemb[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived SecGrpMemb record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecGrpMembId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecGrpMemb readDerivedByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecGrpMembId );

	/**
	 *	Read an array of the derived SecGrpMemb record instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecGrpMemb[] readDerivedByClusterIdx( ICFSecAuthorization Authorization,
		long ClusterId );

	/**
	 *	Read an array of the derived SecGrpMemb record instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecGrpMemb[] readDerivedByGroupIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecGroupId );

	/**
	 *	Read an array of the derived SecGrpMemb record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecGrpMemb[] readDerivedByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read the derived SecGrpMemb record instance identified by the unique key UUserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecGrpMemb readDerivedByUUserIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		CFLibDbKeyHash256 SecGroupId,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read the specific SecGrpMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecGrpMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpMemb readRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the specific SecGrpMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecGrpMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpMemb lockRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all the specific SecGrpMemb record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecGrpMemb instances in the database accessible for the Authorization.
	 */
	ICFSecSecGrpMemb[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecGrpMemb record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecGrpMemb instances in the database accessible for the Authorization.
	 */
	ICFSecSecGrpMemb[] pageAllRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 priorSecGrpMembId );

	/**
	 *	Read the specific SecGrpMemb record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecGrpMembId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpMemb readRecByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecGrpMembId );

	/**
	 *	Read an array of the specific SecGrpMemb record instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpMemb[] readRecByClusterIdx( ICFSecAuthorization Authorization,
		long ClusterId );

	/**
	 *	Read an array of the specific SecGrpMemb record instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpMemb[] readRecByGroupIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecGroupId );

	/**
	 *	Read an array of the specific SecGrpMemb record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpMemb[] readRecByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read the specific SecGrpMemb record instance identified by the unique key UUserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpMemb readRecByUUserIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		CFLibDbKeyHash256 SecGroupId,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read a page array of the specific SecGrpMemb record instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpMemb[] pageRecByClusterIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		CFLibDbKeyHash256 priorSecGrpMembId );

	/**
	 *	Read a page array of the specific SecGrpMemb record instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpMemb[] pageRecByGroupIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecGroupId,
		CFLibDbKeyHash256 priorSecGrpMembId );

	/**
	 *	Read a page array of the specific SecGrpMemb record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpMemb[] pageRecByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId,
		CFLibDbKeyHash256 priorSecGrpMembId );
}
