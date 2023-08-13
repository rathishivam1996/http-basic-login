package com.shivam.login.model;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.sql.Timestamp;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(JpaUser.class)
public abstract class JpaUser_ {

	public static volatile SingularAttribute<JpaUser, Timestamp> createdAt;
	public static volatile SingularAttribute<JpaUser, String> password;
	public static volatile SingularAttribute<JpaUser, Boolean> isAccountNonExpired;
	public static volatile SingularAttribute<JpaUser, Boolean> isCredentialsNonExpired;
	public static volatile SingularAttribute<JpaUser, Integer> optLock;
	public static volatile SingularAttribute<JpaUser, Boolean> isEnabled;
	public static volatile SetAttribute<JpaUser, Role> roles;
	public static volatile SingularAttribute<JpaUser, Boolean> isAccountNonLocked;
	public static volatile SingularAttribute<JpaUser, String> uuid;
	public static volatile SingularAttribute<JpaUser, String> username;
	public static volatile SingularAttribute<JpaUser, Timestamp> updatedAt;

	public static final String CREATED_AT = "createdAt";
	public static final String PASSWORD = "password";
	public static final String IS_ACCOUNT_NON_EXPIRED = "isAccountNonExpired";
	public static final String IS_CREDENTIALS_NON_EXPIRED = "isCredentialsNonExpired";
	public static final String OPT_LOCK = "optLock";
	public static final String IS_ENABLED = "isEnabled";
	public static final String ROLES = "roles";
	public static final String IS_ACCOUNT_NON_LOCKED = "isAccountNonLocked";
	public static final String UUID = "uuid";
	public static final String USERNAME = "username";
	public static final String UPDATED_AT = "updatedAt";

}

