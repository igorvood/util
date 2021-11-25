package ru.vood.util.db.oracle

import oracle.jdbc.OracleConnection

class OraDriverSpecific(private val connectionLocalProperty: ConnectionLocalProperty) {

    fun createArray(type: DbUDT, conn: java.sql.Connection, map: Map<String, String?> = mapOf()): java.sql.Array {
        return conn.unwrap(OracleConnection::class.java).createARRAY(
            "${connectionLocalProperty.owner}.${type.name}",
            map.map { arrayOf(it.key, it.value) }
                .toTypedArray()
        )
    }

    fun createArray(type: DbUDT, conn: java.sql.Connection, set: Set<Any?> = setOf()): java.sql.Array =
        conn.unwrap(OracleConnection::class.java).createARRAY(
            "${connectionLocalProperty.owner}.${type.name}",
            set.toTypedArray()
        )

    fun createArray(type: DbUDT, conn: java.sql.Connection, list: List<Array<Any?>> = listOf()): java.sql.Array =
        conn.unwrap(OracleConnection::class.java).createARRAY(
            "${connectionLocalProperty.owner}.${type.name}",
            list.toTypedArray()
        )

}