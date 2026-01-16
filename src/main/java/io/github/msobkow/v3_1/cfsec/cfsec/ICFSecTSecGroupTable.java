
// Description: Java 25 DbIO interface for TSecGroup.

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
 *	CFSecTSecGroupTable database interface for TSecGroup
 */
public interface ICFSecTSecGroupTable
{

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecTSecGroup createTSecGroup( ICFSecAuthorization Authorization,
		ICFSecTSecGroup rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecTSecGroup updateTSecGroup( ICFSecAuthorization Authorization,
		ICFSecTSecGroup rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteTSecGroup( ICFSecAuthorization Authorization,
		ICFSecTSecGroup rec );
	/**
	 *	Delete the TSecGroup instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteTSecGroupByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argKey );
	/**
	 *	Delete the TSecGroup instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGroup key attribute of the instance generating the id.
	 */
	void deleteTSecGroupByTenantIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argTenantId );

	/**
	 *	Delete the TSecGroup instances identified by the key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTSecGroupByTenantIdx( ICFSecAuthorization Authorization,
		ICFSecTSecGroupByTenantIdxKey argKey );
	/**
	 *	Delete the TSecGroup instances identified by the key TenantVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@param	IsVisible	The TSecGroup key attribute of the instance generating the id.
	 */
	void deleteTSecGroupByTenantVisIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argTenantId,
		boolean argIsVisible );

	/**
	 *	Delete the TSecGroup instances identified by the key TenantVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTSecGroupByTenantVisIdx( ICFSecAuthorization Authorization,
		ICFSecTSecGroupByTenantVisIdxKey argKey );
	/**
	 *	Delete the TSecGroup instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TSecGroup key attribute of the instance generating the id.
	 */
	void deleteTSecGroupByUNameIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argTenantId,
		String argName );

	/**
	 *	Delete the TSecGroup instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteTSecGroupByUNameIdx( ICFSecAuthorization Authorization,
		ICFSecTSecGroupByUNameIdxKey argKey );


	/**
	 *	Read the derived TSecGroup record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TSecGroup instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecTSecGroup readDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the derived TSecGroup record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TSecGroup instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecTSecGroup lockDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all TSecGroup instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecTSecGroup[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived TSecGroup record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TSecGroupId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecTSecGroup readDerivedByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TSecGroupId );

	/**
	 *	Read an array of the derived TSecGroup record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecTSecGroup[] readDerivedByTenantIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TenantId );

	/**
	 *	Read an array of the derived TSecGroup record instances identified by the duplicate key TenantVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@param	IsVisible	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecTSecGroup[] readDerivedByTenantVisIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TenantId,
		boolean IsVisible );

	/**
	 *	Read the derived TSecGroup record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecTSecGroup readDerivedByUNameIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TenantId,
		String Name );

	/**
	 *	Read the specific TSecGroup record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TSecGroup instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGroup readRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the specific TSecGroup record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the TSecGroup instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGroup lockRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all the specific TSecGroup record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific TSecGroup instances in the database accessible for the Authorization.
	 */
	ICFSecTSecGroup[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read the specific TSecGroup record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TSecGroupId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGroup readRecByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TSecGroupId );

	/**
	 *	Read an array of the specific TSecGroup record instances identified by the duplicate key TenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGroup[] readRecByTenantIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TenantId );

	/**
	 *	Read an array of the specific TSecGroup record instances identified by the duplicate key TenantVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@param	IsVisible	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGroup[] readRecByTenantVisIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TenantId,
		boolean IsVisible );

	/**
	 *	Read the specific TSecGroup record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TenantId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGroup readRecByUNameIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 TenantId,
		String Name );
}
