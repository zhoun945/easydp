package com.freedom.easydp.generator;

/**
 * 查询SQL
 *
 * @author nan.zhou
 * @date 2018-09-12
 */
public enum QuerySQL {

    MYSQL("SHOW TABLES", "SHOW TABLE STATUS", "SHOW FULL FIELDS FROM %s"),

    ORACLE("SELECT * FROM USER_TABLES", "SELECT * FROM USER_TAB_COMMENTS",
            "SELECT A.COLUMN_NAME, CASE WHEN A.DATA_TYPE='NUMBER' THEN " +
            "(CASE WHEN A.DATA_PRECISION IS NULL THEN A.DATA_TYPE " +
            "WHEN NVL(A.DATA_SCALE, 0) > 0 THEN A.DATA_TYPE||'('||A.DATA_PRECISION||','||A.DATA_SCALE||')' " +
            "ELSE A.DATA_TYPE||'('||A.DATA_PRECISION||')' END) " +
            "ELSE A.DATA_TYPE END DATA_TYPE, B.COMMENTS,DECODE(C.POSITION, '1', 'PRI') KEY " +
            "FROM USER_TAB_COLUMNS A INNER JOIN USER_COL_COMMENTS B ON A.TABLE_NAME = B.TABLE_NAME" +
            " AND A.COLUMN_NAME = B.COLUMN_NAME LEFT JOIN USER_CONSTRAINTS D " +
            "ON D.TABLE_NAME = A.TABLE_NAME AND D.CONSTRAINT_TYPE = 'P' " +
            "LEFT JOIN USER_CONS_COLUMNS C ON C.CONSTRAINT_NAME = D.CONSTRAINT_NAME " +
            "AND C.COLUMN_NAME=A.COLUMN_NAME WHERE A.TABLE_NAME = '%s'");

    QuerySQL(String tableSql, String tableCommentSql, String columnSql) {
        this.tableSql = tableSql;
        this.tableCommentSql = tableCommentSql;
        this.columnSql = columnSql;
    }

    private String tableSql;
    private String tableCommentSql;
    private String columnSql;

    public String getTableSql() {
        return tableSql;
    }

    public String getTableCommentSql() {
        return tableCommentSql;
    }

    public String getColumnSql(String tableName) {
        return String.format(columnSql, tableName);
    }
}
