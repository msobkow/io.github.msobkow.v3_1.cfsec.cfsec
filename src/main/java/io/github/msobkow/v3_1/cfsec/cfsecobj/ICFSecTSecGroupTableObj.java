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

public interface ICFSecTSecGroupTableObj
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
	 *	Instantiate a new TSecGroup instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecTSecGroupObj newInstance();

	/**
	 *	Instantiate a new TSecGroup edition of the specified TSecGroup instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecTSecGroupEditObj newEditInstance( ICFSecTSecGroupObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecTSecGroupObj realiseTSecGroup( ICFSecTSecGroupObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecTSecGroupObj createTSecGroup( ICFSecTSecGroupObj Obj );

	/**
	 *	Read a TSecGroup-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TSecGroup-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecTSecGroupObj readTSecGroup( CFLibDbKeyHash256 pkey );

	/**
	 *	Read a TSecGroup-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TSecGroup-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecTSecGroupObj readTSecGroup( CFLibDbKeyHash256 pkey,
		boolean forceRead );

	ICFSecTSecGroupObj readCachedTSecGroup( CFLibDbKeyHash256 pkey );

	public void reallyDeepDisposeTSecGroup( ICFSecTSecGroupObj obj );

	void deepDisposeTSecGroup( CFLibDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecTSecGroupObj lockTSecGroup( CFLibDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the TSecGroup-derived instances in the database.
	 *
	 *	@return	List of ICFSecTSecGroupObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecTSecGroupObj> readAllTSecGroup();

	/**
	 *	Return a sorted map of all the TSecGroup-derived instances in the database.
	 *
	 *	@return	List of ICFSecTSecGroupObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecTSecGroupObj> readAllTSecGroup( boolean forceRead );

	List<ICFSecTSecGroupObj> readCachedAllTSecGroup();

	/**
	 *	Get the CFSecTSecGroupObj instance for the primary key attributes.
	 *
	 *	@param	TSecGroupId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTSecGroupObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecTSecGroupObj readTSecGroupByIdIdx( CFLibDbKeyHash256 TSecGroupId );

	/**
	 *	Get the CFSecTSecGroupObj instance for the primary key attributes.
	 *
	 *	@param	TSecGroupId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTSecGroupObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecTSecGroupObj readTSecGroupByIdIdx( CFLibDbKeyHash256 TSecGroupId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecTSecGroupObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTSecGroupObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTSecGroupObj> readTSecGroupByTenantIdx( CFLibDbKeyHash256 TenantId );

	/**
	 *	Get the map of CFSecTSecGroupObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	TenantId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTSecGroupObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTSecGroupObj> readTSecGroupByTenantIdx( CFLibDbKeyHash256 TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecTSecGroupObj instances sorted by their primary keys for the duplicate TenantVisIdx key.
	 *
	 *	@param	TenantId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@param	IsVisible	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTSecGroupObj cached instances sorted by their primary keys for the duplicate TenantVisIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTSecGroupObj> readTSecGroupByTenantVisIdx( CFLibDbKeyHash256 TenantId,
		boolean IsVisible );

	/**
	 *	Get the map of CFSecTSecGroupObj instances sorted by their primary keys for the duplicate TenantVisIdx key.
	 *
	 *	@param	TenantId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@param	IsVisible	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTSecGroupObj cached instances sorted by their primary keys for the duplicate TenantVisIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTSecGroupObj> readTSecGroupByTenantVisIdx( CFLibDbKeyHash256 TenantId,
		boolean IsVisible,
		boolean forceRead );

	/**
	 *	Get the CFSecTSecGroupObj instance for the unique UNameIdx key.
	 *
	 *	@param	TenantId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTSecGroupObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecTSecGroupObj readTSecGroupByUNameIdx(CFLibDbKeyHash256 TenantId,
		String Name );

	/**
	 *	Get the CFSecTSecGroupObj instance for the unique UNameIdx key.
	 *
	 *	@param	TenantId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTSecGroupObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecTSecGroupObj readTSecGroupByUNameIdx(CFLibDbKeyHash256 TenantId,
		String Name,
		boolean forceRead );

	ICFSecTSecGroupObj readCachedTSecGroupByIdIdx( CFLibDbKeyHash256 TSecGroupId );

	List<ICFSecTSecGroupObj> readCachedTSecGroupByTenantIdx( CFLibDbKeyHash256 TenantId );

	List<ICFSecTSecGroupObj> readCachedTSecGroupByTenantVisIdx( CFLibDbKeyHash256 TenantId,
		boolean IsVisible );

	ICFSecTSecGroupObj readCachedTSecGroupByUNameIdx( CFLibDbKeyHash256 TenantId,
		String Name );

	void deepDisposeTSecGroupByIdIdx( CFLibDbKeyHash256 TSecGroupId );

	void deepDisposeTSecGroupByTenantIdx( CFLibDbKeyHash256 TenantId );

	void deepDisposeTSecGroupByTenantVisIdx( CFLibDbKeyHash256 TenantId,
		boolean IsVisible );

	void deepDisposeTSecGroupByUNameIdx( CFLibDbKeyHash256 TenantId,
		String Name );

	/**
	 *	Internal use only.
	 */
	ICFSecTSecGroupObj updateTSecGroup( ICFSecTSecGroupObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTSecGroup( ICFSecTSecGroupObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	TSecGroupId	The TSecGroup key attribute of the instance generating the id.
	 */
	void deleteTSecGroupByIdIdx( CFLibDbKeyHash256 TSecGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The TSecGroup key attribute of the instance generating the id.
	 */
	void deleteTSecGroupByTenantIdx( CFLibDbKeyHash256 TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@param	IsVisible	The TSecGroup key attribute of the instance generating the id.
	 */
	void deleteTSecGroupByTenantVisIdx( CFLibDbKeyHash256 TenantId,
		boolean IsVisible );

	/**
	 *	Internal use only.
	 *
	 *	@param	TenantId	The TSecGroup key attribute of the instance generating the id.
	 *
	 *	@param	Name	The TSecGroup key attribute of the instance generating the id.
	 */
	void deleteTSecGroupByUNameIdx(CFLibDbKeyHash256 TenantId,
		String Name );
}
