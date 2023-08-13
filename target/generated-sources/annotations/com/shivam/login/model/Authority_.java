package com.shivam.login.model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.sql.Timestamp;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Authority.class)
public abstract class Authority_ {

	public static volatile SingularAttribute<Authority, Integer> optLock;
	public static volatile SingularAttribute<Authority, String> authority;
	public static volatile SingularAttribute<Authority, String> uuid;
	public static volatile SingularAttribute<Authority, Timestamp> createdOn;

	public static final String OPT_LOCK = "optLock";
	public static final String AUTHORITY = "authority";
	public static final String UUID = "uuid";
	public static final String CREATED_ON = "createdOn";

}

