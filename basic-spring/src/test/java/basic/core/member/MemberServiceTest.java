package basic.core.member;

import basic.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    //테스트전 먼저 실행
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given: 무엇이 주어졌을때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when: 어떤행동을 했을때
        memberService.join(member);
        Member findmember = memberService.findMember(1L);

        //then: 이렇게 된다.
        Assertions.assertThat(member).isEqualTo(findmember);

    }
}
