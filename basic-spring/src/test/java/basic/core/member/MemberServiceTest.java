package basic.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

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
