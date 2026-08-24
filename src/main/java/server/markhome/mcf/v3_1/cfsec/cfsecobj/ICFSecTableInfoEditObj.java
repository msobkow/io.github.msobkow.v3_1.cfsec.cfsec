// Description: Java 25 Instance Edit Object interface for CFSec TableInfo.

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
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfsec.cfsecprot.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfsec.cfsecprotobj.*;

public interface ICFSecTableInfoEditObj
	extends ICFSecTableInfoObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFSecTableInfoObj.
	 */
	ICFSecTableInfoObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFSecTableInfoObj.
	 */
	ICFSecTableInfoObj getOrigAsTableInfo();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFSecTableInfoObj create();

	/*
	 *	Update the instance.
	 */
	CFSecTableInfoEditObj update();

	/*
	 *	Delete the instance.
	 */
	CFSecTableInfoEditObj deleteInstance();

	/**
	 *	Get the ICFSecTableInfoObj instance referenced by the SuperRef key.
	 *
	 *	@return	The ICFSecTableInfoObj instance referenced by the SuperRef key.
	 */
	ICFSecTableInfoObj getOptionalParentSuperRef();

	/**
	 *	Get the optional ICFSecTableInfoObj instance referenced by the SuperRef key.
	 *
	 *	@return	The optional ICFSecTableInfoObj instance referenced by the SuperRef key.
	 */
	ICFSecTableInfoObj getOptionalParentSuperRef( boolean forceRead );

	/**
	 *	Set the ICFSecTableInfoObj instance referenced by the SuperRef key.
	 *
	 *	@param	value	the ICFSecTableInfoObj instance to be referenced by the SuperRef key.
	 */
	void setOptionalParentSuperRef( ICFSecTableInfoObj value );

	/**
	 *	Get a list ICFSecTableInfoObj instances referenced by the SubRefs key.
	 *
	 *	@return	The (potentially empty) list of ICFSecTableInfoObj instances referenced by the SubRefs key.
	 */
	List<ICFSecTableInfoObj> getOptionalChildrenSubRefs();

	/**
	 *	Get the required $implIJavaAtomType$ attribute TableInfoId.
	 *
	 *	@return	The required $implIJavaAtomType$ attribute TableInfoId.
	 */
	$implIJavaAtomType$ getRequiredTableInfoId();

	/**
	 *	Set the required $implIJavaAtomType$ attribute TableInfoId.
	 *
	 *	@param value The required $implIJavaAtomType$ attribute TableInfoId value to be applied.
	 */
	void setRequiredTableInfoId($implIJavaAtomType$ value);

	/**
	 *	Get the required $implIJavaAtomType$ attribute SchemaName.
	 *
	 *	@return	The required $implIJavaAtomType$ attribute SchemaName.
	 */
	$implIJavaAtomType$ getRequiredSchemaName();

	/**
	 *	Set the required $implIJavaAtomType$ attribute SchemaName.
	 *
	 *	@param value The required $implIJavaAtomType$ attribute SchemaName value to be applied.
	 */
	void setRequiredSchemaName($implIJavaAtomType$ value);

	/**
	 *	Get the required $implIJavaAtomType$ attribute TableName.
	 *
	 *	@return	The required $implIJavaAtomType$ attribute TableName.
	 */
	$implIJavaAtomType$ getRequiredTableName();

	/**
	 *	Set the required $implIJavaAtomType$ attribute TableName.
	 *
	 *	@param value The required $implIJavaAtomType$ attribute TableName value to be applied.
	 */
	void setRequiredTableName($implIJavaAtomType$ value);

	/**
	 *	Get the optional $implIJavaAtomType$ attribute SuperName.
	 *
	 *	@return	The optional $implIJavaAtomType$ attribute SuperName.
	 */
	$implIJavaAtomType$ getOptionalSuperName();

	/**
	 *	Get the required $implIJavaAtomType$ attribute BackingClassCode.
	 *
	 *	@return	The required $implIJavaAtomType$ attribute BackingClassCode.
	 */
	$implIJavaAtomType$ getRequiredBackingClassCode();

	/**
	 *	Set the required $implIJavaAtomType$ attribute BackingClassCode.
	 *
	 *	@param value The required $implIJavaAtomType$ attribute BackingClassCode value to be applied.
	 */
	void setRequiredBackingClassCode($implIJavaAtomType$ value);

	/**
	 *	Get the required $implIJavaAtomType$ attribute RuntimeClassCode.
	 *
	 *	@return	The required $implIJavaAtomType$ attribute RuntimeClassCode.
	 */
	$implIJavaAtomType$ getRequiredRuntimeClassCode();

	/**
	 *	Set the required $implIJavaAtomType$ attribute RuntimeClassCode.
	 *
	 *	@param value The required $implIJavaAtomType$ attribute RuntimeClassCode value to be applied.
	 */
	void setRequiredRuntimeClassCode($implIJavaAtomType$ value);

	/**
	 *	Get the required $implIJavaAtomType$ attribute HasHistory.
	 *
	 *	@return	The required $implIJavaAtomType$ attribute HasHistory.
	 */
	$implIJavaAtomType$ getRequiredHasHistory();

	/**
	 *	Set the required $implIJavaAtomType$ attribute HasHistory.
	 *
	 *	@param value The required $implIJavaAtomType$ attribute HasHistory value to be applied.
	 */
	void setRequiredHasHistory($implIJavaAtomType$ value);

	/**
	 *	Get the required $implIJavaAtomType$ attribute IsMutable.
	 *
	 *	@return	The required $implIJavaAtomType$ attribute IsMutable.
	 */
	$implIJavaAtomType$ getRequiredIsMutable();

	/**
	 *	Set the required $implIJavaAtomType$ attribute IsMutable.
	 *
	 *	@param value The required $implIJavaAtomType$ attribute IsMutable value to be applied.
	 */
	void setRequiredIsMutable($implIJavaAtomType$ value);

	/**
	 *	Get the required $implIJavaAtomType$ attribute SecScopeName.
	 *
	 *	@return	The required $implIJavaAtomType$ attribute SecScopeName.
	 */
	$implIJavaAtomType$ getRequiredSecScopeName();

	/**
	 *	Set the required $implIJavaAtomType$ attribute SecScopeName.
	 *
	 *	@param value The required $implIJavaAtomType$ attribute SecScopeName value to be applied.
	 */
	void setRequiredSecScopeName($implIJavaAtomType$ value);

	/**
	 *	Get the required $implIJavaAtomType$ attribute CodeVis.
	 *
	 *	@return	The required $implIJavaAtomType$ attribute CodeVis.
	 */
	$implIJavaAtomType$ getRequiredCodeVis();

	/**
	 *	Set the required $implIJavaAtomType$ attribute CodeVis.
	 *
	 *	@param value The required $implIJavaAtomType$ attribute CodeVis value to be applied.
	 */
	void setRequiredCodeVis($implIJavaAtomType$ value);

	public void copyRecToOrig();
	public void copyOrigToRec();

}
