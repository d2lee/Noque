package com.doleestudio.noque.data;

/**
 * Created by dolee on 15. 1. 12..
 */
public class Rule {
    public static final int PASSWORD_LENGTH = 8;
    public static final int PHONE_NUMBER_LENGTH = 11; // xxxxxxxxxxx (without 'dash')

    public static final boolean isPhoneNumberValid(String phone) {
        return !phone.isEmpty() && phone.length() == PHONE_NUMBER_LENGTH;
    }

    public static final boolean isUserNameValid(String name) {
        return !name.isEmpty() && name.length() > 2;
    }

    public static final boolean isPasswordValid(String password) {
        return !password.isEmpty() && password.length() >= Rule.PASSWORD_LENGTH;
    }
}
