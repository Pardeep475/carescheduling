package com.example.carescheduling.Utils;

import java.util.regex.Pattern;

public class Constants {
    public static String SHARED_PREFERENCE = "Care_Scheduling_Local";
    public final static Pattern EMAIL_ADDRESS_PATTERN = Pattern
            .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    public static String BASE_URL = "";
}
