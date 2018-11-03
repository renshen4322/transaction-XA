package com.dongnaoedu.tony;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

/***
 * 系统配置
 * 
 * @author Tony
 *
 */
@Configuration
public class AppConfig {

    /** 订单系统数据库 */
    @Bean(name = "orderDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.order-datasource")
    public DataSource orderDataSource() {
        return new AtomikosDataSourceBean();
    }

    @Bean(name = "orderJdbcTemplate")
    @Primary
    public JdbcTemplate orderJdbcTemplate(@Qualifier("orderDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /** 调度系统数据库 */
    @Bean(name = "dispatchDataSource")
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.dispatch-datasource")
    public DataSource dispatchDataSource() {
        return new AtomikosDataSourceBean();
    }

    @Bean(name = "dispatchJdbcTemplate")
    public JdbcTemplate dispatchJdbcTemplate(
            @Qualifier("dispatchDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
