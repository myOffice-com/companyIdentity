package com.myoffice.companyidentity.exceptions;

public final class ResponseCodes {

    private ResponseCodes() {
        super();
    }

    public static final String COMPANY_NAME_ALREADY_EXIST = "CI1";
    public static final String CGI_NUMBER_ALREADY_EXIST = "CI2";
    public static final String ADMIN_ID_ALREADY_EXIST = "CI3";
    public static final String INVALID_FILTER_KEY_PROVIDED = "CI4";
    public static final String COMPANY_ID_NOT_FOUND = "CI5";

}
