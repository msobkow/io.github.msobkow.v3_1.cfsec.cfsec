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
	ICFSecSecSessionObj readSecSession( CFLibDbKeyHash256 pkey );

	/**
	 *	Read a SecSession-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecSession-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecSessionObj readSecSession( CFLibDbKeyHash256 pkey,
		boolean forceRead );

	ICFSecSecSessionObj readCachedSecSession( CFLibDbKeyHash256 pkey );

	public void reallyDeepDisposeSecSession( ICFSecSecSessionObj obj );

	void deepDisposeSecSession( CFLibDbKeyHash256 pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecSecSessionObj lockSecSession( CFLibDbKeyHash256 pkey );

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
	List<ICFSecSecSessionObj> pageAllSecSession(CFLibDbKeyHash256 priorSecSessionId );

	/**
	 *	Get the CFSecSecSessionObj instance for the primary key attributes.
	 *
	 *	@param	SecSessionId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecSessionObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecSessionObj readSecSessionByIdIdx( CFLibDbKeyHash256 SecSessionId );

	/**
	 *	Get the CFSecSecSessionObj instance for the primary key attributes.
	 *
	 *	@param	SecSessionId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecSessionObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecSessionObj readSecSessionByIdIdx( CFLibDbKeyHash256 SecSessionId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecSessionObj instances sorted by their primary keys for the duplicate SecUserIdx key.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecSessionObj cached instances sorted by their primary keys for the duplicate SecUserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecSessionObj> readSecSessionBySecUserIdx( CFLibDbKeyHash256 SecUserId );

	/**
	 *	Get the map of CFSecSecSessionObj instances sorted by their primary keys for the duplicate SecUserIdx key.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecSessionObj cached instances sorted by their primary keys for the duplicate SecUserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecSessionObj> readSecSessionBySecUserIdx( CFLibDbKeyHash256 SecUserId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecSessionObj instances sorted by their primary keys for the duplicate SecDevIdx key.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	SecDevName	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecSessionObj cached instances sorted by their primary keys for the duplicate SecDevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecSessionObj> readSecSessionBySecDevIdx( CFLibDbKeyHash256 SecUserId,
		String SecDevName );

	/**
	 *	Get the map of CFSecSecSessionObj instances sorted by their primary keys for the duplicate SecDevIdx key.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	SecDevName	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecSessionObj cached instances sorted by their primary keys for the duplicate SecDevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecSessionObj> readSecSessionBySecDevIdx( CFLibDbKeyHash256 SecUserId,
		String SecDevName,
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
	ICFSecSecSessionObj readSecSessionByStartIdx(CFLibDbKeyHash256 SecUserId,
		LocalDateTime Start );

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
	ICFSecSecSessionObj readSecSessionByStartIdx(CFLibDbKeyHash256 SecUserId,
		LocalDateTime Start,
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
	List<ICFSecSecSessionObj> readSecSessionByFinishIdx( CFLibDbKeyHash256 SecUserId,
		LocalDateTime Finish );

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
	List<ICFSecSecSessionObj> readSecSessionByFinishIdx( CFLibDbKeyHash256 SecUserId,
		LocalDateTime Finish,
		boolean forceRead );

	/**
	 *	Get the map of CFSecSecSessionObj instances sorted by their primary keys for the duplicate SecProxyIdx key.
	 *
	 *	@param	SecProxyId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecSessionObj cached instances sorted by their primary keys for the duplicate SecProxyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecSessionObj> readSecSessionBySecProxyIdx( CFLibDbKeyHash256 SecProxyId );

	/**
	 *	Get the map of CFSecSecSessionObj instances sorted by their primary keys for the duplicate SecProxyIdx key.
	 *
	 *	@param	SecProxyId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecSecSessionObj cached instances sorted by their primary keys for the duplicate SecProxyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecSecSessionObj> readSecSessionBySecProxyIdx( CFLibDbKeyHash256 SecProxyId,
		boolean forceRead );

	ICFSecSecSessionObj readCachedSecSessionByIdIdx( CFLibDbKeyHash256 SecSessionId );

	List<ICFSecSecSessionObj> readCachedSecSessionBySecUserIdx( CFLibDbKeyHash256 SecUserId );

	List<ICFSecSecSessionObj> readCachedSecSessionBySecDevIdx( CFLibDbKeyHash256 SecUserId,
		String SecDevName );

	ICFSecSecSessionObj readCachedSecSessionByStartIdx( CFLibDbKeyHash256 SecUserId,
		LocalDateTime Start );

	List<ICFSecSecSessionObj> readCachedSecSessionByFinishIdx( CFLibDbKeyHash256 SecUserId,
		LocalDateTime Finish );

	List<ICFSecSecSessionObj> readCachedSecSessionBySecProxyIdx( CFLibDbKeyHash256 SecProxyId );

	void deepDisposeSecSessionByIdIdx( CFLibDbKeyHash256 SecSessionId );

	void deepDisposeSecSessionBySecUserIdx( CFLibDbKeyHash256 SecUserId );

	void deepDisposeSecSessionBySecDevIdx( CFLibDbKeyHash256 SecUserId,
		String SecDevName );

	void deepDisposeSecSessionByStartIdx( CFLibDbKeyHash256 SecUserId,
		LocalDateTime Start );

	void deepDisposeSecSessionByFinishIdx( CFLibDbKeyHash256 SecUserId,
		LocalDateTime Finish );

	void deepDisposeSecSessionBySecProxyIdx( CFLibDbKeyHash256 SecProxyId );

	/**
	 *	Read a page of data as a List of SecSession-derived instances sorted by their primary keys,
	 *	as identified by the duplicate SecUserIdx key attributes.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSession-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecSessionObj> pageSecSessionBySecUserIdx( CFLibDbKeyHash256 SecUserId,
		CFLibDbKeyHash256 priorSecSessionId );

	/**
	 *	Read a page of data as a List of SecSession-derived instances sorted by their primary keys,
	 *	as identified by the duplicate SecDevIdx key attributes.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	SecDevName	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSession-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecSessionObj> pageSecSessionBySecDevIdx( CFLibDbKeyHash256 SecUserId,
		String SecDevName,
		CFLibDbKeyHash256 priorSecSessionId );

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
	List<ICFSecSecSessionObj> pageSecSessionByFinishIdx( CFLibDbKeyHash256 SecUserId,
		LocalDateTime Finish,
		CFLibDbKeyHash256 priorSecSessionId );

	/**
	 *	Read a page of data as a List of SecSession-derived instances sorted by their primary keys,
	 *	as identified by the duplicate SecProxyIdx key attributes.
	 *
	 *	@param	SecProxyId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSession-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFSecSecSessionObj> pageSecSessionBySecProxyIdx( CFLibDbKeyHash256 SecProxyId,
		CFLibDbKeyHash256 priorSecSessionId );

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
	void deleteSecSessionByIdIdx( CFLibDbKeyHash256 SecSessionId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 */
	void deleteSecSessionBySecUserIdx( CFLibDbKeyHash256 SecUserId );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	SecDevName	The SecSession key attribute of the instance generating the id.
	 */
	void deleteSecSessionBySecDevIdx( CFLibDbKeyHash256 SecUserId,
		String SecDevName );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	Start	The SecSession key attribute of the instance generating the id.
	 */
	void deleteSecSessionByStartIdx(CFLibDbKeyHash256 SecUserId,
		LocalDateTime Start );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	Finish	The SecSession key attribute of the instance generating the id.
	 */
	void deleteSecSessionByFinishIdx( CFLibDbKeyHash256 SecUserId,
		LocalDateTime Finish );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecProxyId	The SecSession key attribute of the instance generating the id.
	 */
	void deleteSecSessionBySecProxyIdx( CFLibDbKeyHash256 SecProxyId );

	ICFSecSecSessionObj getSystemSession();
}
