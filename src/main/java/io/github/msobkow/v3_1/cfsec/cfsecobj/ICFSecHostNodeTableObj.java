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

public interface ICFSecHostNodeTableObj
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
	 *	Instantiate a new HostNode instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecHostNodeObj newInstance();

	/**
	 *	Instantiate a new HostNode edition of the specified HostNode instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecHostNodeEditObj newEditInstance( ICFSecHostNodeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecHostNodeObj realiseHostNode( ICFSecHostNodeObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecHostNodeObj createHostNode( ICFSecHostNodeObj Obj );

	/**
	 *	Read a HostNode-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The HostNode-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecHostNodeObj readHostNode( CFLibDbKeyHash256 pkey );

	/**
	 *	Read a HostNode-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The HostNode-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecHostNodeObj readHostNode( CFLibDbKeyHash256 pkey,
		boolean forceRead );

	ICFSecHostNodeObj readCachedHostNode( CFLibDbKeyHash256 pkey );

	public void reallyDeepDisposeHostNode( ICFSecHostNodeObj obj );

	void deepDisposeHostNode( CFLibDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecHostNodeObj lockHostNode( CFLibDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the HostNode-derived instances in the database.
	 *
	 *	@return	List of ICFSecHostNodeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecHostNodeObj> readAllHostNode();

	/**
	 *	Return a sorted map of all the HostNode-derived instances in the database.
	 *
	 *	@return	List of ICFSecHostNodeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecHostNodeObj> readAllHostNode( boolean forceRead );

	List<ICFSecHostNodeObj> readCachedAllHostNode();

	/**
	 *	Return a sorted map of a page of the HostNode-derived instances in the database.
	 *
	 *	@return	List of ICFSecHostNodeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecHostNodeObj> pageAllHostNode(CFLibDbKeyHash256 priorHostNodeId );

	/**
	 *	Get the CFSecHostNodeObj instance for the primary key attributes.
	 *
	 *	@param	HostNodeId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return	CFSecHostNodeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecHostNodeObj readHostNodeByIdIdx( CFLibDbKeyHash256 HostNodeId );

	/**
	 *	Get the CFSecHostNodeObj instance for the primary key attributes.
	 *
	 *	@param	HostNodeId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return	CFSecHostNodeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecHostNodeObj readHostNodeByIdIdx( CFLibDbKeyHash256 HostNodeId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecHostNodeObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecHostNodeObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecHostNodeObj> readHostNodeByClusterIdx( long ClusterId );

	/**
	 *	Get the map of CFSecHostNodeObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecHostNodeObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecHostNodeObj> readHostNodeByClusterIdx( long ClusterId,
		boolean forceRead );

	/**
	 *	Get the CFSecHostNodeObj instance for the unique UDescrIdx key.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	Description	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return	CFSecHostNodeObj cached instance for the unique UDescrIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecHostNodeObj readHostNodeByUDescrIdx(long ClusterId,
		String Description );

	/**
	 *	Get the CFSecHostNodeObj instance for the unique UDescrIdx key.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	Description	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return	CFSecHostNodeObj refreshed instance for the unique UDescrIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecHostNodeObj readHostNodeByUDescrIdx(long ClusterId,
		String Description,
		boolean forceRead );

	/**
	 *	Get the CFSecHostNodeObj instance for the unique HostNameIdx key.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	HostName	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return	CFSecHostNodeObj cached instance for the unique HostNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecHostNodeObj readHostNodeByHostNameIdx(long ClusterId,
		String HostName );

	/**
	 *	Get the CFSecHostNodeObj instance for the unique HostNameIdx key.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	HostName	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return	CFSecHostNodeObj refreshed instance for the unique HostNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecHostNodeObj readHostNodeByHostNameIdx(long ClusterId,
		String HostName,
		boolean forceRead );

	ICFSecHostNodeObj readCachedHostNodeByIdIdx( CFLibDbKeyHash256 HostNodeId );

	List<ICFSecHostNodeObj> readCachedHostNodeByClusterIdx( long ClusterId );

	ICFSecHostNodeObj readCachedHostNodeByUDescrIdx( long ClusterId,
		String Description );

	ICFSecHostNodeObj readCachedHostNodeByHostNameIdx( long ClusterId,
		String HostName );

	void deepDisposeHostNodeByIdIdx( CFLibDbKeyHash256 HostNodeId );

	void deepDisposeHostNodeByClusterIdx( long ClusterId );

	void deepDisposeHostNodeByUDescrIdx( long ClusterId,
		String Description );

	void deepDisposeHostNodeByHostNameIdx( long ClusterId,
		String HostName );

	/**
	 *	Read a page of data as a List of HostNode-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusterIdx key attributes.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@return	A List of HostNode-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecHostNodeObj> pageHostNodeByClusterIdx( long ClusterId,
		CFLibDbKeyHash256 priorHostNodeId );

	/**
	 *	Internal use only.
	 */
	ICFSecHostNodeObj updateHostNode( ICFSecHostNodeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteHostNode( ICFSecHostNodeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	HostNodeId	The HostNode key attribute of the instance generating the id.
	 */
	void deleteHostNodeByIdIdx( CFLibDbKeyHash256 HostNodeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 */
	void deleteHostNodeByClusterIdx( long ClusterId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	Description	The HostNode key attribute of the instance generating the id.
	 */
	void deleteHostNodeByUDescrIdx(long ClusterId,
		String Description );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClusterId	The HostNode key attribute of the instance generating the id.
	 *
	 *	@param	HostName	The HostNode key attribute of the instance generating the id.
	 */
	void deleteHostNodeByHostNameIdx(long ClusterId,
		String HostName );
}
