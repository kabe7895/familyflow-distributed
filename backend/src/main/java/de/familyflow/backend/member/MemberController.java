package de.familyflow.backend.member;

import de.familyflow.backend.member.dto.MemberRequestDTO;
import de.familyflow.backend.member.dto.MemberResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }


    @GetMapping
    public List<MemberResponseDTO> getAllMembers() {
        return service.getAllMembers();
    }


    @PostMapping
    public MemberResponseDTO createMember(
            @Valid @RequestBody MemberRequestDTO member) {

        return service.createMember(member);
    }


    @GetMapping("/{id}")
    public MemberResponseDTO getMemberById(
            @PathVariable Long id) {

        return service.getMemberById(id);
    }


    @PutMapping("/{id}")
    public MemberResponseDTO updateMember(
            @PathVariable Long id,
            @Valid @RequestBody MemberRequestDTO member) {

        return service.updateMember(id, member);
    }


    @DeleteMapping("/{id}")
    public void deleteMember(
            @PathVariable Long id) {

        service.deleteMember(id);
    }
}