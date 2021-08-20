package prac.pracspring.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prac.pracspring.domain.Member;
import prac.pracspring.repository.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long resultId = memberService.join(member);

        //then
        Member findOne = memberService.findOne(resultId).get();
        Assertions.assertThat(findOne.getId()).isEqualTo(resultId);
    }
    
    @Test
    void joinDuplicateName(){
        Member member1 = new Member();
        member1.setName("abc");
        
        Member member2 = new Member();
        member2.setName("abc");
        
        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("중복된 회원입니다.");

       /* try{
            memberService.join(member2);
            fail("중복 회원 가입 예외 발생");
        } catch (IllegalStateException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("중복된 회원입니다.");
        }*/
    }
}