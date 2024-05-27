package com.jaro.keszlet.service.implementation;

import com.jaro.keszlet.model.User;
import com.jaro.keszlet.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class UserServiceImpTest {

    private static final User USER = new User(UUID.randomUUID(), "laszlo", "hhhzhzhzh", "ojfafiou");
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImp userService;

    @Test
    void shouldReturnFindAllUser(){
        BDDMockito.given(userRepository.findAll()).willReturn(List.of(
                USER
        ));

        List<User> allUsers = userService.findAllUsers();

        assertThat(allUsers, equalTo(List.of(USER)));
        verify(userRepository).findAll();
     }

    @Test
    void shouldSaveUser(){
        BDDMockito.given(userRepository.save(USER)).willReturn(USER);

        userService.saveUser(USER);

        verify(userRepository).save(USER);
    }

}