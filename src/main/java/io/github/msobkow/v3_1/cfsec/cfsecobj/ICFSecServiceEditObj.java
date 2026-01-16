// Description: Java 25 Instance Edit Object interface for CFSec Service.

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

public interface ICFSecServiceEditObj
	extends ICFSecServiceObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFSecServiceObj.
	 */
	ICFSecServiceObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFSecServiceObj.
	 */
	ICFSecServiceObj getOrigAsService();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFSecServiceObj create();

	/*
	 *	Update the instance.
	 */
	CFSecServiceEditObj update();

	/*
	 *	Delete the instance.
	 */
	CFSecServiceEditObj deleteInstance();

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
	ICFSecClusterObj getRequiredOwnerCluster();

	/**
	 *	Set the ICFSecClusterObj instance referenced by the Cluster key.
	 *
	 *	@param	value	the ICFSecClusterObj instance to be referenced by the Cluster key.
	 */
	void setRequiredOwnerCluster( ICFSecClusterObj value );

	/**
	 *	Get the ICFSecHostNodeObj instance referenced by the Host key.
	 *
	 *	@return	The ICFSecHostNodeObj instance referenced by the Host key.
	 */
	ICFSecHostNodeObj getOptionalContainerHost();

	/**
	 *	Set the ICFSecHostNodeObj instance referenced by the Host key.
	 *
	 *	@param	value	the ICFSecHostNodeObj instance to be referenced by the Host key.
	 */
	void setOptionalContainerHost( ICFSecHostNodeObj value );

	/**
	 *	Get the ICFSecServiceTypeObj instance referenced by the ServiceType key.
	 *
	 *	@return	The ICFSecServiceTypeObj instance referenced by the ServiceType key.
	 */
	ICFSecServiceTypeObj getOptionalParentServiceType();

	/**
	 *	Set the ICFSecServiceTypeObj instance referenced by the ServiceType key.
	 *
	 *	@param	value	the ICFSecServiceTypeObj instance to be referenced by the ServiceType key.
	 */
	void setOptionalParentServiceType( ICFSecServiceTypeObj value );

	/**
	 *	Get the required CFLibDbKeyHash256 attribute ServiceId.
	 *
	 *	@return	The required CFLibDbKeyHash256 attribute ServiceId.
	 */
	CFLibDbKeyHash256 getRequiredServiceId();

	/**
	 *	Set the required CFLibDbKeyHash256 attribute ServiceId.
	 *
	 *	@param value The required CFLibDbKeyHash256 attribute ServiceId value to be applied.
	 */
	void setRequiredServiceId(CFLibDbKeyHash256 value);

	/**
	 *	Get the required long attribute ClusterId.
	 *
	 *	@return	The required long attribute ClusterId.
	 */
	long getRequiredClusterId();

	/**
	 *	Get the required CFLibDbKeyHash256 attribute HostNodeId.
	 *
	 *	@return	The required CFLibDbKeyHash256 attribute HostNodeId.
	 */
	CFLibDbKeyHash256 getRequiredHostNodeId();

	/**
	 *	Get the required CFLibDbKeyHash256 attribute ServiceTypeId.
	 *
	 *	@return	The required CFLibDbKeyHash256 attribute ServiceTypeId.
	 */
	CFLibDbKeyHash256 getRequiredServiceTypeId();

	/**
	 *	Get the required short attribute HostPort.
	 *
	 *	@return	The required short attribute HostPort.
	 */
	short getRequiredHostPort();

	/**
	 *	Set the required short attribute HostPort.
	 *
	 *	@param value The required short attribute HostPort value to be applied.
	 */
	void setRequiredHostPort(short value);

	public void copyRecToOrig();
	public void copyOrigToRec();

}
