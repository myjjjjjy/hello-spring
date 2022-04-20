package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

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


}
