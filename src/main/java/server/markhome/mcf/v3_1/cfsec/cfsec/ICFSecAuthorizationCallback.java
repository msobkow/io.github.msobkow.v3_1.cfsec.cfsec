// Description: Java 25 Authorization Callback Interface.

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

import java.lang.reflect.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cfsec.cfsecobj.ICFSecClusterObj;
import server.markhome.mcf.v3_1.cfsec.cfsecobj.ICFSecTenantObj;
import server.markhome.mcf.v3_1.cfsec.cfsecobj.ICFSecSecSessionObj;

/*
 *	An ICFSecAuthorizationCallback is callback method hook for locating the currently applicable authorization object at runtime.
 */
public interface ICFSecAuthorizationCallback
{
	/**
	 *	Get the currently effective authorization to be used for processing database I/Os on behalf of the user behind the scenes.
	 *
	 *	@return	The currently effective authorization. May be null if there is no currently active user session, in which case some code uses a default system session.
	 */
	public ICFSecAuthorization getEffectiveAuthorization();
}
