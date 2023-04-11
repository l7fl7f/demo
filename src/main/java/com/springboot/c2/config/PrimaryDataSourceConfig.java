package com.springboot.c2.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Copyright © 2018IPTV.
 *
 * @Title: com.iptv.smp.core.config.DataSourceConfig
 * @Project: iptv
 * @date: 2018/5/14 15:07
 * @author: jack
 * @Description: 主数据源配置
 */
@Configuration
//@Profile("multi-datasource")
@MapperScan(basePackages = {"com.springboot.c2.dao"}, sqlSessionTemplateRef  = "primarySqlSessionTemplate")
public class PrimaryDataSourceConfig {
    private Logger log = LoggerFactory.getLogger(PrimaryDataSourceConfig.class);

    @Bean(name="primaryDataSource")
    @ConfigurationProperties("spring.datasource.druid.primary")
    @Primary //这个注解是说明此是默认数据源，必须设定默认数据源。（即主数据源）
    public DataSource dataSourcePrimary(){
        log.info("===================multi-datasource build primary datasource====================");
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "primarySqlSessionFactory")
    @Primary
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
//        //xml路径
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:sqlmap/**/*.xml"));
        return bean.getObject();
    }

    @Bean
    @Primary
    public DataSourceTransactionManager primaryTransactionManager(@Qualifier("primaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @Primary
    public SqlSessionTemplate primarySqlSessionTemplate(@Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
