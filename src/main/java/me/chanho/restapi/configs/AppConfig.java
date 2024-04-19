package me.chanho.restapi.configs;


import me.chanho.restapi.accounts.Account;
import me.chanho.restapi.accounts.AccountRole;
import me.chanho.restapi.accounts.AccountService;
import me.chanho.restapi.common.AppProperties;
import me.chanho.restapi.events.Event;
import me.chanho.restapi.events.EventRepository;
import me.chanho.restapi.events.EventStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.IntStream;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return new ApplicationRunner() {

            @Autowired
            AccountService accountService;

            @Autowired
            EventRepository eventRepository;

            @Autowired
            AppProperties appProperties;

            @Override
            public void run(ApplicationArguments args) throws Exception {
                Account admin = Account.builder()
                        .email(appProperties.getAdminUsername())
                        .password(appProperties.getAdminPassword())
                        .roles(Set.of(AccountRole.ADMIN, AccountRole.USER))
                        .build();
                accountService.saveAccount(admin);

                Account user = Account.builder()
                        .email(appProperties.getUserUsername())
                        .password(appProperties.getUserPassword())
                        .roles(Set.of(AccountRole.ADMIN, AccountRole.USER))
                        .build();
                accountService.saveAccount(user);

                IntStream.range(0, 30).forEach(index -> {
                    generateEvent(index, admin);
                });
            }

            private Event generateEvent(int index, Account account) {
                Event event = Event.builder()
                        .name("event " + index)
                        .description("test index " + index)
                        .beginEnrollmentDateTime(LocalDateTime.of(2024, 03, 23, 14, 21))
                        .closeEnrollmentDateTime(LocalDateTime.of(2024, 03, 24, 14, 21))
                        .beginEventDateTime(LocalDateTime.of(2024, 03, 25, 14, 21))
                        .endEventDateTime(LocalDateTime.of(2024, 03, 26, 14, 21))
                        .basePrice(100)
                        .maxPrice(200)
                        .limitOfEnrollment(100)
                        .location("강남역 D2 스타텁 팩토리")
                        .free(false)
                        .offline(true)
                        .eventStatus(EventStatus.DRAFT)
                        .manger(account)
                        .build();

                return this.eventRepository.save(event);
            }
        };
    }
}
