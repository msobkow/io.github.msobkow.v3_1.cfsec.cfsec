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

public interface ICFSecSecRoleTableObj
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
	 *	Instantiate a new SecRole instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecSecRoleObj newInstance();

	/**
	 *	Instantiate a new SecRole edition of the specified SecRole instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecSecRoleEditObj newEditInstance( ICFSecSecRoleObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecSecRoleObj realiseSecRole( ICFSecSecRoleObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecSecRoleObj createSecRole( ICFSecSecRoleObj Obj );

	/**
	 *	Read a SecRole-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecRole-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecRoleObj readSecRole( CFLibDbKeyHash256 pkey );

	/**
	 *	Read a SecRole-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecRole-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecRoleObj readSecRole( CFLibDbKeyHash256 pkey,
		boolean forceRead );

	ICFSecSecRoleObj readCachedSecRole( CFLibDbKeyHash256 pkey );

	public void reallyDeepDisposeSecRole( ICFSecSecRoleObj obj );

	void deepDisposeSecRole( CFLibDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecSecRoleObj lockSecRole( CFLibDbKeyHash256 pkey );

	/**
	 *	Return a sorted list of all the SecRole-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecRoleObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecRoleObj> readAllSecRole();

	/**
	 *	Return a sorted map of all the SecRole-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecRoleObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecRoleObj> readAllSecRole( boolean forceRead );

	List<ICFSecSecRoleObj> readCachedAllSecRole();

	/**
	 *	Get the CFSecSecRoleObj instance for the primary key attributes.
	 *
	 *	@param	SecRoleId	The SecRole key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecRoleObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecRoleObj readSecRoleByIdIdx( CFLibDbKeyHash256 SecRoleId );

	/**
	 *	Get the CFSecSecRoleObj instance for the primary key attributes.
	 *
	 *	@param	SecRoleId	The SecRole key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecRoleObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecRoleObj readSecRoleByIdIdx( CFLibDbKeyHash256 SecRoleId,
		boolean forceRead );

	/**
	 *	Get the CFSecSecRoleObj instance for the unique UNameIdx key.
	 *
	 *	@param	Name	The SecRole key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecRoleObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecRoleObj readSecRoleByUNameIdx(String Name );

	/**
	 *	Get the CFSecSecRoleObj instance for the unique UNameIdx key.
	 *
	 *	@param	Name	The SecRole key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecRoleObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecRoleObj readSecRoleByUNameIdx(String Name,
		boolean forceRead );

	ICFSecSecRoleObj readCachedSecRoleByIdIdx( CFLibDbKeyHash256 SecRoleId );

	ICFSecSecRoleObj readCachedSecRoleByUNameIdx( String Name );

	void deepDisposeSecRoleByIdIdx( CFLibDbKeyHash256 SecRoleId );

	void deepDisposeSecRoleByUNameIdx( String Name );

	/**
	 *	Internal use only.
	 */
	ICFSecSecRoleObj updateSecRole( ICFSecSecRoleObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecRole( ICFSecSecRoleObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecRoleId	The SecRole key attribute of the instance generating the id.
	 */
	void deleteSecRoleByIdIdx( CFLibDbKeyHash256 SecRoleId );

	/**
	 *	Internal use only.
	 *
	 *	@param	Name	The SecRole key attribute of the instance generating the id.
	 */
	void deleteSecRoleByUNameIdx(String Name );
}
