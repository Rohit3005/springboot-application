package com.demo.constant;

public class EndPointConstants {

    public static final String SIGN_UP = "/signup";

    public static final String SIGN_IN = "/signin/{empEmailId}/{empPassword}";

    public static final String GET_ALL_DATA = "/getalldata";

    public static final String GET_DATA_BY_ID = "/getdatabyid/{empId}";

    public static final String GET_DATA_BY_FIRSTNAME = "/getdatabyfirstname/{empFirstName}";

    public static final String GET_DATA_BY_FULL_NAME = "/getdatabyfullname/{empFirstName}/{empLastName}";

    public static final String GET_DATA_BY_CONTACT_NUMBER = "/getdatabycontactnumbner/{empContactNumber}";

    public static final String UPDATE_DATA = "/updatedata/{empId}";

    public static final String GET_DATA_BY_ANY_INPUT = "/getdatabyanyinput/{input}";

    public static final String GET_DATA_EMAIL_ID = "/getdatabyemailid/{empEmailId}";

    public static final String SORT_DATA_BY_ID = "/sortdatabyid";

    public static final String SORT_BY_FIRST_NAME = "/sortdatabyname";

    public static final String SORT_DATA_BY_SALARY = "/sortdatabysalary";

    public static final String SORT_DATA_BY_AGE = "/sortdatabyage";

    public static final String FILTER_DATA_BY_SALARY = "/filterdatabysalary/{empSalary}";

    public static final String DELETE_DATA_BY_ID = "/deletedatabyid/{empId}";

    public static final String DELETE_ALL_DATA = "/deletealldata";



}
