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

public interface ICFSecTenantTableObj
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
	 *	Instantiate a new Tenant instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecTenantObj newInstance();

	/**
	 *	Instantiate a new Tenant edition of the specified Tenant instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecTenantEditObj newEditInstance( ICFSecTenantObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecTenantObj realiseTenant( ICFSecTenantObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecTenantObj createTenant( ICFSecTenantObj Obj );

	/**
	 *	Read a Tenant-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Tenant-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecTenantObj readTenant( CFLibDbKeyHash256 pkey );

	/**
	 *	Read a Tenant-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Tenant-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecTenantObj readTenant( CFLibDbKeyHash256 pkey,
		boolean forceRead );

	ICFSecTenantObj readCachedTenant( CFLibDbKeyHash256 pkey );

	public void reallyDeepDisposeTenant( ICFSecTenantObj obj );

	void deepDisposeTenant( CFLibDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecTenantObj lockTenant( CFLibDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Tenant-derived instances in the database.
	 *
	 *	@return	List of ICFSecTenantObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecTenantObj> readAllTenant();

	/**
	 *	Return a sorted map of all the Tenant-derived instances in the database.
	 *
	 *	@return	List of ICFSecTenantObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecTenantObj> readAllTenant( boolean forceRead );

	List<ICFSecTenantObj> readCachedAllTenant();

	/**
	 *	Return a sorted map of a page of the Tenant-derived instances in the database.
	 *
	 *	@return	List of ICFSecTenantObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecTenantObj> pageAllTenant(CFLibDbKeyHash256 priorId );

	/**
	 *	Get the CFSecTenantObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Tenant key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTenantObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecTenantObj readTenantByIdIdx( CFLibDbKeyHash256 Id );

	/**
	 *	Get the CFSecTenantObj instance for the primary key attributes.
	 *
	 *	@param	Id	The Tenant key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTenantObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecTenantObj readTenantByIdIdx( CFLibDbKeyHash256 Id,
		boolean forceRead );

	/**
	 *	Get the map of CFSecTenantObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	ClusterId	The Tenant key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTenantObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTenantObj> readTenantByClusterIdx( long ClusterId );

	/**
	 *	Get the map of CFSecTenantObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	ClusterId	The Tenant key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTenantObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTenantObj> readTenantByClusterIdx( long ClusterId,
		boolean forceRead );

	/**
	 *	Get the CFSecTenantObj instance for the unique UNameIdx key.
	 *
	 *	@param	ClusterId	The Tenant key attribute of the instance generating the id.
	 *
	 *	@param	TenantName	The Tenant key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTenantObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecTenantObj readTenantByUNameIdx(long ClusterId,
		String TenantName );

	/**
	 *	Get the CFSecTenantObj instance for the unique UNameIdx key.
	 *
	 *	@param	ClusterId	The Tenant key attribute of the instance generating the id.
	 *
	 *	@param	TenantName	The Tenant key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTenantObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecTenantObj readTenantByUNameIdx(long ClusterId,
		String TenantName,
		boolean forceRead );

	ICFSecTenantObj readCachedTenantByIdIdx( CFLibDbKeyHash256 Id );

	List<ICFSecTenantObj> readCachedTenantByClusterIdx( long ClusterId );

	ICFSecTenantObj readCachedTenantByUNameIdx( long ClusterId,
		String TenantName );

	void deepDisposeTenantByIdIdx( CFLibDbKeyHash256 Id );

	void deepDisposeTenantByClusterIdx( long ClusterId );

	void deepDisposeTenantByUNameIdx( long ClusterId,
		String TenantName );

	/**
	 *	Read a page of data as a List of Tenant-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusterIdx key attributes.
	 *
	 *	@param	ClusterId	The Tenant key attribute of the instance generating the id.
	 *
	 *	@return	A List of Tenant-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecTenantObj> pageTenantByClusterIdx( long ClusterId,
		CFLibDbKeyHash256 priorId );

	/**
	 *	Internal use only.
	 */
	ICFSecTenantObj updateTenant( ICFSecTenantObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTenant( ICFSecTenantObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	Id	The Tenant key attribute of the instance generating the id.
	 */
	void deleteTenantByIdIdx( CFLibDbKeyHash256 Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClusterId	The Tenant key attribute of the instance generating the id.
	 */
	void deleteTenantByClusterIdx( long ClusterId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClusterId	The Tenant key attribute of the instance generating the id.
	 *
	 *	@param	TenantName	The Tenant key attribute of the instance generating the id.
	 */
	void deleteTenantByUNameIdx(long ClusterId,
		String TenantName );

	ICFSecTenantObj getSystemTenant();
}
