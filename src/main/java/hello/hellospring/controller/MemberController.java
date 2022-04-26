package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    // new 해서 새로 생성하면 문제점? 별 기능 없으니 하나 생성해서 다 같이 공유하면 됨
    // => container에 등록하고 쓰면 됨
        private final MemberService memberService;

    // MemberService에 @Service 이노테이션 명시!
    // 연결시켜줄 때 @Autowired 명시!
    @Autowired
    public MemberController(MemberService memberService) {
    this.memberService = memberService;
    }

    // 데이터 조회할 때 보통 GET
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    // 데이터 등록할 때 보통 POST
    @PostMapping("members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }

    // 회원목록 출력
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";


    }
}
