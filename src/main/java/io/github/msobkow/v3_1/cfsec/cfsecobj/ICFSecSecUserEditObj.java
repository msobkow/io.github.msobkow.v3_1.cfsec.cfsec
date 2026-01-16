// Description: Java 25 Instance Edit Object interface for CFSec SecUser.

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

public interface ICFSecSecUserEditObj
	extends ICFSecSecUserObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFSecSecUserObj.
	 */
	ICFSecSecUserObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFSecSecUserObj.
	 */
	ICFSecSecUserObj getOrigAsSecUser();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFSecSecUserObj create();

	/*
	 *	Update the instance.
	 */
	CFSecSecUserEditObj update();

	/*
	 *	Delete the instance.
	 */
	CFSecSecUserEditObj deleteInstance();

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
	 *	Get a list ICFSecSecDeviceObj instances referenced by the SecDev key.
	 *
	 *	@return	The (potentially empty) list of ICFSecSecDeviceObj instances referenced by the SecDev key.
	 */
	List<ICFSecSecDeviceObj> getOptionalComponentsSecDev();

	/**
	 *	Get the ICFSecSecDeviceObj instance referenced by the DefDev key.
	 *
	 *	@return	The ICFSecSecDeviceObj instance referenced by the DefDev key.
	 */
	ICFSecSecDeviceObj getOptionalLookupDefDev();

	/**
	 *	Set the ICFSecSecDeviceObj instance referenced by the DefDev key.
	 *
	 *	@param	value	the ICFSecSecDeviceObj instance to be referenced by the DefDev key.
	 */
	void setOptionalLookupDefDev( ICFSecSecDeviceObj value );

	/**
	 *	Get a list ICFSecSecSessionObj instances referenced by the SecSess key.
	 *
	 *	@return	The (potentially empty) list of ICFSecSecSessionObj instances referenced by the SecSess key.
	 */
	List<ICFSecSecSessionObj> getOptionalComponentsSecSess();

	/**
	 *	Get a list ICFSecSecSessionObj instances referenced by the SecProxy key.
	 *
	 *	@return	The (potentially empty) list of ICFSecSecSessionObj instances referenced by the SecProxy key.
	 */
	List<ICFSecSecSessionObj> getOptionalChildrenSecProxy();

	/**
	 *	Get a list ICFSecSecGrpMembObj instances referenced by the SecGrpMemb key.
	 *
	 *	@return	The (potentially empty) list of ICFSecSecGrpMembObj instances referenced by the SecGrpMemb key.
	 */
	List<ICFSecSecGrpMembObj> getOptionalChildrenSecGrpMemb();

	/**
	 *	Get a list ICFSecTSecGrpMembObj instances referenced by the TSecGrpMemb key.
	 *
	 *	@return	The (potentially empty) list of ICFSecTSecGrpMembObj instances referenced by the TSecGrpMemb key.
	 */
	List<ICFSecTSecGrpMembObj> getOptionalChildrenTSecGrpMemb();

	/**
	 *	Get the required CFLibDbKeyHash256 attribute SecUserId.
	 *
	 *	@return	The required CFLibDbKeyHash256 attribute SecUserId.
	 */
	CFLibDbKeyHash256 getRequiredSecUserId();

	/**
	 *	Set the required CFLibDbKeyHash256 attribute SecUserId.
	 *
	 *	@param value The required CFLibDbKeyHash256 attribute SecUserId value to be applied.
	 */
	void setRequiredSecUserId(CFLibDbKeyHash256 value);

	/**
	 *	Get the required String attribute LoginId.
	 *
	 *	@return	The required String attribute LoginId.
	 */
	String getRequiredLoginId();

	/**
	 *	Set the required String attribute LoginId.
	 *
	 *	@param value The required String attribute LoginId value to be applied.
	 */
	void setRequiredLoginId(String value);

	/**
	 *	Get the required String attribute EMailAddress.
	 *
	 *	@return	The required String attribute EMailAddress.
	 */
	String getRequiredEMailAddress();

	/**
	 *	Set the required String attribute EMailAddress.
	 *
	 *	@param value The required String attribute EMailAddress value to be applied.
	 */
	void setRequiredEMailAddress(String value);

	/**
	 *	Get the optional CFLibUuid6 attribute EMailConfirmUuid6.
	 *
	 *	@return	The optional CFLibUuid6 attribute EMailConfirmUuid6.
	 */
	CFLibUuid6 getOptionalEMailConfirmUuid6();

	/**
	 *	Set the optional CFLibUuid6 attribute EMailConfirmUuid6.
	 *
	 *	@param value The optional CFLibUuid6 attribute EMailConfirmUuid6 value to be applied.
	 */
	void setOptionalEMailConfirmUuid6(CFLibUuid6 value);

	/**
	 *	Get the optional CFLibDbKeyHash256 attribute DfltDevUserId.
	 *
	 *	@return	The optional CFLibDbKeyHash256 attribute DfltDevUserId.
	 */
	CFLibDbKeyHash256 getOptionalDfltDevUserId();

	/**
	 *	Get the optional String attribute DfltDevName.
	 *
	 *	@return	The optional String attribute DfltDevName.
	 */
	String getOptionalDfltDevName();

	/**
	 *	Get the required String attribute PasswordHash.
	 *
	 *	@return	The required String attribute PasswordHash.
	 */
	String getRequiredPasswordHash();

	/**
	 *	Set the required String attribute PasswordHash.
	 *
	 *	@param value The required String attribute PasswordHash value to be applied.
	 */
	void setRequiredPasswordHash(String value);

	/**
	 *	Get the optional CFLibUuid6 attribute PasswordResetUuid6.
	 *
	 *	@return	The optional CFLibUuid6 attribute PasswordResetUuid6.
	 */
	CFLibUuid6 getOptionalPasswordResetUuid6();

	/**
	 *	Set the optional CFLibUuid6 attribute PasswordResetUuid6.
	 *
	 *	@param value The optional CFLibUuid6 attribute PasswordResetUuid6 value to be applied.
	 */
	void setOptionalPasswordResetUuid6(CFLibUuid6 value);

	public void copyRecToOrig();
	public void copyOrigToRec();

}
