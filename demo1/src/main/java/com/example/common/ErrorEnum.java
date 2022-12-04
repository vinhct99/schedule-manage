package com.example.common;

public enum ErrorEnum {
    SUCCESS(200, "0", "Success"),
    INTERNAL_SERVER_ERROR(500, "500", "Internal Server Error"),
    USER_NOT_FOUND(404, "100", "User not found in system"),
    DEPARTMENT_NOT_FOUND(404, "172", "User not found in system"),
    NOTIFY_NOT_FOUND(404, "171", "User not found in system"),
    USER_EXIST(400, "100", "User existed in system"),
    PHONE_EXIST(400, "101", "Phone existed in system"),
    EMAIL_EXIST(400, "101", "EMAIL existed in system"),
    PHONE_NOT_EXIST(404,"102","Phone not exist in system"),
    PHONE_INVALID(400,"103","Phone number Incorrect format"),
    PASSWORD_LENGTH_INVALID(411,"104","Length password must be larger 0"),
    FULLNAME_LENGTH_INVALID(411,"105","Length fullName must be larger 0"),
    PASSWORD_INVALID(400,"106","password incorrect"),
    IDUSER_NOT_EXIST(404,"107","Id not exist in system"),
    OTP_EXPIRETIME(400,"108","The OTP Expiretime"),
    OTP_NOT_MATCH(400,"109","OTP does not match"),
    OTP_SENDING_FAILED (500,"110","OTP sending failed"),
    LOGIN_FAILED(400,"111","Login failed"),
    UTILITYID_INVALID(400,"112","UtilityId invalid"),
    ADD_DATABASE_ERROR(500,"501","Add database error"),
    REALESTATE_NOT_EXIST(404,"113","realEstateId not exist in list realEstate user"),
    FILE_ISEMPTY(404,"114","File input is empty"),
    POSTID_NOT_EXIST(404,"115","PostId not exist in list Post user"),
    POST_BLOCK(404,"116","Post Block by admin can't change"),
    POST_NOT_PUBLIC(404,"117","Post not public"),
    POST_EXPIRED(404,"118","The post has expired"),
    ROLESUSER_ISEMPTY(404,"119","Roles user is empty"),
    ROLEUSER_NOT_EXIST(404,"120","Role user not exist"),
    STARTDATE_INVALID(404,"121","StartDate less than current date"),
    PACKAGEID_NOT_EXIST(404,"122","PackageId not exist"),
    FEEDBACKID_INVALID(404,"123","feedBackId invalid"),
    DATESEARCH_INVALID(404,"124","Date search invalid"),
    MONTH_INVALID(404,"125","Month invalid"),
    YEAR_INVALID(404,"126","Year invalid"),
    TITLEFEEDBACK_INVALID(404,"127","Title FeedBack invalid"),
    CONTENTFEEDBACK_INVALID(404,"128","Content FeedBack invalid"),
    CONTENTCONFIRM_INVALID(404,"129","Content ConFirm invalid"),
    FEEDAY_INVALID(404,"130","Fee day package invalid"),
    FEEWEEK_INVALID(404,"131","Fee week package invalid"),
    FEEMONTH_INVALID(404,"132","Fee month package invalid"),
    COLOR_INVALID(404,"133","Color package invalid"),
    DISTRICT_INVALID(404,"134","district invalid"),
    CITY_INVALID(404,"135","city invalid"),
    NAMEREALESTATE_INVALID(404,"136","name of RealEstate invalid"),
    ADDRESSREALESTATE_INVALID(404,"137","address of RealEstate invalid"),
    CATEGORY_NOT_EXIST(404,"138","Category not exist"),
    DESCRIPTION_INVALID(404,"139","description invalid"),
    OWNERNAME_INVALID(404,"140","Owner name invalid"),
    OWNERPHONE_INVALID(404,"141","Owner phone invalid"),
    AREA_INVALID(404,"142","Area of RealEstate invalid"),
    FRONTLAND_INVALID(404,"143","FrontLand of RealEstate invalid"),
    TYPE_INVALID(404,"144","Type Post invalid"),
    TXNREF_INVALID(404,"145","TxnRef invalid"),
    SECUREHASH_INVALID(404,"146","SecureHash invalid"),
    RELOAD_CHECKOUT_PAGE(404,"147","can't not reload page checkout"),
    TOTALMONEY_INVALID(404,"148","total money invalid"),
    DURATIONTYPE_INVALID(404,"149","duration type invalid"),
    TOTALTIME_INVALID(404,"150","total time invalid"),
    ISREAD_INVALID(404,"151","isRead invalid"),
    STATUS_INVALID(404,"152","status invalid"),
    ISDATE_INVALID(404,"153","isDate invalid"),
    COSTNUMBER_INVALID(404,"154","codeNumber invalid"),
    COSTSTRING_INVALID(404,"155","codeString invalid"),
    FEEPERTYPE_INVALID(404,"156","fee per type invalid"),
    IPADDRESS_INVALID(404,"157","ipAddress invalid"),
    TITLE_INVALID(404,"158","title invalid"),
    RESPONSECODE_INVALID(404,"159","response code invalid"),
    WATERMONEY_INVALID(404,"160","water money invalid"),
    INTERNETMONEY_INVALID(404,"161","internet money invalid"),
    ELECTRICMONEY_INVALID(404,"162","electric money invalid"),
    BEDROOM_INVALID(404,"163","number of bedroom invalid"),
    FLOOR_INVALID(404,"164","numnber of floor invalid"),
    TOILET_INVALID(404,"165","number of toilet invalid"),
    VERIFIED_INVALID(404,"166","verified invalid"),
    PAGESIZE_INVALID(404,"167","page size invalid"),
    PAGEINDEX_INVALID(404,"167","page index invalid"),
    ISEXPIRY_INVALID(404,"168","IsExpiry invalid"),
    PRICE_INVALID(404,"169","price invalid"),
    SHORTTERMRETAIL_INVALID(404,"170","shortTermRetail invalid"),
    ORDERINFO_INVALID(404,"171","orderInfo invalid");




    private int status;
    private String code;
    private String message;

    ErrorEnum(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public static ErrorEnum getErrorEnum(String code) {
        for (ErrorEnum ee : ErrorEnum.values()) {
            if (ee.getCode().equals(code)) {
                return ee;
            }
        }

        return INTERNAL_SERVER_ERROR;
    }
}
