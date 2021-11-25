package ru.vood.util.db.oracle

import java.sql.Array

enum class DbUDT {
    CMN_STR_TAB,
    CMN_STR_PAIR_TAB
}


sealed interface DbCollection<T>{
    val collection: (Iterable<T>)->(Array)
}

class CmnStrTab : DbCollection<String> {
    override val collection: (Iterable<String>) -> Array
        get() = TODO("Not yet implemented")

}