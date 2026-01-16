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

public interface ICFSecSecGrpMembTableObj
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
	 *	Instantiate a new SecGrpMemb instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecSecGrpMembObj newInstance();

	/**
	 *	Instantiate a new SecGrpMemb edition of the specified SecGrpMemb instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecSecGrpMembEditObj newEditInstance( ICFSecSecGrpMembObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecSecGrpMembObj realiseSecGrpMemb( ICFSecSecGrpMembObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecSecGrpMembObj createSecGrpMemb( ICFSecSecGrpMembObj Obj );

	/**
	 *	Read a SecGrpMemb-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecGrpMemb-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecGrpMembObj readSecGrpMemb( CFLibDbKeyHash256 pkey );

	/**
	 *	Read a SecGrpMemb-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecGrpMemb-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecGrpMembObj readSecGrpMemb( CFLibDbKeyHash256 pkey,
		boolean forceRead );

	ICFSecSecGrpMembObj readCachedSecGrpMemb( CFLibDbKeyHash256 pkey );

	public void reallyDeepDisposeSecGrpMemb( ICFSecSecGrpMembObj obj );

	void deepDisposeSecGrpMemb( CFLibDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecSecGrpMembObj lockSecGrpMemb( CFLibDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the SecGrpMemb-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecGrpMembObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecGrpMembObj> readAllSecGrpMemb();

	/**
	 *	Return a sorted map of all the SecGrpMemb-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecGrpMembObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecGrpMembObj> readAllSecGrpMemb( boolean forceRead );

	List<ICFSecSecGrpMembObj> readCachedAllSecGrpMemb();

	/**
	 *	Return a sorted map of a page of the SecGrpMemb-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecGrpMembObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecGrpMembObj> pageAllSecGrpMemb(CFLibDbKeyHash256 priorSecGrpMembId );

	/**
	 *	Get the CFSecSecGrpMembObj instance for the primary key attributes.
	 *
	 *	@param	SecGrpMembId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecGrpMembObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecGrpMembObj readSecGrpMembByIdIdx( CFLibDbKeyHash256 SecGrpMembId );

	/**
	 *	Get the CFSecSecGrpMembObj instance for the primary key attributes.
	 *
	 *	@param	SecGrpMembId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecGrpMembObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecGrpMembObj readSecGrpMembByIdIdx( CFLibDbKeyHash256 SecGrpMembId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecGrpMembObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	ClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGrpMembObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGrpMembObj> readSecGrpMembByClusterIdx( long ClusterId );

	/**
	 *	Get the map of CFSecSecGrpMembObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	ClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGrpMembObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGrpMembObj> readSecGrpMembByClusterIdx( long ClusterId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecGrpMembObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	SecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGrpMembObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGrpMembObj> readSecGrpMembByGroupIdx( CFLibDbKeyHash256 SecGroupId );

	/**
	 *	Get the map of CFSecSecGrpMembObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	SecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGrpMembObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGrpMembObj> readSecGrpMembByGroupIdx( CFLibDbKeyHash256 SecGroupId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecGrpMembObj instances sorted by their primary keys for the duplicate UserIdx key.
	 *
	 *	@param	SecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGrpMembObj cached instances sorted by their primary keys for the duplicate UserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGrpMembObj> readSecGrpMembByUserIdx( CFLibDbKeyHash256 SecUserId );

	/**
	 *	Get the map of CFSecSecGrpMembObj instances sorted by their primary keys for the duplicate UserIdx key.
	 *
	 *	@param	SecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecGrpMembObj cached instances sorted by their primary keys for the duplicate UserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecGrpMembObj> readSecGrpMembByUserIdx( CFLibDbKeyHash256 SecUserId,
		boolean forceRead );

	/**
	 *	Get the CFSecSecGrpMembObj instance for the unique UUserIdx key.
	 *
	 *	@param	ClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecGrpMembObj cached instance for the unique UUserIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecGrpMembObj readSecGrpMembByUUserIdx(long ClusterId,
		CFLibDbKeyHash256 SecGroupId,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Get the CFSecSecGrpMembObj instance for the unique UUserIdx key.
	 *
	 *	@param	ClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecGrpMembObj refreshed instance for the unique UUserIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecGrpMembObj readSecGrpMembByUUserIdx(long ClusterId,
		CFLibDbKeyHash256 SecGroupId,
		CFLibDbKeyHash256 SecUserId,
		boolean forceRead );

	ICFSecSecGrpMembObj readCachedSecGrpMembByIdIdx( CFLibDbKeyHash256 SecGrpMembId );

	List<ICFSecSecGrpMembObj> readCachedSecGrpMembByClusterIdx( long ClusterId );

	List<ICFSecSecGrpMembObj> readCachedSecGrpMembByGroupIdx( CFLibDbKeyHash256 SecGroupId );

	List<ICFSecSecGrpMembObj> readCachedSecGrpMembByUserIdx( CFLibDbKeyHash256 SecUserId );

	ICFSecSecGrpMembObj readCachedSecGrpMembByUUserIdx( long ClusterId,
		CFLibDbKeyHash256 SecGroupId,
		CFLibDbKeyHash256 SecUserId );

	void deepDisposeSecGrpMembByIdIdx( CFLibDbKeyHash256 SecGrpMembId );

	void deepDisposeSecGrpMembByClusterIdx( long ClusterId );

	void deepDisposeSecGrpMembByGroupIdx( CFLibDbKeyHash256 SecGroupId );

	void deepDisposeSecGrpMembByUserIdx( CFLibDbKeyHash256 SecUserId );

	void deepDisposeSecGrpMembByUUserIdx( long ClusterId,
		CFLibDbKeyHash256 SecGroupId,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read a page of data as a List of SecGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusterIdx key attributes.
	 *
	 *	@param	ClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecGrpMembObj> pageSecGrpMembByClusterIdx( long ClusterId,
		CFLibDbKeyHash256 priorSecGrpMembId );

	/**
	 *	Read a page of data as a List of SecGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate GroupIdx key attributes.
	 *
	 *	@param	SecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecGrpMembObj> pageSecGrpMembByGroupIdx( CFLibDbKeyHash256 SecGroupId,
		CFLibDbKeyHash256 priorSecGrpMembId );

	/**
	 *	Read a page of data as a List of SecGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate UserIdx key attributes.
	 *
	 *	@param	SecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecGrpMembObj> pageSecGrpMembByUserIdx( CFLibDbKeyHash256 SecUserId,
		CFLibDbKeyHash256 priorSecGrpMembId );

	/**
	 *	Internal use only.
	 */
	ICFSecSecGrpMembObj updateSecGrpMemb( ICFSecSecGrpMembObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecGrpMemb( ICFSecSecGrpMembObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecGrpMembId	The SecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecGrpMembByIdIdx( CFLibDbKeyHash256 SecGrpMembId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecGrpMembByClusterIdx( long ClusterId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecGrpMembByGroupIdx( CFLibDbKeyHash256 SecGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecGrpMembByUserIdx( CFLibDbKeyHash256 SecUserId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecGrpMembByUUserIdx(long ClusterId,
		CFLibDbKeyHash256 SecGroupId,
		CFLibDbKeyHash256 SecUserId );
}
