
// Description: Java 25 DbIO interface for SecClusGrpInc.

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
 *	CFSecSecClusGrpIncTable database interface for SecClusGrpInc
 */
public interface ICFSecSecClusGrpIncTable
{

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecSecClusGrpInc createSecClusGrpInc( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpInc rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecSecClusGrpInc updateSecClusGrpInc( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpInc rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteSecClusGrpInc( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpInc rec );
	/**
	 *	Delete the SecClusGrpInc instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusGrpId	The SecClusGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	InclName	The SecClusGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecClusGrpIncByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecClusGrpId,
		String argInclName );
	/**
	 *	Delete the SecClusGrpInc instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSecClusGrpIncByIdIdx( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpIncPKey argKey );
	/**
	 *	Delete the SecClusGrpInc instances identified by the key ClusGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusGrpId	The SecClusGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecClusGrpIncByClusGrpIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecClusGrpId );

	/**
	 *	Delete the SecClusGrpInc instances identified by the key ClusGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecClusGrpIncByClusGrpIdx( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpIncByClusGrpIdxKey argKey );
	/**
	 *	Delete the SecClusGrpInc instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	InclName	The SecClusGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecClusGrpIncByNameIdx( ICFSecAuthorization Authorization,
		String argInclName );

	/**
	 *	Delete the SecClusGrpInc instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecClusGrpIncByNameIdx( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpIncByNameIdxKey argKey );


	/**
	 *	Read the derived SecClusGrpInc record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusGrpInc instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecClusGrpInc readDerived( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpIncPKey PKey );

	/**
	 *	Read the derived SecClusGrpInc record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecClusGrpInc readDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecClusGrpId,
		String InclName );

	/**
	 *	Lock the derived SecClusGrpInc record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusGrpInc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecClusGrpInc lockDerived( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpIncPKey PKey );

	/**
	 *	Read all SecClusGrpInc instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecSecClusGrpInc[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived SecClusGrpInc record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusGrpId	The SecClusGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	InclName	The SecClusGrpInc key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecClusGrpInc readDerivedByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecClusGrpId,
		String InclName );

	/**
	 *	Read an array of the derived SecClusGrpInc record instances identified by the duplicate key ClusGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusGrpId	The SecClusGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecClusGrpInc[] readDerivedByClusGrpIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecClusGrpId );

	/**
	 *	Read an array of the derived SecClusGrpInc record instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	InclName	The SecClusGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecClusGrpInc[] readDerivedByNameIdx( ICFSecAuthorization Authorization,
		String InclName );

	/**
	 *	Read the specific SecClusGrpInc record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusGrpInc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecClusGrpInc readRec( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpIncPKey PKey );

	/**
	 *	Read the specific SecClusGrpInc record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusGrpInc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecClusGrpInc readRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecClusGrpId,
		String InclName );

	/**
	 *	Lock the specific SecClusGrpInc record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecClusGrpInc instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecClusGrpInc lockRec( ICFSecAuthorization Authorization,
		ICFSecSecClusGrpIncPKey PKey );

	/**
	 *	Read all the specific SecClusGrpInc record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecClusGrpInc instances in the database accessible for the Authorization.
	 */
	ICFSecSecClusGrpInc[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecClusGrpInc record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecClusGrpInc instances in the database accessible for the Authorization.
	 */
	ICFSecSecClusGrpInc[] pageAllRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 priorSecClusGrpId,
		String priorInclName );

	/**
	 *	Read the specific SecClusGrpInc record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusGrpId	The SecClusGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	InclName	The SecClusGrpInc key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecClusGrpInc readRecByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecClusGrpId,
		String InclName );

	/**
	 *	Read an array of the specific SecClusGrpInc record instances identified by the duplicate key ClusGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusGrpId	The SecClusGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecClusGrpInc[] readRecByClusGrpIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecClusGrpId );

	/**
	 *	Read an array of the specific SecClusGrpInc record instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	InclName	The SecClusGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecClusGrpInc[] readRecByNameIdx( ICFSecAuthorization Authorization,
		String InclName );

	/**
	 *	Read a page array of the specific SecClusGrpInc record instances identified by the duplicate key ClusGrpIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecClusGrpId	The SecClusGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecClusGrpInc[] pageRecByClusGrpIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecClusGrpId,
		CFLibDbKeyHash256 priorSecClusGrpId,
		String priorInclName );

	/**
	 *	Read a page array of the specific SecClusGrpInc record instances identified by the duplicate key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	InclName	The SecClusGrpInc key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecClusGrpInc[] pageRecByNameIdx( ICFSecAuthorization Authorization,
		String InclName,
		CFLibDbKeyHash256 priorSecClusGrpId,
		String priorInclName );
}
