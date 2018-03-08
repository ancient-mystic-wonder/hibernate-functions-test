package com.dtlim.dialect;

import org.hibernate.dialect.PostgreSQL9Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

public class CustomPostgreSQL9Dialect extends PostgreSQL9Dialect {
    public CustomPostgreSQL9Dialect() {
        super();
        registerCustomFunctions();
    }

    private void registerCustomFunctions() {
        registerFunction("TO_CUSTOM_DATE",
                new SQLFunctionTemplate(StandardBasicTypes.DATE, "TO_DATE(?1, 'YYYYMMDDHH24MISS')"));
    }
}
