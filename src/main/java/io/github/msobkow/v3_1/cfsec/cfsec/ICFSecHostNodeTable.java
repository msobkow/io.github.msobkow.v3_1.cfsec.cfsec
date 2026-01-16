
// Description: Java 25 DbIO interface for HostNode.

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
 *	CFSecHostNodeTable database interface for HostNode
 */
public interface ICFSecHostNodeTable
{

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecHostNode createHostNode( ICFSecAuthorization Authorization,
		ICFSecHostNode rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecHostNode updateHostNode( ICFSecAuthorization Authorization,
		ICFSecHostNode rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteHostNode( ICFSecAuthorization Authorization,
		ICFSecHostNode rec );
	/**
	 *	Delete the HostNode instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteHostNodeByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argKey );
	/**
	 *	Delete the HostNode instances identified by the key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 */
	void deleteHostNodeByClusterIdx( ICFSecAuthorization Authorization,
		long argClusterId );

	/**
	 *	Delete the HostNode instances identified by the key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteHostNodeByClusterIdx( ICFSecAuthorization Authorization,
		ICFSecHostNodeByClusterIdxKey argKey );
	/**
	 *	Delete the HostNode instances identified by the key UDescrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	Description	The HostNode key attribute of the instance generating the id.
	 */
	void deleteHostNodeByUDescrIdx( ICFSecAuthorization Authorization,
		long argClusterId,
		String argDescription );

	/**
	 *	Delete the HostNode instances identified by the key UDescrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteHostNodeByUDescrIdx( ICFSecAuthorization Authorization,
		ICFSecHostNodeByUDescrIdxKey argKey );
	/**
	 *	Delete the HostNode instances identified by the key HostNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	HostName	The HostNode key attribute of the instance generating the id.
	 */
	void deleteHostNodeByHostNameIdx( ICFSecAuthorization Authorization,
		long argClusterId,
		String argHostName );

	/**
	 *	Delete the HostNode instances identified by the key HostNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteHostNodeByHostNameIdx( ICFSecAuthorization Authorization,
		ICFSecHostNodeByHostNameIdxKey argKey );


	/**
	 *	Read the derived HostNode record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the HostNode instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecHostNode readDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the derived HostNode record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the HostNode instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecHostNode lockDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all HostNode instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecHostNode[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived HostNode record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	HostNodeId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecHostNode readDerivedByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 HostNodeId );

	/**
	 *	Read an array of the derived HostNode record instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecHostNode[] readDerivedByClusterIdx( ICFSecAuthorization Authorization,
		long ClusterId );

	/**
	 *	Read the derived HostNode record instance identified by the unique key UDescrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	Description	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecHostNode readDerivedByUDescrIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		String Description );

	/**
	 *	Read the derived HostNode record instance identified by the unique key HostNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	HostName	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecHostNode readDerivedByHostNameIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		String HostName );

	/**
	 *	Read the specific HostNode record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the HostNode instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecHostNode readRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the specific HostNode record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the HostNode instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecHostNode lockRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all the specific HostNode record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific HostNode instances in the database accessible for the Authorization.
	 */
	ICFSecHostNode[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read a page of all the specific HostNode record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific HostNode instances in the database accessible for the Authorization.
	 */
	ICFSecHostNode[] pageAllRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 priorHostNodeId );

	/**
	 *	Read the specific HostNode record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	HostNodeId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecHostNode readRecByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 HostNodeId );

	/**
	 *	Read an array of the specific HostNode record instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecHostNode[] readRecByClusterIdx( ICFSecAuthorization Authorization,
		long ClusterId );

	/**
	 *	Read the specific HostNode record instance identified by the unique key UDescrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	Description	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecHostNode readRecByUDescrIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		String Description );

	/**
	 *	Read the specific HostNode record instance identified by the unique key HostNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	HostName	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecHostNode readRecByHostNameIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		String HostName );

	/**
	 *	Read a page array of the specific HostNode record instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecHostNode[] pageRecByClusterIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		CFLibDbKeyHash256 priorHostNodeId );
}
