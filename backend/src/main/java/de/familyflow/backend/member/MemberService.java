package de.familyflow.backend.member;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    public Member getMemberById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    public Member createMember(Member member) {
        return repository.save(member);
    }

    public Member updateMember(Long id, Member updatedMember) {
        Member existingMember = getMemberById(id);

        existingMember.setName(updatedMember.getName());
        existingMember.setEmail(updatedMember.getEmail());

        return repository.save(existingMember);
    }

    public void deleteMember(Long id) {
        Member member = getMemberById(id);
        repository.delete(member);
    }
}