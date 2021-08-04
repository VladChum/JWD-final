package com.epam.jwd.service.impl;

import com.epam.jwd.entity.Status;
import com.epam.jwd.entity.User;
import com.epam.jwd.exception.ServiceException;
import com.epam.jwd.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class UserServiceImplTest {
    private List<User> users;
    private UserService userService;

    @BeforeEach
    void setup() {
        users = new ArrayList<>();
        users.add(new User(1L, 1L, "aaaa", "aaaaa", "", "", Status.ACTIVATE, BigDecimal.ONE));
        users.add(new User(5L, 2L, "aaaa", "aaaaa", "", "", Status.ACTIVATE, BigDecimal.ONE));
        users.add(new User(4L, 3L, "aaaa", "aaaaa", "", "", Status.BANNED, BigDecimal.ONE));
        users.add(new User(3L, 4L, "aaaa", "aaaaa", "", "", Status.SUSPENDED, BigDecimal.ONE));
        users.add(new User(2L, 5L, "aaaa", "aaaaa", "", "", Status.SUSPENDED, BigDecimal.ONE));
    }

    @Test
    void findAllUsersByStatus() {
        userService = ServiceProvider.INSTANCE.getUserService();
        int[] validArray = new int[]{2, 1, 2};
        Assertions.assertArrayEquals(validArray, userService.findAllUsersByStatus(users));
    }

    @Test
    void findAllUsersByStatus_false() {
        userService = ServiceProvider.INSTANCE.getUserService();
        int[] incorrectArray = new int[]{2, 2, 2};
        Assertions.assertFalse(Arrays.equals(incorrectArray, userService.findAllUsersByStatus(users)));
    }

    @Test
    void findUserById() throws ServiceException {
        userService = mock(UserServiceImpl.class);
        when(userService.findUserById(2L)).thenReturn(java.util.Optional.ofNullable(users.get(4)));
        if (userService.findUserById(2L).isPresent()) {
            User user = userService.findUserById(2L).get();
            Assertions.assertEquals(users.get(4), user);
        }
    }

    @Test
    void findUserByAccountId() throws ServiceException {
        userService = mock(UserServiceImpl.class);
        when(userService.findUserByAccountId(2L)).thenReturn(java.util.Optional.ofNullable(users.get(1)));
        if (userService.findUserByAccountId(2L).isPresent()) {
            User user = userService.findUserByAccountId(2L).get();
            Assertions.assertEquals(users.get(1), user);
        }
    }

    @Test
    void findAll() throws ServiceException {
        userService = mock(UserServiceImpl.class);
        when(userService.findAll()).thenReturn(users);
        List<User> userList = userService.findAll();
        Assertions.assertEquals(users, userList);
    }
}