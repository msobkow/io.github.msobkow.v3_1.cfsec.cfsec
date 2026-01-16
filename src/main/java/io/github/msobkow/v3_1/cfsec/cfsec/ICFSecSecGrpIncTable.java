
// Description: Java 25 DbIO interface for SecGrpInc.

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
 *	CFSecSecGrpIncTable database interface for SecGrpInc
 */
public interface ICFSecSecGrpIncTable
{

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecSecGrpInc createSecGrpInc( ICFSecAuthorization Authorization,
		ICFSecSecGrpInc rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecSecGrpInc updateSecGrpInc( ICFSecAuthorization Authorization,
		ICFSecSecGrpInc rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteSecGrpInc( ICFSecAuthorization Authorization,
		ICFSecSecGrpInc rec );
	/**
	 *	Delete the SecGrpInc instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSecGrpIncByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argKey );
	/**
	 *	Delete the SecGrpInc instances identified by the key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecGrpIncByClusterIdx( ICFSecAuthorization Authorization,
		long argClusterId );

	/**
	 *	Delete the SecGrpInc instances identified by the key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecGrpIncByClusterIdx( ICFSecAuthorization Authorization,
		ICFSecSecGrpIncByClusterIdxKey argKey );
	/**
	 *	Delete the SecGrpInc instances identified by the key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecGrpIncByGroupIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecGroupId );

	/**
	 *	Delete the SecGrpInc instances identified by the key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecGrpIncByGroupIdx( ICFSecAuthorization Authorization,
		ICFSecSecGrpIncByGroupIdxKey argKey );
	/**
	 *	Delete the SecGrpInc instances identified by the key IncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	IncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecGrpIncByIncludeIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argIncludeGroupId );

	/**
	 *	Delete the SecGrpInc instances identified by the key IncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecGrpIncByIncludeIdx( ICFSecAuthorization Authorization,
		ICFSecSecGrpIncByIncludeIdxKey argKey );
	/**
	 *	Delete the SecGrpInc instances identified by the key UIncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	SecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	IncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecGrpIncByUIncludeIdx( ICFSecAuthorization Authorization,
		long argClusterId,
		CFLibDbKeyHash256 argSecGroupId,
		CFLibDbKeyHash256 argIncludeGroupId );

	/**
	 *	Delete the SecGrpInc instances identified by the key UIncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecGrpIncByUIncludeIdx( ICFSecAuthorization Authorization,
		ICFSecSecGrpIncByUIncludeIdxKey argKey );


	/**
	 *	Read the derived SecGrpInc record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecGrpInc instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecGrpInc readDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the derived SecGrpInc record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecGrpInc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecGrpInc lockDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all SecGrpInc instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecSecGrpInc[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived SecGrpInc record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecGrpIncId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecGrpInc readDerivedByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecGrpIncId );

	/**
	 *	Read an array of the derived SecGrpInc record instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecGrpInc[] readDerivedByClusterIdx( ICFSecAuthorization Authorization,
		long ClusterId );

	/**
	 *	Read an array of the derived SecGrpInc record instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecGrpInc[] readDerivedByGroupIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecGroupId );

	/**
	 *	Read an array of the derived SecGrpInc record instances identified by the duplicate key IncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	IncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecGrpInc[] readDerivedByIncludeIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 IncludeGroupId );

	/**
	 *	Read the derived SecGrpInc record instance identified by the unique key UIncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	SecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	IncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecGrpInc readDerivedByUIncludeIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		CFLibDbKeyHash256 SecGroupId,
		CFLibDbKeyHash256 IncludeGroupId );

	/**
	 *	Read the specific SecGrpInc record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecGrpInc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpInc readRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the specific SecGrpInc record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecGrpInc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpInc lockRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all the specific SecGrpInc record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecGrpInc instances in the database accessible for the Authorization.
	 */
	ICFSecSecGrpInc[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecGrpInc record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecGrpInc instances in the database accessible for the Authorization.
	 */
	ICFSecSecGrpInc[] pageAllRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 priorSecGrpIncId );

	/**
	 *	Read the specific SecGrpInc record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecGrpIncId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpInc readRecByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecGrpIncId );

	/**
	 *	Read an array of the specific SecGrpInc record instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpInc[] readRecByClusterIdx( ICFSecAuthorization Authorization,
		long ClusterId );

	/**
	 *	Read an array of the specific SecGrpInc record instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpInc[] readRecByGroupIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecGroupId );

	/**
	 *	Read an array of the specific SecGrpInc record instances identified by the duplicate key IncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	IncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpInc[] readRecByIncludeIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 IncludeGroupId );

	/**
	 *	Read the specific SecGrpInc record instance identified by the unique key UIncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	SecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	IncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpInc readRecByUIncludeIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		CFLibDbKeyHash256 SecGroupId,
		CFLibDbKeyHash256 IncludeGroupId );

	/**
	 *	Read a page array of the specific SecGrpInc record instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpInc[] pageRecByClusterIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		CFLibDbKeyHash256 priorSecGrpIncId );

	/**
	 *	Read a page array of the specific SecGrpInc record instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpInc[] pageRecByGroupIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecGroupId,
		CFLibDbKeyHash256 priorSecGrpIncId );

	/**
	 *	Read a page array of the specific SecGrpInc record instances identified by the duplicate key IncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	IncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpInc[] pageRecByIncludeIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 IncludeGroupId,
		CFLibDbKeyHash256 priorSecGrpIncId );
}
