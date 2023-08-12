package com.shivam.login.repository;

import com.shivam.login.model.JpaUser;
import com.shivam.login.model.JpaUser_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serial;
import java.time.Instant;

public class AuthoritySpecifications {
    public static class CreatedAtBetweenSpec implements Specification<JpaUser> {
        @Serial
        private static final long serialVersionUID = 7893286417970897700L;
        private final Instant from;
        private final Instant to;

        public CreatedAtBetweenSpec(Instant from, Instant to) {
            this.to = to;
            this.from = from;
        }

        @Override
        public Predicate toPredicate(Root<JpaUser> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.between(root.get(JpaUser_.CREATED_AT), from, to);
        }
    }
}
