// Description: Java 25 Instance Edit Object interface for CFSec TSecGrpInc.

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

public interface ICFSecTSecGrpIncEditObj
	extends ICFSecTSecGrpIncObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFSecTSecGrpIncObj.
	 */
	ICFSecTSecGrpIncObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFSecTSecGrpIncObj.
	 */
	ICFSecTSecGrpIncObj getOrigAsTSecGrpInc();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFSecTSecGrpIncObj create();

	/*
	 *	Update the instance.
	 */
	CFSecTSecGrpIncEditObj update();

	/*
	 *	Delete the instance.
	 */
	CFSecTSecGrpIncEditObj deleteInstance();

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
	 *	Get the ICFSecTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The ICFSecTenantObj instance referenced by the Tenant key.
	 */
	ICFSecTenantObj getRequiredOwnerTenant();

	/**
	 *	Set the ICFSecTenantObj instance referenced by the Tenant key.
	 *
	 *	@param	value	the ICFSecTenantObj instance to be referenced by the Tenant key.
	 */
	void setRequiredOwnerTenant( ICFSecTenantObj value );

	/**
	 *	Get the ICFSecTSecGroupObj instance referenced by the Group key.
	 *
	 *	@return	The ICFSecTSecGroupObj instance referenced by the Group key.
	 */
	ICFSecTSecGroupObj getRequiredContainerGroup();

	/**
	 *	Set the ICFSecTSecGroupObj instance referenced by the Group key.
	 *
	 *	@param	value	the ICFSecTSecGroupObj instance to be referenced by the Group key.
	 */
	void setRequiredContainerGroup( ICFSecTSecGroupObj value );

	/**
	 *	Get the ICFSecTSecGroupObj instance referenced by the SubGroup key.
	 *
	 *	@return	The ICFSecTSecGroupObj instance referenced by the SubGroup key.
	 */
	ICFSecTSecGroupObj getRequiredParentSubGroup();

	/**
	 *	Set the ICFSecTSecGroupObj instance referenced by the SubGroup key.
	 *
	 *	@param	value	the ICFSecTSecGroupObj instance to be referenced by the SubGroup key.
	 */
	void setRequiredParentSubGroup( ICFSecTSecGroupObj value );

	/**
	 *	Get the required CFLibDbKeyHash256 attribute TSecGrpIncId.
	 *
	 *	@return	The required CFLibDbKeyHash256 attribute TSecGrpIncId.
	 */
	CFLibDbKeyHash256 getRequiredTSecGrpIncId();

	/**
	 *	Set the required CFLibDbKeyHash256 attribute TSecGrpIncId.
	 *
	 *	@param value The required CFLibDbKeyHash256 attribute TSecGrpIncId value to be applied.
	 */
	void setRequiredTSecGrpIncId(CFLibDbKeyHash256 value);

	/**
	 *	Get the required CFLibDbKeyHash256 attribute TenantId.
	 *
	 *	@return	The required CFLibDbKeyHash256 attribute TenantId.
	 */
	CFLibDbKeyHash256 getRequiredTenantId();

	/**
	 *	Get the required CFLibDbKeyHash256 attribute TSecGroupId.
	 *
	 *	@return	The required CFLibDbKeyHash256 attribute TSecGroupId.
	 */
	CFLibDbKeyHash256 getRequiredTSecGroupId();

	/**
	 *	Get the required CFLibDbKeyHash256 attribute IncludeGroupId.
	 *
	 *	@return	The required CFLibDbKeyHash256 attribute IncludeGroupId.
	 */
	CFLibDbKeyHash256 getRequiredIncludeGroupId();

	public void copyRecToOrig();
	public void copyOrigToRec();

}
