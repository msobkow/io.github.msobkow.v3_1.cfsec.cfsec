
// Description: Java 25 DbIO interface for SecGroup.

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
 *	CFSecSecGroupTable database interface for SecGroup
 */
public interface ICFSecSecGroupTable
{

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecSecGroup createSecGroup( ICFSecAuthorization Authorization,
		ICFSecSecGroup rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecSecGroup updateSecGroup( ICFSecAuthorization Authorization,
		ICFSecSecGroup rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteSecGroup( ICFSecAuthorization Authorization,
		ICFSecSecGroup rec );
	/**
	 *	Delete the SecGroup instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSecGroupByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argKey );
	/**
	 *	Delete the SecGroup instances identified by the key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGroup key attribute of the instance generating the id.
	 */
	void deleteSecGroupByClusterIdx( ICFSecAuthorization Authorization,
		long argClusterId );

	/**
	 *	Delete the SecGroup instances identified by the key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecGroupByClusterIdx( ICFSecAuthorization Authorization,
		ICFSecSecGroupByClusterIdxKey argKey );
	/**
	 *	Delete the SecGroup instances identified by the key ClusterVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@param	IsVisible	The SecGroup key attribute of the instance generating the id.
	 */
	void deleteSecGroupByClusterVisIdx( ICFSecAuthorization Authorization,
		long argClusterId,
		boolean argIsVisible );

	/**
	 *	Delete the SecGroup instances identified by the key ClusterVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecGroupByClusterVisIdx( ICFSecAuthorization Authorization,
		ICFSecSecGroupByClusterVisIdxKey argKey );
	/**
	 *	Delete the SecGroup instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SecGroup key attribute of the instance generating the id.
	 */
	void deleteSecGroupByUNameIdx( ICFSecAuthorization Authorization,
		long argClusterId,
		String argName );

	/**
	 *	Delete the SecGroup instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecGroupByUNameIdx( ICFSecAuthorization Authorization,
		ICFSecSecGroupByUNameIdxKey argKey );


	/**
	 *	Read the derived SecGroup record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecGroup instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecGroup readDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the derived SecGroup record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecGroup instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecGroup lockDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all SecGroup instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecSecGroup[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived SecGroup record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecGroupId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecGroup readDerivedByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecGroupId );

	/**
	 *	Read an array of the derived SecGroup record instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecGroup[] readDerivedByClusterIdx( ICFSecAuthorization Authorization,
		long ClusterId );

	/**
	 *	Read an array of the derived SecGroup record instances identified by the duplicate key ClusterVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@param	IsVisible	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecGroup[] readDerivedByClusterVisIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		boolean IsVisible );

	/**
	 *	Read the derived SecGroup record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecGroup readDerivedByUNameIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		String Name );

	/**
	 *	Read the specific SecGroup record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecGroup instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGroup readRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the specific SecGroup record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecGroup instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGroup lockRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all the specific SecGroup record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecGroup instances in the database accessible for the Authorization.
	 */
	ICFSecSecGroup[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read the specific SecGroup record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecGroupId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGroup readRecByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecGroupId );

	/**
	 *	Read an array of the specific SecGroup record instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGroup[] readRecByClusterIdx( ICFSecAuthorization Authorization,
		long ClusterId );

	/**
	 *	Read an array of the specific SecGroup record instances identified by the duplicate key ClusterVisIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@param	IsVisible	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGroup[] readRecByClusterVisIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		boolean IsVisible );

	/**
	 *	Read the specific SecGroup record instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGroup readRecByUNameIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		String Name );
}
