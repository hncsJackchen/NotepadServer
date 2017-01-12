package com.jack.notepad;

import com.jack.notepad.filter.HTTPBasicAuthorizeAttribute;
import com.jack.notepad.quartz.QuartzManager;
import com.jack.notepad.utils.Log;
import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/19.
 * 启动约束
 */
@EnableSwagger
@EnableAutoConfiguration
@SpringBootApplication
//@MapperScan("com.jack.notepad.inter")
//@ComponentScan("com.jack.notepad")
public class Bootstrap {
//    private static Logger logger = Logger.getLogger(Bootstrap.class);

    //DataSource配置
//    @Bean
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource dataSource() {
//        return new org.apache.tomcat.jdbc.pool.DataSource();
//    }

    //提供SqlSeesion
//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource());
//
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        Resource[] resources = resolver.getResources("classpath:/mapper/*.xml");
//        sqlSessionFactoryBean.setMapperLocations(resources);
//
//        return sqlSessionFactoryBean.getObject();
//    }

//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }

    //程序入口
    public static void main(String[] agrs) {
        //主程序
        SpringApplication.run(Bootstrap.class, agrs);

        //启动定时任务
        QuartzManager.start();


    }

    /**
     * 配置 swagger开始
     */
    private SpringSwaggerConfig springSwaggerConfig;

    /**
     * Required to autowire SpringSwaggerConfig
     */
    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }


    /**
     * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc
     * framework - allowing for multiple swagger groups i.e. same code base
     * multiple swagger resource listings.
     */
    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns(".*?");
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "测试接口文档(标题)", // App Service API
                "这是一个描述信息。。。",
                "termsOfServiceUrl",
                "younaame@yourmail.com",
                "2222222222222222222222222222",
                "3333333333333333333333333333");
        return apiInfo;
    }
    /** 配置 swagger结束*/


    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        Log.i("FilterRegistrationBean...");
        HTTPBasicAuthorizeAttribute basicAuthorizeAttribute = new HTTPBasicAuthorizeAttribute();
        bean.setFilter(basicAuthorizeAttribute);

        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/test1/*");
        bean.setUrlPatterns(urlPatterns);

        return bean;
    }


}
