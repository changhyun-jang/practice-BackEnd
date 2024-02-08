package basic.core.autowired;

import basic.core.member.Member;
import jakarta.annotation.Nullable;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredTest {
    @Test
    void AutowiredOption(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
                TestBean.class);
    }

    static class TestBean{

        //자동 주입할 대상이 없으면 수정자 메서드 자체가 호출 안됨
        @Autowired(required = false)
        public void setNoBean1(Member member) {
            System.out.println("member1 = " + member);
        }

        //자동 주입 대상이 없으면 null
        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("member2 = " + member);
        }

        //자동 주입 대상이 없으면 Optional.empty
        @Autowired
        public void setNoBean3(Optional<Member> member) {
            System.out.println("member3 = " + member);
        }


    }

}
