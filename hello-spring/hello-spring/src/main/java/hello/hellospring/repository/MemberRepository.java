package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    //회원 정보 저장
    Member save(Member member);
    //요즘은 null값을 반환할때 Optional이라는 것으로 감싸서 반환
    //저장된 회원들중 Id값 찾기
    Optional<Member>findById(Long id);
    //저장된 회원들중 Name 찾기
    Optional<Member>findByName(String name);
    //저장된 회원들 정보 모두 조회
    List<Member> findAll();
    
}
