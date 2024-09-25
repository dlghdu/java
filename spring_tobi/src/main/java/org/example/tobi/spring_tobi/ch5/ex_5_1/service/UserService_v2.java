package org.example.tobi.spring_tobi.ch5.ex_5_1.service;

import org.example.tobi.spring_tobi.ch5.ex_5_1.dao.UserDao;
import org.example.tobi.spring_tobi.ch5.ex_5_1.domain.Level;
import org.example.tobi.spring_tobi.ch5.ex_5_1.domain.User;

import java.util.List;

public class UserService_v2 {

    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECCOMMEND_FOR_GOLD = 30;

    private UserDao userDao;

    public UserService_v2(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user) {
        if (user.getLevel() == null) {
            user.setLevel(Level.BASIC);
        }
        userDao.add(user);
    }

    public void upgradelevels() {
        List<User> users = userDao.getAll();

        for (User user : users) {
            if (canUpgradeLevel(user)) {
                // upgrade
                upgradeLevel(user);
            }
        }

//            if (
//                    user.getLevel() == Level.BASIC
//                    && user.getLogin() >= 50
//            ) {
//                user.setLevel(Level.SILVER);
//                changed = true;
//            }
//            else if (
//                user.getLevel() == Level.SILVER &&
//                        user.getRecommend() >= 30
//            ) {
//                user.setLevel(Level.GOLD);
//                changed = true;
//            }
//            else if ( user.getLevel() == Level.GOLD ) {
//                changed = false;
//            }
//            if (changed) { userDao.update(user); }
    }

    private boolean canUpgradeLevel(User user) {
        Level currentlevel = user.getLevel();

        switch (currentlevel) {
            case BASIC:
                return (user.getRecommend() >= MIN_LOGCOUNT_FOR_SILVER);
            case SILVER:
                return (user.getRecommend() >= MIN_RECCOMMEND_FOR_GOLD);
            case GOLD:
                return false;
            default:
                throw new IllegalStateException("Unexpected value: " + currentlevel);
        }
    }

    private void upgradeLevel(User user) {
        user.upgradeLevel();
        userDao.update(user);
    }

}
