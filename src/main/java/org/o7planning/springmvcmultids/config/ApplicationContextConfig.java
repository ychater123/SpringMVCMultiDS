package org.o7planning.springmvcmultids.config;
 
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
 
import javax.sql.DataSource;
 
import org.apache.commons.dbcp.BasicDataSource;
import org.o7planning.springmvcmultids.routing.MyRoutingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
 
@Configuration
@ComponentScan("org.o7planning.springmvcmultids.*")
 
@EnableTransactionManagement
 
// Load to Environment.
@PropertySources({ @PropertySource("classpath:ds/datasource-cfg.properties") })
 
public class ApplicationContextConfig {
 
    // The Environment class serves as the property holder
    // and stores all the properties loaded by the @PropertySource
    @Autowired
    private Environment env;
 
    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
 
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
 
        return viewResolver;
    }
 
    // Returns Routing DataSource (MyRoutingDataSource)
    @Autowired
    @Bean(name = "dataSource")
    public DataSource getDataSource(DataSource dataSource1, DataSource dataSource2) {
 
        System.out.println("## Create DataSource from dataSource1 & dataSource2");
 
        MyRoutingDataSource dataSource = new MyRoutingDataSource();
 
        Map<Object, Object> dsMap = new HashMap<Object, Object>();
        dsMap.put("PUBLISHER_DS", dataSource1);
        dsMap.put("ADVERTISER_DS", dataSource2);
 
        dataSource.setTargetDataSources(dsMap);
 
        return dataSource;
    }
 
    @Bean(name = "dataSource1")
    public DataSource getDataSource1() throws SQLException {
        BasicDataSource dataSource = new BasicDataSource();
 
        // See: datasouce-cfg.properties
        dataSource.setDriverClassName(env.getProperty("ds.database-driver1"));
        dataSource.setUrl(env.getProperty("ds.url1"));
        dataSource.setUsername(env.getProperty("ds.username1"));
        dataSource.setPassword(env.getProperty("ds.password1"));
 
        System.out.println("## getDataSource1: " + dataSource);
        return dataSource;
    }
 
    @Bean(name = "dataSource2")
    public DataSource getDataSource2() throws SQLException {
        BasicDataSource dataSource = new BasicDataSource();
 
        // See: datasouce-cfg.properties
        dataSource.setDriverClassName(env.getProperty("ds.database-driver2"));
        dataSource.setUrl(env.getProperty("ds.url2"));
        dataSource.setUsername(env.getProperty("ds.username2"));
        dataSource.setPassword(env.getProperty("ds.password2"));
 
        System.out.println("## getDataSource2: " + dataSource);
 
        return dataSource;
    }
 
    @Autowired
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
 
        txManager.setDataSource(dataSource);
 
        return txManager;
    }
 
}