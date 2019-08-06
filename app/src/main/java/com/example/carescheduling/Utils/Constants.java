package com.example.carescheduling.Utils;

import java.util.regex.Pattern;

public class Constants {
    public static final String TYPE = "type";
    public static String SHARED_PREFERENCE = "Care_Scheduling_Local";
    public final static Pattern EMAIL_ADDRESS_PATTERN = Pattern
            .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    public static String BASE_URL = "http://mobile.rota.services/CssMobileRestfulService.svc/";
//    public static String BASE_URL = "http://mobile.felagi.net";

    public static String PROFILE_DATA = "profile_data";
    public static String USER_VIEW_MODEL = "user_view_model";
    public static String STRING_VALUE = "string_value";
    public static String PERSON_ID = "PersonId";
    public static String CUSTOMER_ID = "CustomerId";
    public static String BRANCH_ID = "BranchId";
    public static String IS_USER_LOGIN = "is_user_login";
    public static String CURRENT_PASSWORD = "current_password";
    public static String CLIENT_ID = "client_id";
    public static String CLIENT_TASK = "client_tasks";
    public static final int REQUEST_CAMERA = 1111;
    public static final int SELECT_FILE = 1112;
}
