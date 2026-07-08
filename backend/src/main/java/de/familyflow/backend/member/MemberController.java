package de.familyflow.backend.member;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return service.getAllMembers();
    }

@PostMapping
public Member createMember(@Valid @RequestBody Member member) {
    return service.createMember(member);
}

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return service.getMemberById(id);
    }

    @PutMapping("/{id}")
public Member updateMember(
        @PathVariable Long id,
        @Valid @RequestBody Member member) {

    return service.updateMember(id, member);
}

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        service.deleteMember(id);
    }
}