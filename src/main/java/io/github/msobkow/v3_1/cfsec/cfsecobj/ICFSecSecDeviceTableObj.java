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

public interface ICFSecSecDeviceTableObj
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
	 *	Instantiate a new SecDevice instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecSecDeviceObj newInstance();

	/**
	 *	Instantiate a new SecDevice edition of the specified SecDevice instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecSecDeviceEditObj newEditInstance( ICFSecSecDeviceObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecSecDeviceObj realiseSecDevice( ICFSecSecDeviceObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecSecDeviceObj createSecDevice( ICFSecSecDeviceObj Obj );

	/**
	 *	Read a SecDevice-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecDevice-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecDeviceObj readSecDevice( ICFSecSecDevicePKey pkey );

	/**
	 *	Read a SecDevice-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecDevice-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecDeviceObj readSecDevice( ICFSecSecDevicePKey pkey,
		boolean forceRead );

	/**
	 *	Read a SecDevice-derived instance by it's primary key.
	 *
	 *	@return	The SecDevice-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecDeviceObj readSecDevice( CFLibDbKeyHash256 SecUserId,
		String DevName );

	/**
	 *	Read a SecDevice-derived instance by it's primary key.
	 *
	 *	@return	The SecDevice-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecDeviceObj readSecDevice( CFLibDbKeyHash256 SecUserId,
		String DevName,
		boolean forceRead );

	ICFSecSecDeviceObj readCachedSecDevice( ICFSecSecDevicePKey pkey );

	public void reallyDeepDisposeSecDevice( ICFSecSecDeviceObj obj );

	void deepDisposeSecDevice( ICFSecSecDevicePKey pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecSecDeviceObj lockSecDevice( ICFSecSecDevicePKey pkey );

	/**
	 *	Return a sorted list of all the SecDevice-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecDeviceObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecDeviceObj> readAllSecDevice();

	/**
	 *	Return a sorted map of all the SecDevice-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecDeviceObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecDeviceObj> readAllSecDevice( boolean forceRead );

	List<ICFSecSecDeviceObj> readCachedAllSecDevice();

	/**
	 *	Return a sorted map of a page of the SecDevice-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecDeviceObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecDeviceObj> pageAllSecDevice(CFLibDbKeyHash256 priorSecUserId,
		String priorDevName );

	/**
	 *	Get the CFSecSecDeviceObj instance for the primary key attributes.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@param	DevName	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecDeviceObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecDeviceObj readSecDeviceByIdIdx( CFLibDbKeyHash256 SecUserId,
		String DevName );

	/**
	 *	Get the CFSecSecDeviceObj instance for the primary key attributes.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@param	DevName	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecDeviceObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecDeviceObj readSecDeviceByIdIdx( CFLibDbKeyHash256 SecUserId,
		String DevName,
		boolean forceRead );

	/**
	 *	Get the CFSecSecDeviceObj instance for the unique NameIdx key.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@param	DevName	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecDeviceObj cached instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecDeviceObj readSecDeviceByNameIdx(CFLibDbKeyHash256 SecUserId,
		String DevName );

	/**
	 *	Get the CFSecSecDeviceObj instance for the unique NameIdx key.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@param	DevName	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecDeviceObj refreshed instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecDeviceObj readSecDeviceByNameIdx(CFLibDbKeyHash256 SecUserId,
		String DevName,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecDeviceObj instances sorted by their primary keys for the duplicate UserIdx key.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecDeviceObj cached instances sorted by their primary keys for the duplicate UserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecDeviceObj> readSecDeviceByUserIdx( CFLibDbKeyHash256 SecUserId );

	/**
	 *	Get the map of CFSecSecDeviceObj instances sorted by their primary keys for the duplicate UserIdx key.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecDeviceObj cached instances sorted by their primary keys for the duplicate UserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecDeviceObj> readSecDeviceByUserIdx( CFLibDbKeyHash256 SecUserId,
		boolean forceRead );

	ICFSecSecDeviceObj readCachedSecDeviceByIdIdx( CFLibDbKeyHash256 SecUserId,
		String DevName );

	ICFSecSecDeviceObj readCachedSecDeviceByNameIdx( CFLibDbKeyHash256 SecUserId,
		String DevName );

	List<ICFSecSecDeviceObj> readCachedSecDeviceByUserIdx( CFLibDbKeyHash256 SecUserId );

	void deepDisposeSecDeviceByIdIdx( CFLibDbKeyHash256 SecUserId,
		String DevName );

	void deepDisposeSecDeviceByNameIdx( CFLibDbKeyHash256 SecUserId,
		String DevName );

	void deepDisposeSecDeviceByUserIdx( CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read a page of data as a List of SecDevice-derived instances sorted by their primary keys,
	 *	as identified by the duplicate UserIdx key attributes.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecDevice-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecDeviceObj> pageSecDeviceByUserIdx( CFLibDbKeyHash256 SecUserId,
		CFLibDbKeyHash256 priorSecUserId,
		String priorDevName );

	/**
	 *	Internal use only.
	 */
	ICFSecSecDeviceObj updateSecDevice( ICFSecSecDeviceObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecDevice( ICFSecSecDeviceObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@param	DevName	The SecDevice key attribute of the instance generating the id.
	 */
	void deleteSecDeviceByIdIdx( CFLibDbKeyHash256 SecUserId,
		String DevName );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@param	DevName	The SecDevice key attribute of the instance generating the id.
	 */
	void deleteSecDeviceByNameIdx(CFLibDbKeyHash256 SecUserId,
		String DevName );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecUserId	The SecDevice key attribute of the instance generating the id.
	 */
	void deleteSecDeviceByUserIdx( CFLibDbKeyHash256 SecUserId );
}
