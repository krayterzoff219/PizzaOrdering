package com.techelevator.dao.login;

import com.techelevator.model.login.UserData;
import com.techelevator.model.orders.Order;

public interface UserDataDao {
    UserData getUserData(int userID);
    UserData updateUserData(UserData updatedUserData);
    int createGuestData(Order order);
}
