// Description: Java 25 Instance Edit Object interface for CFSec SecSession.

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

public interface ICFSecSecSessionEditObj
	extends ICFSecSecSessionObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFSecSecSessionObj.
	 */
	ICFSecSecSessionObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFSecSecSessionObj.
	 */
	ICFSecSecSessionObj getOrigAsSecSession();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFSecSecSessionObj create();

	/*
	 *	Update the instance.
	 */
	CFSecSecSessionEditObj update();

	/*
	 *	Delete the instance.
	 */
	CFSecSecSessionEditObj deleteInstance();

	/**
	 *	Get the ICFSecSecUserObj instance referenced by the SecUser key.
	 *
	 *	@return	The ICFSecSecUserObj instance referenced by the SecUser key.
	 */
	ICFSecSecUserObj getRequiredContainerSecUser();

	/**
	 *	Set the ICFSecSecUserObj instance referenced by the SecUser key.
	 *
	 *	@param	value	the ICFSecSecUserObj instance to be referenced by the SecUser key.
	 */
	void setRequiredContainerSecUser( ICFSecSecUserObj value );

	/**
	 *	Get the ICFSecSecUserObj instance referenced by the SecProxy key.
	 *
	 *	@return	The ICFSecSecUserObj instance referenced by the SecProxy key.
	 */
	ICFSecSecUserObj getRequiredParentSecProxy();

	/**
	 *	Set the ICFSecSecUserObj instance referenced by the SecProxy key.
	 *
	 *	@param	value	the ICFSecSecUserObj instance to be referenced by the SecProxy key.
	 */
	void setRequiredParentSecProxy( ICFSecSecUserObj value );

	/**
	 *	Get the required CFLibDbKeyHash256 attribute SecSessionId.
	 *
	 *	@return	The required CFLibDbKeyHash256 attribute SecSessionId.
	 */
	CFLibDbKeyHash256 getRequiredSecSessionId();

	/**
	 *	Set the required CFLibDbKeyHash256 attribute SecSessionId.
	 *
	 *	@param value The required CFLibDbKeyHash256 attribute SecSessionId value to be applied.
	 */
	void setRequiredSecSessionId(CFLibDbKeyHash256 value);

	/**
	 *	Get the required CFLibDbKeyHash256 attribute SecUserId.
	 *
	 *	@return	The required CFLibDbKeyHash256 attribute SecUserId.
	 */
	CFLibDbKeyHash256 getRequiredSecUserId();

	/**
	 *	Get the optional String attribute SecDevName.
	 *
	 *	@return	The optional String attribute SecDevName.
	 */
	String getOptionalSecDevName();

	/**
	 *	Set the optional String attribute SecDevName.
	 *
	 *	@param value The optional String attribute SecDevName value to be applied.
	 */
	void setOptionalSecDevName(String value);

	/**
	 *	Get the required LocalDateTime attribute Start.
	 *
	 *	@return	The required LocalDateTime attribute Start.
	 */
	LocalDateTime getRequiredStart();

	/**
	 *	Set the required LocalDateTime attribute Start.
	 *
	 *	@param value The required LocalDateTime attribute Start value to be applied.
	 */
	void setRequiredStart(LocalDateTime value);

	/**
	 *	Get the optional LocalDateTime attribute Finish.
	 *
	 *	@return	The optional LocalDateTime attribute Finish.
	 */
	LocalDateTime getOptionalFinish();

	/**
	 *	Set the optional LocalDateTime attribute Finish.
	 *
	 *	@param value The optional LocalDateTime attribute Finish value to be applied.
	 */
	void setOptionalFinish(LocalDateTime value);

	/**
	 *	Get the optional CFLibDbKeyHash256 attribute SecProxyId.
	 *
	 *	@return	The optional CFLibDbKeyHash256 attribute SecProxyId.
	 */
	CFLibDbKeyHash256 getOptionalSecProxyId();

	public void copyRecToOrig();
	public void copyOrigToRec();

}
