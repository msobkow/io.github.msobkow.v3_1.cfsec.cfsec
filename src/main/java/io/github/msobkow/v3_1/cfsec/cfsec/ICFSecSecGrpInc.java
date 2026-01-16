// Description: Java 25 interface for a SecGrpInc record implementation

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

public interface ICFSecSecGrpInc
{
        public static final String S_INIT_CREATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
        public static final CFLibDbKeyHash256 INIT_CREATED_BY = CFLibDbKeyHash256.fromHex(S_INIT_CREATED_BY);
        public static final String S_INIT_UPDATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
        public static final CFLibDbKeyHash256 INIT_UPDATED_BY = CFLibDbKeyHash256.fromHex(S_INIT_UPDATED_BY);
	public static final String S_SECGRPINCID_INIT_VALUE = "$switch HasInitValue yes InitValue default Zero256bits$";
	public static final CFLibDbKeyHash256 SECGRPINCID_INIT_VALUE = CFLibDbKeyHash256.fromHex( S_SECGRPINCID_INIT_VALUE );
	public static final long CLUSTERID_INIT_VALUE = 0L;
	public static final String S_SECGROUPID_INIT_VALUE = "$switch HasInitValue yes InitValue default Zero256bits$";
	public static final CFLibDbKeyHash256 SECGROUPID_INIT_VALUE = CFLibDbKeyHash256.fromHex( S_SECGROUPID_INIT_VALUE );
	public static final String S_INCLUDEGROUPID_INIT_VALUE = "$switch HasInitValue yes InitValue default Zero256bits$";
	public static final CFLibDbKeyHash256 INCLUDEGROUPID_INIT_VALUE = CFLibDbKeyHash256.fromHex( S_INCLUDEGROUPID_INIT_VALUE );
	public final static int CLASS_CODE = 0xa00e;
	public final static String S_CLASS_CODE = "a00e";

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
	public void setPKey(CFLibDbKeyHash256 requiredSecGrpIncId);
	
	public CFLibDbKeyHash256 getRequiredSecGrpIncId();
	public void setRequiredSecGrpIncId( CFLibDbKeyHash256 value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public ICFSecCluster getRequiredOwnerCluster();
	public ICFSecSecGroup getRequiredContainerGroup();
	public ICFSecSecGroup getRequiredParentSubGroup();
	public void setRequiredOwnerCluster(ICFSecCluster argObj);
	public void setRequiredOwnerCluster(long argClusterId);
	public void setRequiredContainerGroup(ICFSecSecGroup argObj);
	public void setRequiredContainerGroup(CFLibDbKeyHash256 argSecGroupId);
	public void setRequiredParentSubGroup(ICFSecSecGroup argObj);
	public void setRequiredParentSubGroup(CFLibDbKeyHash256 argIncludeGroupId);
	public long getRequiredClusterId();
	public CFLibDbKeyHash256 getRequiredSecGroupId();
	public CFLibDbKeyHash256 getRequiredIncludeGroupId();
	@Override
	public boolean equals( Object obj );
	
	@Override
	public int hashCode();

	//@Override not necessary because interfaces aren't able to implement Comparable, but they can double-team on the requirement
	public int compareTo( Object obj );

	public void set( ICFSecSecGrpInc src );
	public void setSecGrpInc( ICFSecSecGrpInc src );
	public void set( ICFSecSecGrpIncH src );
	public void setSecGrpInc( ICFSecSecGrpIncH src );

	public String getXmlAttrFragment();

	@Override
	public String toString();
}
