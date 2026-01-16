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

public interface ICFSecSecGrpIncTableObj
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
	 *	Instantiate a new SecGrpInc instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecSecGrpIncObj newInstance();

	/**
	 *	Instantiate a new SecGrpInc edition of the specified SecGrpInc instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecSecGrpIncEditObj newEditInstance( ICFSecSecGrpIncObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecSecGrpIncObj realiseSecGrpInc( ICFSecSecGrpIncObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecSecGrpIncObj createSecGrpInc( ICFSecSecGrpIncObj Obj );

	/**
	 *	Read a SecGrpInc-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecGrpInc-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecGrpIncObj readSecGrpInc( CFLibDbKeyHash256 pkey );

	/**
	 *	Read a SecGrpInc-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecGrpInc-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecGrpIncObj readSecGrpInc( CFLibDbKeyHash256 pkey,
		boolean forceRead );

	ICFSecSecGrpIncObj readCachedSecGrpInc( CFLibDbKeyHash256 pkey );

	public void reallyDeepDisposeSecGrpInc( ICFSecSecGrpIncObj obj );

	void deepDisposeSecGrpInc( CFLibDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecSecGrpIncObj lockSecGrpInc( CFLibDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the SecGrpInc-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecGrpIncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecGrpIncObj> readAllSecGrpInc();

	/**
	 *	Return a sorted map of all the SecGrpInc-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecGrpIncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecGrpIncObj> readAllSecGrpInc( boolean forceRead );

	List<ICFSecSecGrpIncObj> readCachedAllSecGrpInc();

	/**
	 *	Return a sorted map of a page of the SecGrpInc-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecGrpIncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecGrpIncObj> pageAllSecGrpInc(CFLibDbKeyHash256 priorSecGrpIncId );

	/**
	 *	Get the CFSecSecGrpIncObj instance for the primary key attributes.
	 *
	 *	@param	SecGrpIncId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecGrpIncObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecGrpIncObj readSecGrpIncByIdIdx( CFLibDbKeyHash256 SecGrpIncId );

	/**
	 *	Get the CFSecSecGrpIncObj instance for the primary key attributes.
	 *
	 *	@param	SecGrpIncId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecGrpIncObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecGrpIncObj readSecGrpIncByIdIdx( CFLibDbKeyHash256 SecGrpIncId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecGrpIncObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	ClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGrpIncObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGrpIncObj> readSecGrpIncByClusterIdx( long ClusterId );

	/**
	 *	Get the map of CFSecSecGrpIncObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	ClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGrpIncObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGrpIncObj> readSecGrpIncByClusterIdx( long ClusterId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecGrpIncObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	SecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGrpIncObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGrpIncObj> readSecGrpIncByGroupIdx( CFLibDbKeyHash256 SecGroupId );

	/**
	 *	Get the map of CFSecSecGrpIncObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	SecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGrpIncObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGrpIncObj> readSecGrpIncByGroupIdx( CFLibDbKeyHash256 SecGroupId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecGrpIncObj instances sorted by their primary keys for the duplicate IncludeIdx key.
	 *
	 *	@param	IncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGrpIncObj cached instances sorted by their primary keys for the duplicate IncludeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGrpIncObj> readSecGrpIncByIncludeIdx( CFLibDbKeyHash256 IncludeGroupId );

	/**
	 *	Get the map of CFSecSecGrpIncObj instances sorted by their primary keys for the duplicate IncludeIdx key.
	 *
	 *	@param	IncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGrpIncObj cached instances sorted by their primary keys for the duplicate IncludeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGrpIncObj> readSecGrpIncByIncludeIdx( CFLibDbKeyHash256 IncludeGroupId,
		boolean forceRead );

	/**
	 *	Get the CFSecSecGrpIncObj instance for the unique UIncludeIdx key.
	 *
	 *	@param	ClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	SecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	IncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecGrpIncObj cached instance for the unique UIncludeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecGrpIncObj readSecGrpIncByUIncludeIdx(long ClusterId,
		CFLibDbKeyHash256 SecGroupId,
		CFLibDbKeyHash256 IncludeGroupId );

	/**
	 *	Get the CFSecSecGrpIncObj instance for the unique UIncludeIdx key.
	 *
	 *	@param	ClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	SecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	IncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecGrpIncObj refreshed instance for the unique UIncludeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecGrpIncObj readSecGrpIncByUIncludeIdx(long ClusterId,
		CFLibDbKeyHash256 SecGroupId,
		CFLibDbKeyHash256 IncludeGroupId,
		boolean forceRead );

	ICFSecSecGrpIncObj readCachedSecGrpIncByIdIdx( CFLibDbKeyHash256 SecGrpIncId );

	List<ICFSecSecGrpIncObj> readCachedSecGrpIncByClusterIdx( long ClusterId );

	List<ICFSecSecGrpIncObj> readCachedSecGrpIncByGroupIdx( CFLibDbKeyHash256 SecGroupId );

	List<ICFSecSecGrpIncObj> readCachedSecGrpIncByIncludeIdx( CFLibDbKeyHash256 IncludeGroupId );

	ICFSecSecGrpIncObj readCachedSecGrpIncByUIncludeIdx( long ClusterId,
		CFLibDbKeyHash256 SecGroupId,
		CFLibDbKeyHash256 IncludeGroupId );

	void deepDisposeSecGrpIncByIdIdx( CFLibDbKeyHash256 SecGrpIncId );

	void deepDisposeSecGrpIncByClusterIdx( long ClusterId );

	void deepDisposeSecGrpIncByGroupIdx( CFLibDbKeyHash256 SecGroupId );

	void deepDisposeSecGrpIncByIncludeIdx( CFLibDbKeyHash256 IncludeGroupId );

	void deepDisposeSecGrpIncByUIncludeIdx( long ClusterId,
		CFLibDbKeyHash256 SecGroupId,
		CFLibDbKeyHash256 IncludeGroupId );

	/**
	 *	Read a page of data as a List of SecGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusterIdx key attributes.
	 *
	 *	@param	ClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecGrpIncObj> pageSecGrpIncByClusterIdx( long ClusterId,
		CFLibDbKeyHash256 priorSecGrpIncId );

	/**
	 *	Read a page of data as a List of SecGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate GroupIdx key attributes.
	 *
	 *	@param	SecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecGrpIncObj> pageSecGrpIncByGroupIdx( CFLibDbKeyHash256 SecGroupId,
		CFLibDbKeyHash256 priorSecGrpIncId );

	/**
	 *	Read a page of data as a List of SecGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate IncludeIdx key attributes.
	 *
	 *	@param	IncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecGrpIncObj> pageSecGrpIncByIncludeIdx( CFLibDbKeyHash256 IncludeGroupId,
		CFLibDbKeyHash256 priorSecGrpIncId );

	/**
	 *	Internal use only.
	 */
	ICFSecSecGrpIncObj updateSecGrpInc( ICFSecSecGrpIncObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecGrpInc( ICFSecSecGrpIncObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecGrpIncId	The SecGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecGrpIncByIdIdx( CFLibDbKeyHash256 SecGrpIncId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClusterId	The SecGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecGrpIncByClusterIdx( long ClusterId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecGrpIncByGroupIdx( CFLibDbKeyHash256 SecGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	IncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecGrpIncByIncludeIdx( CFLibDbKeyHash256 IncludeGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	SecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	IncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecGrpIncByUIncludeIdx(long ClusterId,
		CFLibDbKeyHash256 SecGroupId,
		CFLibDbKeyHash256 IncludeGroupId );
}
