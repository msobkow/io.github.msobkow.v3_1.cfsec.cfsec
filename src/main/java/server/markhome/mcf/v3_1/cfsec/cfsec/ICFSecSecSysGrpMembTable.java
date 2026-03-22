
// Description: Java 25 DbIO interface for SecSysGrpMemb.

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
 *	CFSecSecSysGrpMembTable database interface for SecSysGrpMemb
 */
public interface ICFSecSecSysGrpMembTable
{

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecSecSysGrpMemb createSecSysGrpMemb( ICFSecAuthorization Authorization,
		ICFSecSecSysGrpMemb rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecSecSysGrpMemb updateSecSysGrpMemb( ICFSecAuthorization Authorization,
		ICFSecSecSysGrpMemb rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteSecSysGrpMemb( ICFSecAuthorization Authorization,
		ICFSecSecSysGrpMemb rec );
	/**
	 *	Delete the SecSysGrpMemb instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecUserId	The SecSysGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecSysGrpMembByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecSysGrpId,
		CFLibDbKeyHash256 argSecUserId );
	/**
	 *	Delete the SecSysGrpMemb instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSecSysGrpMembByIdIdx( ICFSecAuthorization Authorization,
		ICFSecSecSysGrpMembPKey argKey );
	/**
	 *	Delete the SecSysGrpMemb instances identified by the key SysGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecSysGrpMembBySysGrpIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecSysGrpId );

	/**
	 *	Delete the SecSysGrpMemb instances identified by the key SysGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecSysGrpMembBySysGrpIdx( ICFSecAuthorization Authorization,
		ICFSecSecSysGrpMembBySysGrpIdxKey argKey );
	/**
	 *	Delete the SecSysGrpMemb instances identified by the key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecSysGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecSysGrpMembByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecUserId );

	/**
	 *	Delete the SecSysGrpMemb instances identified by the key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecSysGrpMembByUserIdx( ICFSecAuthorization Authorization,
		ICFSecSecSysGrpMembByUserIdxKey argKey );


	/**
	 *	Read the derived SecSysGrpMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysGrpMemb instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecSysGrpMemb readDerived( ICFSecAuthorization Authorization,
		ICFSecSecSysGrpMembPKey PKey );

	/**
	 *	Read the derived SecSysGrpMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecSysGrpMemb readDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecSysGrpId,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Lock the derived SecSysGrpMemb record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysGrpMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecSysGrpMemb lockDerived( ICFSecAuthorization Authorization,
		ICFSecSecSysGrpMembPKey PKey );

	/**
	 *	Read all SecSysGrpMemb instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecSecSysGrpMemb[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived SecSysGrpMemb record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecUserId	The SecSysGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecSysGrpMemb readDerivedByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecSysGrpId,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read an array of the derived SecSysGrpMemb record instances identified by the duplicate key SysGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecSysGrpMemb[] readDerivedBySysGrpIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecSysGrpId );

	/**
	 *	Read an array of the derived SecSysGrpMemb record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecSysGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecSysGrpMemb[] readDerivedByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read the specific SecSysGrpMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysGrpMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecSysGrpMemb readRec( ICFSecAuthorization Authorization,
		ICFSecSecSysGrpMembPKey PKey );

	/**
	 *	Read the specific SecSysGrpMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysGrpMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecSysGrpMemb readRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecSysGrpId,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Lock the specific SecSysGrpMemb record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecSysGrpMemb instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecSysGrpMemb lockRec( ICFSecAuthorization Authorization,
		ICFSecSecSysGrpMembPKey PKey );

	/**
	 *	Read all the specific SecSysGrpMemb record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecSysGrpMemb instances in the database accessible for the Authorization.
	 */
	ICFSecSecSysGrpMemb[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecSysGrpMemb record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecSysGrpMemb instances in the database accessible for the Authorization.
	 */
	ICFSecSecSysGrpMemb[] pageAllRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 priorSecSysGrpId,
		CFLibDbKeyHash256 priorSecUserId );

	/**
	 *	Read the specific SecSysGrpMemb record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecUserId	The SecSysGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecSysGrpMemb readRecByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecSysGrpId,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read an array of the specific SecSysGrpMemb record instances identified by the duplicate key SysGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecSysGrpMemb[] readRecBySysGrpIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecSysGrpId );

	/**
	 *	Read an array of the specific SecSysGrpMemb record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecSysGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecSysGrpMemb[] readRecByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read a page array of the specific SecSysGrpMemb record instances identified by the duplicate key SysGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecSysGrpId	The SecSysGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecSysGrpMemb[] pageRecBySysGrpIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecSysGrpId,
		CFLibDbKeyHash256 priorSecSysGrpId,
		CFLibDbKeyHash256 priorSecUserId );

	/**
	 *	Read a page array of the specific SecSysGrpMemb record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecSysGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecSysGrpMemb[] pageRecByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId,
		CFLibDbKeyHash256 priorSecSysGrpId,
		CFLibDbKeyHash256 priorSecUserId );
}
