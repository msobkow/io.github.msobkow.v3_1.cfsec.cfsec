// Description: Java 25 interface for a SecSysGrp record implementation

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

package server.markhome.mcf.v3_1.cfsec.cfsec;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.xml.CFLibXmlUtil;
//import server.markhome.mcf.v3_1.cfsec.cfsec.*;

public interface ICFSecSecSysGrp
{
	public static final ICFSecSchema.SecLevelEnum SECLEVEL_MIN_VALUE = ICFSecSchema.SecLevelEnum.System;
	public static final ICFSecSchema.SecLevelEnum SECLEVEL_MAX_VALUE = ICFSecSchema.SecLevelEnum.Tenant;
        public static final String S_INIT_CREATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
        public static final CFLibDbKeyHash256 INIT_CREATED_BY = CFLibDbKeyHash256.fromHex(S_INIT_CREATED_BY);
        public static final String S_INIT_UPDATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
        public static final CFLibDbKeyHash256 INIT_UPDATED_BY = CFLibDbKeyHash256.fromHex(S_INIT_UPDATED_BY);
	public static final String S_SECSYSGRPID_INIT_VALUE = "$switch HasInitValue yes InitValue default Zero256bits$";
	public static final CFLibDbKeyHash256 SECSYSGRPID_INIT_VALUE = CFLibDbKeyHash256.fromHex( S_SECSYSGRPID_INIT_VALUE );
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final ICFSecSchema.SecLevelEnum SECLEVEL_INIT_VALUE = ICFSecSchema.ordinalToSecLevelEnum( 0 );
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
	public void setPKey(CFLibDbKeyHash256 requiredSecSysGrpId);
	
	public List<ICFSecSecSysGrpInc> getOptionalChildrenIncByGrp();
	public List<ICFSecSecSysGrpMemb> getOptionalChildrenMembByGrp();
	public CFLibDbKeyHash256 getRequiredSecSysGrpId();
	public void setRequiredSecSysGrpId( CFLibDbKeyHash256 value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public List<ICFSecSecSysGrpInc> getOptionalChildrenSysGrpByName();
	public List<ICFSecSecClusGrpInc> getOptionalChildrenClusGrpByName();
	public List<ICFSecSecTentGrpInc> getOptionalChildrenTentGrpByName();
	public String getRequiredName();
	public void setRequiredName( String value );
	public ICFSecSchema.SecLevelEnum getRequiredSecLevel();
	public void setRequiredSecLevel( ICFSecSchema.SecLevelEnum value );
	@Override
	public boolean equals( Object obj );
	
	@Override
	public int hashCode();

	//@Override not necessary because interfaces aren't able to implement Comparable, but they can double-team on the requirement
	public int compareTo( Object obj );

	public void set( ICFSecSecSysGrp src );
	public void setSecSysGrp( ICFSecSecSysGrp src );
	public void set( ICFSecSecSysGrpH src );
	public void setSecSysGrp( ICFSecSecSysGrpH src );

	public String getXmlAttrFragment();

	@Override
	public String toString();
}
