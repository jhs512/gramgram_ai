package com.ll.gramgram_ai.boundedContext.member.repository;

import com.ll.gramgram_ai.boundedContext.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
