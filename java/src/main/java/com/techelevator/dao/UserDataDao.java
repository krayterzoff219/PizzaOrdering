package com.techelevator.dao;

import com.techelevator.model.UserData;

public interface UserDataDao {
    UserData getUserData(int userID);
    UserData updateUserData(UserData updatedUserData);
}
