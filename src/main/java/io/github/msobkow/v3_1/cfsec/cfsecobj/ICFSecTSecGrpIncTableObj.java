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

public interface ICFSecTSecGrpIncTableObj
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
	 *	Instantiate a new TSecGrpInc instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecTSecGrpIncObj newInstance();

	/**
	 *	Instantiate a new TSecGrpInc edition of the specified TSecGrpInc instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecTSecGrpIncEditObj newEditInstance( ICFSecTSecGrpIncObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecTSecGrpIncObj realiseTSecGrpInc( ICFSecTSecGrpIncObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecTSecGrpIncObj createTSecGrpInc( ICFSecTSecGrpIncObj Obj );

	/**
	 *	Read a TSecGrpInc-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TSecGrpInc-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecTSecGrpIncObj readTSecGrpInc( CFLibDbKeyHash256 pkey );

	/**
	 *	Read a TSecGrpInc-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TSecGrpInc-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecTSecGrpIncObj readTSecGrpInc( CFLibDbKeyHash256 pkey,
		boolean forceRead );

	ICFSecTSecGrpIncObj readCachedTSecGrpInc( CFLibDbKeyHash256 pkey );

	public void reallyDeepDisposeTSecGrpInc( ICFSecTSecGrpIncObj obj );

	void deepDisposeTSecGrpInc( CFLibDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecTSecGrpIncObj lockTSecGrpInc( CFLibDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the TSecGrpInc-derived instances in the database.
	 *
	 *	@return	List of ICFSecTSecGrpIncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecTSecGrpIncObj> readAllTSecGrpInc();

	/**
	 *	Return a sorted map of all the TSecGrpInc-derived instances in the database.
	 *
	 *	@return	List of ICFSecTSecGrpIncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecTSecGrpIncObj> readAllTSecGrpInc( boolean forceRead );

	List<ICFSecTSecGrpIncObj> readCachedAllTSecGrpInc();

	/**
	 *	Return a sorted map of a page of the TSecGrpInc-derived instances in the database.
	 *
	 *	@return	List of ICFSecTSecGrpIncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecTSecGrpIncObj> pageAllTSecGrpInc(CFLibDbKeyHash256 priorTSecGrpIncId );

	/**
	 *	Get the CFSecTSecGrpIncObj instance for the primary key attributes.
	 *
	 *	@param	TSecGrpIncId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTSecGrpIncObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecTSecGrpIncObj readTSecGrpIncByIdIdx( CFLibDbKeyHash256 TSecGrpIncId );

	/**
	 *	Get the CFSecTSecGrpIncObj instance for the primary key attributes.
	 *
	 *	@param	TSecGrpIncId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTSecGrpIncObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecTSecGrpIncObj readTSecGrpIncByIdIdx( CFLibDbKeyHash256 TSecGrpIncId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecTSecGrpIncObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTSecGrpIncObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTSecGrpIncObj> readTSecGrpIncByTenantIdx( CFLibDbKeyHash256 TenantId );

	/**
	 *	Get the map of CFSecTSecGrpIncObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTSecGrpIncObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTSecGrpIncObj> readTSecGrpIncByTenantIdx( CFLibDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecTSecGrpIncObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	TSecGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTSecGrpIncObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTSecGrpIncObj> readTSecGrpIncByGroupIdx( CFLibDbKeyHash256 TSecGroupId );

	/**
	 *	Get the map of CFSecTSecGrpIncObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	TSecGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTSecGrpIncObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTSecGrpIncObj> readTSecGrpIncByGroupIdx( CFLibDbKeyHash256 TSecGroupId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecTSecGrpIncObj instances sorted by their primary keys for the duplicate IncludeIdx key.
	 *
	 *	@param	IncludeGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTSecGrpIncObj cached instances sorted by their primary keys for the duplicate IncludeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTSecGrpIncObj> readTSecGrpIncByIncludeIdx( CFLibDbKeyHash256 IncludeGroupId );

	/**
	 *	Get the map of CFSecTSecGrpIncObj instances sorted by their primary keys for the duplicate IncludeIdx key.
	 *
	 *	@param	IncludeGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTSecGrpIncObj cached instances sorted by their primary keys for the duplicate IncludeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTSecGrpIncObj> readTSecGrpIncByIncludeIdx( CFLibDbKeyHash256 IncludeGroupId,
		boolean forceRead );

	/**
	 *	Get the CFSecTSecGrpIncObj instance for the unique UIncludeIdx key.
	 *
	 *	@param	TenantId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	TSecGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	IncludeGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTSecGrpIncObj cached instance for the unique UIncludeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecTSecGrpIncObj readTSecGrpIncByUIncludeIdx(CFLibDbKeyHash256 TenantId,
		CFLibDbKeyHash256 TSecGroupId,
		CFLibDbKeyHash256 IncludeGroupId );

	/**
	 *	Get the CFSecTSecGrpIncObj instance for the unique UIncludeIdx key.
	 *
	 *	@param	TenantId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	TSecGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	IncludeGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTSecGrpIncObj refreshed instance for the unique UIncludeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecTSecGrpIncObj readTSecGrpIncByUIncludeIdx(CFLibDbKeyHash256 TenantId,
		CFLibDbKeyHash256 TSecGroupId,
		CFLibDbKeyHash256 IncludeGroupId,
		boolean forceRead );

	ICFSecTSecGrpIncObj readCachedTSecGrpIncByIdIdx( CFLibDbKeyHash256 TSecGrpIncId );

	List<ICFSecTSecGrpIncObj> readCachedTSecGrpIncByTenantIdx( CFLibDbKeyHash256 TenantId );

	List<ICFSecTSecGrpIncObj> readCachedTSecGrpIncByGroupIdx( CFLibDbKeyHash256 TSecGroupId );

	List<ICFSecTSecGrpIncObj> readCachedTSecGrpIncByIncludeIdx( CFLibDbKeyHash256 IncludeGroupId );

	ICFSecTSecGrpIncObj readCachedTSecGrpIncByUIncludeIdx( CFLibDbKeyHash256 TenantId,
		CFLibDbKeyHash256 TSecGroupId,
		CFLibDbKeyHash256 IncludeGroupId );

	void deepDisposeTSecGrpIncByIdIdx( CFLibDbKeyHash256 TSecGrpIncId );

	void deepDisposeTSecGrpIncByTenantIdx( CFLibDbKeyHash256 TenantId );

	void deepDisposeTSecGrpIncByGroupIdx( CFLibDbKeyHash256 TSecGroupId );

	void deepDisposeTSecGrpIncByIncludeIdx( CFLibDbKeyHash256 IncludeGroupId );

	void deepDisposeTSecGrpIncByUIncludeIdx( CFLibDbKeyHash256 TenantId,
		CFLibDbKeyHash256 TSecGroupId,
		CFLibDbKeyHash256 IncludeGroupId );

	/**
	 *	Read a page of data as a List of TSecGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate TenantIdx key attributes.
	 *
	 *	@param	TenantId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of TSecGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecTSecGrpIncObj> pageTSecGrpIncByTenantIdx( CFLibDbKeyHash256 TenantId,
		CFLibDbKeyHash256 priorTSecGrpIncId );

	/**
	 *	Read a page of data as a List of TSecGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate GroupIdx key attributes.
	 *
	 *	@param	TSecGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of TSecGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecTSecGrpIncObj> pageTSecGrpIncByGroupIdx( CFLibDbKeyHash256 TSecGroupId,
		CFLibDbKeyHash256 priorTSecGrpIncId );

	/**
	 *	Read a page of data as a List of TSecGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate IncludeIdx key attributes.
	 *
	 *	@param	IncludeGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of TSecGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecTSecGrpIncObj> pageTSecGrpIncByIncludeIdx( CFLibDbKeyHash256 IncludeGroupId,
		CFLibDbKeyHash256 priorTSecGrpIncId );

	/**
	 *	Internal use only.
	 */
	ICFSecTSecGrpIncObj updateTSecGrpInc( ICFSecTSecGrpIncObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTSecGrpInc( ICFSecTSecGrpIncObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	TSecGrpIncId	The TSecGrpInc key attribute of the instance generating the id.
	 */
	void deleteTSecGrpIncByIdIdx( CFLibDbKeyHash256 TSecGrpIncId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The TSecGrpInc key attribute of the instance generating the id.
	 */
	void deleteTSecGrpIncByTenantIdx( CFLibDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TSecGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 */
	void deleteTSecGrpIncByGroupIdx( CFLibDbKeyHash256 TSecGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	IncludeGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 */
	void deleteTSecGrpIncByIncludeIdx( CFLibDbKeyHash256 IncludeGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	TSecGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	IncludeGroupId	The TSecGrpInc key attribute of the instance generating the id.
	 */
	void deleteTSecGrpIncByUIncludeIdx(CFLibDbKeyHash256 TenantId,
		CFLibDbKeyHash256 TSecGroupId,
		CFLibDbKeyHash256 IncludeGroupId );
}
