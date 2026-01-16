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

public interface ICFSecServiceTableObj
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
	 *	Instantiate a new Service instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecServiceObj newInstance();

	/**
	 *	Instantiate a new Service edition of the specified Service instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecServiceEditObj newEditInstance( ICFSecServiceObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecServiceObj realiseService( ICFSecServiceObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecServiceObj createService( ICFSecServiceObj Obj );

	/**
	 *	Read a Service-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Service-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecServiceObj readService( CFLibDbKeyHash256 pkey );

	/**
	 *	Read a Service-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Service-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecServiceObj readService( CFLibDbKeyHash256 pkey,
		boolean forceRead );

	ICFSecServiceObj readCachedService( CFLibDbKeyHash256 pkey );

	public void reallyDeepDisposeService( ICFSecServiceObj obj );

	void deepDisposeService( CFLibDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecServiceObj lockService( CFLibDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the Service-derived instances in the database.
	 *
	 *	@return	List of ICFSecServiceObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecServiceObj> readAllService();

	/**
	 *	Return a sorted map of all the Service-derived instances in the database.
	 *
	 *	@return	List of ICFSecServiceObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecServiceObj> readAllService( boolean forceRead );

	List<ICFSecServiceObj> readCachedAllService();

	/**
	 *	Return a sorted map of a page of the Service-derived instances in the database.
	 *
	 *	@return	List of ICFSecServiceObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecServiceObj> pageAllService(CFLibDbKeyHash256 priorServiceId );

	/**
	 *	Get the CFSecServiceObj instance for the primary key attributes.
	 *
	 *	@param	ServiceId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	CFSecServiceObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecServiceObj readServiceByIdIdx( CFLibDbKeyHash256 ServiceId );

	/**
	 *	Get the CFSecServiceObj instance for the primary key attributes.
	 *
	 *	@param	ServiceId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	CFSecServiceObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecServiceObj readServiceByIdIdx( CFLibDbKeyHash256 ServiceId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecServiceObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecServiceObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecServiceObj> readServiceByClusterIdx( long ClusterId );

	/**
	 *	Get the map of CFSecServiceObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecServiceObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecServiceObj> readServiceByClusterIdx( long ClusterId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecServiceObj instances sorted by their primary keys for the duplicate HostIdx key.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecServiceObj cached instances sorted by their primary keys for the duplicate HostIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecServiceObj> readServiceByHostIdx( CFLibDbKeyHash256 HostNodeId );

	/**
	 *	Get the map of CFSecServiceObj instances sorted by their primary keys for the duplicate HostIdx key.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecServiceObj cached instances sorted by their primary keys for the duplicate HostIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecServiceObj> readServiceByHostIdx( CFLibDbKeyHash256 HostNodeId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecServiceObj instances sorted by their primary keys for the duplicate TypeIdx key.
	 *
	 *	@param	ServiceTypeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecServiceObj cached instances sorted by their primary keys for the duplicate TypeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecServiceObj> readServiceByTypeIdx( CFLibDbKeyHash256 ServiceTypeId );

	/**
	 *	Get the map of CFSecServiceObj instances sorted by their primary keys for the duplicate TypeIdx key.
	 *
	 *	@param	ServiceTypeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecServiceObj cached instances sorted by their primary keys for the duplicate TypeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecServiceObj> readServiceByTypeIdx( CFLibDbKeyHash256 ServiceTypeId,
		boolean forceRead );

	/**
	 *	Get the CFSecServiceObj instance for the unique UTypeIdx key.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	ServiceTypeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	CFSecServiceObj cached instance for the unique UTypeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecServiceObj readServiceByUTypeIdx(long ClusterId,
		CFLibDbKeyHash256 HostNodeId,
		CFLibDbKeyHash256 ServiceTypeId );

	/**
	 *	Get the CFSecServiceObj instance for the unique UTypeIdx key.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	ServiceTypeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	CFSecServiceObj refreshed instance for the unique UTypeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecServiceObj readServiceByUTypeIdx(long ClusterId,
		CFLibDbKeyHash256 HostNodeId,
		CFLibDbKeyHash256 ServiceTypeId,
		boolean forceRead );

	/**
	 *	Get the CFSecServiceObj instance for the unique UHostPortIdx key.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	HostPort	The Service key attribute of the instance generating the id.
	 *
	 *	@return	CFSecServiceObj cached instance for the unique UHostPortIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecServiceObj readServiceByUHostPortIdx(long ClusterId,
		CFLibDbKeyHash256 HostNodeId,
		short HostPort );

	/**
	 *	Get the CFSecServiceObj instance for the unique UHostPortIdx key.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	HostPort	The Service key attribute of the instance generating the id.
	 *
	 *	@return	CFSecServiceObj refreshed instance for the unique UHostPortIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecServiceObj readServiceByUHostPortIdx(long ClusterId,
		CFLibDbKeyHash256 HostNodeId,
		short HostPort,
		boolean forceRead );

	ICFSecServiceObj readCachedServiceByIdIdx( CFLibDbKeyHash256 ServiceId );

	List<ICFSecServiceObj> readCachedServiceByClusterIdx( long ClusterId );

	List<ICFSecServiceObj> readCachedServiceByHostIdx( CFLibDbKeyHash256 HostNodeId );

	List<ICFSecServiceObj> readCachedServiceByTypeIdx( CFLibDbKeyHash256 ServiceTypeId );

	ICFSecServiceObj readCachedServiceByUTypeIdx( long ClusterId,
		CFLibDbKeyHash256 HostNodeId,
		CFLibDbKeyHash256 ServiceTypeId );

	ICFSecServiceObj readCachedServiceByUHostPortIdx( long ClusterId,
		CFLibDbKeyHash256 HostNodeId,
		short HostPort );

	void deepDisposeServiceByIdIdx( CFLibDbKeyHash256 ServiceId );

	void deepDisposeServiceByClusterIdx( long ClusterId );

	void deepDisposeServiceByHostIdx( CFLibDbKeyHash256 HostNodeId );

	void deepDisposeServiceByTypeIdx( CFLibDbKeyHash256 ServiceTypeId );

	void deepDisposeServiceByUTypeIdx( long ClusterId,
		CFLibDbKeyHash256 HostNodeId,
		CFLibDbKeyHash256 ServiceTypeId );

	void deepDisposeServiceByUHostPortIdx( long ClusterId,
		CFLibDbKeyHash256 HostNodeId,
		short HostPort );

	/**
	 *	Read a page of data as a List of Service-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusterIdx key attributes.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	A List of Service-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecServiceObj> pageServiceByClusterIdx( long ClusterId,
		CFLibDbKeyHash256 priorServiceId );

	/**
	 *	Read a page of data as a List of Service-derived instances sorted by their primary keys,
	 *	as identified by the duplicate HostIdx key attributes.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	A List of Service-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecServiceObj> pageServiceByHostIdx( CFLibDbKeyHash256 HostNodeId,
		CFLibDbKeyHash256 priorServiceId );

	/**
	 *	Read a page of data as a List of Service-derived instances sorted by their primary keys,
	 *	as identified by the duplicate TypeIdx key attributes.
	 *
	 *	@param	ServiceTypeId	The Service key attribute of the instance generating the id.
	 *
	 *	@return	A List of Service-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecServiceObj> pageServiceByTypeIdx( CFLibDbKeyHash256 ServiceTypeId,
		CFLibDbKeyHash256 priorServiceId );

	/**
	 *	Internal use only.
	 */
	ICFSecServiceObj updateService( ICFSecServiceObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteService( ICFSecServiceObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	ServiceId	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByIdIdx( CFLibDbKeyHash256 ServiceId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByClusterIdx( long ClusterId );

	/**
	 *	Internal use only.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByHostIdx( CFLibDbKeyHash256 HostNodeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ServiceTypeId	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByTypeIdx( CFLibDbKeyHash256 ServiceTypeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	ServiceTypeId	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByUTypeIdx(long ClusterId,
		CFLibDbKeyHash256 HostNodeId,
		CFLibDbKeyHash256 ServiceTypeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ClusterId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	HostNodeId	The Service key attribute of the instance generating the id.
	 *
	 *	@param	HostPort	The Service key attribute of the instance generating the id.
	 */
	void deleteServiceByUHostPortIdx(long ClusterId,
		CFLibDbKeyHash256 HostNodeId,
		short HostPort );
}
