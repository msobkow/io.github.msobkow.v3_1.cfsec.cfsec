// Description: Java 25 interface for a TableInfo record declementation

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

import server.markhome.mcf.v3_1.cfsec.cfsecprotobj.*;

/**
 *	ICFSecTableInfo persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ICFSecTableInfo
{
	public static final int TABLEINFOID_MIN_VALUE = 0;
	public static final int BACKINGCLASSCODE_MIN_VALUE = 0;
	public static final int RUNTIMECLASSCODE_MIN_VALUE = 0;
	public static final int TABLEINFOID_INIT_VALUE = 0;
	public static final String SCHEMANAME_INIT_VALUE = new String( "" );
	public static final String TABLENAME_INIT_VALUE = new String( "" );
	public static final String SUPERNAME_INIT_VALUE = new String( "" );
	public static final int BACKINGCLASSCODE_INIT_VALUE = 0;
	public static final int RUNTIMECLASSCODE_INIT_VALUE = 0;
	public final static boolean HASHISTORY_INIT_VALUE = false;
	public final static boolean ISMUTABLE_INIT_VALUE = false;
	public static final String SECSCOPENAME_INIT_VALUE = new String( "" );
	public static final String CODEVIS_INIT_VALUE = new String( "" );
	public final static int CLASS_CODE = 0xa020;
	public final static String S_CLASS_CODE = "a020";

	public int getClassCode();

	public $iterate Columns ( lone implIJavaOptAtomType first implIJavaOptAtomType each implCommaIJavaOptAtomType empty empty )$ getPKey();
	public void setPKey($iterate Columns ( lone implIJavaOptAtomType first implIJavaOptAtomType each implCommaIJavaOptAtomType empty empty )$ requiredTableInfoId);
	public $implIJavaAtomType$ getRequiredTableInfoId();
	public void setRequiredTableInfoId( $implIJavaAtomType$ value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public ICFSecTableInfo getOptionalParentSuperRef();

	public void setOptionalParentSuperRef($implIJavaAtomType$ argSuperName);

	public void setOptionalParentSuperRef(ICFSecTableInfo argObj);

	public void setOptionalParentSuperRef(ICFSecProtTableInfo argObj);

	public void setOptionalParentSuperRef(ICFSecPubTableInfo argObj);

	public List<ICFSecTableInfo> getOptionalChildrenSubRefs();

	public $implIJavaAtomType$ getRequiredSchemaName();
	public void setRequiredSchemaName( $implIJavaAtomType$ value );
	public $implIJavaAtomType$ getRequiredTableName();
	public void setRequiredTableName( $implIJavaAtomType$ value );
	public $implIJavaAtomType$ getOptionalSuperName();
	public void setOptionalSuperName( $implIJavaAtomType$ value );
	public $implIJavaAtomType$ getRequiredBackingClassCode();
	public void setRequiredBackingClassCode( $implIJavaAtomType$ value );
	public $implIJavaAtomType$ getRequiredRuntimeClassCode();
	public void setRequiredRuntimeClassCode( $implIJavaAtomType$ value );
	public $implIJavaAtomType$ getRequiredHasHistory();
	public void setRequiredHasHistory( $implIJavaAtomType$ value );
	public $implIJavaAtomType$ getRequiredIsMutable();
	public void setRequiredIsMutable( $implIJavaAtomType$ value );
	public $implIJavaAtomType$ getRequiredSecScopeName();
	public void setRequiredSecScopeName( $implIJavaAtomType$ value );
	public $implIJavaAtomType$ getRequiredCodeVis();
	public void setRequiredCodeVis( $implIJavaAtomType$ value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( ICFSecTableInfo src );

	public void setTableInfo( ICFSecTableInfo src );

	public void set( ICFSecTableInfoH src );

	public void setTableInfo( ICFSecTableInfoH src );

	public void set( ICFSecProtTableInfo src );

	public void setTableInfo( ICFSecProtTableInfo src );

	public void set( ICFSecProtTableInfoH src );

	public void setTableInfo( ICFSecProtTableInfoH src );

	public void set( ICFSecPubTableInfo src );

	public void setTableInfo( ICFSecPubTableInfo src );

	public void set( ICFSecPubTableInfoH src );

	public void setTableInfo( ICFSecPubTableInfoH src );

	public String getXmlAttrFragment();

	public String toString();
}
