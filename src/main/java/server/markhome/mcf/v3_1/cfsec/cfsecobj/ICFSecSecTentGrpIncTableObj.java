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

public interface ICFSecSecTentGrpIncTableObj
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
	 *	Instantiate a new SecTentGrpInc instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecSecTentGrpIncObj newInstance();

	/**
	 *	Instantiate a new SecTentGrpInc edition of the specified SecTentGrpInc instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecSecTentGrpIncEditObj newEditInstance( ICFSecSecTentGrpIncObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecSecTentGrpIncObj realiseSecTentGrpInc( ICFSecSecTentGrpIncObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecSecTentGrpIncObj createSecTentGrpInc( ICFSecSecTentGrpIncObj Obj );

	/**
	 *	Read a SecTentGrpInc-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecTentGrpInc-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecTentGrpIncObj readSecTentGrpInc( ICFSecSecTentGrpIncPKey pkey );

	/**
	 *	Read a SecTentGrpInc-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecTentGrpInc-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecTentGrpIncObj readSecTentGrpInc( ICFSecSecTentGrpIncPKey pkey,
		boolean forceRead );

	/**
	 *	Read a SecTentGrpInc-derived instance by it's primary key.
	 *
	 *	@return	The SecTentGrpInc-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecTentGrpIncObj readSecTentGrpInc( CFLibDbKeyHash256 SecTentGrpId,
		String InclName );

	/**
	 *	Read a SecTentGrpInc-derived instance by it's primary key.
	 *
	 *	@return	The SecTentGrpInc-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecTentGrpIncObj readSecTentGrpInc( CFLibDbKeyHash256 SecTentGrpId,
		String InclName,
		boolean forceRead );

	ICFSecSecTentGrpIncObj readCachedSecTentGrpInc( ICFSecSecTentGrpIncPKey pkey );

	public void reallyDeepDisposeSecTentGrpInc( ICFSecSecTentGrpIncObj obj );

	void deepDisposeSecTentGrpInc( ICFSecSecTentGrpIncPKey pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecSecTentGrpIncObj lockSecTentGrpInc( ICFSecSecTentGrpIncPKey pkey );

	/**
	 *	Return a sorted list of all the SecTentGrpInc-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecTentGrpIncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecTentGrpIncObj> readAllSecTentGrpInc();

	/**
	 *	Return a sorted map of all the SecTentGrpInc-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecTentGrpIncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecTentGrpIncObj> readAllSecTentGrpInc( boolean forceRead );

	List<ICFSecSecTentGrpIncObj> readCachedAllSecTentGrpInc();

	/**
	 *	Return a sorted map of a page of the SecTentGrpInc-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecTentGrpIncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecTentGrpIncObj> pageAllSecTentGrpInc(CFLibDbKeyHash256 priorSecTentGrpId,
		String priorInclName );

	/**
	 *	Get the CFSecSecTentGrpIncObj instance for the primary key attributes.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	InclName	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecTentGrpIncObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecTentGrpIncObj readSecTentGrpIncByIdIdx( CFLibDbKeyHash256 SecTentGrpId,
		String InclName );

	/**
	 *	Get the CFSecSecTentGrpIncObj instance for the primary key attributes.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	InclName	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecTentGrpIncObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecTentGrpIncObj readSecTentGrpIncByIdIdx( CFLibDbKeyHash256 SecTentGrpId,
		String InclName,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecTentGrpIncObj instances sorted by their primary keys for the duplicate TentGrpIdx key.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecTentGrpIncObj cached instances sorted by their primary keys for the duplicate TentGrpIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecTentGrpIncObj> readSecTentGrpIncByTentGrpIdx( CFLibDbKeyHash256 SecTentGrpId );

	/**
	 *	Get the map of CFSecSecTentGrpIncObj instances sorted by their primary keys for the duplicate TentGrpIdx key.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecTentGrpIncObj cached instances sorted by their primary keys for the duplicate TentGrpIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecTentGrpIncObj> readSecTentGrpIncByTentGrpIdx( CFLibDbKeyHash256 SecTentGrpId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecTentGrpIncObj instances sorted by their primary keys for the duplicate NameIdx key.
	 *
	 *	@param	InclName	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecTentGrpIncObj cached instances sorted by their primary keys for the duplicate NameIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecTentGrpIncObj> readSecTentGrpIncByNameIdx( String InclName );

	/**
	 *	Get the map of CFSecSecTentGrpIncObj instances sorted by their primary keys for the duplicate NameIdx key.
	 *
	 *	@param	InclName	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecTentGrpIncObj cached instances sorted by their primary keys for the duplicate NameIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecTentGrpIncObj> readSecTentGrpIncByNameIdx( String InclName,
		boolean forceRead );

	ICFSecSecTentGrpIncObj readCachedSecTentGrpIncByIdIdx( CFLibDbKeyHash256 SecTentGrpId,
		String InclName );

	List<ICFSecSecTentGrpIncObj> readCachedSecTentGrpIncByTentGrpIdx( CFLibDbKeyHash256 SecTentGrpId );

	List<ICFSecSecTentGrpIncObj> readCachedSecTentGrpIncByNameIdx( String InclName );

	void deepDisposeSecTentGrpIncByIdIdx( CFLibDbKeyHash256 SecTentGrpId,
		String InclName );

	void deepDisposeSecTentGrpIncByTentGrpIdx( CFLibDbKeyHash256 SecTentGrpId );

	void deepDisposeSecTentGrpIncByNameIdx( String InclName );

	/**
	 *	Read a page of data as a List of SecTentGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate TentGrpIdx key attributes.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecTentGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecTentGrpIncObj> pageSecTentGrpIncByTentGrpIdx( CFLibDbKeyHash256 SecTentGrpId,
		CFLibDbKeyHash256 priorSecTentGrpId,
		String priorInclName );

	/**
	 *	Read a page of data as a List of SecTentGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate NameIdx key attributes.
	 *
	 *	@param	InclName	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecTentGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecTentGrpIncObj> pageSecTentGrpIncByNameIdx( String InclName,
		CFLibDbKeyHash256 priorSecTentGrpId,
		String priorInclName );

	/**
	 *	Internal use only.
	 */
	ICFSecSecTentGrpIncObj updateSecTentGrpInc( ICFSecSecTentGrpIncObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecTentGrpInc( ICFSecSecTentGrpIncObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	InclName	The SecTentGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecTentGrpIncByIdIdx( CFLibDbKeyHash256 SecTentGrpId,
		String InclName );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecTentGrpId	The SecTentGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecTentGrpIncByTentGrpIdx( CFLibDbKeyHash256 SecTentGrpId );

	/**
	 *	Internal use only.
	 *
	 *	@param	InclName	The SecTentGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecTentGrpIncByNameIdx( String InclName );
}
