package com.dearf.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dearf.common.error.ResponseError;
import com.dearf.member.entity.Member;
import com.dearf.member.model.MemberInput;
import com.dearf.member.repository.MemberRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

	
	private final MemberRepository memberRepository;
	
    @PostMapping("/api/member")
    public ResponseEntity<?> addMember(@RequestBody @Valid MemberInput memberInput, Errors errors) {

        List<ResponseError> responseErrorList = new ArrayList<>();
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach((e) -> {
                responseErrorList.add(ResponseError.of((FieldError)e));
            });

            return new ResponseEntity<>(responseErrorList, HttpStatus.BAD_REQUEST);
        }

        Member member = Member.builder()
                .email(memberInput.getEmail())
                .userName(memberInput.getUserName())
                .nickname(memberInput.getNickname())
                .password(memberInput.getPassword())
                .phone(memberInput.getPhone())
                .regDate(LocalDateTime.now())
                .build();
        		memberRepository.save(member);


        return ResponseEntity.ok().build();
    }
}
