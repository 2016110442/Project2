package com.project1.controller.logging;

public class MySQLBuilder {

	static String buildInsertSQL(MyDBNameResolver dbNameResolver) {
		StringBuilder sqlBuilder = new StringBuilder("INSERT INTO ");
		sqlBuilder.append(dbNameResolver.getTableName(LogTableName.logging_information)).append(" (");
		sqlBuilder.append(dbNameResolver.getColumnName(LogColumnName.e_id)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(LogColumnName.c_way)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(LogColumnName.request)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(LogColumnName.r_way)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(LogColumnName.parms)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(LogColumnName.o_way)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(LogColumnName.o_sql)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(LogColumnName.o_date)).append(", ");
		sqlBuilder.append(dbNameResolver.getColumnName(LogColumnName.ip)).append(") ");
		sqlBuilder.append("VALUES (?,?,?,?,?,?,?,?,?)");
		return sqlBuilder.toString();
	}


}
