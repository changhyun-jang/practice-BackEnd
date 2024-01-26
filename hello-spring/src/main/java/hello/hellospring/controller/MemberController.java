package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//컨트롤러라는 어노테이션을 보고 스프링컨테이너에서 관리를함. 그래서 controller같은게 동작함
@Controller
public class MemberController {
    //스프링에서 관리를 하게되면 스프링컨테이너에 등록하고 받아서쓰도록 변경해야함
    //new로 쓰면 멤버컨트롤러외에 다른 컨트롤러가 멤버서비스를 가져다쓸수 있는데, 하나를 아에 생성해놓고 공용으로 쓰는게 좋음
    //그래서 new보다 container에 등록하는게 좋음
    private final MemberService memberService;

    //멤버컨트롤러는 스프링 컨테이너가 뜰때 생성, 그때 그안에 있는 생성자들을 호출하는데, 이떄  생성자에 Autowired가 떠있으면 
    //스프링이 멤버서비스를 가져다 연결을 시켜줌
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    
    //멤버컨트롤러가 생성이될때, 스프링빈에 등록된 멤버서비스객체를 가져다 넣어줌 -> 의존관계 주입
}
