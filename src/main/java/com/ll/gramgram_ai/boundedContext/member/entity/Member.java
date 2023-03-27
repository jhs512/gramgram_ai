package com.ll.gramgram_ai.boundedContext.member.entity;

import com.ll.gramgram_ai.base.entity.Base;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Member extends Base {
    private String username;
    private String password;
    private String accountProviderTypeCode;
}