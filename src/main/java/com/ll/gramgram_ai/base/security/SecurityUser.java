package com.ll.gramgram_ai.base.security;

import com.ll.gramgram_ai.boundedContext.member.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SecurityUser extends User implements OAuth2User {
    public static SecurityUser from(Member member) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("member"));

        return new SecurityUser(member, authorities);
    }

    private SecurityUser(Member member, List<GrantedAuthority> authorities) {
        super(member.getUsername(), "", authorities);
    }

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    @Override
    public String getName() {
        return getUsername();
    }
}
