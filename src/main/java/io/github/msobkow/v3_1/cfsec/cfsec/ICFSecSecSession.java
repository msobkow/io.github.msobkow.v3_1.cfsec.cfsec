// Description: Java 25 interface for a SecSession record implementation

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

public interface ICFSecSecSession
{
	public static final String S_SECSESSIONID_INIT_VALUE = "$switch HasInitValue yes InitValue default Zero256bits$";
	public static final CFLibDbKeyHash256 SECSESSIONID_INIT_VALUE = CFLibDbKeyHash256.fromHex( S_SECSESSIONID_INIT_VALUE );
	public static final String S_SECUSERID_INIT_VALUE = "$switch HasInitValue yes InitValue default Zero256bits$";
	public static final CFLibDbKeyHash256 SECUSERID_INIT_VALUE = CFLibDbKeyHash256.fromHex( S_SECUSERID_INIT_VALUE );
	public static final String SECDEVNAME_INIT_VALUE = new String( "" );
	public static final LocalDateTime START_INIT_VALUE = CFLibXmlUtil.parseTimestamp("2020-01-01T00:00:00");
	public static final String S_SECPROXYID_INIT_VALUE = "$switch HasInitValue yes InitValue default Zero256bits$";
	public static final CFLibDbKeyHash256 SECPROXYID_INIT_VALUE = CFLibDbKeyHash256.fromHex( S_SECPROXYID_INIT_VALUE );
	public final static int CLASS_CODE = 0xa010;
	public final static String S_CLASS_CODE = "a010";

	public int getClassCode();

	public CFLibDbKeyHash256 getPKey();
	public void setPKey(CFLibDbKeyHash256 requiredSecSessionId);
	
	public CFLibDbKeyHash256 getRequiredSecSessionId();
	public void setRequiredSecSessionId( CFLibDbKeyHash256 value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public ICFSecSecUser getRequiredContainerSecUser();
	public ICFSecSecUser getRequiredParentSecProxy();
	public void setRequiredContainerSecUser(ICFSecSecUser argObj);
	public void setRequiredContainerSecUser(CFLibDbKeyHash256 argSecUserId);
	public void setRequiredParentSecProxy(ICFSecSecUser argObj);
	public void setRequiredParentSecProxy(CFLibDbKeyHash256 argSecProxyId);
	public CFLibDbKeyHash256 getRequiredSecUserId();
	public String getOptionalSecDevName();
	public void setOptionalSecDevName( String value );
	public LocalDateTime getRequiredStart();
	public void setRequiredStart( LocalDateTime value );
	public LocalDateTime getOptionalFinish();
	public void setOptionalFinish( LocalDateTime value );
	public CFLibDbKeyHash256 getOptionalSecProxyId();
	@Override
	public boolean equals( Object obj );
	
	@Override
	public int hashCode();

	//@Override not necessary because interfaces aren't able to implement Comparable, but they can double-team on the requirement
	public int compareTo( Object obj );

	public void set( ICFSecSecSession src );
	public void setSecSession( ICFSecSecSession src );
	public String getXmlAttrFragment();

	@Override
	public String toString();
}
