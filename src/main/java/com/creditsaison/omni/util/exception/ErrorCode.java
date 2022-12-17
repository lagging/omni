package com.creditsaison.omni.util.exception;


public enum ErrorCode {

    SUCCESS,
    SERVICE_ERROR,
    NOT_LOGGED_IN,
    JDO_ERROR,
    PERSISTENCE_ERROR,
    BAD_REQUEST_ERROR,
    FORBIDDEN_ERROR,
    ENTITY_NOT_FOUND,
    NOT_FOUND_ERROR,
    ACTION_NOT_ALLOWED,
    INVALID_APP_ID,
    INVALID_APP_CREDENTIALS,
    INVALID_SIGNED_URL,
    EXPIRED_URL,
    ALREADY_VERIFIED,
    ALREADY_REGISTERED,
    NOT_REGISTERED,
    USER_GRADE_CHANGED,
    IO_ERROR,
    USER_NOT_FOUND,
    USER_ALREADY_EXISTS,
    USER_NOT_VALID_STUDENT,
    EMAIL_NOT_REGISTERED,
    INVALID_SOCIAL_USER_INFO,
    INVALID_PASSWORD,
    INVALID_USER_ID,
    INVALID_CALLING_USER_ID,
    ACCOUNT_INSUFFICIENT_BALANCE,
    INSTALMENTS_INCONSISTENT,
    ACCOUNT_NOT_FOUND,
    ACCOUNT_ALREADY_EXISTS,
    INVALID_AMOUNT,
    LOCK_BALANCE_STEP_NOT_FOUND,
    BILLING_STEP_NOT_FOUND,
    TRANSACTION_NOT_FOUND,
    TRANSACTION_ALREADY_PROCESSED,
    SESSION_NOT_FOUND,
    SESSION_INVALID_TIME_PERIOD,
    SESSION_FORBIDDEN_FOR_USER,
    SESSION_ALREADY_ACTIVE,
    SESSION_ALREADY_SCHEDULED,
    SESSION_ALREADY_CANCELED,
    SESSION_NOT_SCHEDULED,
    SESSION_NOT_STARTED,
    SESSION_NOT_ACTIVE,
    SESSION_EXPIRED,
    SESSION_ALREADY_ENDED,
    SESSION_DURATION_LIMIT_EXCEEDED,
    FEEDBACK_NOT_FOUND,
    INVALID_RATING,
    FILE_NOT_FOUND,
    INVALID_FILE_STATE,
    HTML_FILE_NOT_FOUND,
    OFFERING_NOT_FOUND,
    SUBSCRIPTION_NOT_FOUND,
    SUBSCRIPTION_DETAILS_NOT_FOUND,
    SUBSCRIPTION_NOT_ALLOWED,
    SUBSCRIPTION_INACTIVE,
    SUBSCRIPTION_HOURS_INSUFFICIENT,
    USER_ALREADY_SUBSCRIBED,
    INVALID_SUBSCRIPTION_ID,
    INVALID_VERIFICATION_CODE,
    INVALID_PHONE_NUMBER,
    PHONE_NUMBER_VERIFICATION_NOT_ENABLED,
    VERIFICATION_CODE_ALREADY_USED,
    CONTACT_NUMBER_NOT_WHITELISTED,
    STUDENT_NUMBER_NOT_VERIFIED,
    TEACHER_NUMBER_NOT_VERIFIED,
    STUDENT_NUMBER_NOT_WHITELISTED,
    TEACHER_NUMBER_NOT_WHITELISTED,
    PHONE_NUMBER_NOT_VERIFIED,
    PHONE_NUMBER_ALREADY_ADDED,
    PHONE_NUMBER_NOT_ADDED,
    COUPON_INVALID,
    COUPON_CODE_ALREADY_USED,
    COUPON_CODE_NOT_ACTIVE,
    COUPON_CODE_EXPIRED,
    COUPON_USES_PER_USER_LIMIT_REACHED,
    COUPON_USES_LIMIT_REACHED,
    COUPON_UNATHOURIZED_USAGE,
    COUPON_NOT_APPLICABLE,
    INCONSISTENT_REDEEMED_ENTRIES,
    USES_LIMIT_REACHED,
    MIN_ORDER_NOT_SATISFIED,
    MAX_DISCOUNT_EXCEEDED,
    DISCOUNT_EXCEEDS_TOTAL_AMOUNT,
    TIME_SLOT_NOT_FOUND,
    TIME_SLOT_ALREADY_EXISTS,
    TIME_ALREADY_DELETED,
    SLOTS_NOT_AVAILABLE,
    SCHEDULING_FAILED,
    DESCHEDULING_FAILED,
    SUBSCRIPTION_SESSION_ACTIVE,
    PROPOSAL_ALREADY_EXISTS,
    REWARD_ALREADY_EXISTS,
    PROPOSAL_DOES_NOT_EXIST,
    PROPOSAL_ACCEPTED_REJECTED_CANCELED,
    PROPOSAL_NOT_FOUND,
    PROPOSAL_NO_ACCESS,
    PAYMENT_MODE_NOT_FOUND,
    TITLE_NOT_FOUND,
    PROPOSAL_SLOT_EXPIRED,
    PROPOSAL_SLOT_INVALID,
    PROPOSAL_SLOT_5MIN_ERROR,
    INVALID_MESSAGE_ID,
    MESSAGE_NOT_FOUND,
    INVAID_JSON_OBJECT,
    USER_BLOCKED,
    CALENDAR_ENTRY_NOT_FOUND,
    PENDING_CALENDAR_UPDATE,
    TIME_EXCEEDED_DAY,
    SLOT_ALREADY_EXIST,
    SLOT_NOT_EXIST,
    INSTALEARN_REQUEST_MISSED,
    INSTALEARN_REQUEST_NOT_FOUND,
    USER_NOT_AVAILABLE,
    SUBSCRIPTION_REQUESTED_HOURS_INCORRECT,
    HOUR_TRANSACTION_ALREADY_EXIST,
    INVALID_SUBSCRIPTION_REQUEST_STATE,
    SUBSCRIPTION_REQUEST_ALREADY_CANCELLED,
    SUBSCRIPTION_REQUEST_ALREADY_REJECTED,
    SUBSCRIPTION_REQUEST_ALREADY_EXPIRED,
    SUBSCRIPTION_REQUEST_ALREADY_ACCEPTED,
    BROADCAST_ALREADY_ACCEPTED,
    CHAT_CREATION_FAILED,
    NO_TEACHER_AVAILABLE,
    BROADCAST_LEVEL_NOT_PRESENT,
    SUBSCRIPTION_INCORRECT_HOURS,
    //dinero
    ORDER_NOT_FOUND,
    PLAN_NOT_FOUND,
    INSTALMENT_NOT_FOUND,
    MULTIPLE_ORDERED_ITEMS_NOT_ALLOWED,
    INSTALMENT_NOT_PAID_IN_ORDER,
    SESSION_SCHEDULE_EMPTY,
    ALREADY_PAID,
    VERIFICATION_CODE_EXPIRED,
    CONTACT_NUMBER_EXISTS,
    PASSWORD_DOES_NOT_MATCH,
    TEACHER_ACTIVE_NUMBER_NOT_FOUND,
    STUDENT_ACTIVE_NUMBER_NOT_FOUND,
    BATCH_UPDATE_ERROR,
    CALENDAR_UPDATE_ERROR, EMAIL_NOT_VERIFIED,
    TEACHER_CALL_SERVICE_NOT_ALLOWED,
    STUDENT_CALL_SERVICE_NOT_ALLOWED,
    // Session
    INVALID_REFERENCE_TAG,
    INVALID_SESSION_FIELDS,
    SESSION_INVALID_FOR_RESCHEDULE,
    SESSION_ATTENDEE_NOT_FOUND,
    SESSION_MULTIPLE_ATTENDEES_FOUND,
    //Communication
    INVALID_COMMUNICATION_TYPE,
    //Review
    REVIEW_NOT_FOUND,
    NODE_SERVER_NOT_FOUND,
    YOUSCORE_LOGIN_ERROR,
    ENTITY_FILE_STORAGE_EXCEPTION,
    INVALID_QUESTION_TYPE,
    OPTION_DUPLICATION_OCCURED,
    UNKNOWN_QUESTION_TYPE,
    INVALID_ANSWER_FORMAT,
    INVALID_QUESTION_FORMAT,
    INVALID_METADATA,
    CMDS_UPLOAD_ERROR,
    CMDS_CONTENT_NOT_FOUND,
    CMDS_QUESTION_SET_NOT_FOUND, TEST_ATTEMPT_ALREADY_EXISTS, TEST_NOT_STARTED, TEST_START_TIME_OVER, TEST_ENDED, MAX_DEVICES_USED, USER_NOT_IN_TEST_CATEGORY, 
    TEST_NOT_FOUND,
    TEST_ALREADY_ATTEMPTED,

    //Result
    RESULTS_NOT_DECLARED,
    RESULTS_NOT_AVAILABLE,
    USER_LOGIN_REQUIRED
    
    
}