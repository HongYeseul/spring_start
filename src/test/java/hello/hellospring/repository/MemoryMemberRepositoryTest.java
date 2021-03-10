package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEeach(){
        // 메서드가 끝날 때 마다 동작하는 메서드
        // 클래스 자체를 테스트 하면 각 메서드가 순서에 상관없이 실행되기 때문에 clear를 해주지 않으면 에러가 난다.
        // -> 테스트는 서로 의존관계 없이 설계를 해야한다.
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findbyId(member.getId()).get();
//        Assertions.assertThat() ~~~ 적어주어야 하는데 static import를 이용해서 assertThat()~~으로 사용할 수 있다.
//        static import하기 위해서는 alt+enter를 사용하면 된다.
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1") ;
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2") ;
        repository.save(member2);

        Member result =  repository.findbyName("spring1").get();
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

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
