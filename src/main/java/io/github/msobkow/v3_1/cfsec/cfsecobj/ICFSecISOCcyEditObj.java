// Description: Java 25 Instance Edit Object interface for CFSec ISOCcy.

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
import io.github.msobkow.v3_1.cflib.dbutil.*;import org.apache.commons.text.StringEscapeUtils;
import io.github.msobkow.v3_1.cfsec.cfsec.*;

public interface ICFSecISOCcyEditObj
	extends ICFSecISOCcyObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFSecISOCcyObj.
	 */
	ICFSecISOCcyObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFSecISOCcyObj.
	 */
	ICFSecISOCcyObj getOrigAsISOCcy();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFSecISOCcyObj create();

	/*
	 *	Update the instance.
	 */
	CFSecISOCcyEditObj update();

	/*
	 *	Delete the instance.
	 */
	CFSecISOCcyEditObj deleteInstance();

	/**
	 *	Set the user who created this instance.
	 *
	 *	@param	value	The ICFSecSecUserObj instance who created this instance.
	 */
	void setCreatedBy( ICFSecSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was created.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setCreatedAt( LocalDateTime value );

	/**
	 *	Set the user who updated this instance.
	 *
	 *	@param	value	The ICFSecSecUserObj instance who updated this instance.
	 */
	void setUpdatedBy( ICFSecSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was updated.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setUpdatedAt( LocalDateTime value );

	/**
	 *	Get a list ICFSecISOCtryCcyObj instances referenced by the Ctry key.
	 *
	 *	@return	The (potentially empty) list of ICFSecISOCtryCcyObj instances referenced by the Ctry key.
	 */
	List<ICFSecISOCtryCcyObj> getOptionalChildrenCtry();

	/**
	 *	Get the required short attribute ISOCcyId.
	 *
	 *	@return	The required short attribute ISOCcyId.
	 */
	short getRequiredISOCcyId();

	/**
	 *	Set the required short attribute ISOCcyId.
	 *
	 *	@param value The required short attribute ISOCcyId value to be applied.
	 */
	void setRequiredISOCcyId(short value);

	/**
	 *	Get the required String attribute ISOCode.
	 *
	 *	@return	The required String attribute ISOCode.
	 */
	String getRequiredISOCode();

	/**
	 *	Set the required String attribute ISOCode.
	 *
	 *	@param value The required String attribute ISOCode value to be applied.
	 */
	void setRequiredISOCode(String value);

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Set the required String attribute Name.
	 *
	 *	@param value The required String attribute Name value to be applied.
	 */
	void setRequiredName(String value);

	/**
	 *	Get the optional String attribute UnitSymbol.
	 *
	 *	@return	The optional String attribute UnitSymbol.
	 */
	String getOptionalUnitSymbol();

	/**
	 *	Set the optional String attribute UnitSymbol.
	 *
	 *	@param value The optional String attribute UnitSymbol value to be applied.
	 */
	void setOptionalUnitSymbol(String value);

	/**
	 *	Get the required short attribute Precis.
	 *
	 *	@return	The required short attribute Precis.
	 */
	short getRequiredPrecis();

	/**
	 *	Set the required short attribute Precis.
	 *
	 *	@param value The required short attribute Precis value to be applied.
	 */
	void setRequiredPrecis(short value);

	public void copyRecToOrig();
	public void copyOrigToRec();

}
