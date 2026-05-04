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

import java.util.Comparator;

/*
 *	The CFSecRoleInfoDependencyComparator objects are passed in to the CFSec schema implementation to be bound
 *	to the security system.  Their natural order is to compare by dependency first, and by name second.
 */
public class CFSecRoleInfoDependencyComparator implements Comparator<CFSecRoleInfo>
{
	@Override
	public int compare( CFSecRoleInfo lhs, CFSecRoleInfo rhs ) {
		if( lhs == null ) {
			if ( rhs == null ) {
				return( 0 );
			}
			else {
				return( -1 );
			}
		}
		else if( rhs == null ) {
			return( 1 );
		}
		else {
			String lhsName = lhs.getRoleName();
			String rhsName = rhs.getRoleName();
			String lhsMembership = lhs.getMembership();
			String rhsMembership = rhs.getMembership();
			String lhsMembers[] = lhsMembership.split(" ");
			String rhsMembers[] = rhsMembership.split(" ");
			boolean rhsEnablesLhs = false;
			boolean lhsEnablesRhs = false;
			for (String v: lhsMembers) {
				if (rhsName.equals(v)) {
					lhsEnablesRhs = true;
					break;
				}
			}
			for (String v: rhsMembers) {
				if (lhsName.equals(v)) {
					rhsEnablesLhs = true;
					break;
				}
			}
			int ret;
			if (lhsEnablesRhs) {
				if (rhsEnablesLhs) {
					ret = lhsName.compareTo(rhsName);
				}
				else {
					ret = 1;
				}
			}
			else {
				if (rhsEnablesLhs) {
					ret = -1;
				}
				else {
					ret = lhsName.compareTo(rhsName);
				}
			}
			return( ret );
		}
	}
}
