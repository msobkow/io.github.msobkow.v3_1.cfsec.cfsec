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

public interface ICFSecISOCcyTableObj
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
	 *	Instantiate a new ISOCcy instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecISOCcyObj newInstance();

	/**
	 *	Instantiate a new ISOCcy edition of the specified ISOCcy instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecISOCcyEditObj newEditInstance( ICFSecISOCcyObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCcyObj realiseISOCcy( ICFSecISOCcyObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCcyObj createISOCcy( ICFSecISOCcyObj Obj );

	/**
	 *	Read a ISOCcy-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOCcy-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOCcyObj readISOCcy( Short pkey );

	/**
	 *	Read a ISOCcy-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOCcy-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOCcyObj readISOCcy( Short pkey,
		boolean forceRead );

	ICFSecISOCcyObj readCachedISOCcy( Short pkey );

	public void reallyDeepDisposeISOCcy( ICFSecISOCcyObj obj );

	void deepDisposeISOCcy( Short pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCcyObj lockISOCcy( Short pkey );

	/**
	 *	Return a sorted list of all the ISOCcy-derived instances in the database.
	 *
	 *	@return	List of ICFSecISOCcyObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecISOCcyObj> readAllISOCcy();

	/**
	 *	Return a sorted map of all the ISOCcy-derived instances in the database.
	 *
	 *	@return	List of ICFSecISOCcyObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecISOCcyObj> readAllISOCcy( boolean forceRead );

	List<ICFSecISOCcyObj> readCachedAllISOCcy();

	/**
	 *	Get the CFSecISOCcyObj instance for the primary key attributes.
	 *
	 *	@param	ISOCcyId	The ISOCcy key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCcyObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCcyObj readISOCcyByIdIdx( short ISOCcyId );

	/**
	 *	Get the CFSecISOCcyObj instance for the primary key attributes.
	 *
	 *	@param	ISOCcyId	The ISOCcy key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCcyObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCcyObj readISOCcyByIdIdx( short ISOCcyId,
		boolean forceRead );

	/**
	 *	Get the CFSecISOCcyObj instance for the unique CcyCdIdx key.
	 *
	 *	@param	ISOCode	The ISOCcy key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCcyObj cached instance for the unique CcyCdIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCcyObj readISOCcyByCcyCdIdx(String ISOCode );

	/**
	 *	Get the CFSecISOCcyObj instance for the unique CcyCdIdx key.
	 *
	 *	@param	ISOCode	The ISOCcy key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCcyObj refreshed instance for the unique CcyCdIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCcyObj readISOCcyByCcyCdIdx(String ISOCode,
		boolean forceRead );

	/**
	 *	Get the CFSecISOCcyObj instance for the unique CcyNmIdx key.
	 *
	 *	@param	Name	The ISOCcy key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCcyObj cached instance for the unique CcyNmIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCcyObj readISOCcyByCcyNmIdx(String Name );

	/**
	 *	Get the CFSecISOCcyObj instance for the unique CcyNmIdx key.
	 *
	 *	@param	Name	The ISOCcy key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCcyObj refreshed instance for the unique CcyNmIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCcyObj readISOCcyByCcyNmIdx(String Name,
		boolean forceRead );

	ICFSecISOCcyObj readCachedISOCcyByIdIdx( short ISOCcyId );

	ICFSecISOCcyObj readCachedISOCcyByCcyCdIdx( String ISOCode );

	ICFSecISOCcyObj readCachedISOCcyByCcyNmIdx( String Name );

	void deepDisposeISOCcyByIdIdx( short ISOCcyId );

	void deepDisposeISOCcyByCcyCdIdx( String ISOCode );

	void deepDisposeISOCcyByCcyNmIdx( String Name );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCcyObj updateISOCcy( ICFSecISOCcyObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteISOCcy( ICFSecISOCcyObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	ISOCcyId	The ISOCcy key attribute of the instance generating the id.
	 */
	void deleteISOCcyByIdIdx( short ISOCcyId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ISOCode	The ISOCcy key attribute of the instance generating the id.
	 */
	void deleteISOCcyByCcyCdIdx(String ISOCode );

	/**
	 *	Internal use only.
	 *
	 *	@param	Name	The ISOCcy key attribute of the instance generating the id.
	 */
	void deleteISOCcyByCcyNmIdx(String Name );
}
