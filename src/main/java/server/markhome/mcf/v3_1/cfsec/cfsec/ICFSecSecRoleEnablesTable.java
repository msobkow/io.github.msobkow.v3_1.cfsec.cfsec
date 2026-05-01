
// Description: Java 25 DbIO interface for SecRoleEnables.

/*
 *	server.markhome.mcf.CFSec
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFSec - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Mark's Code Fractal CFSec.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.mcf.v3_1.cfsec.cfsec;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cfsec.cfsecobj.*;

/*
 *	CFSecSecRoleEnablesTable database interface for SecRoleEnables
 */
public interface ICFSecSecRoleEnablesTable
{
	public static final String TABLE_NAME = "SecRoleEnables";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecSecRoleEnables createSecRoleEnables( ICFSecAuthorization Authorization,
		ICFSecSecRoleEnables rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecSecRoleEnables updateSecRoleEnables( ICFSecAuthorization Authorization,
		ICFSecSecRoleEnables rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteSecRoleEnables( ICFSecAuthorization Authorization,
		ICFSecSecRoleEnables rec );
	/**
	 *	Delete the SecRoleEnables instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecRoleId	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@param	EnableName	The SecRoleEnables key attribute of the instance generating the id.
	 */
	void deleteSecRoleEnablesByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecRoleId,
		String argEnableName );
	/**
	 *	Delete the SecRoleEnables instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSecRoleEnablesByIdIdx( ICFSecAuthorization Authorization,
		ICFSecSecRoleEnablesPKey argKey );
	/**
	 *	Delete the SecRoleEnables instances identified by the key RoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecRoleId	The SecRoleEnables key attribute of the instance generating the id.
	 */
	void deleteSecRoleEnablesByRoleIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecRoleId );

	/**
	 *	Delete the SecRoleEnables instances identified by the key RoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecRoleEnablesByRoleIdx( ICFSecAuthorization Authorization,
		ICFSecSecRoleEnablesByRoleIdxKey argKey );
	/**
	 *	Delete the SecRoleEnables instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EnableName	The SecRoleEnables key attribute of the instance generating the id.
	 */
	void deleteSecRoleEnablesByNameIdx( ICFSecAuthorization Authorization,
		String argEnableName );

	/**
	 *	Delete the SecRoleEnables instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecRoleEnablesByNameIdx( ICFSecAuthorization Authorization,
		ICFSecSecRoleEnablesByNameIdxKey argKey );


	/**
	 *	Read the derived SecRoleEnables record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecRoleEnables instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecRoleEnables readDerived( ICFSecAuthorization Authorization,
		ICFSecSecRoleEnablesPKey PKey );

	/**
	 *	Read the derived SecRoleEnables record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecRoleEnables readDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecRoleId,
		String EnableName );

	/**
	 *	Lock the derived SecRoleEnables record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecRoleEnables instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecRoleEnables lockDerived( ICFSecAuthorization Authorization,
		ICFSecSecRoleEnablesPKey PKey );

	/**
	 *	Read all SecRoleEnables instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecSecRoleEnables[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived SecRoleEnables record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecRoleId	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@param	EnableName	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecRoleEnables readDerivedByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecRoleId,
		String EnableName );

	/**
	 *	Read an array of the derived SecRoleEnables record instances identified by the duplicate key RoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecRoleId	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecRoleEnables[] readDerivedByRoleIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecRoleId );

	/**
	 *	Read an array of the derived SecRoleEnables record instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EnableName	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecRoleEnables[] readDerivedByNameIdx( ICFSecAuthorization Authorization,
		String EnableName );

	/**
	 *	Read the specific SecRoleEnables record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecRoleEnables instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecRoleEnables readRec( ICFSecAuthorization Authorization,
		ICFSecSecRoleEnablesPKey PKey );

	/**
	 *	Read the specific SecRoleEnables record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecRoleEnables instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecRoleEnables readRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecRoleId,
		String EnableName );

	/**
	 *	Lock the specific SecRoleEnables record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecRoleEnables instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecRoleEnables lockRec( ICFSecAuthorization Authorization,
		ICFSecSecRoleEnablesPKey PKey );

	/**
	 *	Read all the specific SecRoleEnables record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecRoleEnables instances in the database accessible for the Authorization.
	 */
	ICFSecSecRoleEnables[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecRoleEnables record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecRoleEnables instances in the database accessible for the Authorization.
	 */
	ICFSecSecRoleEnables[] pageAllRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 priorSecRoleId,
		String priorEnableName );

	/**
	 *	Read the specific SecRoleEnables record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecRoleId	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@param	EnableName	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecRoleEnables readRecByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecRoleId,
		String EnableName );

	/**
	 *	Read an array of the specific SecRoleEnables record instances identified by the duplicate key RoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecRoleId	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecRoleEnables[] readRecByRoleIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecRoleId );

	/**
	 *	Read an array of the specific SecRoleEnables record instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EnableName	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecRoleEnables[] readRecByNameIdx( ICFSecAuthorization Authorization,
		String EnableName );

	/**
	 *	Read a page array of the specific SecRoleEnables record instances identified by the duplicate key RoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecRoleId	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecRoleEnables[] pageRecByRoleIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecRoleId,
		CFLibDbKeyHash256 priorSecRoleId,
		String priorEnableName );

	/**
	 *	Read a page array of the specific SecRoleEnables record instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	EnableName	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecRoleEnables[] pageRecByNameIdx( ICFSecAuthorization Authorization,
		String EnableName,
		CFLibDbKeyHash256 priorSecRoleId,
		String priorEnableName );
}
