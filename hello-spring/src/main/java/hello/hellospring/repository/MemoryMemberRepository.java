package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store =new HashMap<>(); // 실무에서는 동시성 문제로 공유데이타는 콘크리트해쉬맵
    private static Long sequence = 0L; // 역시 실무에서는 동시성문제로 어셈트롱

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // 시퀀스 1 증가 member.id : 임의로 시스템에서 구별하기위함 , member.name : 고객이 회원가입시 작성
        store.put(member.getId(),member); // store map에다가 데이타 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // 찾는 값이 null일 가능성이 있을시 optional.ofNullable로 감싸기 -> 클라이언트에서 무엇을 할수있음
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
        // 람다식 사용 findAny : map 에서 루프 돌면서 찾아지면 반환 , 끝까지 없으면 Optional에 null 포함해서 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //store.values == store map의 member
    }
    public void clearStore(){
        store.clear();
    }
}
