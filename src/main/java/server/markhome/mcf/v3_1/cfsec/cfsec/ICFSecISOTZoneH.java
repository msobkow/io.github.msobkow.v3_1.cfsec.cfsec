// Description: Java 25 interface for a ISOTZone history object

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
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import server.markhome.mcf.v3_1.cflib.xml.CFLibXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfsec.cfsecprot.*;
import server.markhome.mcf.v3_1.cfsec.cfsecprotobj.*;

/**
 *	ICFSecISOTZoneH provides access to history records matching the CFSecISOTZone object change history.
 */
public interface ICFSecISOTZoneH
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

	public ICFSecISOTZoneHPKey getPKey();
	public void setPKey( ICFSecISOTZoneHPKey pkey );
	public CFLibDbKeyHash256 getAuditClusterId();
	public void setAuditClusterId(CFLibDbKeyHash256 auditClusterId);
	public LocalDateTime getAuditStamp();
	public void setAuditStamp(LocalDateTime auditStamp);
	public short getAuditActionId();
	public void setAuditActionId(short auditActionId);
	public int getRequiredRevision();
	public void setRequiredRevision(int revision);
	public CFLibDbKeyHash256 getAuditSessionId();
	public void setAuditSessionId(CFLibDbKeyHash256 auditSessionId);

	public $implIJavaAtomType first implIJavaAtomType each implCommaIJavaAtomType empty empty )$ getRequiredISOTZoneId();
	public void setRequiredISOTZoneId( $implIJavaAtomType first implIJavaAtomType each implCommaIJavaAtomType empty empty )$ requiredISOTZoneId );

	public $implIJavaAtomType$ getRequiredIso8601();
	public void setRequiredIso8601( $implIJavaAtomType$ value );
	public $implIJavaAtomType$ getRequiredTZName();
	public void setRequiredTZName( $implIJavaAtomType$ value );
	public $implIJavaAtomType$ getRequiredTZHourOffset();
	public void setRequiredTZHourOffset( $implIJavaAtomType$ value );
	public $implIJavaAtomType$ getRequiredTZMinOffset();
	public void setRequiredTZMinOffset( $implIJavaAtomType$ value );
	public $implIJavaAtomType$ getRequiredDescription();
	public void setRequiredDescription( $implIJavaAtomType$ value );
	public $implIJavaAtomType$ getRequiredVisible();
	public void setRequiredVisible( $implIJavaAtomType$ value );
	@Override
	public boolean equals( Object obj );

	@Override
	public int hashCode();

	//@Override
	public int compareTo( Object obj );

	public void set( ICFSecISOTZone src );
	public void set( ICFSecISOTZoneH src );
	public void setISOTZone( ICFSecISOTZone src );
	public void setISOTZone( ICFSecISOTZoneH src );
	public String getXmlAttrFragment();

	@Override
	public String toString();
}
