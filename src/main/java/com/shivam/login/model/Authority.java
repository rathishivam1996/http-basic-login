package com.shivam.login.model;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {
	private static final long serialVersionUID = -5684691522053034674L;

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "authority", nullable = false)
	private String authority;

	public Authority() {
	}

	public Authority(AuthorityEnum authority) {
		this.authority = authority.name();
	}

	@Override
	public String getAuthority() {
		return authority;
	}
}
