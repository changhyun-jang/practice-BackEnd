package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

//test케이스 작성(여러 테스트를 한번에 테스트 할 수 있음)
//미리 검증할 수 있는 테스트 툴을 만들어 작품을 만들은 후 되는 지 확인, 테스트 주도개발(TDD)
//아래는 TDD는 아니고 그냥 테스트를 만들어서 돌려보는 것임
class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository=new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    public void save(){
        Member member=new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //JUnit의 Assertion사용
        //Assertions.assertEquals(member, result);
        
        //assertj의 Assertion사용
        //alt+enter는 라이브러리 모듈 import해주는거 단축키
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        //shift+F6을 통해 그 아래부터 같은 변수들 이름 변경가능
        Member member2 =new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result= repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result =repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
