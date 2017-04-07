package org.mvnsearch.spring.boot.exposed.demo.model

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.LongIdTable

/**
 * user module
 *
 * @author linux_china
 */

class User(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<User>(Users)

    var nick by Users.nick
    val password by Users.password
}

/**
 * Users table
 *
 * @author linux_china
 */
object Users : LongIdTable() {
    val nick = varchar("nick", length = 32)
    val password = varchar("passwd", length = 32)
}
