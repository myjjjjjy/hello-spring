package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

// 서비스단은 네이밍 비지니스적으로!
public class MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 회원가입
    public Long join(Member member){

        // 중복 이름 막기
        // command option v
        // Optional로 감싸니까 if null 안써도됨! null있으면 Optional이 감싸서 반환해주기 떄문에! -> get()으로 꺼내면 됨. (권장하진않음)
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.get();
//        result.ifPresent(m->{
//            throw new IllegalStateException("이미 존재하는 이름입니다. ");
//        });

        // 권장 방법
        // control t
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName((member.getName())).ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        });
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
