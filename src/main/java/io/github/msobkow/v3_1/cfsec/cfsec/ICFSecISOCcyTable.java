
// Description: Java 25 DbIO interface for ISOCcy.

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
 *	CFSecISOCcyTable database interface for ISOCcy
 */
public interface ICFSecISOCcyTable
{

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecISOCcy createISOCcy( ICFSecAuthorization Authorization,
		ICFSecISOCcy rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecISOCcy updateISOCcy( ICFSecAuthorization Authorization,
		ICFSecISOCcy rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteISOCcy( ICFSecAuthorization Authorization,
		ICFSecISOCcy rec );
	/**
	 *	Delete the ISOCcy instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteISOCcyByIdIdx( ICFSecAuthorization Authorization,
		Short argKey );
	/**
	 *	Delete the ISOCcy instances identified by the key CcyCdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOCode	The ISOCcy key attribute of the instance generating the id.
	 */
	void deleteISOCcyByCcyCdIdx( ICFSecAuthorization Authorization,
		String argISOCode );

	/**
	 *	Delete the ISOCcy instances identified by the key CcyCdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteISOCcyByCcyCdIdx( ICFSecAuthorization Authorization,
		ICFSecISOCcyByCcyCdIdxKey argKey );
	/**
	 *	Delete the ISOCcy instances identified by the key CcyNmIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Name	The ISOCcy key attribute of the instance generating the id.
	 */
	void deleteISOCcyByCcyNmIdx( ICFSecAuthorization Authorization,
		String argName );

	/**
	 *	Delete the ISOCcy instances identified by the key CcyNmIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteISOCcyByCcyNmIdx( ICFSecAuthorization Authorization,
		ICFSecISOCcyByCcyNmIdxKey argKey );


	/**
	 *	Read the derived ISOCcy record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOCcy instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecISOCcy readDerived( ICFSecAuthorization Authorization,
		Short PKey );

	/**
	 *	Lock the derived ISOCcy record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOCcy instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecISOCcy lockDerived( ICFSecAuthorization Authorization,
		Short PKey );

	/**
	 *	Read all ISOCcy instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecISOCcy[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived ISOCcy record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOCcyId	The ISOCcy key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecISOCcy readDerivedByIdIdx( ICFSecAuthorization Authorization,
		short ISOCcyId );

	/**
	 *	Read the derived ISOCcy record instance identified by the unique key CcyCdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOCode	The ISOCcy key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecISOCcy readDerivedByCcyCdIdx( ICFSecAuthorization Authorization,
		String ISOCode );

	/**
	 *	Read the derived ISOCcy record instance identified by the unique key CcyNmIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Name	The ISOCcy key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecISOCcy readDerivedByCcyNmIdx( ICFSecAuthorization Authorization,
		String Name );

	/**
	 *	Read the specific ISOCcy record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOCcy instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOCcy readRec( ICFSecAuthorization Authorization,
		Short PKey );

	/**
	 *	Lock the specific ISOCcy record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOCcy instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOCcy lockRec( ICFSecAuthorization Authorization,
		Short PKey );

	/**
	 *	Read all the specific ISOCcy record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific ISOCcy instances in the database accessible for the Authorization.
	 */
	ICFSecISOCcy[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read the specific ISOCcy record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOCcyId	The ISOCcy key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOCcy readRecByIdIdx( ICFSecAuthorization Authorization,
		short ISOCcyId );

	/**
	 *	Read the specific ISOCcy record instance identified by the unique key CcyCdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOCode	The ISOCcy key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOCcy readRecByCcyCdIdx( ICFSecAuthorization Authorization,
		String ISOCode );

	/**
	 *	Read the specific ISOCcy record instance identified by the unique key CcyNmIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Name	The ISOCcy key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOCcy readRecByCcyNmIdx( ICFSecAuthorization Authorization,
		String Name );
}
