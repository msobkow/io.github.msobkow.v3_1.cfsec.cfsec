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

public interface ICFSecISOTZoneTableObj
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
	 *	Instantiate a new ISOTZone instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecISOTZoneObj newInstance();

	/**
	 *	Instantiate a new ISOTZone edition of the specified ISOTZone instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecISOTZoneEditObj newEditInstance( ICFSecISOTZoneObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecISOTZoneObj realiseISOTZone( ICFSecISOTZoneObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecISOTZoneObj createISOTZone( ICFSecISOTZoneObj Obj );

	/**
	 *	Read a ISOTZone-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOTZone-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOTZoneObj readISOTZone( Short pkey );

	/**
	 *	Read a ISOTZone-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOTZone-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOTZoneObj readISOTZone( Short pkey,
		boolean forceRead );

	ICFSecISOTZoneObj readCachedISOTZone( Short pkey );

	public void reallyDeepDisposeISOTZone( ICFSecISOTZoneObj obj );

	void deepDisposeISOTZone( Short pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecISOTZoneObj lockISOTZone( Short pkey );

	/**
	 *	Return a sorted list of all the ISOTZone-derived instances in the database.
	 *
	 *	@return	List of ICFSecISOTZoneObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecISOTZoneObj> readAllISOTZone();

	/**
	 *	Return a sorted map of all the ISOTZone-derived instances in the database.
	 *
	 *	@return	List of ICFSecISOTZoneObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecISOTZoneObj> readAllISOTZone( boolean forceRead );

	List<ICFSecISOTZoneObj> readCachedAllISOTZone();

	/**
	 *	Get the CFSecISOTZoneObj instance for the primary key attributes.
	 *
	 *	@param	ISOTZoneId	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOTZoneObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOTZoneObj readISOTZoneByIdIdx( short ISOTZoneId );

	/**
	 *	Get the CFSecISOTZoneObj instance for the primary key attributes.
	 *
	 *	@param	ISOTZoneId	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOTZoneObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOTZoneObj readISOTZoneByIdIdx( short ISOTZoneId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecISOTZoneObj instances sorted by their primary keys for the duplicate OffsetIdx key.
	 *
	 *	@param	TZHourOffset	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@param	TZMinOffset	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOTZoneObj cached instances sorted by their primary keys for the duplicate OffsetIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOTZoneObj> readISOTZoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset );

	/**
	 *	Get the map of CFSecISOTZoneObj instances sorted by their primary keys for the duplicate OffsetIdx key.
	 *
	 *	@param	TZHourOffset	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@param	TZMinOffset	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOTZoneObj cached instances sorted by their primary keys for the duplicate OffsetIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOTZoneObj> readISOTZoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset,
		boolean forceRead );

	/**
	 *	Get the CFSecISOTZoneObj instance for the unique UTZNameIdx key.
	 *
	 *	@param	TZName	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOTZoneObj cached instance for the unique UTZNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOTZoneObj readISOTZoneByUTZNameIdx(String TZName );

	/**
	 *	Get the CFSecISOTZoneObj instance for the unique UTZNameIdx key.
	 *
	 *	@param	TZName	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOTZoneObj refreshed instance for the unique UTZNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOTZoneObj readISOTZoneByUTZNameIdx(String TZName,
		boolean forceRead );

	/**
	 *	Get the map of CFSecISOTZoneObj instances sorted by their primary keys for the duplicate Iso8601Idx key.
	 *
	 *	@param	Iso8601	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOTZoneObj cached instances sorted by their primary keys for the duplicate Iso8601Idx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOTZoneObj> readISOTZoneByIso8601Idx( String Iso8601 );

	/**
	 *	Get the map of CFSecISOTZoneObj instances sorted by their primary keys for the duplicate Iso8601Idx key.
	 *
	 *	@param	Iso8601	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOTZoneObj cached instances sorted by their primary keys for the duplicate Iso8601Idx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOTZoneObj> readISOTZoneByIso8601Idx( String Iso8601,
		boolean forceRead );

	ICFSecISOTZoneObj readCachedISOTZoneByIdIdx( short ISOTZoneId );

	List<ICFSecISOTZoneObj> readCachedISOTZoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset );

	ICFSecISOTZoneObj readCachedISOTZoneByUTZNameIdx( String TZName );

	List<ICFSecISOTZoneObj> readCachedISOTZoneByIso8601Idx( String Iso8601 );

	void deepDisposeISOTZoneByIdIdx( short ISOTZoneId );

	void deepDisposeISOTZoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset );

	void deepDisposeISOTZoneByUTZNameIdx( String TZName );

	void deepDisposeISOTZoneByIso8601Idx( String Iso8601 );

	/**
	 *	Internal use only.
	 */
	ICFSecISOTZoneObj updateISOTZone( ICFSecISOTZoneObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteISOTZone( ICFSecISOTZoneObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	ISOTZoneId	The ISOTZone key attribute of the instance generating the id.
	 */
	void deleteISOTZoneByIdIdx( short ISOTZoneId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TZHourOffset	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@param	TZMinOffset	The ISOTZone key attribute of the instance generating the id.
	 */
	void deleteISOTZoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset );

	/**
	 *	Internal use only.
	 *
	 *	@param	TZName	The ISOTZone key attribute of the instance generating the id.
	 */
	void deleteISOTZoneByUTZNameIdx(String TZName );

	/**
	 *	Internal use only.
	 *
	 *	@param	Iso8601	The ISOTZone key attribute of the instance generating the id.
	 */
	void deleteISOTZoneByIso8601Idx( String Iso8601 );
}
