package com.yadu.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.yadu.example.demo.mapper.master", sqlSessionTemplateRef  = "masterSqlSessionTemplate")
public class MasterDataSourceConfiguration {

    @Bean(name = "masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DataSource dataSource() {
        return  new DruidDataSource();
    }

    @Bean(name = "masterSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "masterTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("masterDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "masterSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    

}