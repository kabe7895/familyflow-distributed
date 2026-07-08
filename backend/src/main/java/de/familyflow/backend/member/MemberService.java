package de.familyflow.backend.member;

import de.familyflow.backend.exception.MemberNotFoundException;
import de.familyflow.backend.member.dto.MemberRequestDTO;
import de.familyflow.backend.member.dto.MemberResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }


    public List<MemberResponseDTO> getAllMembers() {

        return repository.findAll()
                .stream()
                .map(member -> new MemberResponseDTO(
                        member.getId(),
                        member.getName(),
                        member.getEmail()
                ))
                .toList();
    }


    public MemberResponseDTO getMemberById(Long id) {

        Member member = repository.findById(id)
                .orElseThrow(() ->
                        new MemberNotFoundException("Member not found"));

        return new MemberResponseDTO(
                member.getId(),
                member.getName(),
                member.getEmail()
        );
    }


    public MemberResponseDTO createMember(MemberRequestDTO request) {

        Member member = new Member();

        member.setName(request.getName());
        member.setEmail(request.getEmail());

        Member saved = repository.save(member);

        return new MemberResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getEmail()
        );
    }


    public MemberResponseDTO updateMember(
            Long id,
            MemberRequestDTO request) {

        Member existingMember = repository.findById(id)
                .orElseThrow(() ->
                        new MemberNotFoundException("Member not found"));

        existingMember.setName(request.getName());
        existingMember.setEmail(request.getEmail());

        Member saved = repository.save(existingMember);

        return new MemberResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getEmail()
        );
    }


    public void deleteMember(Long id) {

        Member member = repository.findById(id)
                .orElseThrow(() ->
                        new MemberNotFoundException("Member not found"));

        repository.delete(member);
    }
}