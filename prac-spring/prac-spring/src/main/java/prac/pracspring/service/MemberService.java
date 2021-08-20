package prac.pracspring.service;

import prac.pracspring.domain.Member;
import prac.pracspring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원 가입 */
    public Long join(Member member){
        validateDuplicateMember(member.getName());
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 회원 중복 검사 */
    public void validateDuplicateMember(String name){
        memberRepository.findByName(name)
                .ifPresent(member -> {
                   throw new IllegalStateException("중복된 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회 */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**
     * Id로 회원 조회*/
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
