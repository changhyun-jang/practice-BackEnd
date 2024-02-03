package basic.core;

import basic.core.discount.DiscountPolicy;
import basic.core.discount.FixDiscountPolicy;
import basic.core.discount.RateDiscountPolicy;
import basic.core.member.MemberRepository;
import basic.core.member.MemberService;
import basic.core.member.MemberServiceImpl;
import basic.core.member.MemoryMemberRepository;
import basic.core.order.OrderService;
import basic.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //Configuration : Spring에서 설정 정보를 가지고 있는 클래스라는 의미로 쓰임
    //Bean : SpringContainer에 등록
    //역할을 세우고 그안에 구현이 어떻게 되어있는지 보이도록 구현, 중복 제거
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
