package com.dearf.member.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 데이터에 대한 id 

    @Column
    private String email; // 로그인 시에 사용할 이메일

    @Column
    private String userName; // 실제 회원의 이름
    
    @Column
    private String nickname; // 일기 피드에 노출될 닉네임

    @Column
    private String password;

    @Column
    private String phone;

    @Column
    private LocalDateTime regDate; // 회원 등록일 

    @Column
    private LocalDateTime updateDate; // 회원 정보 수정일
    
    @Column
    private boolean passwordResetYn; // 초기화 요청 여부
 
    @Column
    private String passwordResetKey; // 초기화시에 사용된 키

}
