package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MemberRepository {
    // 동시성 문제 고려 X , 실무에서는 ConcurrentHashMap , AtomicLong 고려
    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;

    // 싱글톤 사용을 위한 코드
    // 외부에서 생성자 호출 X -> only, getInstance() 메쏘드만을 호출
    private static MemberRepository instance = new MemberRepository();

    private MemberRepository(){
    }

    public static MemberRepository getInstance(){
        return instance;
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    public Member findMember(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
        // store HashMap 보호 위해
    }

    public void clearStore(){
        store.clear();
    }

}
