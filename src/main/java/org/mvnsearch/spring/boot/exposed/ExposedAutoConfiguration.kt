package org.mvnsearch.spring.boot.exposed

import org.jetbrains.exposed.spring.SpringTransactionManager
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.DEFAULT_ISOLATION_LEVEL
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct

import javax.sql.DataSource

/**
 * exposed auto configuration

 * @author linux_china
 */
@Configuration
open class ExposedAutoConfiguration {
    @Autowired
    lateinit var dataSource: DataSource

    @PostConstruct
    fun init() {
        Database.connect(dataSource)
    }

    @Bean
    open fun transactionManager(dataSource: DataSource): SpringTransactionManager {
        return SpringTransactionManager(dataSource, DEFAULT_ISOLATION_LEVEL)
    }
}
