// Description: Java 25 interface for a SecGrpInc history object

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

/**
 *	ICFSecSecGrpIncH provides access to history records matching the CFSecSecGrpInc object change history.
 */
public interface ICFSecSecGrpIncH
{
	public int getClassCode();

	public CFLibDbKeyHash256 getCreatedByUserId();
	public void setCreatedByUserId( CFLibDbKeyHash256 value );
	public LocalDateTime getCreatedAt();
	public void setCreatedAt( LocalDateTime value );
	public CFLibDbKeyHash256 getUpdatedByUserId();
	public void setUpdatedByUserId( CFLibDbKeyHash256 value );
	public LocalDateTime getUpdatedAt();
	public void setUpdatedAt( LocalDateTime value );

	public ICFSecSecGrpIncHPKey getPKey();
	public void setPKey( ICFSecSecGrpIncHPKey pkey );
	public long getAuditClusterId();
	public void setAuditClusterId(long auditClusterId);
	public LocalDateTime getAuditStamp();
	public void setAuditStamp(LocalDateTime auditStamp);
	public short getAuditActionId();
	public void setAuditActionId(short auditActionId);
	public int getRequiredRevision();
	public void setRequiredRevision(int revision);
	public CFLibDbKeyHash256 getAuditSessionId();
	public void setAuditSessionId(CFLibDbKeyHash256 auditSessionId);

	public CFLibDbKeyHash256 getRequiredSecGrpIncId();
	public void setRequiredSecGrpIncId( CFLibDbKeyHash256 requiredSecGrpIncId );

	public long getRequiredClusterId();
	public void setRequiredClusterId( long value );
	public CFLibDbKeyHash256 getRequiredSecGroupId();
	public void setRequiredSecGroupId( CFLibDbKeyHash256 value );
	public CFLibDbKeyHash256 getRequiredIncludeGroupId();
	public void setRequiredIncludeGroupId( CFLibDbKeyHash256 value );
	@Override
	public boolean equals( Object obj );

	@Override
	public int hashCode();

	//@Override
	public int compareTo( Object obj );

	public void set( ICFSecSecGrpInc src );
	public void set( ICFSecSecGrpIncH src );
	public void setSecGrpInc( ICFSecSecGrpInc src );
	public void setSecGrpInc( ICFSecSecGrpIncH src );
	public String getXmlAttrFragment();

	@Override
	public String toString();
}
