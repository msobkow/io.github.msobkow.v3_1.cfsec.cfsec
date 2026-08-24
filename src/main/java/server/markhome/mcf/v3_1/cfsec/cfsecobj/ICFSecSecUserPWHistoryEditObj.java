// Description: Java 25 Instance Edit Object interface for CFSec SecUserPWHistory.

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

public interface ICFSecSecUserPWHistoryEditObj
	extends ICFSecSecUserPWHistoryObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFSecSecUserPWHistoryObj.
	 */
	ICFSecSecUserPWHistoryObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFSecSecUserPWHistoryObj.
	 */
	ICFSecSecUserPWHistoryObj getOrigAsSecUserPWHistory();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFSecSecUserPWHistoryObj create();

	/*
	 *	Update the instance.
	 */
	CFSecSecUserPWHistoryEditObj update();

	/*
	 *	Delete the instance.
	 */
	CFSecSecUserPWHistoryEditObj deleteInstance();

	/**
	 *	Get the required $implIJavaAtomType$ attribute SecUserId.
	 *
	 *	@return	The required $implIJavaAtomType$ attribute SecUserId.
	 */
	$implIJavaAtomType$ getRequiredSecUserId();

	/**
	 *	Set the required $implIJavaAtomType$ attribute SecUserId.
	 *
	 *	@param value The required $implIJavaAtomType$ attribute SecUserId value to be applied.
	 */
	void setRequiredSecUserId($implIJavaAtomType$ value);

	/**
	 *	Get the required $implIJavaAtomType$ attribute PWSetStamp.
	 *
	 *	@return	The required $implIJavaAtomType$ attribute PWSetStamp.
	 */
	$implIJavaAtomType$ getRequiredPWSetStamp();

	/**
	 *	Set the required $implIJavaAtomType$ attribute PWSetStamp.
	 *
	 *	@param value The required $implIJavaAtomType$ attribute PWSetStamp value to be applied.
	 */
	void setRequiredPWSetStamp($implIJavaAtomType$ value);

	/**
	 *	Get the required $implIJavaAtomType$ attribute PWReplacedStamp.
	 *
	 *	@return	The required $implIJavaAtomType$ attribute PWReplacedStamp.
	 */
	$implIJavaAtomType$ getRequiredPWReplacedStamp();

	/**
	 *	Set the required $implIJavaAtomType$ attribute PWReplacedStamp.
	 *
	 *	@param value The required $implIJavaAtomType$ attribute PWReplacedStamp value to be applied.
	 */
	void setRequiredPWReplacedStamp($implIJavaAtomType$ value);

	/**
	 *	Get the required $implIJavaAtomType$ attribute PasswordHash.
	 *
	 *	@return	The required $implIJavaAtomType$ attribute PasswordHash.
	 */
	$implIJavaAtomType$ getRequiredPasswordHash();

	/**
	 *	Set the required $implIJavaAtomType$ attribute PasswordHash.
	 *
	 *	@param value The required $implIJavaAtomType$ attribute PasswordHash value to be applied.
	 */
	void setRequiredPasswordHash($implIJavaAtomType$ value);

	public void copyRecToOrig();
	public void copyOrigToRec();

}
