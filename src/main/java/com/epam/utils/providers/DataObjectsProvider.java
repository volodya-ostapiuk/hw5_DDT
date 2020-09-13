package com.epam.utils.providers;

import com.epam.utils.Constants;

public class DataObjectsProvider implements Constants {
    public static Object[][] getUsers() {
        int usersAmount = USERS.size();
        Object[][] users = new Object[usersAmount][];
        for (int i = 0; i < usersAmount; i++) {
            users[i] = new Object[]{USERS.get(i).getEmail(), USERS.get(i).getPassword()};
        }
        return users;
    }
}
