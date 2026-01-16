// Description: Java 25 interface for a Tenant record implementation

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

package io.github.msobkow.v3_1.cfsec.cfsec;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import io.github.msobkow.v3_1.cflib.*;
import io.github.msobkow.v3_1.cflib.dbutil.*;
import io.github.msobkow.v3_1.cflib.xml.CFLibXmlUtil;
//import io.github.msobkow.v3_1.cfsec.cfsec.*;

public interface ICFSecTenant
{
        public static final String S_INIT_CREATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
        public static final CFLibDbKeyHash256 INIT_CREATED_BY = CFLibDbKeyHash256.fromHex(S_INIT_CREATED_BY);
        public static final String S_INIT_UPDATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
        public static final CFLibDbKeyHash256 INIT_UPDATED_BY = CFLibDbKeyHash256.fromHex(S_INIT_UPDATED_BY);
	public static final String S_ID_INIT_VALUE = "$switch HasInitValue yes InitValue default Zero256bits$";
	public static final CFLibDbKeyHash256 ID_INIT_VALUE = CFLibDbKeyHash256.fromHex( S_ID_INIT_VALUE );
	public static final long CLUSTERID_INIT_VALUE = 0L;
	public static final String TENANTNAME_INIT_VALUE = new String( "" );
	public final static int CLASS_CODE = 0xa015;
	public final static String S_CLASS_CODE = "a015";

	public int getClassCode();

	public CFLibDbKeyHash256 getCreatedByUserId();
	public void setCreatedByUserId( CFLibDbKeyHash256 value );
	public LocalDateTime getCreatedAt();
	public void setCreatedAt( LocalDateTime value );
	public CFLibDbKeyHash256 getUpdatedByUserId();
	public void setUpdatedByUserId( CFLibDbKeyHash256 value );
	public LocalDateTime getUpdatedAt();
	public void setUpdatedAt( LocalDateTime value );

	public CFLibDbKeyHash256 getPKey();
	public void setPKey(CFLibDbKeyHash256 requiredId);
	
	public List<ICFSecTSecGroup> getOptionalComponentsTSecGroup();
	public CFLibDbKeyHash256 getRequiredId();
	public void setRequiredId( CFLibDbKeyHash256 value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public ICFSecCluster getRequiredContainerCluster();
	public void setRequiredContainerCluster(ICFSecCluster argObj);
	public void setRequiredContainerCluster(long argClusterId);
	public long getRequiredClusterId();
	public String getRequiredTenantName();
	public void setRequiredTenantName( String value );
	@Override
	public boolean equals( Object obj );
	
	@Override
	public int hashCode();

	//@Override not necessary because interfaces aren't able to implement Comparable, but they can double-team on the requirement
	public int compareTo( Object obj );

	public void set( ICFSecTenant src );
	public void setTenant( ICFSecTenant src );
	public void set( ICFSecTenantH src );
	public void setTenant( ICFSecTenantH src );

	public String getXmlAttrFragment();

	@Override
	public String toString();
}
