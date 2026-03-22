
// Description: Java 25 DbIO interface for SecTentGrpInc.

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
 *	CFSecSecTentGrpIncTable database interface for SecTentGrpInc
 */
public interface ICFSecSecTentGrpIncTable
{

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecSecTentGrpInc createSecTentGrpInc( ICFSecAuthorization Authorization,
		ICFSecSecTentGrpInc rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecSecTentGrpInc updateSecTentGrpInc( ICFSecAuthorization Authorization,
		ICFSecSecTentGrpInc rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteSecTentGrpInc( ICFSecAuthorization Authorization,
		ICFSecSecTentGrpInc rec );
	/**
	 *	Delete the SecTentGrpInc instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	IncName	The SecTentGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecTentGrpIncByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecTentGrpId,
		String argIncName );
	/**
	 *	Delete the SecTentGrpInc instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSecTentGrpIncByIdIdx( ICFSecAuthorization Authorization,
		ICFSecSecTentGrpIncPKey argKey );
	/**
	 *	Delete the SecTentGrpInc instances identified by the key TentGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecTentGrpIncByTentGrpIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecTentGrpId );

	/**
	 *	Delete the SecTentGrpInc instances identified by the key TentGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecTentGrpIncByTentGrpIdx( ICFSecAuthorization Authorization,
		ICFSecSecTentGrpIncByTentGrpIdxKey argKey );
	/**
	 *	Delete the SecTentGrpInc instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	IncName	The SecTentGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecTentGrpIncByNameIdx( ICFSecAuthorization Authorization,
		String argIncName );

	/**
	 *	Delete the SecTentGrpInc instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecTentGrpIncByNameIdx( ICFSecAuthorization Authorization,
		ICFSecSecTentGrpIncByNameIdxKey argKey );


	/**
	 *	Read the derived SecTentGrpInc record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecTentGrpInc instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecTentGrpInc readDerived( ICFSecAuthorization Authorization,
		ICFSecSecTentGrpIncPKey PKey );

	/**
	 *	Read the derived SecTentGrpInc record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecTentGrpInc readDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecTentGrpId,
		String IncName );

	/**
	 *	Lock the derived SecTentGrpInc record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecTentGrpInc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecTentGrpInc lockDerived( ICFSecAuthorization Authorization,
		ICFSecSecTentGrpIncPKey PKey );

	/**
	 *	Read all SecTentGrpInc instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecSecTentGrpInc[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived SecTentGrpInc record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	IncName	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecTentGrpInc readDerivedByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecTentGrpId,
		String IncName );

	/**
	 *	Read an array of the derived SecTentGrpInc record instances identified by the duplicate key TentGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecTentGrpInc[] readDerivedByTentGrpIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecTentGrpId );

	/**
	 *	Read an array of the derived SecTentGrpInc record instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	IncName	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecTentGrpInc[] readDerivedByNameIdx( ICFSecAuthorization Authorization,
		String IncName );

	/**
	 *	Read the specific SecTentGrpInc record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecTentGrpInc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecTentGrpInc readRec( ICFSecAuthorization Authorization,
		ICFSecSecTentGrpIncPKey PKey );

	/**
	 *	Read the specific SecTentGrpInc record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecTentGrpInc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecTentGrpInc readRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecTentGrpId,
		String IncName );

	/**
	 *	Lock the specific SecTentGrpInc record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecTentGrpInc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecTentGrpInc lockRec( ICFSecAuthorization Authorization,
		ICFSecSecTentGrpIncPKey PKey );

	/**
	 *	Read all the specific SecTentGrpInc record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecTentGrpInc instances in the database accessible for the Authorization.
	 */
	ICFSecSecTentGrpInc[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecTentGrpInc record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecTentGrpInc instances in the database accessible for the Authorization.
	 */
	ICFSecSecTentGrpInc[] pageAllRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 priorSecTentGrpId,
		String priorIncName );

	/**
	 *	Read the specific SecTentGrpInc record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	IncName	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecTentGrpInc readRecByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecTentGrpId,
		String IncName );

	/**
	 *	Read an array of the specific SecTentGrpInc record instances identified by the duplicate key TentGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecTentGrpInc[] readRecByTentGrpIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecTentGrpId );

	/**
	 *	Read an array of the specific SecTentGrpInc record instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	IncName	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecTentGrpInc[] readRecByNameIdx( ICFSecAuthorization Authorization,
		String IncName );

	/**
	 *	Read a page array of the specific SecTentGrpInc record instances identified by the duplicate key TentGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecTentGrpInc[] pageRecByTentGrpIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecTentGrpId,
		CFLibDbKeyHash256 priorSecTentGrpId,
		String priorIncName );

	/**
	 *	Read a page array of the specific SecTentGrpInc record instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	IncName	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecTentGrpInc[] pageRecByNameIdx( ICFSecAuthorization Authorization,
		String IncName,
		CFLibDbKeyHash256 priorSecTentGrpId,
		String priorIncName );
}
