package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(Long id);

    // Optional:null이 반환될때 null을 Optional에 감싸서 반환할 수 있음. Java8에 있는 기능.
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
