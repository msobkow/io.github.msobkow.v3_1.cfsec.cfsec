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

public interface ICFSecISOCtryCcyTableObj
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
	 *	Instantiate a new ISOCtryCcy instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecISOCtryCcyObj newInstance();

	/**
	 *	Instantiate a new ISOCtryCcy edition of the specified ISOCtryCcy instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecISOCtryCcyEditObj newEditInstance( ICFSecISOCtryCcyObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCtryCcyObj realiseISOCtryCcy( ICFSecISOCtryCcyObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCtryCcyObj createISOCtryCcy( ICFSecISOCtryCcyObj Obj );

	/**
	 *	Read a ISOCtryCcy-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOCtryCcy-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOCtryCcyObj readISOCtryCcy( ICFSecISOCtryCcyPKey pkey );

	/**
	 *	Read a ISOCtryCcy-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOCtryCcy-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOCtryCcyObj readISOCtryCcy( ICFSecISOCtryCcyPKey pkey,
		boolean forceRead );

	/**
	 *	Read a ISOCtryCcy-derived instance by it's primary key.
	 *
	 *	@return	The ISOCtryCcy-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOCtryCcyObj readISOCtryCcy( short ISOCtryId,
		short ISOCcyId );

	/**
	 *	Read a ISOCtryCcy-derived instance by it's primary key.
	 *
	 *	@return	The ISOCtryCcy-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOCtryCcyObj readISOCtryCcy( short ISOCtryId,
		short ISOCcyId,
		boolean forceRead );

	ICFSecISOCtryCcyObj readCachedISOCtryCcy( ICFSecISOCtryCcyPKey pkey );

	public void reallyDeepDisposeISOCtryCcy( ICFSecISOCtryCcyObj obj );

	void deepDisposeISOCtryCcy( ICFSecISOCtryCcyPKey pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCtryCcyObj lockISOCtryCcy( ICFSecISOCtryCcyPKey pkey );

	/**
	 *	Return a sorted list of all the ISOCtryCcy-derived instances in the database.
	 *
	 *	@return	List of ICFSecISOCtryCcyObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecISOCtryCcyObj> readAllISOCtryCcy();

	/**
	 *	Return a sorted map of all the ISOCtryCcy-derived instances in the database.
	 *
	 *	@return	List of ICFSecISOCtryCcyObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecISOCtryCcyObj> readAllISOCtryCcy( boolean forceRead );

	List<ICFSecISOCtryCcyObj> readCachedAllISOCtryCcy();

	/**
	 *	Get the CFSecISOCtryCcyObj instance for the primary key attributes.
	 *
	 *	@param	ISOCtryId	The ISOCtryCcy key attribute of the instance generating the id.
	 *
	 *	@param	ISOCcyId	The ISOCtryCcy key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCtryCcyObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCtryCcyObj readISOCtryCcyByIdIdx( short ISOCtryId,
		short ISOCcyId );

	/**
	 *	Get the CFSecISOCtryCcyObj instance for the primary key attributes.
	 *
	 *	@param	ISOCtryId	The ISOCtryCcy key attribute of the instance generating the id.
	 *
	 *	@param	ISOCcyId	The ISOCtryCcy key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCtryCcyObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCtryCcyObj readISOCtryCcyByIdIdx( short ISOCtryId,
		short ISOCcyId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecISOCtryCcyObj instances sorted by their primary keys for the duplicate CtryIdx key.
	 *
	 *	@param	ISOCtryId	The ISOCtryCcy key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOCtryCcyObj cached instances sorted by their primary keys for the duplicate CtryIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOCtryCcyObj> readISOCtryCcyByCtryIdx( short ISOCtryId );

	/**
	 *	Get the map of CFSecISOCtryCcyObj instances sorted by their primary keys for the duplicate CtryIdx key.
	 *
	 *	@param	ISOCtryId	The ISOCtryCcy key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOCtryCcyObj cached instances sorted by their primary keys for the duplicate CtryIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOCtryCcyObj> readISOCtryCcyByCtryIdx( short ISOCtryId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecISOCtryCcyObj instances sorted by their primary keys for the duplicate CcyIdx key.
	 *
	 *	@param	ISOCcyId	The ISOCtryCcy key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOCtryCcyObj cached instances sorted by their primary keys for the duplicate CcyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOCtryCcyObj> readISOCtryCcyByCcyIdx( short ISOCcyId );

	/**
	 *	Get the map of CFSecISOCtryCcyObj instances sorted by their primary keys for the duplicate CcyIdx key.
	 *
	 *	@param	ISOCcyId	The ISOCtryCcy key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOCtryCcyObj cached instances sorted by their primary keys for the duplicate CcyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOCtryCcyObj> readISOCtryCcyByCcyIdx( short ISOCcyId,
		boolean forceRead );

	ICFSecISOCtryCcyObj readCachedISOCtryCcyByIdIdx( short ISOCtryId,
		short ISOCcyId );

	List<ICFSecISOCtryCcyObj> readCachedISOCtryCcyByCtryIdx( short ISOCtryId );

	List<ICFSecISOCtryCcyObj> readCachedISOCtryCcyByCcyIdx( short ISOCcyId );

	void deepDisposeISOCtryCcyByIdIdx( short ISOCtryId,
		short ISOCcyId );

	void deepDisposeISOCtryCcyByCtryIdx( short ISOCtryId );

	void deepDisposeISOCtryCcyByCcyIdx( short ISOCcyId );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCtryCcyObj updateISOCtryCcy( ICFSecISOCtryCcyObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteISOCtryCcy( ICFSecISOCtryCcyObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	ISOCtryId	The ISOCtryCcy key attribute of the instance generating the id.
	 *
	 *	@param	ISOCcyId	The ISOCtryCcy key attribute of the instance generating the id.
	 */
	void deleteISOCtryCcyByIdIdx( short ISOCtryId,
		short ISOCcyId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ISOCtryId	The ISOCtryCcy key attribute of the instance generating the id.
	 */
	void deleteISOCtryCcyByCtryIdx( short ISOCtryId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ISOCcyId	The ISOCtryCcy key attribute of the instance generating the id.
	 */
	void deleteISOCtryCcyByCcyIdx( short ISOCcyId );
}
