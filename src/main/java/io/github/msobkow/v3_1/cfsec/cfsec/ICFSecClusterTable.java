
// Description: Java 25 DbIO interface for Cluster.

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
 *	CFSecClusterTable database interface for Cluster
 */
public interface ICFSecClusterTable
{

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecCluster createCluster( ICFSecAuthorization Authorization,
		ICFSecCluster rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecCluster updateCluster( ICFSecAuthorization Authorization,
		ICFSecCluster rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteCluster( ICFSecAuthorization Authorization,
		ICFSecCluster rec );
	/**
	 *	Delete the Cluster instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteClusterByIdIdx( ICFSecAuthorization Authorization,
		Long argKey );
	/**
	 *	Delete the Cluster instances identified by the key UDomNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	FullDomName	The Cluster key attribute of the instance generating the id.
	 */
	void deleteClusterByUDomNameIdx( ICFSecAuthorization Authorization,
		String argFullDomName );

	/**
	 *	Delete the Cluster instances identified by the key UDomNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClusterByUDomNameIdx( ICFSecAuthorization Authorization,
		ICFSecClusterByUDomNameIdxKey argKey );
	/**
	 *	Delete the Cluster instances identified by the key UDescrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Description	The Cluster key attribute of the instance generating the id.
	 */
	void deleteClusterByUDescrIdx( ICFSecAuthorization Authorization,
		String argDescription );

	/**
	 *	Delete the Cluster instances identified by the key UDescrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteClusterByUDescrIdx( ICFSecAuthorization Authorization,
		ICFSecClusterByUDescrIdxKey argKey );


	/**
	 *	Read the derived Cluster record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Cluster instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecCluster readDerived( ICFSecAuthorization Authorization,
		Long PKey );

	/**
	 *	Lock the derived Cluster record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Cluster instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecCluster lockDerived( ICFSecAuthorization Authorization,
		Long PKey );

	/**
	 *	Read all Cluster instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecCluster[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived Cluster record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The Cluster key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecCluster readDerivedByIdIdx( ICFSecAuthorization Authorization,
		long Id );

	/**
	 *	Read the derived Cluster record instance identified by the unique key UDomNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	FullDomName	The Cluster key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecCluster readDerivedByUDomNameIdx( ICFSecAuthorization Authorization,
		String FullDomName );

	/**
	 *	Read the derived Cluster record instance identified by the unique key UDescrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Description	The Cluster key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecCluster readDerivedByUDescrIdx( ICFSecAuthorization Authorization,
		String Description );

	/**
	 *	Read the specific Cluster record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Cluster instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecCluster readRec( ICFSecAuthorization Authorization,
		Long PKey );

	/**
	 *	Lock the specific Cluster record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the Cluster instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecCluster lockRec( ICFSecAuthorization Authorization,
		Long PKey );

	/**
	 *	Read all the specific Cluster record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific Cluster instances in the database accessible for the Authorization.
	 */
	ICFSecCluster[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read a page of all the specific Cluster record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific Cluster instances in the database accessible for the Authorization.
	 */
	ICFSecCluster[] pageAllRec( ICFSecAuthorization Authorization,
		Long priorId );

	/**
	 *	Read the specific Cluster record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Id	The Cluster key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecCluster readRecByIdIdx( ICFSecAuthorization Authorization,
		long Id );

	/**
	 *	Read the specific Cluster record instance identified by the unique key UDomNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	FullDomName	The Cluster key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecCluster readRecByUDomNameIdx( ICFSecAuthorization Authorization,
		String FullDomName );

	/**
	 *	Read the specific Cluster record instance identified by the unique key UDescrIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Description	The Cluster key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecCluster readRecByUDescrIdx( ICFSecAuthorization Authorization,
		String Description );
}
