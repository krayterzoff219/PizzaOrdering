package com.techelevator.dao.login;

import com.techelevator.model.login.UserData;

public interface UserDataDao {
    UserData getUserData(int userID);
    UserData updateUserData(UserData updatedUserData);
}
