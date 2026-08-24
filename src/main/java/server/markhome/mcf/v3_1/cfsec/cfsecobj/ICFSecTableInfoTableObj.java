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

public interface ICFSecTableInfoTableObj
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
	 *	Instantiate a new TableInfo instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecTableInfoObj newInstance();

	/**
	 *	Instantiate a new TableInfo edition of the specified TableInfo instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecTableInfoEditObj newEditInstance( ICFSecTableInfoObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecTableInfoObj realiseTableInfo( ICFSecTableInfoObj Obj );

	/**
	 *	Internal use only.
	 */
	ICFSecTableInfoObj createTableInfo( ICFSecTableInfoObj Obj );

	/**
	 *	Read a TableInfo-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TableInfo-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecTableInfoObj readTableInfo( $iterate Columns ( lone implIJavaOptAtomType first implIJavaOptAtomType each implCommaIJavaOptAtomType empty empty )$ pkey );

	/**
	 *	Read a TableInfo-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TableInfo-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecTableInfoObj readTableInfo( $iterate Columns ( lone implIJavaOptAtomType first implIJavaOptAtomType each implCommaIJavaOptAtomType empty empty )$ pkey,
		boolean forceRead );

	ICFSecTableInfoObj readCachedTableInfo( $iterate Columns ( lone implIJavaOptAtomType first implIJavaOptAtomType each implCommaIJavaOptAtomType empty empty )$ pkey );

	public void reallyDeepDisposeTableInfo( ICFSecTableInfoObj obj );

	void deepDisposeTableInfo( $iterate Columns ( lone implIJavaOptAtomType first implIJavaOptAtomType each implCommaIJavaOptAtomType empty empty )$ pkey );

	/**
	 *	Internal use only.
	 */
	ICFSecTableInfoObj lockTableInfo( $iterate Columns ( lone implIJavaOptAtomType first implIJavaOptAtomType each implCommaIJavaOptAtomType empty empty )$ pkey );

	/**
	 *	Return a sorted list of all the TableInfo-derived instances in the database.
	 *
	 *	@return	List of ICFSecTableInfoObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecTableInfoObj> readAllTableInfo();

	/**
	 *	Return a sorted map of all the TableInfo-derived instances in the database.
	 *
	 *	@return	List of ICFSecTableInfoObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecTableInfoObj> readAllTableInfo( boolean forceRead );

	List<ICFSecTableInfoObj> readCachedAllTableInfo();

	/**
	 *	Get the CFSecTableInfoObj instance for the primary key attributes.
	 *
	 *	@param	TableInfoId	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTableInfoObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecTableInfoObj readTableInfoByIdIdx( $implIJavaAtomType$ TableInfoId );

	/**
	 *	Get the CFSecTableInfoObj instance for the primary key attributes.
	 *
	 *	@param	TableInfoId	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTableInfoObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecTableInfoObj readTableInfoByIdIdx( $implIJavaAtomType$ TableInfoId,
		boolean forceRead );

	/**
	 *	Get the CFSecTableInfoObj instance for the unique TableNameIdx key.
	 *
	 *	@param	TableName	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTableInfoObj cached instance for the unique TableNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecTableInfoObj readTableInfoByTableNameIdx($implIJavaAtomType$ TableName );

	/**
	 *	Get the CFSecTableInfoObj instance for the unique TableNameIdx key.
	 *
	 *	@param	TableName	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTableInfoObj refreshed instance for the unique TableNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecTableInfoObj readTableInfoByTableNameIdx($implIJavaAtomType$ TableName,
		boolean forceRead );

	/**
	 *	Get the map of CFSecTableInfoObj instances sorted by their primary keys for the duplicate SuperNameIdx key.
	 *
	 *	@param	SuperName	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTableInfoObj cached instances sorted by their primary keys for the duplicate SuperNameIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTableInfoObj> readTableInfoBySuperNameIdx( $implIJavaAtomType$ SuperName );

	/**
	 *	Get the map of CFSecTableInfoObj instances sorted by their primary keys for the duplicate SuperNameIdx key.
	 *
	 *	@param	SuperName	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTableInfoObj cached instances sorted by their primary keys for the duplicate SuperNameIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTableInfoObj> readTableInfoBySuperNameIdx( $implIJavaAtomType$ SuperName,
		boolean forceRead );

	/**
	 *	Get the map of CFSecTableInfoObj instances sorted by their primary keys for the duplicate SchemaNameIdx key.
	 *
	 *	@param	SchemaName	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTableInfoObj cached instances sorted by their primary keys for the duplicate SchemaNameIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTableInfoObj> readTableInfoBySchemaNameIdx( $implIJavaAtomType$ SchemaName );

	/**
	 *	Get the map of CFSecTableInfoObj instances sorted by their primary keys for the duplicate SchemaNameIdx key.
	 *
	 *	@param	SchemaName	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecTableInfoObj cached instances sorted by their primary keys for the duplicate SchemaNameIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecTableInfoObj> readTableInfoBySchemaNameIdx( $implIJavaAtomType$ SchemaName,
		boolean forceRead );

	/**
	 *	Get the CFSecTableInfoObj instance for the unique SchemaBkCodeIdx key.
	 *
	 *	@param	SchemaName	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@param	BackingClassCode	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTableInfoObj cached instance for the unique SchemaBkCodeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecTableInfoObj readTableInfoBySchemaBkCodeIdx($implIJavaAtomType$ SchemaName,
		$implIJavaAtomType$ BackingClassCode );

	/**
	 *	Get the CFSecTableInfoObj instance for the unique SchemaBkCodeIdx key.
	 *
	 *	@param	SchemaName	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@param	BackingClassCode	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTableInfoObj refreshed instance for the unique SchemaBkCodeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecTableInfoObj readTableInfoBySchemaBkCodeIdx($implIJavaAtomType$ SchemaName,
		$implIJavaAtomType$ BackingClassCode,
		boolean forceRead );

	/**
	 *	Get the CFSecTableInfoObj instance for the unique SchemaRTCodeIdx key.
	 *
	 *	@param	RuntimeClassCode	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTableInfoObj cached instance for the unique SchemaRTCodeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecTableInfoObj readTableInfoBySchemaRTCodeIdx($implIJavaAtomType$ RuntimeClassCode );

	/**
	 *	Get the CFSecTableInfoObj instance for the unique SchemaRTCodeIdx key.
	 *
	 *	@param	RuntimeClassCode	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@return	CFSecTableInfoObj refreshed instance for the unique SchemaRTCodeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecTableInfoObj readTableInfoBySchemaRTCodeIdx($implIJavaAtomType$ RuntimeClassCode,
		boolean forceRead );

	ICFSecTableInfoObj readCachedTableInfoByIdIdx( $implIJavaAtomType$ TableInfoId );

	ICFSecTableInfoObj readCachedTableInfoByTableNameIdx( $implIJavaAtomType$ TableName );

	List<ICFSecTableInfoObj> readCachedTableInfoBySuperNameIdx( $implIJavaAtomType$ SuperName );

	List<ICFSecTableInfoObj> readCachedTableInfoBySchemaNameIdx( $implIJavaAtomType$ SchemaName );

	ICFSecTableInfoObj readCachedTableInfoBySchemaBkCodeIdx( $implIJavaAtomType$ SchemaName,
		$implIJavaAtomType$ BackingClassCode );

	ICFSecTableInfoObj readCachedTableInfoBySchemaRTCodeIdx( $implIJavaAtomType$ RuntimeClassCode );

	void deepDisposeTableInfoByIdIdx( $implIJavaAtomType$ TableInfoId );

	void deepDisposeTableInfoByTableNameIdx( $implIJavaAtomType$ TableName );

	void deepDisposeTableInfoBySuperNameIdx( $implIJavaAtomType$ SuperName );

	void deepDisposeTableInfoBySchemaNameIdx( $implIJavaAtomType$ SchemaName );

	void deepDisposeTableInfoBySchemaBkCodeIdx( $implIJavaAtomType$ SchemaName,
		$implIJavaAtomType$ BackingClassCode );

	void deepDisposeTableInfoBySchemaRTCodeIdx( $implIJavaAtomType$ RuntimeClassCode );

	/**
	 *	Internal use only.
	 */
	ICFSecTableInfoObj updateTableInfo( ICFSecTableInfoObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTableInfo( ICFSecTableInfoObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableInfoId	The TableInfo key attribute of the instance generating the id.
	 */
	void deleteTableInfoByIdIdx( $implIJavaAtomType$ TableInfoId );

	/**
	 *	Internal use only.
	 *
	 *	@param	TableName	The TableInfo key attribute of the instance generating the id.
	 */
	void deleteTableInfoByTableNameIdx($implIJavaAtomType$ TableName );

	/**
	 *	Internal use only.
	 *
	 *	@param	SuperName	The TableInfo key attribute of the instance generating the id.
	 */
	void deleteTableInfoBySuperNameIdx( $implIJavaAtomType$ SuperName );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaName	The TableInfo key attribute of the instance generating the id.
	 */
	void deleteTableInfoBySchemaNameIdx( $implIJavaAtomType$ SchemaName );

	/**
	 *	Internal use only.
	 *
	 *	@param	SchemaName	The TableInfo key attribute of the instance generating the id.
	 *
	 *	@param	BackingClassCode	The TableInfo key attribute of the instance generating the id.
	 */
	void deleteTableInfoBySchemaBkCodeIdx($implIJavaAtomType$ SchemaName,
		$implIJavaAtomType$ BackingClassCode );

	/**
	 *	Internal use only.
	 *
	 *	@param	RuntimeClassCode	The TableInfo key attribute of the instance generating the id.
	 */
	void deleteTableInfoBySchemaRTCodeIdx($implIJavaAtomType$ RuntimeClassCode );
}
