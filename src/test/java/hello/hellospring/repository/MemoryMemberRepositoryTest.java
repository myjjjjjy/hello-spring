package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();


    // 메소드는 순서 상관없이 뭐가 먼저 실행되던지 동작돼야함!! => 테스트 하나 끝나면 데이터 클리어 해줘야함!
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("yeonghye");

        repository.save(member);

        // 반환타입이 Optional, get()메소드 이용해서 꺼내줄 수 있음. 좋은 방법은 아니나 테스트코드니까!
        Member result = repository.findById(member.getId()).get();
        //System.out.println("result = " + (result==member));

        // 두 개가 같은 지 확인할 수 있음
        //Assertions.assertEquals(member, result);

        // option+enter 누르고 Add on-demand static import for ~~ 나옴
        // -> 상단에 Assertions 임폴트 되고 생략, 다음부터는 assertThat만 가져와서 쓰면 됨!
        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("juyeon");
        repository.save(member1);

        // shift+F6 : 복사하고 리네임할때 유용한 팁
        Member member2 = new Member();
        member2.setName("gwanjun");
        repository.save(member2);

        Member result = repository.findByName("juyeon").get();

        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("juyeon");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("gwanjun");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }

}