package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    // new 해서 새로 생성하면 문제점? 별 기능 없으니 하나 생성해서 다 같이 공유하면 됨
    // => container에 등록하고 쓰면 됨
        private final MemberService memberService;

        // MemberService에 @Service 이노테이션 명시!
        @Autowired // 연결시켜줄 때 @Autowired 명시!
        public MemberController(MemberService memberService) {
        this.memberService = memberService;
        }
}
