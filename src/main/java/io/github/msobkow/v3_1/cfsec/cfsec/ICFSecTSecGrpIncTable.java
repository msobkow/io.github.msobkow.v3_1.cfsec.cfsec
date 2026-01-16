
// Description: Java 25 DbIO interface for TSecGrpInc.

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
 *	CFSecTSecGrpIncTable database interface for TSecGrpInc
 */
public interface ICFSecTSecGrpIncTable
{

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecTSecGrpInc createTSecGrpInc( ICFSecAuthorization Authorization,
		ICFSecTSecGrpInc rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecTSecGrpInc updateTSecGrpInc( ICFSecAuthorization Authorization,
		ICFSecTSecGrpInc rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteTSecGrpInc( ICFSecAuthorization Authorization,
		ICFSecTSecGrpInc rec );
	/**
	 *	Delete the TSecGrpInc instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteTSecGrpIncByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argKey );
	/**
	 *	Delete the TSecGrpInc instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGrpInc key attribute of the instance generating the id.
	 */
	void deleteTSecGrpIncByTenantIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argTenantId );

	/**
	 *	Delete the TSecGrpInc instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTSecGrpIncByTenantIdx( ICFSecAuthorization Authorization,
		ICFSecTSecGrpIncByTenantIdxKey argKey );
	/**
	 *	Delete the TSecGrpInc instances identified by the key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TSecGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 */
	void deleteTSecGrpIncByGroupIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argTSecGroupId );

	/**
	 *	Delete the TSecGrpInc instances identified by the key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTSecGrpIncByGroupIdx( ICFSecAuthorization Authorization,
		ICFSecTSecGrpIncByGroupIdxKey argKey );
	/**
	 *	Delete the TSecGrpInc instances identified by the key IncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	IncludeGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 */
	void deleteTSecGrpIncByIncludeIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argIncludeGroupId );

	/**
	 *	Delete the TSecGrpInc instances identified by the key IncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTSecGrpIncByIncludeIdx( ICFSecAuthorization Authorization,
		ICFSecTSecGrpIncByIncludeIdxKey argKey );
	/**
	 *	Delete the TSecGrpInc instances identified by the key UIncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	TSecGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	IncludeGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 */
	void deleteTSecGrpIncByUIncludeIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argTenantId,
		CFLibDbKeyHash256 argTSecGroupId,
		CFLibDbKeyHash256 argIncludeGroupId );

	/**
	 *	Delete the TSecGrpInc instances identified by the key UIncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTSecGrpIncByUIncludeIdx( ICFSecAuthorization Authorization,
		ICFSecTSecGrpIncByUIncludeIdxKey argKey );


	/**
	 *	Read the derived TSecGrpInc record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TSecGrpInc instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecTSecGrpInc readDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the derived TSecGrpInc record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TSecGrpInc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecTSecGrpInc lockDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all TSecGrpInc instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecTSecGrpInc[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived TSecGrpInc record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TSecGrpIncId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecTSecGrpInc readDerivedByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TSecGrpIncId );

	/**
	 *	Read an array of the derived TSecGrpInc record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecTSecGrpInc[] readDerivedByTenantIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TenantId );

	/**
	 *	Read an array of the derived TSecGrpInc record instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TSecGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecTSecGrpInc[] readDerivedByGroupIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TSecGroupId );

	/**
	 *	Read an array of the derived TSecGrpInc record instances identified by the duplicate key IncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	IncludeGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecTSecGrpInc[] readDerivedByIncludeIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 IncludeGroupId );

	/**
	 *	Read the derived TSecGrpInc record instance identified by the unique key UIncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	TSecGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	IncludeGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecTSecGrpInc readDerivedByUIncludeIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TenantId,
		CFLibDbKeyHash256 TSecGroupId,
		CFLibDbKeyHash256 IncludeGroupId );

	/**
	 *	Read the specific TSecGrpInc record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TSecGrpInc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpInc readRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the specific TSecGrpInc record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TSecGrpInc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpInc lockRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all the specific TSecGrpInc record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific TSecGrpInc instances in the database accessible for the Authorization.
	 */
	ICFSecTSecGrpInc[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read a page of all the specific TSecGrpInc record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific TSecGrpInc instances in the database accessible for the Authorization.
	 */
	ICFSecTSecGrpInc[] pageAllRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 priorTSecGrpIncId );

	/**
	 *	Read the specific TSecGrpInc record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TSecGrpIncId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpInc readRecByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TSecGrpIncId );

	/**
	 *	Read an array of the specific TSecGrpInc record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpInc[] readRecByTenantIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TenantId );

	/**
	 *	Read an array of the specific TSecGrpInc record instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TSecGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpInc[] readRecByGroupIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TSecGroupId );

	/**
	 *	Read an array of the specific TSecGrpInc record instances identified by the duplicate key IncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	IncludeGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpInc[] readRecByIncludeIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 IncludeGroupId );

	/**
	 *	Read the specific TSecGrpInc record instance identified by the unique key UIncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	TSecGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	IncludeGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpInc readRecByUIncludeIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TenantId,
		CFLibDbKeyHash256 TSecGroupId,
		CFLibDbKeyHash256 IncludeGroupId );

	/**
	 *	Read a page array of the specific TSecGrpInc record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpInc[] pageRecByTenantIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TenantId,
		CFLibDbKeyHash256 priorTSecGrpIncId );

	/**
	 *	Read a page array of the specific TSecGrpInc record instances identified by the duplicate key GroupIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TSecGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpInc[] pageRecByGroupIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TSecGroupId,
		CFLibDbKeyHash256 priorTSecGrpIncId );

	/**
	 *	Read a page array of the specific TSecGrpInc record instances identified by the duplicate key IncludeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	IncludeGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpInc[] pageRecByIncludeIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 IncludeGroupId,
		CFLibDbKeyHash256 priorTSecGrpIncId );
}
