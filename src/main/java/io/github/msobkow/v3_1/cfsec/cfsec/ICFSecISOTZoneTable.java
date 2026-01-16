
// Description: Java 25 DbIO interface for ISOTZone.

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
 *	CFSecISOTZoneTable database interface for ISOTZone
 */
public interface ICFSecISOTZoneTable
{

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecISOTZone createISOTZone( ICFSecAuthorization Authorization,
		ICFSecISOTZone rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecISOTZone updateISOTZone( ICFSecAuthorization Authorization,
		ICFSecISOTZone rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteISOTZone( ICFSecAuthorization Authorization,
		ICFSecISOTZone rec );
	/**
	 *	Delete the ISOTZone instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteISOTZoneByIdIdx( ICFSecAuthorization Authorization,
		Short argKey );
	/**
	 *	Delete the ISOTZone instances identified by the key OffsetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TZHourOffset	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@param	TZMinOffset	The ISOTZone key attribute of the instance generating the id.
	 */
	void deleteISOTZoneByOffsetIdx( ICFSecAuthorization Authorization,
		short argTZHourOffset,
		short argTZMinOffset );

	/**
	 *	Delete the ISOTZone instances identified by the key OffsetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteISOTZoneByOffsetIdx( ICFSecAuthorization Authorization,
		ICFSecISOTZoneByOffsetIdxKey argKey );
	/**
	 *	Delete the ISOTZone instances identified by the key UTZNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TZName	The ISOTZone key attribute of the instance generating the id.
	 */
	void deleteISOTZoneByUTZNameIdx( ICFSecAuthorization Authorization,
		String argTZName );

	/**
	 *	Delete the ISOTZone instances identified by the key UTZNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteISOTZoneByUTZNameIdx( ICFSecAuthorization Authorization,
		ICFSecISOTZoneByUTZNameIdxKey argKey );
	/**
	 *	Delete the ISOTZone instances identified by the key Iso8601Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Iso8601	The ISOTZone key attribute of the instance generating the id.
	 */
	void deleteISOTZoneByIso8601Idx( ICFSecAuthorization Authorization,
		String argIso8601 );

	/**
	 *	Delete the ISOTZone instances identified by the key Iso8601Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteISOTZoneByIso8601Idx( ICFSecAuthorization Authorization,
		ICFSecISOTZoneByIso8601IdxKey argKey );


	/**
	 *	Read the derived ISOTZone record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOTZone instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecISOTZone readDerived( ICFSecAuthorization Authorization,
		Short PKey );

	/**
	 *	Lock the derived ISOTZone record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOTZone instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecISOTZone lockDerived( ICFSecAuthorization Authorization,
		Short PKey );

	/**
	 *	Read all ISOTZone instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecISOTZone[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived ISOTZone record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOTZoneId	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecISOTZone readDerivedByIdIdx( ICFSecAuthorization Authorization,
		short ISOTZoneId );

	/**
	 *	Read an array of the derived ISOTZone record instances identified by the duplicate key OffsetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TZHourOffset	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@param	TZMinOffset	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecISOTZone[] readDerivedByOffsetIdx( ICFSecAuthorization Authorization,
		short TZHourOffset,
		short TZMinOffset );

	/**
	 *	Read the derived ISOTZone record instance identified by the unique key UTZNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TZName	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecISOTZone readDerivedByUTZNameIdx( ICFSecAuthorization Authorization,
		String TZName );

	/**
	 *	Read an array of the derived ISOTZone record instances identified by the duplicate key Iso8601Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Iso8601	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecISOTZone[] readDerivedByIso8601Idx( ICFSecAuthorization Authorization,
		String Iso8601 );

	/**
	 *	Read the specific ISOTZone record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOTZone instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOTZone readRec( ICFSecAuthorization Authorization,
		Short PKey );

	/**
	 *	Lock the specific ISOTZone record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOTZone instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOTZone lockRec( ICFSecAuthorization Authorization,
		Short PKey );

	/**
	 *	Read all the specific ISOTZone record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific ISOTZone instances in the database accessible for the Authorization.
	 */
	ICFSecISOTZone[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read the specific ISOTZone record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOTZoneId	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOTZone readRecByIdIdx( ICFSecAuthorization Authorization,
		short ISOTZoneId );

	/**
	 *	Read an array of the specific ISOTZone record instances identified by the duplicate key OffsetIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TZHourOffset	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@param	TZMinOffset	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOTZone[] readRecByOffsetIdx( ICFSecAuthorization Authorization,
		short TZHourOffset,
		short TZMinOffset );

	/**
	 *	Read the specific ISOTZone record instance identified by the unique key UTZNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	TZName	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOTZone readRecByUTZNameIdx( ICFSecAuthorization Authorization,
		String TZName );

	/**
	 *	Read an array of the specific ISOTZone record instances identified by the duplicate key Iso8601Idx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Iso8601	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOTZone[] readRecByIso8601Idx( ICFSecAuthorization Authorization,
		String Iso8601 );
}
