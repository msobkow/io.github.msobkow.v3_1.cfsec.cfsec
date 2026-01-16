// Description: Java 25 Instance Edit Object interface for CFSec SecGroup.

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

public interface ICFSecSecGroupEditObj
	extends ICFSecSecGroupObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFSecSecGroupObj.
	 */
	ICFSecSecGroupObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFSecSecGroupObj.
	 */
	ICFSecSecGroupObj getOrigAsSecGroup();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFSecSecGroupObj create();

	/*
	 *	Update the instance.
	 */
	CFSecSecGroupEditObj update();

	/*
	 *	Delete the instance.
	 */
	CFSecSecGroupEditObj deleteInstance();

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
	 *	Get the ICFSecClusterObj instance referenced by the Cluster key.
	 *
	 *	@return	The ICFSecClusterObj instance referenced by the Cluster key.
	 */
	ICFSecClusterObj getRequiredContainerCluster();

	/**
	 *	Set the ICFSecClusterObj instance referenced by the Cluster key.
	 *
	 *	@param	value	the ICFSecClusterObj instance to be referenced by the Cluster key.
	 */
	void setRequiredContainerCluster( ICFSecClusterObj value );

	/**
	 *	Get a list ICFSecSecGrpIncObj instances referenced by the Include key.
	 *
	 *	@return	The (potentially empty) list of ICFSecSecGrpIncObj instances referenced by the Include key.
	 */
	List<ICFSecSecGrpIncObj> getOptionalComponentsInclude();

	/**
	 *	Get a list ICFSecSecGrpMembObj instances referenced by the Member key.
	 *
	 *	@return	The (potentially empty) list of ICFSecSecGrpMembObj instances referenced by the Member key.
	 */
	List<ICFSecSecGrpMembObj> getOptionalComponentsMember();

	/**
	 *	Get a list ICFSecSecGrpIncObj instances referenced by the IncByGroup key.
	 *
	 *	@return	The (potentially empty) list of ICFSecSecGrpIncObj instances referenced by the IncByGroup key.
	 */
	List<ICFSecSecGrpIncObj> getRequiredChildrenIncByGroup();

	/**
	 *	Get the required long attribute ClusterId.
	 *
	 *	@return	The required long attribute ClusterId.
	 */
	long getRequiredClusterId();

	/**
	 *	Get the required CFLibDbKeyHash256 attribute SecGroupId.
	 *
	 *	@return	The required CFLibDbKeyHash256 attribute SecGroupId.
	 */
	CFLibDbKeyHash256 getRequiredSecGroupId();

	/**
	 *	Set the required CFLibDbKeyHash256 attribute SecGroupId.
	 *
	 *	@param value The required CFLibDbKeyHash256 attribute SecGroupId value to be applied.
	 */
	void setRequiredSecGroupId(CFLibDbKeyHash256 value);

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
	 *	Get the required boolean attribute IsVisible.
	 *
	 *	@return	The required boolean attribute IsVisible.
	 */
	boolean getRequiredIsVisible();

	/**
	 *	Set the required boolean attribute IsVisible.
	 *
	 *	@param value The required boolean attribute IsVisible value to be applied.
	 */
	void setRequiredIsVisible(boolean value);

	public void copyRecToOrig();
	public void copyOrigToRec();

}
