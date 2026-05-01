// Description: Java 25 Table Object interface for CFSec.

/*
 *	server.markhome.mcf.CFSec
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFSec - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Mark's Code Fractal CFSec.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.mcf.v3_1.cfsec.cfsecobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;

public interface ICFSecSecRoleEnablesTableObj
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
	 *	Instantiate a new SecRoleEnables instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecSecRoleEnablesObj newInstance();

	/**
	 *	Instantiate a new SecRoleEnables edition of the specified SecRoleEnables instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecSecRoleEnablesEditObj newEditInstance( ICFSecSecRoleEnablesObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecSecRoleEnablesObj realiseSecRoleEnables( ICFSecSecRoleEnablesObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecSecRoleEnablesObj createSecRoleEnables( ICFSecSecRoleEnablesObj Obj );

	/**
	 *	Read a SecRoleEnables-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecRoleEnables-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecRoleEnablesObj readSecRoleEnables( ICFSecSecRoleEnablesPKey pkey );

	/**
	 *	Read a SecRoleEnables-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecRoleEnables-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecRoleEnablesObj readSecRoleEnables( ICFSecSecRoleEnablesPKey pkey,
		boolean forceRead );

	/**
	 *	Read a SecRoleEnables-derived instance by it's primary key.
	 *
	 *	@return	The SecRoleEnables-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecRoleEnablesObj readSecRoleEnables( CFLibDbKeyHash256 SecRoleId,
		String EnableName );

	/**
	 *	Read a SecRoleEnables-derived instance by it's primary key.
	 *
	 *	@return	The SecRoleEnables-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecRoleEnablesObj readSecRoleEnables( CFLibDbKeyHash256 SecRoleId,
		String EnableName,
		boolean forceRead );

	ICFSecSecRoleEnablesObj readCachedSecRoleEnables( ICFSecSecRoleEnablesPKey pkey );

	public void reallyDeepDisposeSecRoleEnables( ICFSecSecRoleEnablesObj obj );

	void deepDisposeSecRoleEnables( ICFSecSecRoleEnablesPKey pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecSecRoleEnablesObj lockSecRoleEnables( ICFSecSecRoleEnablesPKey pkey );

	/**
	 *	Return a sorted list of all the SecRoleEnables-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecRoleEnablesObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecRoleEnablesObj> readAllSecRoleEnables();

	/**
	 *	Return a sorted map of all the SecRoleEnables-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecRoleEnablesObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecRoleEnablesObj> readAllSecRoleEnables( boolean forceRead );

	List<ICFSecSecRoleEnablesObj> readCachedAllSecRoleEnables();

	/**
	 *	Return a sorted map of a page of the SecRoleEnables-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecRoleEnablesObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecRoleEnablesObj> pageAllSecRoleEnables(CFLibDbKeyHash256 priorSecRoleId,
		String priorEnableName );

	/**
	 *	Get the CFSecSecRoleEnablesObj instance for the primary key attributes.
	 *
	 *	@param	SecRoleId	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@param	EnableName	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecRoleEnablesObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecRoleEnablesObj readSecRoleEnablesByIdIdx( CFLibDbKeyHash256 SecRoleId,
		String EnableName );

	/**
	 *	Get the CFSecSecRoleEnablesObj instance for the primary key attributes.
	 *
	 *	@param	SecRoleId	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@param	EnableName	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecRoleEnablesObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecRoleEnablesObj readSecRoleEnablesByIdIdx( CFLibDbKeyHash256 SecRoleId,
		String EnableName,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecRoleEnablesObj instances sorted by their primary keys for the duplicate RoleIdx key.
	 *
	 *	@param	SecRoleId	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecRoleEnablesObj cached instances sorted by their primary keys for the duplicate RoleIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecRoleEnablesObj> readSecRoleEnablesByRoleIdx( CFLibDbKeyHash256 SecRoleId );

	/**
	 *	Get the map of CFSecSecRoleEnablesObj instances sorted by their primary keys for the duplicate RoleIdx key.
	 *
	 *	@param	SecRoleId	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecRoleEnablesObj cached instances sorted by their primary keys for the duplicate RoleIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecRoleEnablesObj> readSecRoleEnablesByRoleIdx( CFLibDbKeyHash256 SecRoleId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecRoleEnablesObj instances sorted by their primary keys for the duplicate NameIdx key.
	 *
	 *	@param	EnableName	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecRoleEnablesObj cached instances sorted by their primary keys for the duplicate NameIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecRoleEnablesObj> readSecRoleEnablesByNameIdx( String EnableName );

	/**
	 *	Get the map of CFSecSecRoleEnablesObj instances sorted by their primary keys for the duplicate NameIdx key.
	 *
	 *	@param	EnableName	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecRoleEnablesObj cached instances sorted by their primary keys for the duplicate NameIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecRoleEnablesObj> readSecRoleEnablesByNameIdx( String EnableName,
		boolean forceRead );

	ICFSecSecRoleEnablesObj readCachedSecRoleEnablesByIdIdx( CFLibDbKeyHash256 SecRoleId,
		String EnableName );

	List<ICFSecSecRoleEnablesObj> readCachedSecRoleEnablesByRoleIdx( CFLibDbKeyHash256 SecRoleId );

	List<ICFSecSecRoleEnablesObj> readCachedSecRoleEnablesByNameIdx( String EnableName );

	void deepDisposeSecRoleEnablesByIdIdx( CFLibDbKeyHash256 SecRoleId,
		String EnableName );

	void deepDisposeSecRoleEnablesByRoleIdx( CFLibDbKeyHash256 SecRoleId );

	void deepDisposeSecRoleEnablesByNameIdx( String EnableName );

	/**
	 *	Read a page of data as a List of SecRoleEnables-derived instances sorted by their primary keys,
	 *	as identified by the duplicate RoleIdx key attributes.
	 *
	 *	@param	SecRoleId	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecRoleEnables-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecRoleEnablesObj> pageSecRoleEnablesByRoleIdx( CFLibDbKeyHash256 SecRoleId,
		CFLibDbKeyHash256 priorSecRoleId,
		String priorEnableName );

	/**
	 *	Read a page of data as a List of SecRoleEnables-derived instances sorted by their primary keys,
	 *	as identified by the duplicate NameIdx key attributes.
	 *
	 *	@param	EnableName	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecRoleEnables-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecRoleEnablesObj> pageSecRoleEnablesByNameIdx( String EnableName,
		CFLibDbKeyHash256 priorSecRoleId,
		String priorEnableName );

	/**
	 *	Internal use only.
	 */
	ICFSecSecRoleEnablesObj updateSecRoleEnables( ICFSecSecRoleEnablesObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecRoleEnables( ICFSecSecRoleEnablesObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecRoleId	The SecRoleEnables key attribute of the instance generating the id.
	 *
	 *	@param	EnableName	The SecRoleEnables key attribute of the instance generating the id.
	 */
	void deleteSecRoleEnablesByIdIdx( CFLibDbKeyHash256 SecRoleId,
		String EnableName );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecRoleId	The SecRoleEnables key attribute of the instance generating the id.
	 */
	void deleteSecRoleEnablesByRoleIdx( CFLibDbKeyHash256 SecRoleId );

	/**
	 *	Internal use only.
	 *
	 *	@param	EnableName	The SecRoleEnables key attribute of the instance generating the id.
	 */
	void deleteSecRoleEnablesByNameIdx( String EnableName );
}
