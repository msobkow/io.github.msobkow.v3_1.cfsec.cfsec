
// Description: Java 25 DbIO interface for SecDevice.

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
 *	CFSecSecDeviceTable database interface for SecDevice
 */
public interface ICFSecSecDeviceTable
{

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecSecDevice createSecDevice( ICFSecAuthorization Authorization,
		ICFSecSecDevice rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecSecDevice updateSecDevice( ICFSecAuthorization Authorization,
		ICFSecSecDevice rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteSecDevice( ICFSecAuthorization Authorization,
		ICFSecSecDevice rec );
	/**
	 *	Delete the SecDevice instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@param	DevName	The SecDevice key attribute of the instance generating the id.
	 */
	void deleteSecDeviceByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecUserId,
		String argDevName );
	/**
	 *	Delete the SecDevice instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteSecDeviceByIdIdx( ICFSecAuthorization Authorization,
		ICFSecSecDevicePKey argKey );
	/**
	 *	Delete the SecDevice instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@param	DevName	The SecDevice key attribute of the instance generating the id.
	 */
	void deleteSecDeviceByNameIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecUserId,
		String argDevName );

	/**
	 *	Delete the SecDevice instances identified by the key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecDeviceByNameIdx( ICFSecAuthorization Authorization,
		ICFSecSecDeviceByNameIdxKey argKey );
	/**
	 *	Delete the SecDevice instances identified by the key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 */
	void deleteSecDeviceByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 argSecUserId );

	/**
	 *	Delete the SecDevice instances identified by the key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteSecDeviceByUserIdx( ICFSecAuthorization Authorization,
		ICFSecSecDeviceByUserIdxKey argKey );


	/**
	 *	Read the derived SecDevice record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecDevice instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecDevice readDerived( ICFSecAuthorization Authorization,
		ICFSecSecDevicePKey PKey );

	/**
	 *	Read the derived SecDevice record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecDevice readDerived( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId,
		String DevName );

	/**
	 *	Lock the derived SecDevice record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecDevice instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecDevice lockDerived( ICFSecAuthorization Authorization,
		ICFSecSecDevicePKey PKey );

	/**
	 *	Read all SecDevice instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecSecDevice[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived SecDevice record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@param	DevName	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecDevice readDerivedByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId,
		String DevName );

	/**
	 *	Read the derived SecDevice record instance identified by the unique key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@param	DevName	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecSecDevice readDerivedByNameIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId,
		String DevName );

	/**
	 *	Read an array of the derived SecDevice record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecSecDevice[] readDerivedByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read the specific SecDevice record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecDevice instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecDevice readRec( ICFSecAuthorization Authorization,
		ICFSecSecDevicePKey PKey );

	/**
	 *	Read the specific SecDevice record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecDevice instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecDevice readRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId,
		String DevName );

	/**
	 *	Lock the specific SecDevice record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the SecDevice instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecDevice lockRec( ICFSecAuthorization Authorization,
		ICFSecSecDevicePKey PKey );

	/**
	 *	Read all the specific SecDevice record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecDevice instances in the database accessible for the Authorization.
	 */
	ICFSecSecDevice[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read a page of all the specific SecDevice record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific SecDevice instances in the database accessible for the Authorization.
	 */
	ICFSecSecDevice[] pageAllRec( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 priorSecUserId,
		String priorDevName );

	/**
	 *	Read the specific SecDevice record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@param	DevName	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecDevice readRecByIdIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId,
		String DevName );

	/**
	 *	Read the specific SecDevice record instance identified by the unique key NameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@param	DevName	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecDevice readRecByNameIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId,
		String DevName );

	/**
	 *	Read an array of the specific SecDevice record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecDevice[] readRecByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read a page array of the specific SecDevice record instances identified by the duplicate key UserIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecDevice[] pageRecByUserIdx( ICFSecAuthorization Authorization,
		CFLibDbKeyHash256 SecUserId,
		CFLibDbKeyHash256 priorSecUserId,
		String priorDevName );
}
