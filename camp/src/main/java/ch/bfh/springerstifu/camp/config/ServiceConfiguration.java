package ch.bfh.springerstifu.camp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import ch.bfh.springerstifu.camp.service.HeroService;
import ch.bfh.springerstifu.camp.service.NameService;
import ch.bfh.springerstifu.camp.service.PartyService;
import ch.bfh.springerstifu.camp.service.impl.HeroServiceImpl;
import ch.bfh.springerstifu.camp.service.impl.NameServiceImpl;
import ch.bfh.springerstifu.camp.service.impl.PartyServiceImpl;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "ch.bfh.springerstifu.camp.repository")
public class ServiceConfiguration {

    @Primary
    @Bean
    public HeroService heroService() {
        return new HeroServiceImpl();
    }

    @Primary
    @Bean
    public PartyService partyService() {
        return new PartyServiceImpl();
    }

    @Primary
    @Bean
    public NameService nameService() {
        return new NameServiceImpl();
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
        bean.setDatabase(Database.H2);
        bean.setGenerateDdl(true);
        return bean;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dSource, JpaVendorAdapter jva) {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dSource);
        bean.setJpaVendorAdapter(jva);
        bean.setPackagesToScan("ch.bfh.springerstifu.camp.model");
        return bean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}