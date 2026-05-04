// Description: Java 25 CFSec Role Information Implementation

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

/*
 *	The CFSecRoleInfo objects are passed in to the CFSec schema implementation to be bound
 *	to the security system.
 */
public class CFSecRoleInfo implements Serializable
{
	protected final String roleName;
	protected final String membership;

	public CFSecRoleInfo(String roleName, String membership) {
		this.roleName = roleName;
		this.membership = membership;
	}

	public String getRoleName() {
		return roleName;
	}

	public String getMembership() {
		return membership;
	}
}
