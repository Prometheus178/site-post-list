package com.realestate.site.services.user.impl;

import com.realestate.site.repositories.user.RoleRepository;
import com.realestate.site.repositories.user.UserRepository;
import com.realestate.site.models.user.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceImplTest {
    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private RoleRepository mockRoleRepository;

    private UserServiceImpl userServiceImplUnderTest;
    private User user;

    @Before
    public void setUp(){
        initMocks(this);
//        userServiceImplUnderTest = new UserServiceImpl(mockUserRepository,mockRoleRepository);
        user = new User();
        user.setId(1L);
        user.setUsername("username");
        user.setPassword("password");
        user.setEmail("test@email.com");
        Mockito.when(mockUserRepository.save(any())).thenReturn(user);
        Mockito.when(mockUserRepository.findByEmail(anyString())).thenReturn(user);
    }

    @Test
    public void findUserByName() {
        final String email = "test@email.com";
        final User result = userServiceImplUnderTest.findUserByEmail(email);
        assertEquals(email,result.getEmail());
    }

    @Test
    public void saveUser() {
        final String email = "test@email.com";
        user = new User();
        user.setId(1L);
        user.setUsername("username");
        user.setPassword("password");
        user.setEmail("test@email.com");
        User result = userServiceImplUnderTest.saveUser(user);

        assertEquals(email, result.getEmail());
    }
}