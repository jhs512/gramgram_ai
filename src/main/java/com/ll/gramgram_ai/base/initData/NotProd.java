package com.ll.gramgram_ai.base.initData;

import com.ll.gramgram_ai.boundedContext.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev", "test"})
@Slf4j
public class NotProd {
    @Bean
    CommandLineRunner initData(
            AccountService accountService
    ) {
        return args -> {
            log.debug("NotProd 시작");
            accountService.join("user1", "1234");
            log.debug("NotProd 끝");
        };
    }
}
