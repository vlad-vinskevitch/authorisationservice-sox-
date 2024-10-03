package com.sitionix.athssox.usecase;

import com.sitionix.athssox.domain.User;
import com.sitionix.athssox.repository.UserRepository;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CreateUserImplTest {

    @TestConfiguration
    static class TestContextConfiguration{
        @Bean
        public CreateUserImpl createUserImpl(final UserRepository userRepository){
            return new CreateUserImpl(userRepository);
        }
    }

    @MockBean
    private UserRepository userRepository;

    @Test
    void givenUser_whenCreateUser_thenReturnCreatedUser() {

        //given
        final Long givenUserId = null;
        final String givenPassword = "password";

        final Long createdId = 1L;
        final String createdPassword = null;

        final User givenUser = getUser(givenUserId, givenPassword);
        final User createdUser = getUser(createdId, createdPassword);

        when(this.userRepository.createUser(givenUser)).thenReturn(createdUser);

        //when

        final User actual = this.userRepository.createUser(givenUser);

        //then

        assertThat(actual).isEqualTo(createdUser);
    }

    private User getUser(Long id, String password) {
        return User.builder()
                .userName("userName")
                .id(id)
                .password(password)
                .build();
    }

}