package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    //실무에서는 동시성 문제가 발생할 수 있어 공유되는 변수 일떄는 콘크로 해시맵??을 써야함 
    //해당 예제는 단순하므로 HashMap사용
    private static Map<Long,Member> store=new HashMap<>();
    private static long sequence=0L;

    @Override
    public Member save(Member member) {
        //member의 id값을 세팅
        member.setId(++sequence);
        //파라미터로 넘어온 이름은
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
