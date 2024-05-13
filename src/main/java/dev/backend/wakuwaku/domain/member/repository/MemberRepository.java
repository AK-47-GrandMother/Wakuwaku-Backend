package dev.backend.wakuwaku.domain.member.repository;

import dev.backend.wakuwaku.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(Long id);

    Optional<Member> findByoauthServerId(String oauthServerId);
}
