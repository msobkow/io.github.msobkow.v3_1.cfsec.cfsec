
// Description: Java 25 DbIO interface for SecRoleMemb.

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
 *	CFSecSecRoleMembTable database interface for SecRoleMemb
 */
public interface ICFSecSecRoleMembTable
{
	public static final String TABLE_NAME = "SecRoleMemb";

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecSecRoleMemb createSecRoleMemb( ICFSecAuthorization Authorization,
		ICFSecSecRoleMemb rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecSecRoleMemb updateSecRoleMemb( ICFSecAuthorization Authorization,
		ICFSecSecRoleMemb rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteSecRoleMemb( ICFSecAuthorization Authorization,
		ICFSecSecRoleMemb rec );
	/**
	 *	Delete the SecRoleMemb instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecRoleId	The SecRoleMemb key attribute of the instance generating the id.
	 *
	 *	@param	LoginId	The SecRoleMemb key attribute of the instance generating the id.
	 */
	void deleteSecRoleMembByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecRoleId,
		String argLoginId );
	/**
	 *	Delete the SecRoleMemb instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSecRoleMembByIdIdx( ICFSecAuthorization Authorization,
		ICFSecSecRoleMembPKey argKey );
	/**
	 *	Delete the SecRoleMemb instances identified by the key RoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecRoleId	The SecRoleMemb key attribute of the instance generating the id.
	 */
	void deleteSecRoleMembByRoleIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecRoleId );

	/**
	 *	Delete the SecRoleMemb instances identified by the key RoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecRoleMembByRoleIdx( ICFSecAuthorization Authorization,
		ICFSecSecRoleMembByRoleIdxKey argKey );
	/**
	 *	Delete the SecRoleMemb instances identified by the key LoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecRoleMemb key attribute of the instance generating the id.
	 */
	void deleteSecRoleMembByLoginIdx( ICFSecAuthorization Authorization,
		String argLoginId );

	/**
	 *	Delete the SecRoleMemb instances identified by the key LoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecRoleMembByLoginIdx( ICFSecAuthorization Authorization,
		ICFSecSecRoleMembByLoginIdxKey argKey );


	/**
	 *	Read the derived SecRoleMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecRoleMemb instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecRoleMemb readDerived( ICFSecAuthorization Authorization,
		ICFSecSecRoleMembPKey PKey );

	/**
	 *	Read the derived SecRoleMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecRoleMemb readDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecRoleId,
		String LoginId );

	/**
	 *	Lock the derived SecRoleMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecRoleMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecRoleMemb lockDerived( ICFSecAuthorization Authorization,
		ICFSecSecRoleMembPKey PKey );

	/**
	 *	Read all SecRoleMemb instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecSecRoleMemb[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived SecRoleMemb record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecRoleId	The SecRoleMemb key attribute of the instance generating the id.
	 *
	 *	@param	LoginId	The SecRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecRoleMemb readDerivedByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecRoleId,
		String LoginId );

	/**
	 *	Read an array of the derived SecRoleMemb record instances identified by the duplicate key RoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecRoleId	The SecRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecRoleMemb[] readDerivedByRoleIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecRoleId );

	/**
	 *	Read an array of the derived SecRoleMemb record instances identified by the duplicate key LoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecRoleMemb[] readDerivedByLoginIdx( ICFSecAuthorization Authorization,
		String LoginId );

	/**
	 *	Read the specific SecRoleMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecRoleMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecRoleMemb readRec( ICFSecAuthorization Authorization,
		ICFSecSecRoleMembPKey PKey );

	/**
	 *	Read the specific SecRoleMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecRoleMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecRoleMemb readRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecRoleId,
		String LoginId );

	/**
	 *	Lock the specific SecRoleMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecRoleMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecRoleMemb lockRec( ICFSecAuthorization Authorization,
		ICFSecSecRoleMembPKey PKey );

	/**
	 *	Read all the specific SecRoleMemb record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecRoleMemb instances in the database accessible for the Authorization.
	 */
	ICFSecSecRoleMemb[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecRoleMemb record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecRoleMemb instances in the database accessible for the Authorization.
	 */
	ICFSecSecRoleMemb[] pageAllRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 priorSecRoleId,
		String priorLoginId );

	/**
	 *	Read the specific SecRoleMemb record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecRoleId	The SecRoleMemb key attribute of the instance generating the id.
	 *
	 *	@param	LoginId	The SecRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecRoleMemb readRecByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecRoleId,
		String LoginId );

	/**
	 *	Read an array of the specific SecRoleMemb record instances identified by the duplicate key RoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecRoleId	The SecRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecRoleMemb[] readRecByRoleIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecRoleId );

	/**
	 *	Read an array of the specific SecRoleMemb record instances identified by the duplicate key LoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecRoleMemb[] readRecByLoginIdx( ICFSecAuthorization Authorization,
		String LoginId );

	/**
	 *	Read a page array of the specific SecRoleMemb record instances identified by the duplicate key RoleIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecRoleId	The SecRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecRoleMemb[] pageRecByRoleIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecRoleId,
		CFLibDbKeyHash256 priorSecRoleId,
		String priorLoginId );

	/**
	 *	Read a page array of the specific SecRoleMemb record instances identified by the duplicate key LoginIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	LoginId	The SecRoleMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecRoleMemb[] pageRecByLoginIdx( ICFSecAuthorization Authorization,
		String LoginId,
		CFLibDbKeyHash256 priorSecRoleId,
		String priorLoginId );
}
