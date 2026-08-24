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

public interface ICFSecISOCtryLangTableObj
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
	 *	Instantiate a new ISOCtryLang instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecISOCtryLangObj newInstance();

	/**
	 *	Instantiate a new ISOCtryLang edition of the specified ISOCtryLang instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecISOCtryLangEditObj newEditInstance( ICFSecISOCtryLangObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCtryLangObj realiseISOCtryLang( ICFSecISOCtryLangObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCtryLangObj createISOCtryLang( ICFSecISOCtryLangObj Obj );

	/**
	 *	Read a ISOCtryLang-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOCtryLang-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOCtryLangObj readISOCtryLang( ICFSecISOCtryLangPKey pkey );

	/**
	 *	Read a ISOCtryLang-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOCtryLang-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOCtryLangObj readISOCtryLang( ICFSecISOCtryLangPKey pkey,
		boolean forceRead );

	/**
	 *	Read a ISOCtryLang-derived instance by it's primary key.
	 *
	 *	@return	The ISOCtryLang-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOCtryLangObj readISOCtryLang( $implIJavaAtomType$ ISOCtryId,
		$implIJavaAtomType$ ISOLangId );

	/**
	 *	Read a ISOCtryLang-derived instance by it's primary key.
	 *
	 *	@return	The ISOCtryLang-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOCtryLangObj readISOCtryLang( $implIJavaAtomType$ ISOCtryId,
		$implIJavaAtomType$ ISOLangId,
		boolean forceRead );

	ICFSecISOCtryLangObj readCachedISOCtryLang( ICFSecISOCtryLangPKey pkey );

	public void reallyDeepDisposeISOCtryLang( ICFSecISOCtryLangObj obj );

	void deepDisposeISOCtryLang( ICFSecISOCtryLangPKey pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCtryLangObj lockISOCtryLang( ICFSecISOCtryLangPKey pkey );

	/**
	 *	Return a sorted list of all the ISOCtryLang-derived instances in the database.
	 *
	 *	@return	List of ICFSecISOCtryLangObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecISOCtryLangObj> readAllISOCtryLang();

	/**
	 *	Return a sorted map of all the ISOCtryLang-derived instances in the database.
	 *
	 *	@return	List of ICFSecISOCtryLangObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecISOCtryLangObj> readAllISOCtryLang( boolean forceRead );

	List<ICFSecISOCtryLangObj> readCachedAllISOCtryLang();

	/**
	 *	Get the CFSecISOCtryLangObj instance for the primary key attributes.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCtryLangObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCtryLangObj readISOCtryLangByIdIdx( $implIJavaAtomType$ ISOCtryId,
		$implIJavaAtomType$ ISOLangId );

	/**
	 *	Get the CFSecISOCtryLangObj instance for the primary key attributes.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCtryLangObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCtryLangObj readISOCtryLangByIdIdx( $implIJavaAtomType$ ISOCtryId,
		$implIJavaAtomType$ ISOLangId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecISOCtryLangObj instances sorted by their primary keys for the duplicate CtryIdx key.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOCtryLangObj cached instances sorted by their primary keys for the duplicate CtryIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOCtryLangObj> readISOCtryLangByCtryIdx( $implIJavaAtomType$ ISOCtryId );

	/**
	 *	Get the map of CFSecISOCtryLangObj instances sorted by their primary keys for the duplicate CtryIdx key.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOCtryLangObj cached instances sorted by their primary keys for the duplicate CtryIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOCtryLangObj> readISOCtryLangByCtryIdx( $implIJavaAtomType$ ISOCtryId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecISOCtryLangObj instances sorted by their primary keys for the duplicate LangIdx key.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOCtryLangObj cached instances sorted by their primary keys for the duplicate LangIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOCtryLangObj> readISOCtryLangByLangIdx( $implIJavaAtomType$ ISOLangId );

	/**
	 *	Get the map of CFSecISOCtryLangObj instances sorted by their primary keys for the duplicate LangIdx key.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOCtryLangObj cached instances sorted by their primary keys for the duplicate LangIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOCtryLangObj> readISOCtryLangByLangIdx( $implIJavaAtomType$ ISOLangId,
		boolean forceRead );

	ICFSecISOCtryLangObj readCachedISOCtryLangByIdIdx( $implIJavaAtomType$ ISOCtryId,
		$implIJavaAtomType$ ISOLangId );

	List<ICFSecISOCtryLangObj> readCachedISOCtryLangByCtryIdx( $implIJavaAtomType$ ISOCtryId );

	List<ICFSecISOCtryLangObj> readCachedISOCtryLangByLangIdx( $implIJavaAtomType$ ISOLangId );

	void deepDisposeISOCtryLangByIdIdx( $implIJavaAtomType$ ISOCtryId,
		$implIJavaAtomType$ ISOLangId );

	void deepDisposeISOCtryLangByCtryIdx( $implIJavaAtomType$ ISOCtryId );

	void deepDisposeISOCtryLangByLangIdx( $implIJavaAtomType$ ISOLangId );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCtryLangObj updateISOCtryLang( ICFSecISOCtryLangObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteISOCtryLang( ICFSecISOCtryLangObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 */
	void deleteISOCtryLangByIdIdx( $implIJavaAtomType$ ISOCtryId,
		$implIJavaAtomType$ ISOLangId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ISOCtryId	The ISOCtryLang key attribute of the instance generating the id.
	 */
	void deleteISOCtryLangByCtryIdx( $implIJavaAtomType$ ISOCtryId );

	/**
	 *	Internal use only.
	 *
	 *	@param	ISOLangId	The ISOCtryLang key attribute of the instance generating the id.
	 */
	void deleteISOCtryLangByLangIdx( $implIJavaAtomType$ ISOLangId );
}
