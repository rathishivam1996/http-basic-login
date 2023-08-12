package com.shivam.login.repository;

import com.shivam.login.model.JpaUser;
import com.shivam.login.model.JpaUser_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.io.Serial;
import java.time.Instant;

import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {

    public static class NameLikeSpec implements Specification<JpaUser> {
        @Serial
        private static final long serialVersionUID = 339845254090942701L;
        private final String name;

        public NameLikeSpec(String name) {
            this.name = name;
        }

        @Override
        public Predicate toPredicate(Root<JpaUser> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.like(root.get(JpaUser_.USERNAME), "%" + name + "%");
        }
    }

    public static class NameEqualSpec implements Specification<JpaUser> {
        @Serial
        private static final long serialVersionUID = 7893286417970897700L;
        private final String name;

        public NameEqualSpec(String name) {
            this.name = name;
        }

        @Override
        public Predicate toPredicate(Root<JpaUser> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.equal(root.get(JpaUser_.USERNAME), name);
        }
    }

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

    public static class UpdatedAtBetweenSpec implements Specification<JpaUser> {
        @Serial
        private static final long serialVersionUID = 7893286417970897700L;
        private final Instant from;
        private final Instant to;

        public UpdatedAtBetweenSpec(Instant from, Instant to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public Predicate toPredicate(Root<JpaUser> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.between(root.get(JpaUser_.UPDATED_AT), from, to);
        }
    }

    public static class DeleteByUsernameSpec implements Specification<JpaUser> {
        @Serial
        private static final long serialVersionUID = 7893286417970897700L;
        private final String username;

        public DeleteByUsernameSpec(String username) {
            this.username = username;
        }

        @Override
        public Predicate toPredicate(Root<JpaUser> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            return criteriaBuilder.equal(root.get(JpaUser_.USERNAME), username);
        }
    }
}
