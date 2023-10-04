package hello.springstart;
import hello.springstart.aop.TimeTraceAop;
import hello.springstart.repository.*;
//import hello.springstart.repository.JdbcTemplateMemberRepository;
import hello.springstart.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired //생성자 하나라 생략 가능
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository);
    }


    //@Bean
    //public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);

    //}
}