package com.employee.Utils;

import org.apache.commons.lang.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class EmployeeUtils {

    public String randomAlphanumericString() {
        return RandomStringUtils.randomAlphanumeric(5);
    }

    public String randomString() {
        return RandomStringUtils.randomAlphabetic(6);
    }

    public String randomEmail() {
        return randomAlphanumericString() + "@gmail.com";
    }

    public String randomPhoneNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public Integer randomInteger() {
        Random random = new Random();
        return random.nextInt();
    }

    public String randomDateISO8601(){
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String text = simpleDateFormat.format(date);
        return text;
    }

}
