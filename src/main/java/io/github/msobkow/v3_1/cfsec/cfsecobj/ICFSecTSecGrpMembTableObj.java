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

public interface ICFSecTSecGrpMembTableObj
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
	 *	Instantiate a new TSecGrpMemb instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecTSecGrpMembObj newInstance();

	/**
	 *	Instantiate a new TSecGrpMemb edition of the specified TSecGrpMemb instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecTSecGrpMembEditObj newEditInstance( ICFSecTSecGrpMembObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecTSecGrpMembObj realiseTSecGrpMemb( ICFSecTSecGrpMembObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecTSecGrpMembObj createTSecGrpMemb( ICFSecTSecGrpMembObj Obj );

	/**
	 *	Read a TSecGrpMemb-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TSecGrpMemb-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecTSecGrpMembObj readTSecGrpMemb( CFLibDbKeyHash256 pkey );

	/**
	 *	Read a TSecGrpMemb-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TSecGrpMemb-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecTSecGrpMembObj readTSecGrpMemb( CFLibDbKeyHash256 pkey,
		boolean forceRead );

	ICFSecTSecGrpMembObj readCachedTSecGrpMemb( CFLibDbKeyHash256 pkey );

	public void reallyDeepDisposeTSecGrpMemb( ICFSecTSecGrpMembObj obj );

	void deepDisposeTSecGrpMemb( CFLibDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecTSecGrpMembObj lockTSecGrpMemb( CFLibDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the TSecGrpMemb-derived instances in the database.
	 *
	 *	@return	List of ICFSecTSecGrpMembObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecTSecGrpMembObj> readAllTSecGrpMemb();

	/**
	 *	Return a sorted map of all the TSecGrpMemb-derived instances in the database.
	 *
	 *	@return	List of ICFSecTSecGrpMembObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecTSecGrpMembObj> readAllTSecGrpMemb( boolean forceRead );

	List<ICFSecTSecGrpMembObj> readCachedAllTSecGrpMemb();

	/**
	 *	Return a sorted map of a page of the TSecGrpMemb-derived instances in the database.
	 *
	 *	@return	List of ICFSecTSecGrpMembObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecTSecGrpMembObj> pageAllTSecGrpMemb(CFLibDbKeyHash256 priorTSecGrpMembId );

	/**
	 *	Get the CFSecTSecGrpMembObj instance for the primary key attributes.
	 *
	 *	@param	TSecGrpMembId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTSecGrpMembObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecTSecGrpMembObj readTSecGrpMembByIdIdx( CFLibDbKeyHash256 TSecGrpMembId );

	/**
	 *	Get the CFSecTSecGrpMembObj instance for the primary key attributes.
	 *
	 *	@param	TSecGrpMembId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTSecGrpMembObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecTSecGrpMembObj readTSecGrpMembByIdIdx( CFLibDbKeyHash256 TSecGrpMembId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecTSecGrpMembObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTSecGrpMembObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTSecGrpMembObj> readTSecGrpMembByTenantIdx( CFLibDbKeyHash256 TenantId );

	/**
	 *	Get the map of CFSecTSecGrpMembObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTSecGrpMembObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTSecGrpMembObj> readTSecGrpMembByTenantIdx( CFLibDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecTSecGrpMembObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	TSecGroupId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTSecGrpMembObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTSecGrpMembObj> readTSecGrpMembByGroupIdx( CFLibDbKeyHash256 TSecGroupId );

	/**
	 *	Get the map of CFSecTSecGrpMembObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	TSecGroupId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTSecGrpMembObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTSecGrpMembObj> readTSecGrpMembByGroupIdx( CFLibDbKeyHash256 TSecGroupId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecTSecGrpMembObj instances sorted by their primary keys for the duplicate UserIdx key.
	 *
	 *	@param	SecUserId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTSecGrpMembObj cached instances sorted by their primary keys for the duplicate UserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTSecGrpMembObj> readTSecGrpMembByUserIdx( CFLibDbKeyHash256 SecUserId );

	/**
	 *	Get the map of CFSecTSecGrpMembObj instances sorted by their primary keys for the duplicate UserIdx key.
	 *
	 *	@param	SecUserId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTSecGrpMembObj cached instances sorted by their primary keys for the duplicate UserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTSecGrpMembObj> readTSecGrpMembByUserIdx( CFLibDbKeyHash256 SecUserId,
		boolean forceRead );

	/**
	 *	Get the CFSecTSecGrpMembObj instance for the unique UUserIdx key.
	 *
	 *	@param	TenantId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	TSecGroupId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecUserId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTSecGrpMembObj cached instance for the unique UUserIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecTSecGrpMembObj readTSecGrpMembByUUserIdx(CFLibDbKeyHash256 TenantId,
		CFLibDbKeyHash256 TSecGroupId,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Get the CFSecTSecGrpMembObj instance for the unique UUserIdx key.
	 *
	 *	@param	TenantId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	TSecGroupId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecUserId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTSecGrpMembObj refreshed instance for the unique UUserIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecTSecGrpMembObj readTSecGrpMembByUUserIdx(CFLibDbKeyHash256 TenantId,
		CFLibDbKeyHash256 TSecGroupId,
		CFLibDbKeyHash256 SecUserId,
		boolean forceRead );

	ICFSecTSecGrpMembObj readCachedTSecGrpMembByIdIdx( CFLibDbKeyHash256 TSecGrpMembId );

	List<ICFSecTSecGrpMembObj> readCachedTSecGrpMembByTenantIdx( CFLibDbKeyHash256 TenantId );

	List<ICFSecTSecGrpMembObj> readCachedTSecGrpMembByGroupIdx( CFLibDbKeyHash256 TSecGroupId );

	List<ICFSecTSecGrpMembObj> readCachedTSecGrpMembByUserIdx( CFLibDbKeyHash256 SecUserId );

	ICFSecTSecGrpMembObj readCachedTSecGrpMembByUUserIdx( CFLibDbKeyHash256 TenantId,
		CFLibDbKeyHash256 TSecGroupId,
		CFLibDbKeyHash256 SecUserId );

	void deepDisposeTSecGrpMembByIdIdx( CFLibDbKeyHash256 TSecGrpMembId );

	void deepDisposeTSecGrpMembByTenantIdx( CFLibDbKeyHash256 TenantId );

	void deepDisposeTSecGrpMembByGroupIdx( CFLibDbKeyHash256 TSecGroupId );

	void deepDisposeTSecGrpMembByUserIdx( CFLibDbKeyHash256 SecUserId );

	void deepDisposeTSecGrpMembByUUserIdx( CFLibDbKeyHash256 TenantId,
		CFLibDbKeyHash256 TSecGroupId,
		CFLibDbKeyHash256 SecUserId );

	/**
	 *	Read a page of data as a List of TSecGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate TenantIdx key attributes.
	 *
	 *	@param	TenantId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of TSecGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecTSecGrpMembObj> pageTSecGrpMembByTenantIdx( CFLibDbKeyHash256 TenantId,
		CFLibDbKeyHash256 priorTSecGrpMembId );

	/**
	 *	Read a page of data as a List of TSecGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate GroupIdx key attributes.
	 *
	 *	@param	TSecGroupId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of TSecGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecTSecGrpMembObj> pageTSecGrpMembByGroupIdx( CFLibDbKeyHash256 TSecGroupId,
		CFLibDbKeyHash256 priorTSecGrpMembId );

	/**
	 *	Read a page of data as a List of TSecGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate UserIdx key attributes.
	 *
	 *	@param	SecUserId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of TSecGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecTSecGrpMembObj> pageTSecGrpMembByUserIdx( CFLibDbKeyHash256 SecUserId,
		CFLibDbKeyHash256 priorTSecGrpMembId );

	/**
	 *	Internal use only.
	 */
	ICFSecTSecGrpMembObj updateTSecGrpMemb( ICFSecTSecGrpMembObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTSecGrpMemb( ICFSecTSecGrpMembObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	TSecGrpMembId	The TSecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteTSecGrpMembByIdIdx( CFLibDbKeyHash256 TSecGrpMembId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The TSecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteTSecGrpMembByTenantIdx( CFLibDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TSecGroupId	The TSecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteTSecGrpMembByGroupIdx( CFLibDbKeyHash256 TSecGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecUserId	The TSecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteTSecGrpMembByUserIdx( CFLibDbKeyHash256 SecUserId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	TSecGroupId	The TSecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	SecUserId	The TSecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteTSecGrpMembByUUserIdx(CFLibDbKeyHash256 TenantId,
		CFLibDbKeyHash256 TSecGroupId,
		CFLibDbKeyHash256 SecUserId );
}
