// Description: Java 25 interface for a ISOTZone record implementation

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

public interface ICFSecISOTZone
{
	public static final short ISOTZONEID_MIN_VALUE = (short)0;
	public static final short TZHOUROFFSET_MIN_VALUE = (short)-12;
	public static final short TZMINOFFSET_MIN_VALUE = (short)-59;
	public static final short TZHOUROFFSET_MAX_VALUE = (short)12;
	public static final short TZMINOFFSET_MAX_VALUE = (short)59;
        public static final String S_INIT_CREATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
        public static final CFLibDbKeyHash256 INIT_CREATED_BY = CFLibDbKeyHash256.fromHex(S_INIT_CREATED_BY);
        public static final String S_INIT_UPDATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
        public static final CFLibDbKeyHash256 INIT_UPDATED_BY = CFLibDbKeyHash256.fromHex(S_INIT_UPDATED_BY);
	public static final short ISOTZONEID_INIT_VALUE = (short)0;
	public static final String ISO8601_INIT_VALUE = new String( "" );
	public static final String TZNAME_INIT_VALUE = new String( "" );
	public static final short TZHOUROFFSET_INIT_VALUE = (short)0;
	public static final short TZMINOFFSET_INIT_VALUE = (short)0;
	public static final String DESCRIPTION_INIT_VALUE = new String( "" );
	public final static boolean VISIBLE_INIT_VALUE = true;
	public final static int CLASS_CODE = 0xa008;
	public final static String S_CLASS_CODE = "a008";

	public int getClassCode();

	public CFLibDbKeyHash256 getCreatedByUserId();
	public void setCreatedByUserId( CFLibDbKeyHash256 value );
	public LocalDateTime getCreatedAt();
	public void setCreatedAt( LocalDateTime value );
	public CFLibDbKeyHash256 getUpdatedByUserId();
	public void setUpdatedByUserId( CFLibDbKeyHash256 value );
	public LocalDateTime getUpdatedAt();
	public void setUpdatedAt( LocalDateTime value );

	public Short getPKey();
	public void setPKey(Short requiredISOTZoneId);
	
	public short getRequiredISOTZoneId();
	public void setRequiredISOTZoneId( short value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public String getRequiredIso8601();
	public void setRequiredIso8601( String value );
	public String getRequiredTZName();
	public void setRequiredTZName( String value );
	public short getRequiredTZHourOffset();
	public void setRequiredTZHourOffset( short value );
	public short getRequiredTZMinOffset();
	public void setRequiredTZMinOffset( short value );
	public String getRequiredDescription();
	public void setRequiredDescription( String value );
	public boolean getRequiredVisible();
	public void setRequiredVisible( boolean value );
	@Override
	public boolean equals( Object obj );
	
	@Override
	public int hashCode();

	//@Override not necessary because interfaces aren't able to implement Comparable, but they can double-team on the requirement
	public int compareTo( Object obj );

	public void set( ICFSecISOTZone src );
	public void setISOTZone( ICFSecISOTZone src );
	public void set( ICFSecISOTZoneH src );
	public void setISOTZone( ICFSecISOTZoneH src );

	public String getXmlAttrFragment();

	@Override
	public String toString();
}
