package com.shivam.login.model;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.sql.Timestamp;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Role.class)
public abstract class Role_ {

	public static volatile SingularAttribute<Role, Integer> optLock;
	public static volatile SingularAttribute<Role, String> authority;
	public static volatile SingularAttribute<Role, String> uuid;
	public static volatile SetAttribute<Role, Authority> allowedAuthorities;
	public static volatile SingularAttribute<Role, Timestamp> createdOn;

	public static final String OPT_LOCK = "optLock";
	public static final String AUTHORITY = "authority";
	public static final String UUID = "uuid";
	public static final String ALLOWED_AUTHORITIES = "allowedAuthorities";
	public static final String CREATED_ON = "createdOn";

}

