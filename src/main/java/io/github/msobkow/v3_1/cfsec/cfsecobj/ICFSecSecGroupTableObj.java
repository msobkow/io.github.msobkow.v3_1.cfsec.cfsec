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

public interface ICFSecSecGroupTableObj
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
	 *	Instantiate a new SecGroup instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecSecGroupObj newInstance();

	/**
	 *	Instantiate a new SecGroup edition of the specified SecGroup instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecSecGroupEditObj newEditInstance( ICFSecSecGroupObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecSecGroupObj realiseSecGroup( ICFSecSecGroupObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecSecGroupObj createSecGroup( ICFSecSecGroupObj Obj );

	/**
	 *	Read a SecGroup-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecGroup-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecGroupObj readSecGroup( CFLibDbKeyHash256 pkey );

	/**
	 *	Read a SecGroup-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecGroup-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecGroupObj readSecGroup( CFLibDbKeyHash256 pkey,
		boolean forceRead );

	ICFSecSecGroupObj readCachedSecGroup( CFLibDbKeyHash256 pkey );

	public void reallyDeepDisposeSecGroup( ICFSecSecGroupObj obj );

	void deepDisposeSecGroup( CFLibDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecSecGroupObj lockSecGroup( CFLibDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the SecGroup-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecGroupObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecGroupObj> readAllSecGroup();

	/**
	 *	Return a sorted map of all the SecGroup-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecGroupObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecGroupObj> readAllSecGroup( boolean forceRead );

	List<ICFSecSecGroupObj> readCachedAllSecGroup();

	/**
	 *	Get the CFSecSecGroupObj instance for the primary key attributes.
	 *
	 *	@param	SecGroupId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecGroupObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecGroupObj readSecGroupByIdIdx( CFLibDbKeyHash256 SecGroupId );

	/**
	 *	Get the CFSecSecGroupObj instance for the primary key attributes.
	 *
	 *	@param	SecGroupId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecGroupObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecGroupObj readSecGroupByIdIdx( CFLibDbKeyHash256 SecGroupId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecGroupObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	ClusterId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGroupObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGroupObj> readSecGroupByClusterIdx( long ClusterId );

	/**
	 *	Get the map of CFSecSecGroupObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	ClusterId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGroupObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGroupObj> readSecGroupByClusterIdx( long ClusterId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecGroupObj instances sorted by their primary keys for the duplicate ClusterVisIdx key.
	 *
	 *	@param	ClusterId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@param	IsVisible	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGroupObj cached instances sorted by their primary keys for the duplicate ClusterVisIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGroupObj> readSecGroupByClusterVisIdx( long ClusterId,
		boolean IsVisible );

	/**
	 *	Get the map of CFSecSecGroupObj instances sorted by their primary keys for the duplicate ClusterVisIdx key.
	 *
	 *	@param	ClusterId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@param	IsVisible	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGroupObj cached instances sorted by their primary keys for the duplicate ClusterVisIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGroupObj> readSecGroupByClusterVisIdx( long ClusterId,
		boolean IsVisible,
		boolean forceRead );

	/**
	 *	Get the CFSecSecGroupObj instance for the unique UNameIdx key.
	 *
	 *	@param	ClusterId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecGroupObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecGroupObj readSecGroupByUNameIdx(long ClusterId,
		String Name );

	/**
	 *	Get the CFSecSecGroupObj instance for the unique UNameIdx key.
	 *
	 *	@param	ClusterId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecGroupObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecGroupObj readSecGroupByUNameIdx(long ClusterId,
		String Name,
		boolean forceRead );

	ICFSecSecGroupObj readCachedSecGroupByIdIdx( CFLibDbKeyHash256 SecGroupId );

	List<ICFSecSecGroupObj> readCachedSecGroupByClusterIdx( long ClusterId );

	List<ICFSecSecGroupObj> readCachedSecGroupByClusterVisIdx( long ClusterId,
		boolean IsVisible );

	ICFSecSecGroupObj readCachedSecGroupByUNameIdx( long ClusterId,
		String Name );

	void deepDisposeSecGroupByIdIdx( CFLibDbKeyHash256 SecGroupId );

	void deepDisposeSecGroupByClusterIdx( long ClusterId );

	void deepDisposeSecGroupByClusterVisIdx( long ClusterId,
		boolean IsVisible );

	void deepDisposeSecGroupByUNameIdx( long ClusterId,
		String Name );

	/**
	 *	Internal use only.
	 */
	ICFSecSecGroupObj updateSecGroup( ICFSecSecGroupObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecGroup( ICFSecSecGroupObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecGroupId	The SecGroup key attribute of the instance generating the id.
	 */
	void deleteSecGroupByIdIdx( CFLibDbKeyHash256 SecGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClusterId	The SecGroup key attribute of the instance generating the id.
	 */
	void deleteSecGroupByClusterIdx( long ClusterId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClusterId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@param	IsVisible	The SecGroup key attribute of the instance generating the id.
	 */
	void deleteSecGroupByClusterVisIdx( long ClusterId,
		boolean IsVisible );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClusterId	The SecGroup key attribute of the instance generating the id.
	 *
	 *	@param	Name	The SecGroup key attribute of the instance generating the id.
	 */
	void deleteSecGroupByUNameIdx(long ClusterId,
		String Name );
}
