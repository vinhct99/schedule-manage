package com.example.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.example.common.ExceptionState;

public class BaseState {
    protected static final Map<String, ResponseCode> map = new ConcurrentHashMap();

    public BaseState() {
    }

    public static String getTitle(String code) {
        return MessageContext.getMessage(code);
    }

    public static String getMessage(Integer code) {
        return map.containsKey(code) ? MessageContext.getMessage(((ResponseCode)map.get(code)).getMsg()) : null;
    }

    public static String getMessage(String code) {
        return map.containsKey(code) ? MessageContext.getMessage(((ResponseCode)map.get(code)).getMsg()) : MessageContext.getMessage(code);
    }

    public static enum ResponseCode implements ExceptionState {
        SUCCESS("0", "success", "success"),
        ERROR("1", "error", "error"),
        BAD_REQUEST("400", "bad_request", "bad_request"),
        NO_CONTENT("204", "request_error", "no_content"),
        NOT_FOUND("4004", "not_found_entity", "not_found_entity"),
        INVALID("403", "invalid", "invalid"),
        INTERNAL_SERVER_ERROR("500", "server_error", "internal_server_error"),
        FILE_NOT_DETECT("3000", "file_not_detect", "file_not_detect"),
        BUSINESS_EXCEPTION("5000", "business_error", "business_exception");

        private String code;
        private String msg;
        private String title;

        private ResponseCode(String code, String title, String msg) {
            this.code = code;
            this.msg = msg;
            this.title = title;
        }

        public String getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }

        public String getTitle() {
            return this.title;
        }

        static {
            ResponseCode[] var0 = values();
            int var1 = var0.length;

            for(int var2 = 0; var2 < var1; ++var2) {
                ResponseCode res = var0[var2];
                BaseState.map.put(res.getCode(), res);
            }

        }
    }
}
