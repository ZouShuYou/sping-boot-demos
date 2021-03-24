package com.springboot.demos.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-24 11:15
 */

@Configuration
@MapperScan(
        basePackages = "com.springboot.demos.dao.two",
        sqlSessionFactoryRef = "twoSqlSessionFactory",
        sqlSessionTemplateRef = "twoSqlSessionTemplate"
)
public class TwoDataSourceConfig {

    @Bean
    @ConfigurationProperties(value = "spring.datasource.two")
    public DataSource twoDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "twoSqlSessionFactory")
    public SqlSessionFactory twoSqlSessionFactory(@Qualifier("twoDataSource") DataSource twoDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(twoDataSource);

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate twoSqlSessionTemplate(@Qualifier("twoSqlSessionFactory") SqlSessionFactory twoSqlSessionFactory){
        return new SqlSessionTemplate(twoSqlSessionFactory);
    }
}
