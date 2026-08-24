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
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfsec.cfsecprot.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfsec.cfsecprotobj.*;

public interface ICFSecSecSessionTableObj
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
	 *	Instantiate a new SecSession instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecSecSessionObj newInstance();

	/**
	 *	Instantiate a new SecSession edition of the specified SecSession instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecSecSessionEditObj newEditInstance( ICFSecSecSessionObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecSecSessionObj realiseSecSession( ICFSecSecSessionObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecSecSessionObj createSecSession( ICFSecSecSessionObj Obj );

	/**
	 *	Read a SecSession-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecSession-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecSessionObj readSecSession( $iterate Columns ( lone implIJavaOptAtomType first implIJavaOptAtomType each implCommaIJavaOptAtomType empty empty )$ pkey );

	/**
	 *	Read a SecSession-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecSession-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecSessionObj readSecSession( $iterate Columns ( lone implIJavaOptAtomType first implIJavaOptAtomType each implCommaIJavaOptAtomType empty empty )$ pkey,
		boolean forceRead );

	ICFSecSecSessionObj readCachedSecSession( $iterate Columns ( lone implIJavaOptAtomType first implIJavaOptAtomType each implCommaIJavaOptAtomType empty empty )$ pkey );

	public void reallyDeepDisposeSecSession( ICFSecSecSessionObj obj );

	void deepDisposeSecSession( $iterate Columns ( lone implIJavaOptAtomType first implIJavaOptAtomType each implCommaIJavaOptAtomType empty empty )$ pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecSecSessionObj lockSecSession( $iterate Columns ( lone implIJavaOptAtomType first implIJavaOptAtomType each implCommaIJavaOptAtomType empty empty )$ pkey );

	/**
	 *	Return a sorted list of all the SecSession-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecSessionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecSessionObj> readAllSecSession();

	/**
	 *	Return a sorted map of all the SecSession-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecSessionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecSessionObj> readAllSecSession( boolean forceRead );

	List<ICFSecSecSessionObj> readCachedAllSecSession();

	/**
	 *	Return a sorted map of a page of the SecSession-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecSessionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecSessionObj> pageAllSecSession($implIJavaOptAtomType$ priorSecSessionId );

	/**
	 *	Get the CFSecSecSessionObj instance for the primary key attributes.
	 *
	 *	@param	SecSessionId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecSessionObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecSessionObj readSecSessionByIdIdx( $implIJavaAtomType$ SecSessionId );

	/**
	 *	Get the CFSecSecSessionObj instance for the primary key attributes.
	 *
	 *	@param	SecSessionId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecSessionObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecSessionObj readSecSessionByIdIdx( $implIJavaAtomType$ SecSessionId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecSessionObj instances sorted by their primary keys for the duplicate SecUserIdx key.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecSessionObj cached instances sorted by their primary keys for the duplicate SecUserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecSessionObj> readSecSessionBySecUserIdx( $implIJavaAtomType$ SecUserId );

	/**
	 *	Get the map of CFSecSecSessionObj instances sorted by their primary keys for the duplicate SecUserIdx key.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecSessionObj cached instances sorted by their primary keys for the duplicate SecUserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecSessionObj> readSecSessionBySecUserIdx( $implIJavaAtomType$ SecUserId,
		boolean forceRead );

	/**
	 *	Get the CFSecSecSessionObj instance for the unique StartIdx key.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	Start	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecSessionObj cached instance for the unique StartIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecSessionObj readSecSessionByStartIdx($implIJavaAtomType$ SecUserId,
		$implIJavaAtomType$ Start );

	/**
	 *	Get the CFSecSecSessionObj instance for the unique StartIdx key.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	Start	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecSessionObj refreshed instance for the unique StartIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecSessionObj readSecSessionByStartIdx($implIJavaAtomType$ SecUserId,
		$implIJavaAtomType$ Start,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecSessionObj instances sorted by their primary keys for the duplicate FinishIdx key.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	Finish	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecSessionObj cached instances sorted by their primary keys for the duplicate FinishIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecSessionObj> readSecSessionByFinishIdx( $implIJavaAtomType$ SecUserId,
		$implIJavaAtomType$ Finish );

	/**
	 *	Get the map of CFSecSecSessionObj instances sorted by their primary keys for the duplicate FinishIdx key.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	Finish	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecSessionObj cached instances sorted by their primary keys for the duplicate FinishIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecSessionObj> readSecSessionByFinishIdx( $implIJavaAtomType$ SecUserId,
		$implIJavaAtomType$ Finish,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecSessionObj instances sorted by their primary keys for the duplicate SecProxyIdx key.
	 *
	 *	@param	SecProxyId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecSessionObj cached instances sorted by their primary keys for the duplicate SecProxyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecSessionObj> readSecSessionBySecProxyIdx( $implIJavaAtomType$ SecProxyId );

	/**
	 *	Get the map of CFSecSecSessionObj instances sorted by their primary keys for the duplicate SecProxyIdx key.
	 *
	 *	@param	SecProxyId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecSessionObj cached instances sorted by their primary keys for the duplicate SecProxyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecSessionObj> readSecSessionBySecProxyIdx( $implIJavaAtomType$ SecProxyId,
		boolean forceRead );

	ICFSecSecSessionObj readCachedSecSessionByIdIdx( $implIJavaAtomType$ SecSessionId );

	List<ICFSecSecSessionObj> readCachedSecSessionBySecUserIdx( $implIJavaAtomType$ SecUserId );

	ICFSecSecSessionObj readCachedSecSessionByStartIdx( $implIJavaAtomType$ SecUserId,
		$implIJavaAtomType$ Start );

	List<ICFSecSecSessionObj> readCachedSecSessionByFinishIdx( $implIJavaAtomType$ SecUserId,
		$implIJavaAtomType$ Finish );

	List<ICFSecSecSessionObj> readCachedSecSessionBySecProxyIdx( $implIJavaAtomType$ SecProxyId );

	void deepDisposeSecSessionByIdIdx( $implIJavaAtomType$ SecSessionId );

	void deepDisposeSecSessionBySecUserIdx( $implIJavaAtomType$ SecUserId );

	void deepDisposeSecSessionByStartIdx( $implIJavaAtomType$ SecUserId,
		$implIJavaAtomType$ Start );

	void deepDisposeSecSessionByFinishIdx( $implIJavaAtomType$ SecUserId,
		$implIJavaAtomType$ Finish );

	void deepDisposeSecSessionBySecProxyIdx( $implIJavaAtomType$ SecProxyId );

	/**
	 *	Read a page of data as a List of SecSession-derived instances sorted by their primary keys,
	 *	as identified by the duplicate SecUserIdx key attributes.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSession-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecSessionObj> pageSecSessionBySecUserIdx( $implIJavaAtomType$ SecUserId,
		$implIJavaOptAtomType$ priorSecSessionId );

	/**
	 *	Read a page of data as a List of SecSession-derived instances sorted by their primary keys,
	 *	as identified by the duplicate FinishIdx key attributes.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	Finish	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSession-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecSessionObj> pageSecSessionByFinishIdx( $implIJavaAtomType$ SecUserId,
		$implIJavaAtomType$ Finish,
		$implIJavaOptAtomType$ priorSecSessionId );

	/**
	 *	Read a page of data as a List of SecSession-derived instances sorted by their primary keys,
	 *	as identified by the duplicate SecProxyIdx key attributes.
	 *
	 *	@param	SecProxyId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSession-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecSessionObj> pageSecSessionBySecProxyIdx( $implIJavaAtomType$ SecProxyId,
		$implIJavaOptAtomType$ priorSecSessionId );

	/**
	 *	Internal use only.
	 */
	ICFSecSecSessionObj updateSecSession( ICFSecSecSessionObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecSession( ICFSecSecSessionObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecSessionId	The SecSession key attribute of the instance generating the id.
	 */
	void deleteSecSessionByIdIdx( $implIJavaAtomType$ SecSessionId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 */
	void deleteSecSessionBySecUserIdx( $implIJavaAtomType$ SecUserId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	Start	The SecSession key attribute of the instance generating the id.
	 */
	void deleteSecSessionByStartIdx($implIJavaAtomType$ SecUserId,
		$implIJavaAtomType$ Start );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	Finish	The SecSession key attribute of the instance generating the id.
	 */
	void deleteSecSessionByFinishIdx( $implIJavaAtomType$ SecUserId,
		$implIJavaAtomType$ Finish );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecProxyId	The SecSession key attribute of the instance generating the id.
	 */
	void deleteSecSessionBySecProxyIdx( $implIJavaAtomType$ SecProxyId );
}
