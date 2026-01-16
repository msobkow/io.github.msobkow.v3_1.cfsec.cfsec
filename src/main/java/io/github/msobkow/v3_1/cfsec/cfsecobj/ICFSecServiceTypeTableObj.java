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

public interface ICFSecServiceTypeTableObj
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
	 *	Instantiate a new ServiceType instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecServiceTypeObj newInstance();

	/**
	 *	Instantiate a new ServiceType edition of the specified ServiceType instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecServiceTypeEditObj newEditInstance( ICFSecServiceTypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecServiceTypeObj realiseServiceType( ICFSecServiceTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecServiceTypeObj createServiceType( ICFSecServiceTypeObj Obj );

	/**
	 *	Read a ServiceType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ServiceType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecServiceTypeObj readServiceType( CFLibDbKeyHash256 pkey );

	/**
	 *	Read a ServiceType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ServiceType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecServiceTypeObj readServiceType( CFLibDbKeyHash256 pkey,
		boolean forceRead );

	ICFSecServiceTypeObj readCachedServiceType( CFLibDbKeyHash256 pkey );

	public void reallyDeepDisposeServiceType( ICFSecServiceTypeObj obj );

	void deepDisposeServiceType( CFLibDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecServiceTypeObj lockServiceType( CFLibDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the ServiceType-derived instances in the database.
	 *
	 *	@return	List of ICFSecServiceTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecServiceTypeObj> readAllServiceType();

	/**
	 *	Return a sorted map of all the ServiceType-derived instances in the database.
	 *
	 *	@return	List of ICFSecServiceTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecServiceTypeObj> readAllServiceType( boolean forceRead );

	List<ICFSecServiceTypeObj> readCachedAllServiceType();

	/**
	 *	Get the CFSecServiceTypeObj instance for the primary key attributes.
	 *
	 *	@param	ServiceTypeId	The ServiceType key attribute of the instance generating the id.
	 *
	 *	@return	CFSecServiceTypeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecServiceTypeObj readServiceTypeByIdIdx( CFLibDbKeyHash256 ServiceTypeId );

	/**
	 *	Get the CFSecServiceTypeObj instance for the primary key attributes.
	 *
	 *	@param	ServiceTypeId	The ServiceType key attribute of the instance generating the id.
	 *
	 *	@return	CFSecServiceTypeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecServiceTypeObj readServiceTypeByIdIdx( CFLibDbKeyHash256 ServiceTypeId,
		boolean forceRead );

	/**
	 *	Get the CFSecServiceTypeObj instance for the unique UDescrIdx key.
	 *
	 *	@param	Description	The ServiceType key attribute of the instance generating the id.
	 *
	 *	@return	CFSecServiceTypeObj cached instance for the unique UDescrIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecServiceTypeObj readServiceTypeByUDescrIdx(String Description );

	/**
	 *	Get the CFSecServiceTypeObj instance for the unique UDescrIdx key.
	 *
	 *	@param	Description	The ServiceType key attribute of the instance generating the id.
	 *
	 *	@return	CFSecServiceTypeObj refreshed instance for the unique UDescrIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecServiceTypeObj readServiceTypeByUDescrIdx(String Description,
		boolean forceRead );

	ICFSecServiceTypeObj readCachedServiceTypeByIdIdx( CFLibDbKeyHash256 ServiceTypeId );

	ICFSecServiceTypeObj readCachedServiceTypeByUDescrIdx( String Description );

	void deepDisposeServiceTypeByIdIdx( CFLibDbKeyHash256 ServiceTypeId );

	void deepDisposeServiceTypeByUDescrIdx( String Description );

	/**
	 *	Internal use only.
	 */
	ICFSecServiceTypeObj updateServiceType( ICFSecServiceTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteServiceType( ICFSecServiceTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	ServiceTypeId	The ServiceType key attribute of the instance generating the id.
	 */
	void deleteServiceTypeByIdIdx( CFLibDbKeyHash256 ServiceTypeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	Description	The ServiceType key attribute of the instance generating the id.
	 */
	void deleteServiceTypeByUDescrIdx(String Description );
}
