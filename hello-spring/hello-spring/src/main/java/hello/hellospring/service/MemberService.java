package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//멤버서비스가 일반클래스라서 spirng에서 읽어올수 없음, 그래서 service어노테이션필요
public class MemberService {
    private final MemberRepository memberRepository;
    //멤버서비스는 멤버리포지토리가 필요.이때 멤버서비스 생성자를 호출하는데 @Autowired 이게 있으면
    //레포지토리가 필요함을 알고 스프링컨테이너에 레포지토리를 넣어줌

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member){
        //같은 이름이 있는 중복회원X
//        //ctrl+alt+v 를 통해 Optional<Member> 생성
//        //Optional을 반환해서 사용하는것 보다 바로 사용하는게 나음
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        //orElseGet 메소드를 통해 값을 꺼냄, 값이 있으면 꺼내고 없으면 메소드를 실행하거나 default 값을 가져옴
//        result.ifPresent(m ->{
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });

        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
           .ifPresent(m ->{
               throw new IllegalStateException("이미 존재하는 회원입니다.");
           });
    }
    
    //전체회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
    
}
