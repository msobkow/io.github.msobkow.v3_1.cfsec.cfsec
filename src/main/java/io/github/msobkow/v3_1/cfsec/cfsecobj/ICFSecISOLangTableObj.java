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

public interface ICFSecISOLangTableObj
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
	 *	Instantiate a new ISOLang instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecISOLangObj newInstance();

	/**
	 *	Instantiate a new ISOLang edition of the specified ISOLang instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecISOLangEditObj newEditInstance( ICFSecISOLangObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecISOLangObj realiseISOLang( ICFSecISOLangObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecISOLangObj createISOLang( ICFSecISOLangObj Obj );

	/**
	 *	Read a ISOLang-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOLang-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOLangObj readISOLang( Short pkey );

	/**
	 *	Read a ISOLang-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOLang-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOLangObj readISOLang( Short pkey,
		boolean forceRead );

	ICFSecISOLangObj readCachedISOLang( Short pkey );

	public void reallyDeepDisposeISOLang( ICFSecISOLangObj obj );

	void deepDisposeISOLang( Short pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecISOLangObj lockISOLang( Short pkey );

	/**
	 *	Return a sorted list of all the ISOLang-derived instances in the database.
	 *
	 *	@return	List of ICFSecISOLangObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecISOLangObj> readAllISOLang();

	/**
	 *	Return a sorted map of all the ISOLang-derived instances in the database.
	 *
	 *	@return	List of ICFSecISOLangObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecISOLangObj> readAllISOLang( boolean forceRead );

	List<ICFSecISOLangObj> readCachedAllISOLang();

	/**
	 *	Get the CFSecISOLangObj instance for the primary key attributes.
	 *
	 *	@param	ISOLangId	The ISOLang key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOLangObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOLangObj readISOLangByIdIdx( short ISOLangId );

	/**
	 *	Get the CFSecISOLangObj instance for the primary key attributes.
	 *
	 *	@param	ISOLangId	The ISOLang key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOLangObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOLangObj readISOLangByIdIdx( short ISOLangId,
		boolean forceRead );

	/**
	 *	Get the CFSecISOLangObj instance for the unique Code3Idx key.
	 *
	 *	@param	ISO6392Code	The ISOLang key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOLangObj cached instance for the unique Code3Idx key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOLangObj readISOLangByCode3Idx(String ISO6392Code );

	/**
	 *	Get the CFSecISOLangObj instance for the unique Code3Idx key.
	 *
	 *	@param	ISO6392Code	The ISOLang key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOLangObj refreshed instance for the unique Code3Idx key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOLangObj readISOLangByCode3Idx(String ISO6392Code,
		boolean forceRead );

	/**
	 *	Get the map of CFSecISOLangObj instances sorted by their primary keys for the duplicate Code2Idx key.
	 *
	 *	@param	ISO6391Code	The ISOLang key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOLangObj cached instances sorted by their primary keys for the duplicate Code2Idx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOLangObj> readISOLangByCode2Idx( String ISO6391Code );

	/**
	 *	Get the map of CFSecISOLangObj instances sorted by their primary keys for the duplicate Code2Idx key.
	 *
	 *	@param	ISO6391Code	The ISOLang key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOLangObj cached instances sorted by their primary keys for the duplicate Code2Idx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOLangObj> readISOLangByCode2Idx( String ISO6391Code,
		boolean forceRead );

	ICFSecISOLangObj readCachedISOLangByIdIdx( short ISOLangId );

	ICFSecISOLangObj readCachedISOLangByCode3Idx( String ISO6392Code );

	List<ICFSecISOLangObj> readCachedISOLangByCode2Idx( String ISO6391Code );

	void deepDisposeISOLangByIdIdx( short ISOLangId );

	void deepDisposeISOLangByCode3Idx( String ISO6392Code );

	void deepDisposeISOLangByCode2Idx( String ISO6391Code );

	/**
	 *	Internal use only.
	 */
	ICFSecISOLangObj updateISOLang( ICFSecISOLangObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteISOLang( ICFSecISOLangObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	ISOLangId	The ISOLang key attribute of the instance generating the id.
	 */
	void deleteISOLangByIdIdx( short ISOLangId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ISO6392Code	The ISOLang key attribute of the instance generating the id.
	 */
	void deleteISOLangByCode3Idx(String ISO6392Code );

	/**
	 *	Internal use only.
	 *
	 *	@param	ISO6391Code	The ISOLang key attribute of the instance generating the id.
	 */
	void deleteISOLangByCode2Idx( String ISO6391Code );
}
