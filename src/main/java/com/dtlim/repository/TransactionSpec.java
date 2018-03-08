package com.dtlim.repository;

import com.dtlim.domain.Transaction;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class TransactionSpec {

    public static Specification<Transaction> referenceNumber(String referenceNumber) {
        return (root, query, cb) -> cb.equal(root.get("referenceNumber"), referenceNumber);
    }

    public static Specification<Transaction> loggedBetween(Date before, Date after) {
        return (root, query, cb) -> cb.between(
                cb.function("TO_DATE", Date.class, root.get("logTime"), cb.literal("YYYYMMDDHH24MISS")),
                before,
                after
        );
    }

    public static Specification<Transaction> loggedBetweenCustom(Date before, Date after) {
        return (root, query, cb) -> cb.between(
                cb.function("TO_CUSTOM_DATE", Date.class, root.get("logTime")),
                before,
                after
        );
    }
}
