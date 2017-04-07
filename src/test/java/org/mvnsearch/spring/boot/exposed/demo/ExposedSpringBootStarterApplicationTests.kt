package org.mvnsearch.spring.boot.exposed.demo

import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.junit.Test
import org.junit.runner.RunWith
import org.mvnsearch.spring.boot.exposed.demo.model.User
import org.mvnsearch.spring.boot.exposed.demo.model.Users
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
open class ExposedSpringBootStarterApplicationTests {
    @Test
    fun contextLoads() {
        SchemaUtils.create(Users)

        Users.insert {
            it[nick] = "jackie"
            it[password] = "123456"
        }

        val jackie = User.find { Users.nick eq "jackie" }.first()
        println(jackie.nick)
    }

}
