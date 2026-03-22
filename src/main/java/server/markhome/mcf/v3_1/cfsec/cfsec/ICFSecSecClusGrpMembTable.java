
// Description: Java 25 DbIO interface for SecClusGrpMemb.

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
 *	CFSecSecClusGrpMembTable database interface for SecClusGrpMemb
 */
public interface ICFSecSecClusGrpMembTable
{

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecSecClusGrpMemb createSecClusGrpMemb( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpMemb rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecSecClusGrpMemb updateSecClusGrpMemb( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpMemb rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteSecClusGrpMemb( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpMemb rec );
	/**
	 *	Delete the SecClusGrpMemb instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusGrpId	The SecClusGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecUserId	The SecClusGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecClusGrpMembByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecClusGrpId,
		CFLibDbKeyHash256 argSecUserId );
	/**
	 *	Delete the SecClusGrpMemb instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSecClusGrpMembByIdIdx( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpMembPKey argKey );
	/**
	 *	Delete the SecClusGrpMemb instances identified by the key ClusGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusGrpId	The SecClusGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecClusGrpMembByClusGrpIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecClusGrpId );

	/**
	 *	Delete the SecClusGrpMemb instances identified by the key ClusGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecClusGrpMembByClusGrpIdx( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpMembByClusGrpIdxKey argKey );
	/**
	 *	Delete the SecClusGrpMemb instances identified by the key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecClusGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecClusGrpMembByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecUserId );

	/**
	 *	Delete the SecClusGrpMemb instances identified by the key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecClusGrpMembByUserIdx( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpMembByUserIdxKey argKey );


	/**
	 *	Read the derived SecClusGrpMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusGrpMemb instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecClusGrpMemb readDerived( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpMembPKey PKey );

	/**
	 *	Read the derived SecClusGrpMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecClusGrpMemb readDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecClusGrpId,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Lock the derived SecClusGrpMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusGrpMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecClusGrpMemb lockDerived( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpMembPKey PKey );

	/**
	 *	Read all SecClusGrpMemb instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecSecClusGrpMemb[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived SecClusGrpMemb record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusGrpId	The SecClusGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecUserId	The SecClusGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecClusGrpMemb readDerivedByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecClusGrpId,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read an array of the derived SecClusGrpMemb record instances identified by the duplicate key ClusGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusGrpId	The SecClusGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecClusGrpMemb[] readDerivedByClusGrpIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecClusGrpId );

	/**
	 *	Read an array of the derived SecClusGrpMemb record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecClusGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecClusGrpMemb[] readDerivedByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read the specific SecClusGrpMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusGrpMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecClusGrpMemb readRec( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpMembPKey PKey );

	/**
	 *	Read the specific SecClusGrpMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusGrpMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecClusGrpMemb readRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecClusGrpId,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Lock the specific SecClusGrpMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusGrpMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecClusGrpMemb lockRec( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpMembPKey PKey );

	/**
	 *	Read all the specific SecClusGrpMemb record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecClusGrpMemb instances in the database accessible for the Authorization.
	 */
	ICFSecSecClusGrpMemb[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecClusGrpMemb record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecClusGrpMemb instances in the database accessible for the Authorization.
	 */
	ICFSecSecClusGrpMemb[] pageAllRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 priorSecClusGrpId,
		CFLibDbKeyHash256 priorSecUserId );

	/**
	 *	Read the specific SecClusGrpMemb record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusGrpId	The SecClusGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecUserId	The SecClusGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecClusGrpMemb readRecByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecClusGrpId,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read an array of the specific SecClusGrpMemb record instances identified by the duplicate key ClusGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusGrpId	The SecClusGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecClusGrpMemb[] readRecByClusGrpIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecClusGrpId );

	/**
	 *	Read an array of the specific SecClusGrpMemb record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecClusGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecClusGrpMemb[] readRecByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read a page array of the specific SecClusGrpMemb record instances identified by the duplicate key ClusGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusGrpId	The SecClusGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecClusGrpMemb[] pageRecByClusGrpIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecClusGrpId,
		CFLibDbKeyHash256 priorSecClusGrpId,
		CFLibDbKeyHash256 priorSecUserId );

	/**
	 *	Read a page array of the specific SecClusGrpMemb record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecClusGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecClusGrpMemb[] pageRecByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId,
		CFLibDbKeyHash256 priorSecClusGrpId,
		CFLibDbKeyHash256 priorSecUserId );
}
