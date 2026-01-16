
// Description: Java 25 DbIO interface for ISOCtryLang.

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
 *	CFSecISOCtryLangTable database interface for ISOCtryLang
 */
public interface ICFSecISOCtryLangTable
{

	/**
	 *	Create the instance in the database, and update the specified record
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be created.
	 */
	ICFSecISOCtryLang createISOCtryLang( ICFSecAuthorization Authorization,
		ICFSecISOCtryLang rec );


	/**
	 *	Update the instance in the database, and update the specified record
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be updated
	 */
	ICFSecISOCtryLang updateISOCtryLang( ICFSecAuthorization Authorization,
		ICFSecISOCtryLang rec );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	rec	The instance interface to be deleted.
	 */
	void deleteISOCtryLang( ICFSecAuthorization Authorization,
		ICFSecISOCtryLang rec );
	/**
	 *	Delete the ISOCtryLang instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 */
	void deleteISOCtryLangByIdIdx( ICFSecAuthorization Authorization,
		short argISOCtryId,
		short argISOLangId );
	/**
	 *	Delete the ISOCtryLang instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteISOCtryLangByIdIdx( ICFSecAuthorization Authorization,
		ICFSecISOCtryLangPKey argKey );
	/**
	 *	Delete the ISOCtryLang instances identified by the key CtryIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 */
	void deleteISOCtryLangByCtryIdx( ICFSecAuthorization Authorization,
		short argISOCtryId );

	/**
	 *	Delete the ISOCtryLang instances identified by the key CtryIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteISOCtryLangByCtryIdx( ICFSecAuthorization Authorization,
		ICFSecISOCtryLangByCtryIdxKey argKey );
	/**
	 *	Delete the ISOCtryLang instances identified by the key LangIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 */
	void deleteISOCtryLangByLangIdx( ICFSecAuthorization Authorization,
		short argISOLangId );

	/**
	 *	Delete the ISOCtryLang instances identified by the key LangIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteISOCtryLangByLangIdx( ICFSecAuthorization Authorization,
		ICFSecISOCtryLangByLangIdxKey argKey );


	/**
	 *	Read the derived ISOCtryLang record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOCtryLang instance to be read.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecISOCtryLang readDerived( ICFSecAuthorization Authorization,
		ICFSecISOCtryLangPKey PKey );

	/**
	 *	Read the derived ISOCtryLang record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecISOCtryLang readDerived( ICFSecAuthorization Authorization,
		short ISOCtryId,
		short ISOLangId );

	/**
	 *	Lock the derived ISOCtryLang record instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOCtryLang instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecISOCtryLang lockDerived( ICFSecAuthorization Authorization,
		ICFSecISOCtryLangPKey PKey );

	/**
	 *	Read all ISOCtryLang instances.
	 *
	 *	@param	Authorization	The session authorization information.	
	 *
	 *	@return An array of derived record instances, potentially with 0 elements in the set.
	 */
	ICFSecISOCtryLang[] readAllDerived( ICFSecAuthorization Authorization );

	/**
	 *	Read the derived ISOCtryLang record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	ICFSecISOCtryLang readDerivedByIdIdx( ICFSecAuthorization Authorization,
		short ISOCtryId,
		short ISOLangId );

	/**
	 *	Read an array of the derived ISOCtryLang record instances identified by the duplicate key CtryIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecISOCtryLang[] readDerivedByCtryIdx( ICFSecAuthorization Authorization,
		short ISOCtryId );

	/**
	 *	Read an array of the derived ISOCtryLang record instances identified by the duplicate key LangIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return An array of derived instances for the specified key, potentially with 0 elements in the set.
	 */
	ICFSecISOCtryLang[] readDerivedByLangIdx( ICFSecAuthorization Authorization,
		short ISOLangId );

	/**
	 *	Read the specific ISOCtryLang record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOCtryLang instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOCtryLang readRec( ICFSecAuthorization Authorization,
		ICFSecISOCtryLangPKey PKey );

	/**
	 *	Read the specific ISOCtryLang record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOCtryLang instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOCtryLang readRec( ICFSecAuthorization Authorization,
		short ISOCtryId,
		short ISOLangId );

	/**
	 *	Lock the specific ISOCtryLang record instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the ISOCtryLang instance to be locked.
	 *
	 *	@return The record instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOCtryLang lockRec( ICFSecAuthorization Authorization,
		ICFSecISOCtryLangPKey PKey );

	/**
	 *	Read all the specific ISOCtryLang record instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific ISOCtryLang instances in the database accessible for the Authorization.
	 */
	ICFSecISOCtryLang[] readAllRec( ICFSecAuthorization Authorization );

	/**
	 *	Read the specific ISOCtryLang record instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return The record instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOCtryLang readRecByIdIdx( ICFSecAuthorization Authorization,
		short ISOCtryId,
		short ISOLangId );

	/**
	 *	Read an array of the specific ISOCtryLang record instances identified by the duplicate key CtryIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOCtryLang[] readRecByCtryIdx( ICFSecAuthorization Authorization,
		short ISOCtryId );

	/**
	 *	Read an array of the specific ISOCtryLang record instances identified by the duplicate key LangIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return An array of derived record instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOCtryLang[] readRecByLangIdx( ICFSecAuthorization Authorization,
		short ISOLangId );
}
