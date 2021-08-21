package prac.pracspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import prac.pracspring.repository.JdbcMemberRepository;
import prac.pracspring.repository.JdbcMemberTemplateRepository;
import prac.pracspring.repository.JpaMemberRepository;
import prac.pracspring.repository.MemberRepository;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    /*private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcMemberTemplateRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
