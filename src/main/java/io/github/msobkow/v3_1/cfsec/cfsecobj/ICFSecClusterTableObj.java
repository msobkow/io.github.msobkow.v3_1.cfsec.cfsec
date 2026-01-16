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

public interface ICFSecClusterTableObj
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
	 *	Instantiate a new Cluster instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecClusterObj newInstance();

	/**
	 *	Instantiate a new Cluster edition of the specified Cluster instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecClusterEditObj newEditInstance( ICFSecClusterObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecClusterObj realiseCluster( ICFSecClusterObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecClusterObj createCluster( ICFSecClusterObj Obj );

	/**
	 *	Read a Cluster-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Cluster-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecClusterObj readCluster( Long pkey );

	/**
	 *	Read a Cluster-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Cluster-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecClusterObj readCluster( Long pkey,
		boolean forceRead );

	ICFSecClusterObj readCachedCluster( Long pkey );

	public void reallyDeepDisposeCluster( ICFSecClusterObj obj );

	void deepDisposeCluster( Long pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecClusterObj lockCluster( Long pkey );

	/**
	 *	Return a sorted list of all the Cluster-derived instances in the database.
	 *
	 *	@return	List of ICFSecClusterObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecClusterObj> readAllCluster();

	/**
	 *	Return a sorted map of all the Cluster-derived instances in the database.
	 *
	 *	@return	List of ICFSecClusterObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecClusterObj> readAllCluster( boolean forceRead );

	List<ICFSecClusterObj> readCachedAllCluster();

	/**
	 *	Return a sorted map of a page of the Cluster-derived instances in the database.
	 *
	 *	@return	List of ICFSecClusterObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecClusterObj> pageAllCluster(Long priorId );

	/**
	 *	Get the CFSecClusterObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Cluster key attribute of the instance generating the id.
	 *
	 *	@return	CFSecClusterObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecClusterObj readClusterByIdIdx( long Id );

	/**
	 *	Get the CFSecClusterObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Cluster key attribute of the instance generating the id.
	 *
	 *	@return	CFSecClusterObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecClusterObj readClusterByIdIdx( long Id,
		boolean forceRead );

	/**
	 *	Get the CFSecClusterObj instance for the unique UDomNameIdx key.
	 *
	 *	@param	FullDomName	The Cluster key attribute of the instance generating the id.
	 *
	 *	@return	CFSecClusterObj cached instance for the unique UDomNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecClusterObj readClusterByUDomNameIdx(String FullDomName );

	/**
	 *	Get the CFSecClusterObj instance for the unique UDomNameIdx key.
	 *
	 *	@param	FullDomName	The Cluster key attribute of the instance generating the id.
	 *
	 *	@return	CFSecClusterObj refreshed instance for the unique UDomNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecClusterObj readClusterByUDomNameIdx(String FullDomName,
		boolean forceRead );

	/**
	 *	Get the CFSecClusterObj instance for the unique UDescrIdx key.
	 *
	 *	@param	Description	The Cluster key attribute of the instance generating the id.
	 *
	 *	@return	CFSecClusterObj cached instance for the unique UDescrIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecClusterObj readClusterByUDescrIdx(String Description );

	/**
	 *	Get the CFSecClusterObj instance for the unique UDescrIdx key.
	 *
	 *	@param	Description	The Cluster key attribute of the instance generating the id.
	 *
	 *	@return	CFSecClusterObj refreshed instance for the unique UDescrIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecClusterObj readClusterByUDescrIdx(String Description,
		boolean forceRead );

	ICFSecClusterObj readCachedClusterByIdIdx( long Id );

	ICFSecClusterObj readCachedClusterByUDomNameIdx( String FullDomName );

	ICFSecClusterObj readCachedClusterByUDescrIdx( String Description );

	void deepDisposeClusterByIdIdx( long Id );

	void deepDisposeClusterByUDomNameIdx( String FullDomName );

	void deepDisposeClusterByUDescrIdx( String Description );

	/**
	 *	Internal use only.
	 */
	ICFSecClusterObj updateCluster( ICFSecClusterObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteCluster( ICFSecClusterObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Cluster key attribute of the instance generating the id.
	 */
	void deleteClusterByIdIdx( long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	FullDomName	The Cluster key attribute of the instance generating the id.
	 */
	void deleteClusterByUDomNameIdx(String FullDomName );

	/**
	 *	Internal use only.
	 *
	 *	@param	Description	The Cluster key attribute of the instance generating the id.
	 */
	void deleteClusterByUDescrIdx(String Description );

	ICFSecClusterObj getSystemCluster();
}
