package hello.springstart.repository;

import hello.springstart.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{

    // findBy"Name" -> JPQL: select m from Member m where m.name = ?
    // findByNameAndId 등등 다양한 기능을 이미 제공
    @Override
    Optional<Member> findByName(String name);
}
