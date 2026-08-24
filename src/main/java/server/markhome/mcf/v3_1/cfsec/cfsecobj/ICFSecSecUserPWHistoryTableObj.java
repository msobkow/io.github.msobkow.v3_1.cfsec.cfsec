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

public interface ICFSecSecUserPWHistoryTableObj
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
	 *	Instantiate a new SecUserPWHistory instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecSecUserPWHistoryObj newInstance();

	/**
	 *	Instantiate a new SecUserPWHistory edition of the specified SecUserPWHistory instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecSecUserPWHistoryEditObj newEditInstance( ICFSecSecUserPWHistoryObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecSecUserPWHistoryObj realiseSecUserPWHistory( ICFSecSecUserPWHistoryObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecSecUserPWHistoryObj createSecUserPWHistory( ICFSecSecUserPWHistoryObj Obj );

	/**
	 *	Read a SecUserPWHistory-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecUserPWHistory-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecUserPWHistoryObj readSecUserPWHistory( ICFSecSecUserPWHistoryPKey pkey );

	/**
	 *	Read a SecUserPWHistory-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecUserPWHistory-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecUserPWHistoryObj readSecUserPWHistory( ICFSecSecUserPWHistoryPKey pkey,
		boolean forceRead );

	/**
	 *	Read a SecUserPWHistory-derived instance by it's primary key.
	 *
	 *	@return	The SecUserPWHistory-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecUserPWHistoryObj readSecUserPWHistory( $implIJavaAtomType$ SecUserId,
		$implIJavaAtomType$ PWSetStamp );

	/**
	 *	Read a SecUserPWHistory-derived instance by it's primary key.
	 *
	 *	@return	The SecUserPWHistory-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecSecUserPWHistoryObj readSecUserPWHistory( $implIJavaAtomType$ SecUserId,
		$implIJavaAtomType$ PWSetStamp,
		boolean forceRead );

	ICFSecSecUserPWHistoryObj readCachedSecUserPWHistory( ICFSecSecUserPWHistoryPKey pkey );

	public void reallyDeepDisposeSecUserPWHistory( ICFSecSecUserPWHistoryObj obj );

	void deepDisposeSecUserPWHistory( ICFSecSecUserPWHistoryPKey pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecSecUserPWHistoryObj lockSecUserPWHistory( ICFSecSecUserPWHistoryPKey pkey );

	/**
	 *	Return a sorted list of all the SecUserPWHistory-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecUserPWHistoryObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecUserPWHistoryObj> readAllSecUserPWHistory();

	/**
	 *	Return a sorted map of all the SecUserPWHistory-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecUserPWHistoryObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecUserPWHistoryObj> readAllSecUserPWHistory( boolean forceRead );

	List<ICFSecSecUserPWHistoryObj> readCachedAllSecUserPWHistory();

	/**
	 *	Return a sorted map of a page of the SecUserPWHistory-derived instances in the database.
	 *
	 *	@return	List of ICFSecSecUserPWHistoryObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecSecUserPWHistoryObj> pageAllSecUserPWHistory($implIJavaOptAtomType$ priorSecUserId,
		LocalDateTime priorPWSetStamp );

	/**
	 *	Get the CFSecSecUserPWHistoryObj instance for the primary key attributes.
	 *
	 *	@param	SecUserId	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@param	PWSetStamp	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecUserPWHistoryObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecUserPWHistoryObj readSecUserPWHistoryByIdIdx( $implIJavaAtomType$ SecUserId,
		$implIJavaAtomType$ PWSetStamp );

	/**
	 *	Get the CFSecSecUserPWHistoryObj instance for the primary key attributes.
	 *
	 *	@param	SecUserId	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@param	PWSetStamp	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecUserPWHistoryObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecUserPWHistoryObj readSecUserPWHistoryByIdIdx( $implIJavaAtomType$ SecUserId,
		$implIJavaAtomType$ PWSetStamp,
		boolean forceRead );

	/**
	 *	Get the CFSecSecUserPWHistoryObj instance for the unique UserIdx key.
	 *
	 *	@param	SecUserId	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecUserPWHistoryObj cached instance for the unique UserIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecUserPWHistoryObj readSecUserPWHistoryByUserIdx($implIJavaAtomType$ SecUserId );

	/**
	 *	Get the CFSecSecUserPWHistoryObj instance for the unique UserIdx key.
	 *
	 *	@param	SecUserId	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecUserPWHistoryObj refreshed instance for the unique UserIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecUserPWHistoryObj readSecUserPWHistoryByUserIdx($implIJavaAtomType$ SecUserId,
		boolean forceRead );

	/**
	 *	Get the CFSecSecUserPWHistoryObj instance for the unique SetStampIdx key.
	 *
	 *	@param	PWSetStamp	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecUserPWHistoryObj cached instance for the unique SetStampIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecUserPWHistoryObj readSecUserPWHistoryBySetStampIdx($implIJavaAtomType$ PWSetStamp );

	/**
	 *	Get the CFSecSecUserPWHistoryObj instance for the unique SetStampIdx key.
	 *
	 *	@param	PWSetStamp	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecUserPWHistoryObj refreshed instance for the unique SetStampIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecUserPWHistoryObj readSecUserPWHistoryBySetStampIdx($implIJavaAtomType$ PWSetStamp,
		boolean forceRead );

	/**
	 *	Get the CFSecSecUserPWHistoryObj instance for the unique ReplacedStampIdx key.
	 *
	 *	@param	PWReplacedStamp	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecUserPWHistoryObj cached instance for the unique ReplacedStampIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecUserPWHistoryObj readSecUserPWHistoryByReplacedStampIdx($implIJavaAtomType$ PWReplacedStamp );

	/**
	 *	Get the CFSecSecUserPWHistoryObj instance for the unique ReplacedStampIdx key.
	 *
	 *	@param	PWReplacedStamp	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@return	CFSecSecUserPWHistoryObj refreshed instance for the unique ReplacedStampIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecSecUserPWHistoryObj readSecUserPWHistoryByReplacedStampIdx($implIJavaAtomType$ PWReplacedStamp,
		boolean forceRead );

	ICFSecSecUserPWHistoryObj readCachedSecUserPWHistoryByIdIdx( $implIJavaAtomType$ SecUserId,
		$implIJavaAtomType$ PWSetStamp );

	ICFSecSecUserPWHistoryObj readCachedSecUserPWHistoryByUserIdx( $implIJavaAtomType$ SecUserId );

	ICFSecSecUserPWHistoryObj readCachedSecUserPWHistoryBySetStampIdx( $implIJavaAtomType$ PWSetStamp );

	ICFSecSecUserPWHistoryObj readCachedSecUserPWHistoryByReplacedStampIdx( $implIJavaAtomType$ PWReplacedStamp );

	void deepDisposeSecUserPWHistoryByIdIdx( $implIJavaAtomType$ SecUserId,
		$implIJavaAtomType$ PWSetStamp );

	void deepDisposeSecUserPWHistoryByUserIdx( $implIJavaAtomType$ SecUserId );

	void deepDisposeSecUserPWHistoryBySetStampIdx( $implIJavaAtomType$ PWSetStamp );

	void deepDisposeSecUserPWHistoryByReplacedStampIdx( $implIJavaAtomType$ PWReplacedStamp );

	/**
	 *	Internal use only.
	 */
	ICFSecSecUserPWHistoryObj updateSecUserPWHistory( ICFSecSecUserPWHistoryObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecUserPWHistory( ICFSecSecUserPWHistoryObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecUserId	The SecUserPWHistory key attribute of the instance generating the id.
	 *
	 *	@param	PWSetStamp	The SecUserPWHistory key attribute of the instance generating the id.
	 */
	void deleteSecUserPWHistoryByIdIdx( $implIJavaAtomType$ SecUserId,
		$implIJavaAtomType$ PWSetStamp );

	/**
	 *	Internal use only.
	 *
	 *	@param	SecUserId	The SecUserPWHistory key attribute of the instance generating the id.
	 */
	void deleteSecUserPWHistoryByUserIdx($implIJavaAtomType$ SecUserId );

	/**
	 *	Internal use only.
	 *
	 *	@param	PWSetStamp	The SecUserPWHistory key attribute of the instance generating the id.
	 */
	void deleteSecUserPWHistoryBySetStampIdx($implIJavaAtomType$ PWSetStamp );

	/**
	 *	Internal use only.
	 *
	 *	@param	PWReplacedStamp	The SecUserPWHistory key attribute of the instance generating the id.
	 */
	void deleteSecUserPWHistoryByReplacedStampIdx($implIJavaAtomType$ PWReplacedStamp );
}
