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

public interface ICFSecSysClusterTableObj
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
	 *	Instantiate a new SysCluster instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecSysClusterObj newInstance();

	/**
	 *	Instantiate a new SysCluster edition of the specified SysCluster instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecSysClusterEditObj newEditInstance( ICFSecSysClusterObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecSysClusterObj realiseSysCluster( ICFSecSysClusterObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecSysClusterObj createSysCluster( ICFSecSysClusterObj Obj );

	/**
	 *	Read a SysCluster-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SysCluster-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSysClusterObj readSysCluster( Integer pkey );

	/**
	 *	Read a SysCluster-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SysCluster-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSysClusterObj readSysCluster( Integer pkey,
		boolean forceRead );

	ICFSecSysClusterObj readCachedSysCluster( Integer pkey );

	public void reallyDeepDisposeSysCluster( ICFSecSysClusterObj obj );

	void deepDisposeSysCluster( Integer pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecSysClusterObj lockSysCluster( Integer pkey );

	/**
	 *	Return a sorted list of all the SysCluster-derived instances in the database.
	 *
	 *	@return	List of ICFSecSysClusterObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSysClusterObj> readAllSysCluster();

	/**
	 *	Return a sorted map of all the SysCluster-derived instances in the database.
	 *
	 *	@return	List of ICFSecSysClusterObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSysClusterObj> readAllSysCluster( boolean forceRead );

	List<ICFSecSysClusterObj> readCachedAllSysCluster();

	/**
	 *	Get the CFSecSysClusterObj instance for the primary key attributes.
	 *
	 *	@param	SingletonId	The SysCluster key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSysClusterObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSysClusterObj readSysClusterByIdIdx( int SingletonId );

	/**
	 *	Get the CFSecSysClusterObj instance for the primary key attributes.
	 *
	 *	@param	SingletonId	The SysCluster key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSysClusterObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSysClusterObj readSysClusterByIdIdx( int SingletonId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSysClusterObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	ClusterId	The SysCluster key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSysClusterObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSysClusterObj> readSysClusterByClusterIdx( long ClusterId );

	/**
	 *	Get the map of CFSecSysClusterObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	ClusterId	The SysCluster key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSysClusterObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSysClusterObj> readSysClusterByClusterIdx( long ClusterId,
		boolean forceRead );

	ICFSecSysClusterObj readCachedSysClusterByIdIdx( int SingletonId );

	List<ICFSecSysClusterObj> readCachedSysClusterByClusterIdx( long ClusterId );

	void deepDisposeSysClusterByIdIdx( int SingletonId );

	void deepDisposeSysClusterByClusterIdx( long ClusterId );

	/**
	 *	Internal use only.
	 */
	ICFSecSysClusterObj updateSysCluster( ICFSecSysClusterObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSysCluster( ICFSecSysClusterObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	SingletonId	The SysCluster key attribute of the instance generating the id.
	 */
	void deleteSysClusterByIdIdx( int SingletonId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClusterId	The SysCluster key attribute of the instance generating the id.
	 */
	void deleteSysClusterByClusterIdx( long ClusterId );
}
