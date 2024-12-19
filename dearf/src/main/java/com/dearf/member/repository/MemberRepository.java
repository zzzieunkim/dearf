package com.dearf.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dearf.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
