package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        // autowired를 하게되면 이미 만들어져있는 memberService를 찾아 연결 시켜준다.
        // 하지만 어떤것과 연결 해줘야하는지를 명시해주지 않으면 스프링은 그것을 모른다.
        // 이 때 MemberService 클래스에 @Service를 해주면 스프링에 올라올 때 Service라는 것을 인식하고 스프링 컨테이너에 등록해준다.
        // + Repository도 @Repository를 추가해준다.
        // -> 의존성 주입 DI(Dependancy Injection)

        this.memberService = memberService;
    }
}
