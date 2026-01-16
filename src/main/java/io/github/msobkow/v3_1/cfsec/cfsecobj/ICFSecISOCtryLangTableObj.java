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

public interface ICFSecISOCtryLangTableObj
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
	 *	Instantiate a new ISOCtryLang instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecISOCtryLangObj newInstance();

	/**
	 *	Instantiate a new ISOCtryLang edition of the specified ISOCtryLang instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecISOCtryLangEditObj newEditInstance( ICFSecISOCtryLangObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCtryLangObj realiseISOCtryLang( ICFSecISOCtryLangObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCtryLangObj createISOCtryLang( ICFSecISOCtryLangObj Obj );

	/**
	 *	Read a ISOCtryLang-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOCtryLang-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOCtryLangObj readISOCtryLang( ICFSecISOCtryLangPKey pkey );

	/**
	 *	Read a ISOCtryLang-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOCtryLang-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOCtryLangObj readISOCtryLang( ICFSecISOCtryLangPKey pkey,
		boolean forceRead );

	/**
	 *	Read a ISOCtryLang-derived instance by it's primary key.
	 *
	 *	@return	The ISOCtryLang-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOCtryLangObj readISOCtryLang( short ISOCtryId,
		short ISOLangId );

	/**
	 *	Read a ISOCtryLang-derived instance by it's primary key.
	 *
	 *	@return	The ISOCtryLang-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOCtryLangObj readISOCtryLang( short ISOCtryId,
		short ISOLangId,
		boolean forceRead );

	ICFSecISOCtryLangObj readCachedISOCtryLang( ICFSecISOCtryLangPKey pkey );

	public void reallyDeepDisposeISOCtryLang( ICFSecISOCtryLangObj obj );

	void deepDisposeISOCtryLang( ICFSecISOCtryLangPKey pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCtryLangObj lockISOCtryLang( ICFSecISOCtryLangPKey pkey );

	/**
	 *	Return a sorted list of all the ISOCtryLang-derived instances in the database.
	 *
	 *	@return	List of ICFSecISOCtryLangObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecISOCtryLangObj> readAllISOCtryLang();

	/**
	 *	Return a sorted map of all the ISOCtryLang-derived instances in the database.
	 *
	 *	@return	List of ICFSecISOCtryLangObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecISOCtryLangObj> readAllISOCtryLang( boolean forceRead );

	List<ICFSecISOCtryLangObj> readCachedAllISOCtryLang();

	/**
	 *	Get the CFSecISOCtryLangObj instance for the primary key attributes.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCtryLangObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCtryLangObj readISOCtryLangByIdIdx( short ISOCtryId,
		short ISOLangId );

	/**
	 *	Get the CFSecISOCtryLangObj instance for the primary key attributes.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCtryLangObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCtryLangObj readISOCtryLangByIdIdx( short ISOCtryId,
		short ISOLangId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecISOCtryLangObj instances sorted by their primary keys for the duplicate CtryIdx key.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOCtryLangObj cached instances sorted by their primary keys for the duplicate CtryIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOCtryLangObj> readISOCtryLangByCtryIdx( short ISOCtryId );

	/**
	 *	Get the map of CFSecISOCtryLangObj instances sorted by their primary keys for the duplicate CtryIdx key.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOCtryLangObj cached instances sorted by their primary keys for the duplicate CtryIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOCtryLangObj> readISOCtryLangByCtryIdx( short ISOCtryId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecISOCtryLangObj instances sorted by their primary keys for the duplicate LangIdx key.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOCtryLangObj cached instances sorted by their primary keys for the duplicate LangIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOCtryLangObj> readISOCtryLangByLangIdx( short ISOLangId );

	/**
	 *	Get the map of CFSecISOCtryLangObj instances sorted by their primary keys for the duplicate LangIdx key.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOCtryLangObj cached instances sorted by their primary keys for the duplicate LangIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOCtryLangObj> readISOCtryLangByLangIdx( short ISOLangId,
		boolean forceRead );

	ICFSecISOCtryLangObj readCachedISOCtryLangByIdIdx( short ISOCtryId,
		short ISOLangId );

	List<ICFSecISOCtryLangObj> readCachedISOCtryLangByCtryIdx( short ISOCtryId );

	List<ICFSecISOCtryLangObj> readCachedISOCtryLangByLangIdx( short ISOLangId );

	void deepDisposeISOCtryLangByIdIdx( short ISOCtryId,
		short ISOLangId );

	void deepDisposeISOCtryLangByCtryIdx( short ISOCtryId );

	void deepDisposeISOCtryLangByLangIdx( short ISOLangId );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCtryLangObj updateISOCtryLang( ICFSecISOCtryLangObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteISOCtryLang( ICFSecISOCtryLangObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 */
	void deleteISOCtryLangByIdIdx( short ISOCtryId,
		short ISOLangId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 */
	void deleteISOCtryLangByCtryIdx( short ISOCtryId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 */
	void deleteISOCtryLangByLangIdx( short ISOLangId );
}
