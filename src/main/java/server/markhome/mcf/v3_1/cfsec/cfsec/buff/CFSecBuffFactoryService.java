// Description: Java 25 buffer implementation of a CFSec factory service.

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

package server.markhome.mcf.v3_1.cfsec.cfsec.buff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;

@Service("cfsec31BuffFactoryService")
public class CFSecBuffFactoryService
	implements ICFSecFactory
{

	@Autowired
	@Qualifier("cfsec31BuffClusterFactoryService")
	protected ICFSecClusterFactory factoryCluster;

	@Autowired
	@Qualifier("cfsec31BuffISOCcyFactoryService")
	protected ICFSecISOCcyFactory factoryISOCcy;

	@Autowired
	@Qualifier("cfsec31BuffISOCtryFactoryService")
	protected ICFSecISOCtryFactory factoryISOCtry;

	@Autowired
	@Qualifier("cfsec31BuffISOCtryCcyFactoryService")
	protected ICFSecISOCtryCcyFactory factoryISOCtryCcy;

	@Autowired
	@Qualifier("cfsec31BuffISOCtryLangFactoryService")
	protected ICFSecISOCtryLangFactory factoryISOCtryLang;

	@Autowired
	@Qualifier("cfsec31BuffISOLangFactoryService")
	protected ICFSecISOLangFactory factoryISOLang;

	@Autowired
	@Qualifier("cfsec31BuffISOTZoneFactoryService")
	protected ICFSecISOTZoneFactory factoryISOTZone;

	@Autowired
	@Qualifier("cfsec31BuffSecClusGrpFactoryService")
	protected ICFSecSecClusGrpFactory factorySecClusGrp;

	@Autowired
	@Qualifier("cfsec31BuffSecClusGrpMembFactoryService")
	protected ICFSecSecClusGrpMembFactory factorySecClusGrpMemb;

	@Autowired
	@Qualifier("cfsec31BuffSecClusRoleFactoryService")
	protected ICFSecSecClusRoleFactory factorySecClusRole;

	@Autowired
	@Qualifier("cfsec31BuffSecClusRoleMembFactoryService")
	protected ICFSecSecClusRoleMembFactory factorySecClusRoleMemb;

	@Autowired
	@Qualifier("cfsec31BuffSecSessionFactoryService")
	protected ICFSecSecSessionFactory factorySecSession;

	@Autowired
	@Qualifier("cfsec31BuffSecSysGrpFactoryService")
	protected ICFSecSecSysGrpFactory factorySecSysGrp;

	@Autowired
	@Qualifier("cfsec31BuffSecSysGrpIncFactoryService")
	protected ICFSecSecSysGrpIncFactory factorySecSysGrpInc;

	@Autowired
	@Qualifier("cfsec31BuffSecSysGrpMembFactoryService")
	protected ICFSecSecSysGrpMembFactory factorySecSysGrpMemb;

	@Autowired
	@Qualifier("cfsec31BuffSecSysRoleFactoryService")
	protected ICFSecSecSysRoleFactory factorySecSysRole;

	@Autowired
	@Qualifier("cfsec31BuffSecSysRoleEnablesFactoryService")
	protected ICFSecSecSysRoleEnablesFactory factorySecSysRoleEnables;

	@Autowired
	@Qualifier("cfsec31BuffSecSysRoleMembFactoryService")
	protected ICFSecSecSysRoleMembFactory factorySecSysRoleMemb;

	@Autowired
	@Qualifier("cfsec31BuffSecTentGrpFactoryService")
	protected ICFSecSecTentGrpFactory factorySecTentGrp;

	@Autowired
	@Qualifier("cfsec31BuffSecTentGrpMembFactoryService")
	protected ICFSecSecTentGrpMembFactory factorySecTentGrpMemb;

	@Autowired
	@Qualifier("cfsec31BuffSecTentRoleFactoryService")
	protected ICFSecSecTentRoleFactory factorySecTentRole;

	@Autowired
	@Qualifier("cfsec31BuffSecTentRoleMembFactoryService")
	protected ICFSecSecTentRoleMembFactory factorySecTentRoleMemb;

	@Autowired
	@Qualifier("cfsec31BuffSecUserFactoryService")
	protected ICFSecSecUserFactory factorySecUser;

	@Autowired
	@Qualifier("cfsec31BuffSecUserEMConfFactoryService")
	protected ICFSecSecUserEMConfFactory factorySecUserEMConf;

	@Autowired
	@Qualifier("cfsec31BuffSecUserPWHistoryFactoryService")
	protected ICFSecSecUserPWHistoryFactory factorySecUserPWHistory;

	@Autowired
	@Qualifier("cfsec31BuffSecUserPWResetFactoryService")
	protected ICFSecSecUserPWResetFactory factorySecUserPWReset;

	@Autowired
	@Qualifier("cfsec31BuffSecUserPasswordFactoryService")
	protected ICFSecSecUserPasswordFactory factorySecUserPassword;

	@Autowired
	@Qualifier("cfsec31BuffSysClusterFactoryService")
	protected ICFSecSysClusterFactory factorySysCluster;

	@Autowired
	@Qualifier("cfsec31BuffTableInfoFactoryService")
	protected ICFSecTableInfoFactory factoryTableInfo;

	@Autowired
	@Qualifier("cfsec31BuffTenantFactoryService")
	protected ICFSecTenantFactory factoryTenant;


	public CFSecBuffFactoryService() { }

	@Override
	public ICFSecClusterFactory getFactoryCluster() {
		return( factoryCluster );
	}

	@Override
	public ICFSecISOCcyFactory getFactoryISOCcy() {
		return( factoryISOCcy );
	}

	@Override
	public ICFSecISOCtryFactory getFactoryISOCtry() {
		return( factoryISOCtry );
	}

	@Override
	public ICFSecISOCtryCcyFactory getFactoryISOCtryCcy() {
		return( factoryISOCtryCcy );
	}

	@Override
	public ICFSecISOCtryLangFactory getFactoryISOCtryLang() {
		return( factoryISOCtryLang );
	}

	@Override
	public ICFSecISOLangFactory getFactoryISOLang() {
		return( factoryISOLang );
	}

	@Override
	public ICFSecISOTZoneFactory getFactoryISOTZone() {
		return( factoryISOTZone );
	}

	@Override
	public ICFSecSecClusGrpFactory getFactorySecClusGrp() {
		return( factorySecClusGrp );
	}

	@Override
	public ICFSecSecClusGrpMembFactory getFactorySecClusGrpMemb() {
		return( factorySecClusGrpMemb );
	}

	@Override
	public ICFSecSecClusRoleFactory getFactorySecClusRole() {
		return( factorySecClusRole );
	}

	@Override
	public ICFSecSecClusRoleMembFactory getFactorySecClusRoleMemb() {
		return( factorySecClusRoleMemb );
	}

	@Override
	public ICFSecSecSessionFactory getFactorySecSession() {
		return( factorySecSession );
	}

	@Override
	public ICFSecSecSysGrpFactory getFactorySecSysGrp() {
		return( factorySecSysGrp );
	}

	@Override
	public ICFSecSecSysGrpIncFactory getFactorySecSysGrpInc() {
		return( factorySecSysGrpInc );
	}

	@Override
	public ICFSecSecSysGrpMembFactory getFactorySecSysGrpMemb() {
		return( factorySecSysGrpMemb );
	}

	@Override
	public ICFSecSecSysRoleFactory getFactorySecSysRole() {
		return( factorySecSysRole );
	}

	@Override
	public ICFSecSecSysRoleEnablesFactory getFactorySecSysRoleEnables() {
		return( factorySecSysRoleEnables );
	}

	@Override
	public ICFSecSecSysRoleMembFactory getFactorySecSysRoleMemb() {
		return( factorySecSysRoleMemb );
	}

	@Override
	public ICFSecSecTentGrpFactory getFactorySecTentGrp() {
		return( factorySecTentGrp );
	}

	@Override
	public ICFSecSecTentGrpMembFactory getFactorySecTentGrpMemb() {
		return( factorySecTentGrpMemb );
	}

	@Override
	public ICFSecSecTentRoleFactory getFactorySecTentRole() {
		return( factorySecTentRole );
	}

	@Override
	public ICFSecSecTentRoleMembFactory getFactorySecTentRoleMemb() {
		return( factorySecTentRoleMemb );
	}

	@Override
	public ICFSecSecUserFactory getFactorySecUser() {
		return( factorySecUser );
	}

	@Override
	public ICFSecSecUserEMConfFactory getFactorySecUserEMConf() {
		return( factorySecUserEMConf );
	}

	@Override
	public ICFSecSecUserPWHistoryFactory getFactorySecUserPWHistory() {
		return( factorySecUserPWHistory );
	}

	@Override
	public ICFSecSecUserPWResetFactory getFactorySecUserPWReset() {
		return( factorySecUserPWReset );
	}

	@Override
	public ICFSecSecUserPasswordFactory getFactorySecUserPassword() {
		return( factorySecUserPassword );
	}

	@Override
	public ICFSecSysClusterFactory getFactorySysCluster() {
		return( factorySysCluster );
	}

	@Override
	public ICFSecTableInfoFactory getFactoryTableInfo() {
		return( factoryTableInfo );
	}

	@Override
	public ICFSecTenantFactory getFactoryTenant() {
		return( factoryTenant );
	}

}
