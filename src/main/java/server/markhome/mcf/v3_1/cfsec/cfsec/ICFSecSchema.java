// Description: Java 25 interface for a CFSec schema.

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
import java.nio.charset.StandardCharsets;
import java.math.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.*;
import java.util.*;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.xml.CFLibXmlUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import java.util.concurrent.atomic.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public interface ICFSecSchema
{
	public static final String SCHEMA_NAME = "CFSec";
	public static final String DBSCHEMA_NAME = "CFSec31";
	static final AtomicReference<ApplicationContext> arApplicationContext = new AtomicReference<>();

	public default void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		arApplicationContext.compareAndSet(arApplicationContext.get(), applicationContext);
	}

	public static ApplicationContext getApplicationContext() {
		return( arApplicationContext.get() );
	}

	public static interface BackingRecConstructor {
		public Object instantiate();
	}
	
	public static class ClassMapEntry {
		final String schemaName;
		final String tableName;
		final int backingClassCode;
		int runtimeClassCode;
		BackingRecConstructor cbRecConstructor;
		
		public ClassMapEntry(String schemaName, String tableName, int backingClassCode) {
			this.schemaName = schemaName;
			this.tableName = tableName;
			this.backingClassCode = backingClassCode;
			runtimeClassCode = 0;
			cbRecConstructor = null;
		}
		
		public String getSchemaName() { return schemaName; }
		public String getTableName() { return tableName; }
		public int getBackingClassCode() { return backingClassCode; }

		public int getRuntimeClassCode() { return runtimeClassCode; }
		public void setRuntimeClassCode(int runtimeClassCode) { this.runtimeClassCode = runtimeClassCode; }
		
		public BackingRecConstructor getBackingRecConstructor() { return cbRecConstructor; }
		public void setBackingRecConstructor(BackingRecConstructor backingRecConstructor) { this.cbRecConstructor = backingRecConstructor; }
	}

		final static ArrayList<ICFSecSchema.ClassMapEntry> entries = new ArrayList<>();
		final static HashMap<Integer,ICFSecSchema.ClassMapEntry> mapBackingClassCodeToEntry = new HashMap<>();
		final static HashMap<Integer,ICFSecSchema.ClassMapEntry> mapRuntimeClassCodeToEntry = new HashMap<>();
		final static AtomicReference<ICFSecSchema> backingCFSec = new AtomicReference<>();
	public enum AuditActionEnum {
		Created,
		Updated,
		Deleted,
		Mutated
	};

	static HashMap<String,AuditActionEnum> lookupAuditActionEnum = new HashMap<String,AuditActionEnum>();

	public static AuditActionEnum parseAuditActionEnum( String value ) {
		AuditActionEnum retval = parseAuditActionEnum( ICFSecSchema.class.getName(), value );
		return( retval );
	}

	public static AuditActionEnum parseAuditActionEnum( String fieldOrClassName, String value ) {
		final String S_ProcName = "parseAuditActionEnum";
		if( lookupAuditActionEnum.isEmpty() ) {
			lookupAuditActionEnum.put( "Created", AuditActionEnum.Created );
			lookupAuditActionEnum.put( "Updated", AuditActionEnum.Updated );
			lookupAuditActionEnum.put( "Deleted", AuditActionEnum.Deleted );
			lookupAuditActionEnum.put( "Mutated", AuditActionEnum.Mutated );
		}
		AuditActionEnum retval;
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			retval = null;
		}
		else {
			retval = lookupAuditActionEnum.get( value );
			if( retval == null ) {
				throw new CFLibInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	static HashMap<Integer,AuditActionEnum> lookupOrdinalAuditActionEnum = new HashMap<Integer,AuditActionEnum>();

	public static AuditActionEnum ordinalToAuditActionEnum( String fieldOrClassName, Short value ) {
		AuditActionEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToAuditActionEnum( fieldOrClassName, Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static AuditActionEnum ordinalToAuditActionEnum( Short value ) {
		AuditActionEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToAuditActionEnum( Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static AuditActionEnum ordinalToAuditActionEnum( Integer value ) {
		AuditActionEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToAuditActionEnum( ICFSecSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static AuditActionEnum ordinalToAuditActionEnum( String fieldOrClassName, Integer value ) {
		final String S_ProcName = "ordinalToAuditActionEnum";
		if( lookupOrdinalAuditActionEnum.isEmpty() ) {
			lookupOrdinalAuditActionEnum.put( Integer.valueOf( AuditActionEnum.Created.ordinal() ), AuditActionEnum.Created );
			lookupOrdinalAuditActionEnum.put( Integer.valueOf( AuditActionEnum.Updated.ordinal() ), AuditActionEnum.Updated );
			lookupOrdinalAuditActionEnum.put( Integer.valueOf( AuditActionEnum.Deleted.ordinal() ), AuditActionEnum.Deleted );
			lookupOrdinalAuditActionEnum.put( Integer.valueOf( AuditActionEnum.Mutated.ordinal() ), AuditActionEnum.Mutated );
		}
		AuditActionEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = lookupOrdinalAuditActionEnum.get( value );
			if( retval == null ) {
				throw new CFLibInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	public enum SecLevelEnum {
		System,
		Global,
		Cluster,
		Tenant
	};

	static HashMap<String,SecLevelEnum> lookupSecLevelEnum = new HashMap<String,SecLevelEnum>();

	public static SecLevelEnum parseSecLevelEnum( String value ) {
		SecLevelEnum retval = parseSecLevelEnum( ICFSecSchema.class.getName(), value );
		return( retval );
	}

	public static SecLevelEnum parseSecLevelEnum( String fieldOrClassName, String value ) {
		final String S_ProcName = "parseSecLevelEnum";
		if( lookupSecLevelEnum.isEmpty() ) {
			lookupSecLevelEnum.put( "System", SecLevelEnum.System );
			lookupSecLevelEnum.put( "Global", SecLevelEnum.Global );
			lookupSecLevelEnum.put( "Cluster", SecLevelEnum.Cluster );
			lookupSecLevelEnum.put( "Tenant", SecLevelEnum.Tenant );
		}
		SecLevelEnum retval;
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			retval = null;
		}
		else {
			retval = lookupSecLevelEnum.get( value );
			if( retval == null ) {
				throw new CFLibInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	static HashMap<Integer,SecLevelEnum> lookupOrdinalSecLevelEnum = new HashMap<Integer,SecLevelEnum>();

	public static SecLevelEnum ordinalToSecLevelEnum( String fieldOrClassName, Short value ) {
		SecLevelEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecLevelEnum( fieldOrClassName, Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecLevelEnum ordinalToSecLevelEnum( Short value ) {
		SecLevelEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecLevelEnum( Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecLevelEnum ordinalToSecLevelEnum( Integer value ) {
		SecLevelEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecLevelEnum( ICFSecSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecLevelEnum ordinalToSecLevelEnum( String fieldOrClassName, Integer value ) {
		final String S_ProcName = "ordinalToSecLevelEnum";
		if( lookupOrdinalSecLevelEnum.isEmpty() ) {
			lookupOrdinalSecLevelEnum.put( Integer.valueOf( SecLevelEnum.System.ordinal() ), SecLevelEnum.System );
			lookupOrdinalSecLevelEnum.put( Integer.valueOf( SecLevelEnum.Global.ordinal() ), SecLevelEnum.Global );
			lookupOrdinalSecLevelEnum.put( Integer.valueOf( SecLevelEnum.Cluster.ordinal() ), SecLevelEnum.Cluster );
			lookupOrdinalSecLevelEnum.put( Integer.valueOf( SecLevelEnum.Tenant.ordinal() ), SecLevelEnum.Tenant );
		}
		SecLevelEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = lookupOrdinalSecLevelEnum.get( value );
			if( retval == null ) {
				throw new CFLibInvalidArgumentException( fieldOrClassName,
					fieldOrClassName,
					S_ProcName,
					2,
					"value",
					"Invalid enum limb argument " + value,
					"Invalid enum limb argument " + value);
			}
		}
		return( retval );
	}

	static final AtomicReference<CFLibDbKeyHash256> sysClusterId = new AtomicReference<>();
	static final AtomicReference<CFLibDbKeyHash256> sysTenantId = new AtomicReference<>();
	static final AtomicReference<CFLibDbKeyHash256> sysAdminId = new AtomicReference<>();

	public static String getPasswordHash(String pw) {
		if (pw == null || pw.isEmpty()) {
			throw new CFLibNullArgumentException(ICFSecSchema.class, "getPasswordHash", 1, "pw");
		}
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(pw.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
	}

	public static CFLibDbKeyHash256 getSysClusterId() {
		return (sysClusterId.get());
	}

	public static void setSysClusterId(CFLibDbKeyHash256 argClusterId) {
		if (argClusterId == null || argClusterId.isNull()) {
			throw new CFLibNullArgumentException(ICFSecSchema.class, "setSysClusterId", 1, "argClusterId");
		}
		CFLibDbKeyHash256 oldid = sysClusterId.get();
		if (oldid == null) {
			sysClusterId.compareAndSet(null, argClusterId);
		}
		else if (oldid.isNull()) {
			sysClusterId.compareAndSet(oldid, argClusterId);
		}
		else {
			throw new CFLibInvalidArgumentException(ICFSecSchema.class, "setSysClusterId", "sysClusterId has already been set", "sysClusterId has already been set");
		}
	}

	public static CFLibDbKeyHash256 getSysTenantId() {
		return (sysTenantId.get());
	}

	public static void setSysTenantId(CFLibDbKeyHash256 argTenantId) {
		if (argTenantId == null || argTenantId.isNull()) {
			throw new CFLibNullArgumentException(ICFSecSchema.class, "setSysTenantId", 1, "argTenantId");
		}
		CFLibDbKeyHash256 oldid = sysTenantId.get();
		if (oldid == null) {
			sysTenantId.compareAndSet(null, argTenantId);
		}
		else if (oldid.isNull()) {
			sysTenantId.compareAndSet(oldid, argTenantId);
		}
		else {
			throw new CFLibInvalidArgumentException(ICFSecSchema.class, "setSysTenantId", "sysTenantId has already been set", "sysTenantId has already been set");
		}
	}

	public static CFLibDbKeyHash256 getSysAdminId() {
		return (sysAdminId.get());
	}

	public static void setSysAdminId(CFLibDbKeyHash256 argAdminId) {
		if (argAdminId == null || argAdminId.isNull()) {
			throw new CFLibNullArgumentException(ICFSecSchema.class, "setSysAdminId", 1, "argAdminId");
		}
		CFLibDbKeyHash256 oldid = sysAdminId.get();
		if (oldid == null) {
			sysAdminId.compareAndSet(null, argAdminId);
		}
		else if (oldid.isNull()) {
			sysAdminId.compareAndSet(oldid, argAdminId);
		}
		else {
			throw new CFLibInvalidArgumentException(ICFSecSchema.class, "setSysAdminId", "sysAdminId has already been set", "sysAdminId has already been set");
		}
	}

		public static ICFSecSchema getBackingCFSec() {
			return( ICFSecSchema.backingCFSec.get() );
		}
		
		public static void setBackingCFSec(ICFSecSchema backingSchema) {
			ICFSecSchema.backingCFSec.set(backingSchema);
		}
		
		public ICFSecSchema getCFSecSchema();
		public void setCFSecSchema(ICFSecSchema schema);
		
		public static int doInitClassMapEntries(int value) {
			if (ICFSecSchema.entries.isEmpty()) {
				ICFSecSchema.ClassMapEntry entry;
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "Cluster", ICFSecCluster.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "Tenant", ICFSecTenant.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "ISOCcy", ICFSecISOCcy.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "ISOCtry", ICFSecISOCtry.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "ISOCtryCcy", ICFSecISOCtryCcy.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "ISOCtryLang", ICFSecISOCtryLang.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "ISOLang", ICFSecISOLang.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "ISOTZone", ICFSecISOTZone.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "SecUser", ICFSecSecUser.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "SecUserPassword", ICFSecSecUserPassword.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "SecUserEMConf", ICFSecSecUserEMConf.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "SecUserPWReset", ICFSecSecUserPWReset.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "SecUserPWHistory", ICFSecSecUserPWHistory.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "SecSysGrp", ICFSecSecSysGrp.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "SecSysGrpInc", ICFSecSecSysGrpInc.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "SecSysGrpMemb", ICFSecSecSysGrpMemb.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "SecClusGrp", ICFSecSecClusGrp.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "SecClusGrpInc", ICFSecSecClusGrpInc.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "SecClusGrpMemb", ICFSecSecClusGrpMemb.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "SecTentGrp", ICFSecSecTentGrp.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "SecTentGrpInc", ICFSecSecTentGrpInc.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "SecTentGrpMemb", ICFSecSecTentGrpMemb.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "SecSession", ICFSecSecSession.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				entry = new ICFSecSchema.ClassMapEntry(ICFSecSchema.SCHEMA_NAME, "SysCluster", ICFSecSysCluster.CLASS_CODE);
				ICFSecSchema.entries.add(entry);
				for( ICFSecSchema.ClassMapEntry cur: ICFSecSchema.entries) {
					cur.setRuntimeClassCode(value++);
				}
				ICFSecSchema.mapBackingClassCodeToEntry.clear();
				ICFSecSchema.mapRuntimeClassCodeToEntry.clear();
				for( ICFSecSchema.ClassMapEntry cur: ICFSecSchema.entries) {
					ICFSecSchema.mapBackingClassCodeToEntry.put(cur.getBackingClassCode(), cur);
					ICFSecSchema.mapRuntimeClassCodeToEntry.put(cur.getRuntimeClassCode(), cur);
				}
			}
			return(value);
		}
		
		public static ICFSecSchema.ClassMapEntry getClassMapByBackingClassCode(int code) {
			ICFSecSchema.ClassMapEntry entry;
			entry = ICFSecSchema.mapBackingClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			return( null );
		}
		
		public static ICFSecSchema.ClassMapEntry getClassMapByRuntimeClassCode(int code) {
			ICFSecSchema.ClassMapEntry entry;
			entry = ICFSecSchema.mapRuntimeClassCodeToEntry.get(code);
			if (entry != null) {
				return( entry );
			}
			return( null );
		}
		
		public int initClassMapEntries(int value);
		public void wireRecConstructors();
		public void wireTableTableInstances();

	/**
	 *	Allocate a new schema instance.
	 *
	 *	@return	A new ICFSecSchema instance.
	 */
	public ICFSecSchema newSchema();

	/**
	 *	Get the next ISOCcyIdGen identifier.
	 *
	 *	@return	The next ISOCcyIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCcyIdGen();

	/**
	 *	Get the next ISOCtryIdGen identifier.
	 *
	 *	@return	The next ISOCtryIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCtryIdGen();

	/**
	 *	Get the next ISOLangIdGen identifier.
	 *
	 *	@return	The next ISOLangIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOLangIdGen();

	/**
	 *	Get the next ISOTZoneIdGen identifier.
	 *
	 *	@return	The next ISOTZoneIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOTZoneIdGen();

	/**
	 *	Get the next ClusterIdGen identifier.
	 *
	 *	@return	The next ClusterIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextClusterIdGen();

	/**
	 *	Get the next SecSessionIdGen identifier.
	 *
	 *	@return	The next SecSessionIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecSessionIdGen();

	/**
	 *	Get the next SecUserIdGen identifier.
	 *
	 *	@return	The next SecUserIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecUserIdGen();

	/**
	 *	Get the next TenantIdGen identifier.
	 *
	 *	@return	The next TenantIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextTenantIdGen();

	/**
	 *	Get the next SecSysGrpIdGen identifier.
	 *
	 *	@return	The next SecSysGrpIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecSysGrpIdGen();

	/**
	 *	Get the next SecClusGrpIdGen identifier.
	 *
	 *	@return	The next SecClusGrpIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecClusGrpIdGen();

	/**
	 *	Get the next SecTentGrpIdGen identifier.
	 *
	 *	@return	The next SecTentGrpIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecTentGrpIdGen();

	/**
	 *	Get the Cluster Table interface for the schema.
	 *
	 *	@return	The Cluster Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecClusterTable getTableCluster();

	/**
	 *	Get the Cluster Factory interface for the schema.
	 *
	 *	@return	The Cluster Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecClusterFactory getFactoryCluster();

	/**
	 *	Get the ISOCcy Table interface for the schema.
	 *
	 *	@return	The ISOCcy Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecISOCcyTable getTableISOCcy();

	/**
	 *	Get the ISOCcy Factory interface for the schema.
	 *
	 *	@return	The ISOCcy Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecISOCcyFactory getFactoryISOCcy();

	/**
	 *	Get the ISOCtry Table interface for the schema.
	 *
	 *	@return	The ISOCtry Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecISOCtryTable getTableISOCtry();

	/**
	 *	Get the ISOCtry Factory interface for the schema.
	 *
	 *	@return	The ISOCtry Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecISOCtryFactory getFactoryISOCtry();

	/**
	 *	Get the ISOCtryCcy Table interface for the schema.
	 *
	 *	@return	The ISOCtryCcy Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecISOCtryCcyTable getTableISOCtryCcy();

	/**
	 *	Get the ISOCtryCcy Factory interface for the schema.
	 *
	 *	@return	The ISOCtryCcy Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecISOCtryCcyFactory getFactoryISOCtryCcy();

	/**
	 *	Get the ISOCtryLang Table interface for the schema.
	 *
	 *	@return	The ISOCtryLang Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecISOCtryLangTable getTableISOCtryLang();

	/**
	 *	Get the ISOCtryLang Factory interface for the schema.
	 *
	 *	@return	The ISOCtryLang Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecISOCtryLangFactory getFactoryISOCtryLang();

	/**
	 *	Get the ISOLang Table interface for the schema.
	 *
	 *	@return	The ISOLang Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecISOLangTable getTableISOLang();

	/**
	 *	Get the ISOLang Factory interface for the schema.
	 *
	 *	@return	The ISOLang Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecISOLangFactory getFactoryISOLang();

	/**
	 *	Get the ISOTZone Table interface for the schema.
	 *
	 *	@return	The ISOTZone Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecISOTZoneTable getTableISOTZone();

	/**
	 *	Get the ISOTZone Factory interface for the schema.
	 *
	 *	@return	The ISOTZone Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecISOTZoneFactory getFactoryISOTZone();

	/**
	 *	Get the SecClusGrp Table interface for the schema.
	 *
	 *	@return	The SecClusGrp Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecClusGrpTable getTableSecClusGrp();

	/**
	 *	Get the SecClusGrp Factory interface for the schema.
	 *
	 *	@return	The SecClusGrp Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecClusGrpFactory getFactorySecClusGrp();

	/**
	 *	Get the SecClusGrpInc Table interface for the schema.
	 *
	 *	@return	The SecClusGrpInc Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecClusGrpIncTable getTableSecClusGrpInc();

	/**
	 *	Get the SecClusGrpInc Factory interface for the schema.
	 *
	 *	@return	The SecClusGrpInc Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecClusGrpIncFactory getFactorySecClusGrpInc();

	/**
	 *	Get the SecClusGrpMemb Table interface for the schema.
	 *
	 *	@return	The SecClusGrpMemb Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecClusGrpMembTable getTableSecClusGrpMemb();

	/**
	 *	Get the SecClusGrpMemb Factory interface for the schema.
	 *
	 *	@return	The SecClusGrpMemb Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecClusGrpMembFactory getFactorySecClusGrpMemb();

	/**
	 *	Get the SecSession Table interface for the schema.
	 *
	 *	@return	The SecSession Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecSessionTable getTableSecSession();

	/**
	 *	Get the SecSession Factory interface for the schema.
	 *
	 *	@return	The SecSession Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecSessionFactory getFactorySecSession();

	/**
	 *	Get the SecSysGrp Table interface for the schema.
	 *
	 *	@return	The SecSysGrp Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecSysGrpTable getTableSecSysGrp();

	/**
	 *	Get the SecSysGrp Factory interface for the schema.
	 *
	 *	@return	The SecSysGrp Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecSysGrpFactory getFactorySecSysGrp();

	/**
	 *	Get the SecSysGrpInc Table interface for the schema.
	 *
	 *	@return	The SecSysGrpInc Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecSysGrpIncTable getTableSecSysGrpInc();

	/**
	 *	Get the SecSysGrpInc Factory interface for the schema.
	 *
	 *	@return	The SecSysGrpInc Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecSysGrpIncFactory getFactorySecSysGrpInc();

	/**
	 *	Get the SecSysGrpMemb Table interface for the schema.
	 *
	 *	@return	The SecSysGrpMemb Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecSysGrpMembTable getTableSecSysGrpMemb();

	/**
	 *	Get the SecSysGrpMemb Factory interface for the schema.
	 *
	 *	@return	The SecSysGrpMemb Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecSysGrpMembFactory getFactorySecSysGrpMemb();

	/**
	 *	Get the SecTentGrp Table interface for the schema.
	 *
	 *	@return	The SecTentGrp Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecTentGrpTable getTableSecTentGrp();

	/**
	 *	Get the SecTentGrp Factory interface for the schema.
	 *
	 *	@return	The SecTentGrp Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecTentGrpFactory getFactorySecTentGrp();

	/**
	 *	Get the SecTentGrpInc Table interface for the schema.
	 *
	 *	@return	The SecTentGrpInc Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecTentGrpIncTable getTableSecTentGrpInc();

	/**
	 *	Get the SecTentGrpInc Factory interface for the schema.
	 *
	 *	@return	The SecTentGrpInc Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecTentGrpIncFactory getFactorySecTentGrpInc();

	/**
	 *	Get the SecTentGrpMemb Table interface for the schema.
	 *
	 *	@return	The SecTentGrpMemb Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecTentGrpMembTable getTableSecTentGrpMemb();

	/**
	 *	Get the SecTentGrpMemb Factory interface for the schema.
	 *
	 *	@return	The SecTentGrpMemb Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecTentGrpMembFactory getFactorySecTentGrpMemb();

	/**
	 *	Get the SecUser Table interface for the schema.
	 *
	 *	@return	The SecUser Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecUserTable getTableSecUser();

	/**
	 *	Get the SecUser Factory interface for the schema.
	 *
	 *	@return	The SecUser Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecUserFactory getFactorySecUser();

	/**
	 *	Get the SecUserEMConf Table interface for the schema.
	 *
	 *	@return	The SecUserEMConf Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecUserEMConfTable getTableSecUserEMConf();

	/**
	 *	Get the SecUserEMConf Factory interface for the schema.
	 *
	 *	@return	The SecUserEMConf Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecUserEMConfFactory getFactorySecUserEMConf();

	/**
	 *	Get the SecUserPWHistory Table interface for the schema.
	 *
	 *	@return	The SecUserPWHistory Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecUserPWHistoryTable getTableSecUserPWHistory();

	/**
	 *	Get the SecUserPWHistory Factory interface for the schema.
	 *
	 *	@return	The SecUserPWHistory Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecUserPWHistoryFactory getFactorySecUserPWHistory();

	/**
	 *	Get the SecUserPWReset Table interface for the schema.
	 *
	 *	@return	The SecUserPWReset Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecUserPWResetTable getTableSecUserPWReset();

	/**
	 *	Get the SecUserPWReset Factory interface for the schema.
	 *
	 *	@return	The SecUserPWReset Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecUserPWResetFactory getFactorySecUserPWReset();

	/**
	 *	Get the SecUserPassword Table interface for the schema.
	 *
	 *	@return	The SecUserPassword Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecUserPasswordTable getTableSecUserPassword();

	/**
	 *	Get the SecUserPassword Factory interface for the schema.
	 *
	 *	@return	The SecUserPassword Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSecUserPasswordFactory getFactorySecUserPassword();

	/**
	 *	Get the SysCluster Table interface for the schema.
	 *
	 *	@return	The SysCluster Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSysClusterTable getTableSysCluster();

	/**
	 *	Get the SysCluster Factory interface for the schema.
	 *
	 *	@return	The SysCluster Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecSysClusterFactory getFactorySysCluster();

	/**
	 *	Get the Tenant Table interface for the schema.
	 *
	 *	@return	The Tenant Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecTenantTable getTableTenant();

	/**
	 *	Get the Tenant Factory interface for the schema.
	 *
	 *	@return	The Tenant Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public ICFSecTenantFactory getFactoryTenant();

	/**
	 *	Get the Table Permissions interface for the schema.
	 *
	 *	@return	The Table Permissions interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	//public static ICFSecTablePerms getTablePerms();

	/**
	 *	Get the Table Permissions interface cast to this schema's implementation.
	 *
	 *	@return The Table Permissions interface for this schema.
	 */
	//public static ICFSecTablePerms getCFSecTablePerms();

	/**
	 *	Set the Table Permissions interface for the schema.  All fractal subclasses of
	 *	the ICFSecTablePerms implement at least that interface plus their own
	 *	accessors.
	 *
	 *	@param	value	The Table Permissions interface to be used by the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	//public static void setTablePerms( ICFSecTablePerms value );

	public void bootstrapSchema();
}
