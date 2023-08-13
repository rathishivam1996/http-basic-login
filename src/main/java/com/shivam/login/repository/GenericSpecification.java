package com.shivam.login.repository;


import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;

public class GenericSpecification {
    public static <T> Specification<T> attributeContains(String attributeName, String keyword) {
        return (root, query, builder) ->
                builder.like(builder.lower(root.get(attributeName)),
                        "%" + keyword.toLowerCase() + "%");
    }

    public static <T> Specification<T> attributeEqual(String attributeName, String keyword) {
        return (root, query, builder) ->
                builder.equal(root.get(attributeName),
                        keyword);
    }

    public static <T> Specification<T> attributeBetween(String attributeName, Instant from, Instant to) {
        return (root, query, builder) ->
                builder.between(root.get(attributeName),
                        from, to);
    }
}
