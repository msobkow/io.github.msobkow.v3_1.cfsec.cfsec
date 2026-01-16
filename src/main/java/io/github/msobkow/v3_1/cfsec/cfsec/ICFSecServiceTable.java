
// Description: Java 25 DbIO interface for Service.

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
 *	CFSecServiceTable database interface for Service
 */
public interface ICFSecServiceTable
{

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecService createService( ICFSecAuthorization Authorization,
		ICFSecService rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecService updateService( ICFSecAuthorization Authorization,
		ICFSecService rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteService( ICFSecAuthorization Authorization,
		ICFSecService rec );
	/**
	 *	Delete the Service instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteServiceByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argKey );
	/**
	 *	Delete the Service instances identified by the key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByClusterIdx( ICFSecAuthorization Authorization,
		long argClusterId );

	/**
	 *	Delete the Service instances identified by the key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteServiceByClusterIdx( ICFSecAuthorization Authorization,
		ICFSecServiceByClusterIdxKey argKey );
	/**
	 *	Delete the Service instances identified by the key HostIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByHostIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argHostNodeId );

	/**
	 *	Delete the Service instances identified by the key HostIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteServiceByHostIdx( ICFSecAuthorization Authorization,
		ICFSecServiceByHostIdxKey argKey );
	/**
	 *	Delete the Service instances identified by the key TypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ServiceTypeId	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByTypeIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argServiceTypeId );

	/**
	 *	Delete the Service instances identified by the key TypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteServiceByTypeIdx( ICFSecAuthorization Authorization,
		ICFSecServiceByTypeIdxKey argKey );
	/**
	 *	Delete the Service instances identified by the key UTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	ServiceTypeId	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByUTypeIdx( ICFSecAuthorization Authorization,
		long argClusterId,
		CFLibDbKeyHash256 argHostNodeId,
		CFLibDbKeyHash256 argServiceTypeId );

	/**
	 *	Delete the Service instances identified by the key UTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteServiceByUTypeIdx( ICFSecAuthorization Authorization,
		ICFSecServiceByUTypeIdxKey argKey );
	/**
	 *	Delete the Service instances identified by the key UHostPortIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	HostPort	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByUHostPortIdx( ICFSecAuthorization Authorization,
		long argClusterId,
		CFLibDbKeyHash256 argHostNodeId,
		short argHostPort );

	/**
	 *	Delete the Service instances identified by the key UHostPortIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteServiceByUHostPortIdx( ICFSecAuthorization Authorization,
		ICFSecServiceByUHostPortIdxKey argKey );


	/**
	 *	Read the derived Service record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Service instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecService readDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the derived Service record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Service instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecService lockDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all Service instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecService[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived Service record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ServiceId	The Service key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecService readDerivedByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 ServiceId );

	/**
	 *	Read an array of the derived Service record instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecService[] readDerivedByClusterIdx( ICFSecAuthorization Authorization,
		long ClusterId );

	/**
	 *	Read an array of the derived Service record instances identified by the duplicate key HostIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecService[] readDerivedByHostIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 HostNodeId );

	/**
	 *	Read an array of the derived Service record instances identified by the duplicate key TypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ServiceTypeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecService[] readDerivedByTypeIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 ServiceTypeId );

	/**
	 *	Read the derived Service record instance identified by the unique key UTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	ServiceTypeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecService readDerivedByUTypeIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		CFLibDbKeyHash256 HostNodeId,
		CFLibDbKeyHash256 ServiceTypeId );

	/**
	 *	Read the derived Service record instance identified by the unique key UHostPortIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	HostPort	The Service key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecService readDerivedByUHostPortIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		CFLibDbKeyHash256 HostNodeId,
		short HostPort );

	/**
	 *	Read the specific Service record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Service instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecService readRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Lock the specific Service record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Service instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecService lockRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 PKey );

	/**
	 *	Read all the specific Service record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific Service instances in the database accessible for the Authorization.
	 */
	ICFSecService[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read a page of all the specific Service record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific Service instances in the database accessible for the Authorization.
	 */
	ICFSecService[] pageAllRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 priorServiceId );

	/**
	 *	Read the specific Service record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ServiceId	The Service key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecService readRecByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 ServiceId );

	/**
	 *	Read an array of the specific Service record instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecService[] readRecByClusterIdx( ICFSecAuthorization Authorization,
		long ClusterId );

	/**
	 *	Read an array of the specific Service record instances identified by the duplicate key HostIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecService[] readRecByHostIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 HostNodeId );

	/**
	 *	Read an array of the specific Service record instances identified by the duplicate key TypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ServiceTypeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecService[] readRecByTypeIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 ServiceTypeId );

	/**
	 *	Read the specific Service record instance identified by the unique key UTypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	ServiceTypeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecService readRecByUTypeIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		CFLibDbKeyHash256 HostNodeId,
		CFLibDbKeyHash256 ServiceTypeId );

	/**
	 *	Read the specific Service record instance identified by the unique key UHostPortIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	HostPort	The Service key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecService readRecByUHostPortIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		CFLibDbKeyHash256 HostNodeId,
		short HostPort );

	/**
	 *	Read a page array of the specific Service record instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecService[] pageRecByClusterIdx( ICFSecAuthorization Authorization,
		long ClusterId,
		CFLibDbKeyHash256 priorServiceId );

	/**
	 *	Read a page array of the specific Service record instances identified by the duplicate key HostIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecService[] pageRecByHostIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 HostNodeId,
		CFLibDbKeyHash256 priorServiceId );

	/**
	 *	Read a page array of the specific Service record instances identified by the duplicate key TypeIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ServiceTypeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecService[] pageRecByTypeIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 ServiceTypeId,
		CFLibDbKeyHash256 priorServiceId );
}
