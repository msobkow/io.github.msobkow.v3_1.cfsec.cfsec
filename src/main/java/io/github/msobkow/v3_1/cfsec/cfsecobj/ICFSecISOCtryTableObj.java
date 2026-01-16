// Description: Java 25 Table Object interface for CFSec.

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

package io.github.msobkow.v3_1.cfsec.cfsecobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import io.github.msobkow.v3_1.cflib.*;
import io.github.msobkow.v3_1.cflib.dbutil.*;
import io.github.msobkow.v3_1.cfsec.cfsec.*;

public interface ICFSecISOCtryTableObj
{
	public ICFSecSchemaObj getSchema();
	public void setSchema( ICFSecSchemaObj value );

	public void minimizeMemory();

	public String getTableName();
	public String getTableDbName();

	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	public int getClassCode();

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	// public static int getBackingClassCode();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new ISOCtry instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecISOCtryObj newInstance();

	/**
	 *	Instantiate a new ISOCtry edition of the specified ISOCtry instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecISOCtryEditObj newEditInstance( ICFSecISOCtryObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCtryObj realiseISOCtry( ICFSecISOCtryObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCtryObj createISOCtry( ICFSecISOCtryObj Obj );

	/**
	 *	Read a ISOCtry-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOCtry-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOCtryObj readISOCtry( Short pkey );

	/**
	 *	Read a ISOCtry-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOCtry-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOCtryObj readISOCtry( Short pkey,
		boolean forceRead );

	ICFSecISOCtryObj readCachedISOCtry( Short pkey );

	public void reallyDeepDisposeISOCtry( ICFSecISOCtryObj obj );

	void deepDisposeISOCtry( Short pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCtryObj lockISOCtry( Short pkey );

	/**
	 *	Return a sorted list of all the ISOCtry-derived instances in the database.
	 *
	 *	@return	List of ICFSecISOCtryObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecISOCtryObj> readAllISOCtry();

	/**
	 *	Return a sorted map of all the ISOCtry-derived instances in the database.
	 *
	 *	@return	List of ICFSecISOCtryObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecISOCtryObj> readAllISOCtry( boolean forceRead );

	List<ICFSecISOCtryObj> readCachedAllISOCtry();

	/**
	 *	Get the CFSecISOCtryObj instance for the primary key attributes.
	 *
	 *	@param	ISOCtryId	The ISOCtry key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCtryObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCtryObj readISOCtryByIdIdx( short ISOCtryId );

	/**
	 *	Get the CFSecISOCtryObj instance for the primary key attributes.
	 *
	 *	@param	ISOCtryId	The ISOCtry key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCtryObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCtryObj readISOCtryByIdIdx( short ISOCtryId,
		boolean forceRead );

	/**
	 *	Get the CFSecISOCtryObj instance for the unique ISOCodeIdx key.
	 *
	 *	@param	ISOCode	The ISOCtry key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCtryObj cached instance for the unique ISOCodeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCtryObj readISOCtryByISOCodeIdx(String ISOCode );

	/**
	 *	Get the CFSecISOCtryObj instance for the unique ISOCodeIdx key.
	 *
	 *	@param	ISOCode	The ISOCtry key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCtryObj refreshed instance for the unique ISOCodeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCtryObj readISOCtryByISOCodeIdx(String ISOCode,
		boolean forceRead );

	/**
	 *	Get the CFSecISOCtryObj instance for the unique NameIdx key.
	 *
	 *	@param	Name	The ISOCtry key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCtryObj cached instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCtryObj readISOCtryByNameIdx(String Name );

	/**
	 *	Get the CFSecISOCtryObj instance for the unique NameIdx key.
	 *
	 *	@param	Name	The ISOCtry key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCtryObj refreshed instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCtryObj readISOCtryByNameIdx(String Name,
		boolean forceRead );

	ICFSecISOCtryObj readCachedISOCtryByIdIdx( short ISOCtryId );

	ICFSecISOCtryObj readCachedISOCtryByISOCodeIdx( String ISOCode );

	ICFSecISOCtryObj readCachedISOCtryByNameIdx( String Name );

	void deepDisposeISOCtryByIdIdx( short ISOCtryId );

	void deepDisposeISOCtryByISOCodeIdx( String ISOCode );

	void deepDisposeISOCtryByNameIdx( String Name );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCtryObj updateISOCtry( ICFSecISOCtryObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteISOCtry( ICFSecISOCtryObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	ISOCtryId	The ISOCtry key attribute of the instance generating the id.
	 */
	void deleteISOCtryByIdIdx( short ISOCtryId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ISOCode	The ISOCtry key attribute of the instance generating the id.
	 */
	void deleteISOCtryByISOCodeIdx(String ISOCode );

	/**
	 *	Internal use only.
	 *
	 *	@param	Name	The ISOCtry key attribute of the instance generating the id.
	 */
	void deleteISOCtryByNameIdx(String Name );
}
