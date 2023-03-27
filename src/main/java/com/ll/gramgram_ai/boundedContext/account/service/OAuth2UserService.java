package com.ll.gramgram_ai.boundedContext.account.service;

import com.ll.gramgram_ai.base.security.SecurityUser;
import com.ll.gramgram_ai.boundedContext.member.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class OAuth2UserService extends DefaultOAuth2UserService {
    private final AccountService accountService;

    // 카카오톡 로그인이 성공할 때 마다 이 함수가 실행된다.
    @Override
    @Transactional
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String oauthId = oAuth2User.getName();
        String accountProviderTypeCode = userRequest.getClientRegistration().getRegistrationId().toLowerCase();

        if (!"kakao".equals(accountProviderTypeCode)) {
            throw new RuntimeException("카카오로그인만 가능합니다.");
        }

        String username = null;

        switch (accountProviderTypeCode) {
            case "kakao" -> {
                username = "kakao__%s".formatted(oauthId);
            }
        }

        Member member = accountService.whenSocialLogin(accountProviderTypeCode, username);

        return SecurityUser.from(member);
    }
}
