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
        basePackages = "com.springboot.demos.dao.one",
        sqlSessionFactoryRef = "oneSqlSessionFactory",
        sqlSessionTemplateRef = "oneSqlSessionTemplate"
)
public class OneDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.one")
    public DataSource oneDataSource(){
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "oneSqlSessionFactory")
    public SqlSessionFactory oneSqlSessionFactory(@Qualifier("oneDataSource") DataSource oneDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(oneDataSource);

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate oneSqlSessionTemplate(@Qualifier("oneSqlSessionFactory") SqlSessionFactory oneSqlSessionFactory){
        return new SqlSessionTemplate(oneSqlSessionFactory);
    }
}
